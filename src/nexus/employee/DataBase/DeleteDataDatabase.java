package nexus.employee.DataBase;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDataDatabase {
    public static void main(String[] args) {
        // Tạo đối tượng DBConnection để kết nối đến cơ sở dữ liệu
        DBConnection dbConnection = new DBConnection();

        try {
            if (dbConnection.connection != null) {
                System.out.println("Kết nối đến cơ sở dữ liệu thành công.");

                // SQL query để xóa hết dữ liệu từ bảng Employees
                String deleteQuery = "DELETE FROM Employees";
                String auto_increment ="ALTER TABLE Employees AUTO_INCREMENT = 1";

                // Sử dụng PreparedStatement để thực hiện truy vấn DELETE
                PreparedStatement preparedStatement = dbConnection.connection.prepareStatement(deleteQuery);
                // Đặt lại auto_increment =1
                PreparedStatement auto_increment1 = dbConnection.connection.prepareStatement(auto_increment);

                int rowsDeleted = preparedStatement.executeUpdate();

                System.out.println("Đã xóa " + rowsDeleted + " bản ghi từ bảng RandomPeople.");
                System.out.println("Đã reset lại auto_increment");
                preparedStatement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            dbConnection.closeConnection(); // Đảm bảo rằng kết nối được đóng ngay cả khi có lỗi
        }
    }
}

