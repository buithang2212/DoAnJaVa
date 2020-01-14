CREATE DATABASE QLTV
GO
USE QLTV
GO
CREATE TABLE tblSach(
	MaSach VARCHAR(10) PRIMARY KEY,
	TenSach NVARCHAR(50) NOT NULL,
	TacGia NVARCHAR(50) NOT NULL,
	NhaXB NVARCHAR(50) NOT NULL,
	NamXB INT,
	Gia FLOAT,
	NgayNhap DATE
)
INSERT INTO tblSach VALUES('S001',N'Đế quốc Mỹ là con hổ giấy',N'Nguyễn Viết Chung',N'Nói phét',1955,35,'2018-05-31')
INSERT INTO tblSach VALUES('S002',N'Hoa Kỳ là nước xấu',N'L.Quốc Bình',N'Chém gió',1962,98,'2018-05-31')
INSERT INTO tblSach VALUES('S003',N'Đế quốc Mỹ trong cơn giẫy chểt',N'N.V Hiển',N'Phụ nữ',1975,32,'2018-05-31')
INSERT INTO tblSach VALUES('S004',N'Mỹ bị đòn đau ở Campuchia',N'Việt Hà',N'Ánh sáng',1945,17,'2018-05-31')
INSERT INTO tblSach VALUES('S005',N'Triển vọng vĩ đại của Triều Tiên',N'Kim Nhật Thành',N'Bốc sít',1951,64,'2018-05-31')
INSERT INTO tblSach VALUES('S006',N'Hệ thông tư bản chủ nghĩa đang tan rã',N'Trần Nhôm',N'Ong vò vẽ',1932,79,'2018-05-31')

SELECT * FROM tblSach