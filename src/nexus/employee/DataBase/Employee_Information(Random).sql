USE QLNV;

-- Tạo bảng tạm thời để chứa dữ liệu ngẫu nhiên
CREATE TEMPORARY TABLE TempRandomData (
    EmployeeID INT,
    Name VARCHAR(50),
    Gender VARCHAR(10),
    Dob DATE,
    Address VARCHAR(255),
    Email VARCHAR(100),
    Phone VARCHAR(15),
    DepartmentID INT,
    Salary DECIMAL(10, 2),
    Country VARCHAR(50),
    RoleID INT
);

-- Danh sách tên và quốc tịch
SET @names = 'John Smith,Maria Garcia,Alexander Petrov,Laura Johnson,Luca Bianchi,Ji-hoon Kim,Nguyen Minh,Wei Chen,Sophie Martin,Emma Müller,Adrian van der Berg,Felipe Silva,Gabriel Lopez,William Anderson,Lisa Johnson,Elena Sokolova,Carlos Lopez,Sofia Rodriguez,Jack Smith,Matilda Nilsson,Isabella Rossi,Mia Hernandez,Olivia Smith,Sophia Müller,Emily Nguyen,Emma Wilson,Mia Kim,Olivia Petrova,Emily Davis,Isabella Garcia';
SET @countries = 'USA,Spain,Russia,UK,Italy,South Korea,Vietnam,China,France,Germany,Netherlands,Brazil,Spain,USA,UK,Russia,Spain,Argentina,USA,Sweden,Italy,Mexico,USA,Germany,Vietnam,Canada,South Korea,Russia,Australia,Spain';

-- Sử dụng lệnh INSERT INTO để chèn dữ liệu ngẫu nhiên vào bảng tạm thời
INSERT INTO TempRandomData (EmployeeID, Name, Gender, Dob, Address, Email, Phone, DepartmentID, Salary, Country, RoleID)
SELECT
    NULL, -- Tạo EmployeeID tự động (AUTO_INCREMENT)
    SUBSTRING_INDEX(@names, ',', 1 + FLOOR(RAND() * (LENGTH(@names) / LENGTH(',') - 1))),
    CASE WHEN RAND() > 0.5 THEN 'Nam' ELSE 'Nữ' END,
    DATE(DATE_SUB(NOW(), INTERVAL FLOOR(20 + RAND() * 20) YEAR)),
    CONCAT(FLOOR(100 + RAND() * 899), ' ', SUBSTRING_INDEX(@countries, ',', 1 + FLOOR(RAND() * (LENGTH(@countries) / LENGTH(',') - 1)))),
    CONCAT('email', FLOOR(1 + RAND() * 1000), '@example.com'),
    CONCAT('123456', FLOOR(100000 + RAND() * 899999)),
    FLOOR(1 + RAND() * 5), -- Số ngẫu nhiên từ 1 đến 5 cho phòng ban
    ROUND(1000 + RAND() * 9000, 2), -- Lương ngẫu nhiên từ 1000 đến 10000 với 2 chữ số thập phân
    SUBSTRING_INDEX(@countries, ',', 1 + FLOOR(RAND() * (LENGTH(@countries) / LENGTH(',') - 1))),
    2 -- Đặt RoleID theo mô hình của bạn
FROM
    information_schema.tables LIMIT 30;

-- Sao chép dữ liệu từ bảng tạm thời vào bảng thực tế (Employees)
INSERT INTO Employees (employee_id, name, gender, dob, address, email, phone, departmentID, salary, country, role_id)
SELECT
    EmployeeID,
    Name,
    Gender,
    Dob,
    Address,
    Email,
    Phone,
    DepartmentID,
    Salary,
    Country,
    RoleID
FROM
    TempRandomData;

-- Xóa bảng tạm thời
DROP TEMPORARY TABLE IF EXISTS TempRandomData;
