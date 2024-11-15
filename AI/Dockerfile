# Bắt đầu từ image anaconda với CUDA hỗ trợ (nếu bạn cần hỗ trợ GPU)
FROM python:3.9-slim

# Cài đặt các thư viện hệ thống cần thiết cho OpenCV
RUN apt-get update -qq \
    && apt-get install --no-install-recommends -y \
    build-essential \
    libgl1-mesa-glx \
    libglib2.0-0 \
    gcc \
    g++ \
    make \
    graphviz \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Sao chép file requirements.txt vào container
WORKDIR /app
COPY requirements.txt /app/

# Cài đặt các thư viện Python từ requirements.txt
RUN pip install --no-cache-dir -r requirements.txt

# Sao chép mã nguồn vào container
COPY . /app/

# Mở cổng 8000 cho FastAPI
EXPOSE 8000

# Lệnh để chạy FastAPI sử dụng Uvicorn
CMD ["uvicorn", "api:app", "--host", "0.0.0.0", "--port", "8000"]
