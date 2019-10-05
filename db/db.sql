CREATE DATABASE AILATRIEUPHU
GO
USE AILATRIEUPHU
GO
CREATE TABLE ChiTietLuotChoi(
    id INT PRIMARY KEY NOT NULL,
    luot_choi_id INT,
    cau_hoi_id INT,
    phuong_an VARCHAR(20),
    diem INT,
); 
CREATE TABLE LichSuMuaCredit(
    id INT PRIMARY KEY NOT NULL,
    nguoi_choi_id INT,
    goi_credit_id INT,
    credit INT,
    so_tien INT
);
CREATE TABLE GoiCredit(
    id INT PRIMARY KEY NOT NULL,
    ten_goi VARCHAR(20),
    credit INT,
    so_tien INT,
    XOA BIT,
    CONSTRAINT FK_GoiCredit_LichSuMuaCredit FOREIGN KEY (id) REFERENCES LichSuMuaCredit (id)
);
CREATE TABLE LuotChoi(
    id INT PRIMARY KEY NOT NULL,
    nguoi_choi_id INT,
    so_cau INT,
    diem VARCHAR(20),
    ngay_gio DATETIME,
    CONSTRAINT FK_LuotChoi_ChiTietLuotChoi FOREIGN KEY (nguoi_choi_id) REFERENCES ChiTietLuotChoi(id)
);
CREATE TABLE NguoiChoi(
    id INT PRIMARY KEY NOT NULL,
    ten_dang_nhap VARCHAR(20),
    mat_khau VARCHAR(30),
    email VARCHAR(20),
    hinh_dai_dien VARCHAR(20),
    diem_cao_nhat INT,
    credit INT,
    XOA BIT,
    CONSTRAINT FK_NguoiChoi_LuotChoi FOREIGN KEY (id) REFERENCES LuotChoi (id),
    CONSTRAINT FK_NguoiChoi_LichSuMuaCredit FOREIGN KEY (id) REFERENCES LichSuMuaCredit (id)
);
 CREATE TABLE CauHoi(
    id INT PRIMARY KEY NOT NULL,
    noi_dung VARCHAR(20),
    linh_vuc_id INT,
    phuong_an_a VARCHAR(20),
    phuong_an_b VARCHAR(20),
    phuong_an_c VARCHAR(20),
    phuong_an_d VARCHAR(20),
    dap_an VARCHAR(20),
    xoa BIT,
    CONSTRAINT FK_CauHoi_ChiTietLuotChoi FOREIGN KEY(id) REFERENCES ChiTietLuotChoi(id)
);
CREATE TABLE LinhVuc(
    id INT PRIMARY KEY NOT NULL,
    ten_linh_vuc VARCHAR(20),
    xoa BIT, 
    CONSTRAINT FK_LinhVuc_CauHoi FOREIGN KEY (id) REFERENCES CauHoi(id) 
);  
CREATE TABLE CauHinhDiemCauHoi(
    id INT PRIMARY KEY NOT NULL,
    thu_tu INT,
    diem INT
);

CREATE TABLE CauHinhApp(
    id INT PRIMARY KEY NOT NULL,
    co_hoi_sai INT,
    thoi_gian_tra_thoi INT
); CREATE TABLE QuanTriVien(
    id INT PRIMARY KEY NOT NULL,
    ten_dang_nhap VARCHAR(20),
    mat_khau VARCHAR(20),
    ho_ten VARCHAR(20),
    xoa BIT
); CREATE TABLE CauHinhTroGiup(
    id INT PRIMARY KEY NOT NULL,
    loai_tro_giup INT,
    thu_tu INT,
    CREDIT INT
);
-- DATABASE ANDROID .....