package nexus.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DBConnection {
    public Connection connection;
    public Statement statement;

    public DBConnection() {
        try {

            // Load driver JDBC cho MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Thiết lập thông tin kết nối đến cơ sở dữ liệu MySQL của bạn

            String url="jdbc:mysql://localhost:3306/QLNV"; // Địa chỉ cơ sở dữ liệu MySQL
            String username="root"; // Tên đăng nhập MySQL của bạn
            String password="trunghieu97"; // Mật khẩu MySQL của bạn

            // Tạo kết nối đến cơ sở dữ liệu
            connection=DriverManager.getConnection(url, username, password);

            // Thiết lập cơ sở dữ liệu mặc định
            statement=connection.createStatement();
            // Lưu trữ đối tượng Statement để sử dụng sau này
//            this.statement = statement;

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public void closeConnection() {     // Đóng kết nối
        try {
            if (statement != null){
                statement.close();
            }if (connection != null){
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public PreparedStatement prepareStatement(String str) {
        return null;
    }
}