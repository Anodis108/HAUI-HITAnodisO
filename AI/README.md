## AI

Thư mục này chứa các mô-đun AI và xử lý dữ liệu liên quan đến trí tuệ nhân tạo (AI). Các chức năng chính bao gồm việc xử lý hình ảnh, thêm con dấu vào PDF và các tính năng AI khác nếu có.


### Cấu trúc thư mục
```bash
AI/
├── api.py               # API để xử lý hình ảnh và PDF
├── Dockerfile            # Dockerfile cho container hóa AI module
└── requirements.txt      # Các thư viện cần thiết cho dự án
```

### Cài đặt môi trường

1. **Cài đặt các thư viện cần thiết từ file `requirements.txt`:**

    Đảm bảo bạn đang ở trong thư mục `AI`, sau đó chạy lệnh:
    ```bash
    pip install -r requirements.txt
    ```
2. **Chạy module AI:**
    Sử dụng `uvicorn` để chạy API:
    ```bash
    uvicorn api:app --host 0.0.0.0 --port 8000
    ```
    Hoặc, nếu bạn muốn chạy ứng dụng trong container Docker, hãy thực hiện các bước sau:
    - Xây dựng Docker image:
        ```bash
        docker build -t ai-module .
        ```
    - Chạy container:
        ```bash
        docker run -d -p 8000:8000 my-fastapi-app
        ```

### Mô tả chức năng chính

**`/stamp-pdf/`**: API nhận file PDF và hình ảnh con dấu, thực hiện xử lý để tách nền hình ảnh và chèn dấu vào trang được chỉ định của tệp PDF.

**Tham số yêu cầu:**
- `pdf_file`: File PDF cần đóng dấu.
- `stamp_image`: Hình ảnh con dấu cần chèn.
- `x`, `y`: Tọa độ của vị trí chèn dấu trên trang PDF.
- `stamp_width`, `stamp_height`: Kích thước hình ảnh con dấu.
- `page_number`: Số thứ tự của trang PDF để chèn dấu (bắt đầu từ 1).

**Cách sử dụng:**
Gửi một yêu cầu `POST` tới endpoint **`/stamp-pdf/`** với các file và tham số cần thiết.


- **Quy trình**:
  1. Tách nền hình ảnh con dấu.
  2. Thay đổi kích thước hình ảnh con dấu để phù hợp với kích thước trang PDF.
  3. Chèn hình ảnh con dấu vào trang PDF.
  4. Trả về file PDF đã được chèn con dấu.

- **Ví dụ**:
  Bạn có thể sử dụng API này để chèn con dấu vào mẫu đơn đăng ký hoặc bất kỳ tài liệu PDF nào.

