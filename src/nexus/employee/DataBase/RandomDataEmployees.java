package nexus.employee.DataBase;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDataEmployees {
    public static void main(String[] args) {
        // Tạo đối tượng DBConnection để kết nối đến cơ sở dữ liệu
        DBConnection dbConnection = new DBConnection();
        try {
            if (dbConnection.connection != null) {
                System.out.println("Kết nối đến cơ sở dữ liệu thành công.");

                // Danh sách quốc gia và tên tương ứng
                String[] countries = {"VietNam", "Japan", "China", "South Korea", "USA", "Brazil", "Spain", "UK", "Italy"};
                String[][] names = {
                        {"Ta Trung Hieu", "Le Thi My", "Bui Duc Nam", "Nguyen Quang Dien", "Nguyen Thi Thuy", "Tran Van Hieu", "Nguyen Thi Thanh", "Nguyen Van Hieu", "Nguyen Thi Thuy", "Nguyen Van Hieu"},
                        {"Hiroshi Tanaka", "Masako Sato", "Yukiko Watanabe", "Kazuki Suzuki", "Sakura Ito", "Takashi Yamamoto", "Akiko Nakamura", "Haruki Saito", "Haruka Kobayashi", "Kaito Takahashi", "Miyu Kimura", "Satoshi Kato", "Ai Fujita", "Yuki Nakajima", "Tetsuya Tanaka", "Yukihiro Sato", "Ryota Ito", "Yumi Suzuki", "Noboru Nakamura", "Akane Saito"},
                        {"Li Wei", "Chen Xin", "Wang Li", "Zhang Peng", "Liu Yang", "Huang Jing", "Xu Min", "Yang Guo", "Gao Xing", "Wu Chun"},
                        {"Kim Min-jun", "Park Ji-hye", "Lee Min-woo", "Choi Soo-jin", "Kang Ji-eun", "Jeon Ji-hoon", "Han Mi-soo", "Seo Min-ki", "Ahn Soo-jung", "Yoo Ji-ho"},
                        {"John Smith", "Mary Johnson", "Robert Williams", "Linda Brown", "William Davis", "Maria Garcia", "Laura Johnson", "Michael Wilson", "Sarah Taylor", "David White"},
                        {"Felipe Silva", "Gabriel Lima", "Lucas Souza", "Mariana Alves", "Isabella Santos", "Rafael Oliveira", "André Pereira", "Ana Silva", "Carlos Ferreira", "Paulo Sousa"},
                        {"Javier López", "María García", "Carlos Martínez", "Luis Rodríguez", "Ana Sánchez"},
                        {"James Smith", "Emily Johnson", "Daniel Williams", "Jessica Brown", "William Davis", "Lily White", "Matthew Clark", "Sophia Lewis", "Samuel Hughes", "Olivia Turner"},
                        {"Marco Rossi", "Alessia Ricci", "Lorenzo Ferrari", "Elena Romano", "Davide Marini"}
                };

                Random random = new Random();

                // SQL query để chèn dữ liệu vào bảng Employees
                String insertQuery = "INSERT INTO Employees (name, gender, dob, address, email, phone, departmentID, salary, country, role_id) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                // Sử dụng PreparedStatement để thêm dữ liệu
                PreparedStatement preparedStatement = dbConnection.connection.prepareStatement(insertQuery);

                int count = 0;
                List<String> usedNames = new ArrayList<>();
                for (int countryIndex = 0; countryIndex < countries.length; countryIndex++) {
                    String country = countries[countryIndex];
                    String[] nameList = names[countryIndex];

                    for (String name : nameList) {
                        if (!usedNames.contains(name)) {
                            usedNames.add(name);
                            String gender = random.nextBoolean() ? "MALE" : "FEMALE";

                            // Tạo năm sinh từ 1980 đến 2000
                            int birthYear = 1980 + random.nextInt(21);
                            Date dob = new Date(birthYear - 1900, random.nextInt(12), random.nextInt(28) + 1);

                            String address = random.nextInt(900) + 100 + " " + country;
                            String email = name.toLowerCase().replace(" ", "") + random.nextInt(1000) + "@gmail.com";
                            String phone = "080" + (10000000 + random.nextInt(90000000)); // Bắt đầu từ 080xxxxxxxx
                            int departmentID = random.nextInt(5) + 1; // Số ngẫu nhiên từ 1 đến 5 cho phòng ban
                            int salary = 200000 + random.nextInt(9000); // Lương ngẫu nhiên từ 200000 đến 1000000
                            int roleID = 2; // Đặt RoleID theo mô hình của bạn

                            preparedStatement.setString(1, name);
                            preparedStatement.setString(2, gender);
                            preparedStatement.setDate(3, dob);
                            preparedStatement.setString(4, address);
                            preparedStatement.setString(5, email);
                            preparedStatement.setString(6, phone);
                            preparedStatement.setInt(7, departmentID);
                            preparedStatement.setInt(8, salary);
                            preparedStatement.setString(9, country);
                            preparedStatement.setInt(10, roleID);

                            preparedStatement.executeUpdate();
                            System.out.println("Đã thêm dữ liệu cho " + name + " vào bảng Employees.");
                            count++;
                        }
                    }
                }

                preparedStatement.close();
                System.out.println("Đã thêm " + count + " bản ghi vào bảng Employees.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            dbConnection.closeConnection(); // Đảm bảo rằng kết nối được đóng ngay cả khi có lỗi
        }
    }
}
