package nexus.employee.userUI;

import nexus.employee.DBConnection;
import nexus.employee.EmployeeManager;
import nexus.employee.MainUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeUI implements ActionListener {
    JFrame userJf,searchFrame;
    JLabel jblImage;
    JButton btnView,btnLogout;

    public EmployeeUI() {
        userJf=new JFrame();
        // Background Image
        jblImage=new JLabel();
        jblImage.setBounds(0, 0, 900, 600);
        jblImage.setLayout(null);
        ImageIcon i=new ImageIcon("src/nexus/employee/images/mainController.png");
        jblImage.setIcon(i);
        userJf.add(jblImage);

        btnView=new JButton("検索");
        btnView.setBounds(310, 400, 120, 40);
        btnView.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        btnView.setForeground(Color.BLACK);
        btnView.setBackground(Color.LIGHT_GRAY);
        jblImage.add(btnView);

        btnLogout=new JButton("ログアウト");
        btnLogout.setBounds(470, 400, 120, 40);
        btnLogout.setFont(new Font("Times_New_Roman", Font.BOLD,18));
        btnLogout.setForeground(Color.BLACK);
        btnLogout.setBackground(Color.LIGHT_GRAY);
        jblImage.add(btnLogout);

        searchFrame = new JFrame("検索");
        JLabel jlbImgSearch, jlbInfor;
        JTextField jtxInfor;
        JButton btnSearch, btnSearchCancel;
        //Frame Details
        searchFrame.setSize(900, 600);
        searchFrame.setLocation(300, 200);
        searchFrame.setResizable(false);
        searchFrame.setLayout(null);

        //Background Image
        jlbImgSearch=new JLabel();
        ImageIcon img=new ImageIcon("src/nexus/employee/images/frontPage_1.png");
        jlbImgSearch.setBounds(0, 0, 900, 600);
        jlbImgSearch.setLayout(null);
        jlbImgSearch.setIcon(img);
        searchFrame.add(jlbImgSearch);

        //Label Details
        jlbInfor=new JLabel("従業員のID:");
        jlbInfor.setBounds(270, 250, 250, 30);
        jlbInfor.setForeground(Color.BLACK);
        jlbInfor.setFont(new Font("Times_New_Roman", Font.BOLD, 25));
        jlbImgSearch.add(jlbInfor);

        jtxInfor=new JTextField();
        jtxInfor.setBounds(420, 250, 220, 30);
        jtxInfor.setFont(new Font("serif", Font.PLAIN, 18));
        jlbImgSearch.add(jtxInfor);

        //Button Details
        btnSearch=new JButton("検索");
        btnSearch.setBounds(300, 300, 140, 35);
        btnSearch.setBackground(Color.LIGHT_GRAY);
        btnSearch.setForeground(Color.BLACK);
        btnSearch.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        jlbImgSearch.add(btnSearch);

        btnSearchCancel=new JButton("キャンセル");
        btnSearchCancel.setBounds(460, 300, 140, 35);
        btnSearchCancel.setBackground(Color.LIGHT_GRAY);
        btnSearchCancel.setForeground(Color.BLACK);
        btnSearchCancel.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        jlbImgSearch.add(btnSearchCancel);
        btnView.addActionListener(this); //Thêm ActionListener cho nút "検索"
        btnLogout.addActionListener(this);

        //Frame Details
        userJf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        userJf.setResizable(false);
        userJf.setLayout(null);
        userJf.setLocation(300, 200);
        userJf.setSize(900, 600);
        userJf.setVisible(true);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DBConnection dbConnection=new DBConnection(); // Tạo kết nối cơ sở dữ liệu
                String searchTerm=jtxInfor.getText(); // Lấy giá trị từ JTextField

                try {
                    // Thiết lập truy vấn SQL và thực hiện truy vấn
                    String query="SELECT * FROM employees WHERE name = ? OR phone = ? OR email = ? OR employee_id = ?";
                    PreparedStatement preparedStatement=dbConnection.connection.prepareStatement(query);

                    // Đặt các giá trị vào các placeholder
                    preparedStatement.setString(1, searchTerm); // name
                    preparedStatement.setString(2, searchTerm); // phone
                    preparedStatement.setString(3, searchTerm); // email
                    preparedStatement.setString(4, searchTerm); // employee_id

                    // Thực hiện truy vấn và lấy kết quả
                    ResultSet rs=preparedStatement.executeQuery();

                    // Xử lý kết quả và hiển thị thông tin nếu tìm thấy
                    while (rs.next()) {
                        // Lấy thông tin từ ResultSet
                        String employeeId=rs.getString("employee_id");
                        String name=rs.getString("name");
                        String gender=rs.getString("gender");
                        String dob=rs.getString("dob");
                        String address=rs.getString("address");
                        String email=rs.getString("email");
                        String phone=rs.getString("phone");
                        String position=rs.getString("position");

                        // Hiển thị thông tin (ví dụ: sử dụng System.out.println hoặc hiển thị trong giao diện người dùng)
                        System.out.println("EmployeeID" + employeeId);
                        System.out.println("Name: " + name);
                        System.out.println("Gender" + gender);
                        System.out.println("Date Of Birth" + dob);
                        System.out.println("Address: " + address);
                        System.out.println("Email: " + email);
                        System.out.println("Phone Number: " + phone);
                        System.out.println("Position: " + position);
                    }
                    // Đóng kết nối cơ sở dữ liệu
                    dbConnection.connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnSearchCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchFrame.dispose();
                userJf.setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnView) {
            searchFrame.setVisible(true);
            userJf.setVisible(false);
            userJf.dispose();
        }
        if (e.getSource()==btnLogout){
            DBConnection dbConnection=new DBConnection();
            dbConnection.closeConnection();
            MainUI mainUI=new MainUI();
            mainUI.showFrontPage();
            userJf.setVisible(false);
            userJf.dispose();
        }
    }

    public void setVisible(boolean b) {
        userJf.setVisible(b);
    }

    public static void main(String[] args) {
        new EmployeeUI();
    }
}
