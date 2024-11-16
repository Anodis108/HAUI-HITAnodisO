from docx import Document

def string_to_docx(text, file_name):
    # Tạo một tài liệu mới
    doc = Document()
    
    # Thêm chuỗi vào tài liệu
    doc.add_paragraph(text)
    
    # Lưu tài liệu dưới dạng .docx
    doc.save(file_name)

# Ví dụ sử dụng
text = ""
string_to_docx(text, "output.docx")
