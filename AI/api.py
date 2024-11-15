# Copyright 2024 HaUI
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

from fastapi import FastAPI, UploadFile, File
from fastapi.responses import FileResponse
import fitz  # PyMuPDF
import cv2
import numpy as np
import shutil
import os

app = FastAPI()

def remove_background(image_path):
    """
    Tách nền của hình ảnh và giữ lại độ trong suốt.
    """
    # Đọc hình ảnh
    img = cv2.imread(image_path, cv2.IMREAD_UNCHANGED)

    # Kiểm tra nếu ảnh có kênh alpha (để xử lý trong suốt)
    if img.shape[2] == 4:
        alpha_channel = img[:, :, 3]
        _, mask = cv2.threshold(alpha_channel, 0, 255, cv2.THRESH_BINARY)
        img_rgb = cv2.cvtColor(img, cv2.COLOR_BGRA2BGR)
    else:
        img_rgb = img

    # Chuyển đổi sang không gian màu HSV
    hsv_img = cv2.cvtColor(img_rgb, cv2.COLOR_BGR2HSV)

    # Xác định phạm vi màu để tách nền (điều chỉnh tùy thuộc vào màu nền)
    lower_bound = np.array([0, 0, 200])  # Giới hạn dưới cho màu nền (ví dụ: màu trắng)
    upper_bound = np.array([180, 30, 255])  # Giới hạn trên cho màu nền

    # Tạo mặt nạ để tách nền
    mask = cv2.inRange(hsv_img, lower_bound, upper_bound)

    # Đảo ngược mặt nạ để giữ lại phần không phải nền
    mask_inv = cv2.bitwise_not(mask)

    # Tách nền ra khỏi hình ảnh bằng mặt nạ
    img_no_bg = cv2.bitwise_and(img_rgb, img_rgb, mask=mask_inv)

    # Thêm kênh alpha để giữ độ trong suốt
    b, g, r = cv2.split(img_no_bg)
    alpha = mask_inv  # Sử dụng mask_inv làm kênh alpha

    # Kết hợp các kênh BGR và alpha
    img_rgba = cv2.merge((b, g, r, alpha))

    return img_rgba

@app.post("/stamp-pdf/")
async def stamp_pdf(pdf_file: UploadFile = File(...), stamp_image: UploadFile = File(...), x: int = 350, y: int = 500, stamp_width: int = 150, stamp_height: int = 150, page_number: int = 1):

    # Lưu các tệp đã tải lên vào hệ thống tệp tạm thời
    pdf_path = f"temp_{pdf_file.filename}"
    stamp_path = f"temp_{stamp_image.filename}"

    with open(pdf_path, "wb") as pdf_out:
        shutil.copyfileobj(pdf_file.file, pdf_out)

    with open(stamp_path, "wb") as stamp_out:
        shutil.copyfileobj(stamp_image.file, stamp_out)

    # Gọi hàm để tách nền hình ảnh con dấu
    stamp_img_no_bg = remove_background(stamp_path)

    # Thay đổi kích thước hình ảnh dấu mộc để phù hợp với PDF
    stamp_img_resized = cv2.resize(stamp_img_no_bg, (stamp_width, stamp_height))

    # Lưu hình ảnh đã xử lý vào file tạm thời với nền trong suốt
    resized_stamp_path = 'resized_stamp.png'
    cv2.imwrite(resized_stamp_path, stamp_img_resized, [cv2.IMWRITE_PNG_COMPRESSION, 9])

    # Mở tệp PDF để chèn hình ảnh
    document = fitz.open(pdf_path)

    if page_number > len(document):
        document.close()
        return {"error": f"Invalid page number. The PDF has {len(document)} pages."}
    page = document.load_page(page_number - 1)  # Chọn trang cụ thể - 1 vì index bắt đầu từ 0


    # Chèn dấu mộc lên PDF
    page.insert_image(
        fitz.Rect(x, y, x + stamp_width, y + stamp_height),
        filename=resized_stamp_path,
        keep_proportion=True,
        overlay=True
    )

    # Lưu file PDF đã được chèn dấu mộc
    output_pdf_path = "stamped_enrollment_form.pdf"
    document.save(output_pdf_path)
    document.close()

    # Xóa tệp tạm thời
    os.remove(pdf_path)
    os.remove(stamp_path)
    os.remove(resized_stamp_path)

    # Trả về file PDF dưới dạng phản hồi
    return FileResponse(output_pdf_path, media_type='application/pdf', filename='stamped_enrollment_form.pdf')

