CREATE TABLE `QLNV`.` Employees` (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
    gender VARCHAR(10),
    dob DATE,
	address VARCHAR(255),
    email VARCHAR(100),
    phone VARCHAR(15),
    departmentID INT,
    salary DECIMAL(10, 2),
    country VARCHAR(50),
    role_id INT,
    CONSTRAINT FK_Department FOREIGN KEY (departmentID) REFERENCES Department(DepartmentID)
);

