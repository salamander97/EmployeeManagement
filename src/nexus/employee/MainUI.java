package nexus.employee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MainUI extends JFrame implements ActionListener {
    // Các component cho FrontPage
    JLabel jlbImgFrontPage,jlbImgLogin,lblTitle,jlbUsername,jlbPassword;
    JButton btnLogin,btnLogin1,btnCancel,btnForgotPassword;
    JTextField jtfUsername;
    JPasswordField jPasswordField;
    JFrame frontPage,login;

    //     Các phương thức khai báo và xử lý chức năng
    public MainUI() {
        ImageIcon imgFrontPage=new ImageIcon("src/nexus/employee/images/frontPage_1.png");
        ImageIcon imgLogin=new ImageIcon("src/nexus/employee/images/login.png");
        // Thiết lập frontPage
        frontPage=new JFrame();
        frontPage.setSize(900, 600);
        frontPage.setLocation(300, 200);
        frontPage.setResizable(false);
        frontPage.setLayout(null);
        jlbImgFrontPage=new JLabel();

        jlbImgFrontPage.setLayout(null);
        jlbImgFrontPage.setIcon(imgFrontPage);
        jlbImgFrontPage.setBounds(0, 0, 900, 600); //Đặt vị trí và kích thước cho frontPageBackground
        jlbImgFrontPage.setSize(900, 600);

        // Thiết lập Background Image cho frontPage
        frontPage.add(jlbImgFrontPage);
        frontPage.setVisible(true);

        // Thiết lập tittle
        lblTitle=new JLabel("従業員の管理システム");
        lblTitle.setBounds(210, 60, 1100, 250); //Đặt vị trí và kích thước cho lblTitle
        lblTitle.setFont(new Font("Arial", Font.BOLD, 50)); //Đặt font cho lblTitle
        lblTitle.setForeground(new Color(82, 113, 255)); //Đặt màu chữ cho btnLogin
        jlbImgFrontPage.add(lblTitle); //Thêm lblTitle vào frontPage

        // Thiết lập nút Login trong frontPage
        btnLogin=new JButton("Login");
        btnLogin.setBounds(315, 393, 270, 70);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 64));
        btnLogin.setBackground(Color.WHITE);
        btnLogin.setForeground(new Color(82, 113, 255)); //Đặt màu chữ cho btnLogin
        btnLogin.setOpaque(false); //Đặt nút btnLogin trong suốt
        btnLogin.setContentAreaFilled(true); //Đặt nút btnLogin trong suốt
        btnLogin.setBorderPainted(false); //Đặt nút btnLogin trong suốt
        jlbImgFrontPage.add(btnLogin); //Thêm btnLogin vào frontPage

        btnLogin.addActionListener(this); //Thêm sự kiện cho btnLogin
        btnLogin.addActionListener(e -> {
            frontPage.setVisible(false);
            login.setVisible(true);
        });
        // Thiết lập login
        login=new JFrame();
        login.setSize(900, 600);
        login.setLocation(300, 200);
        login.setResizable(false);
        login.setLayout(null);

        jlbImgLogin=new JLabel();
        jlbImgLogin.setLayout(null);
        jlbImgLogin.setIcon(imgLogin);
        jlbImgLogin.setBounds(0, 0, 900, 600); //Đặt vị trí và kích thước cho loginBackground
        jlbImgLogin.setSize(900, 600);

        // Thiết lập Background Image cho login
        login.add(jlbImgLogin);

        jlbUsername=new JLabel("ユーザー名");
        jlbUsername.setBounds(300, 300, 120, 30);        //Đặt vị trí và kích thước cho jlbUsername
        jlbUsername.setFont(new Font("Times_New_Roman",Font.BOLD,18));  //Đặt font cho jlbUsername
        jlbUsername.setForeground(Color.black);                             //Đặt màu chữ cho jlbUsername
        jlbImgLogin.add(jlbUsername);                                             //Thêm jlbUsername vào login

        // Thiết lập jlbPassword
        jlbPassword=new JLabel("パスワード");
        jlbPassword.setBounds(300, 350, 120, 30);              //Đặt vị trí và kích thước cho jlbPassword
        jlbPassword.setFont(new Font("Times_New_Roman",Font.BOLD,18)); //Đặt font cho jlbPassword
        jlbPassword.setForeground(Color.black);                                   //Đặt màu chữ cho jlbPassword
        jlbImgLogin.add(jlbPassword);                                             //Thêm jlbPassword vào login

        // Thiết lập tfUsername
        jtfUsername=new JTextField();
        jtfUsername.setBounds(400, 300, 180, 30);               //Đặt vị trí và kích thước cho tfUsername
        jtfUsername.setFont(new Font("Times_New_Roman",Font.PLAIN,18)); //Đặt font cho tfUsername
        jtfUsername.setForeground(Color.black);                                     //Đặt màu chữ cho tfUsername
        jtfUsername.setBackground(Color.white);                                     //Đặt màu nền cho tfUsername
        jlbImgLogin.add(jtfUsername);                                               //Thêm tfUsername vào login

        // Thiết lập tfPassword
        jPasswordField=new JPasswordField();
        jPasswordField.setBounds(400, 350, 180, 30);            //Đặt vị trí và kích thước cho tfPassword
        jPasswordField.setFont(new Font("Times_New_Roman",Font.PLAIN,18));   //Đặt font cho tfPassword
        jPasswordField.setForeground(Color.black);                                 //Đặt màu chữ cho tfPassword
        jPasswordField.setBackground(Color.white);                                 //Đặt màu nền cho tfPassword
        jlbImgLogin.add(jPasswordField);                                                 //Thêm tfPassword vào login

        // Thiết lập nút Login
        btnLogin1=new JButton("ログイン");
        btnLogin1.setBounds(210, 415, 130, 40);         //Đặt vị trí và kích thước cho btnLogin
        btnLogin1.setBackground(Color.black);                              //Đặt màu nền cho btnLogin
        btnLogin1.setForeground(Color.BLACK);                              //Đặt màu chữ cho btnLogin  ＜ーーー
        btnLogin1.setFont(new Font("Times_New_Roman",Font.BOLD,18));       //Đặt font cho btnLogin
        btnLogin1.addActionListener(this);                              //Thêm sự kiện cho btnLogin
        jlbImgLogin.add(btnLogin1);                                             //Thêm btnLogin vào login

        // Thiết lập nút Cancel
        btnCancel=new JButton("キャンセル");
        btnCancel.setBounds(360, 415, 130, 40);         //Đặt vị trí và kích thước cho btnCancel
        btnCancel.setBackground(Color.black);                              //Đặt màu nền cho btnCancel
        btnCancel.setForeground(Color.BLACK);                              //Đặt màu chữ cho btnCancel
        btnCancel.setFont(new Font("Times_New_Roman",Font.BOLD,18));       //Đặt font cho btnCancel
        btnCancel.addActionListener(this);                              //Thêm sự kiện cho btnCancel
        jlbImgLogin.add(btnCancel);                                              //Thêm btnCancel vào login

        // Thiết lập nút ForgotPassword
        btnForgotPassword=new JButton("パスワードを忘れた");
        btnForgotPassword.setBounds(510, 415, 200, 40); //Đặt vị trí và kích thước cho btnForgotPassword
        btnForgotPassword.setBackground(Color.black);                      //Đặt màu nền cho btnForgotPassword
        btnForgotPassword.setForeground(Color.BLACK);                      //Đặt màu chữ cho btnForgotPassword
        btnForgotPassword.setFont(new Font("Times_New_Roman",Font.BOLD,18)); //Đặt font cho btnForgotPassword
        btnForgotPassword.addActionListener(this);                      //Thêm sự kiện cho btnForgotPassword
        jlbImgLogin.add(btnForgotPassword);                                      //Thêm btnForgotPassword vào login

    }

    public void actionPerformed(ActionEvent ae) { //Xử lý sự kiện cho các nút
        if (ae.getSource() == btnLogin1) {
            {
                try {
                    DBConnection dbConnection=new DBConnection();
                    char[] passwordChars = jPasswordField.getPassword();
                    String username=jtfUsername.getText();
                    String password = String.valueOf(passwordChars);
                    String sql="SELECT * FROM login WHERE username = '" + username + "' AND password = '" + password + "'";   //Lấy dữ liệu từ database
                    ResultSet resultSet=dbConnection.statement.executeQuery(sql);
                    if (resultSet.next()) {          //Kiểm tra dữ liệu nhập vào có trùng với dữ liệu trong database hay không
                        // Kiểm tra và xử lý phân quyền dựa trên roleId
                            JOptionPane.showMessageDialog(null, "ログイン成功");
                        int roleId =resultSet.getInt("role_id");
                        EmployeeReader employeeReader=new EmployeeReader();
                        if (roleId == 1) {
                            // Nếu là admin thì hiển thị màn hình AdminUI
                            employeeReader.showAdminUI();
                            login.dispose();
                            this.setVisible(false);
                        } else if (roleId == 2) {
                            // Nếu là nhân viên thì hiển thị màn hình EmployeeUI
//                            JOptionPane.showMessageDialog(null, "ログイン成功");
                            employeeReader.showEmployeeUI();
                            login.dispose();
                            this.setVisible(false);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "ユーザー名またはパスワードが正しくありません");
                        int click=JOptionPane.showConfirmDialog(null, "アカウントを探す", "Notification", JOptionPane.YES_NO_OPTION);
                        if (click == JOptionPane.YES_OPTION) {
                            ForgetPassword forgetPassword=new ForgetPassword();
                            forgetPassword.setVisible(true);
                            this.setVisible(false);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (ae.getSource() == btnCancel) { //Nếu nhấn nút btnCancel
            System.exit(0); //Thoát chương trình
        } else if (ae.getSource() == btnForgotPassword) { //Nếu nhấn nút btnForgotPassword
            ForgetPassword forgetPassword=new ForgetPassword(); //Hiển thị màn hình ForgetPassword
            forgetPassword.setVisible(true);
            this.setVisible(false);
            this.dispose();
        }
    }
    public void showLoginFrame() {
        login.setVisible(true);
    }
    public void showFrontPage() {
        frontPage.setVisible(true);
    }
    public static void main(String[] args) {
        // Tạo giao diện
        MainUI mainUI=new MainUI();
        mainUI.showFrontPage();
    }
}