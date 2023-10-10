package nexus.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MainController extends JFrame implements ActionListener {
    CardLayout cardLayout = new CardLayout(); //Khai báo cardLayout
    JPanel cardPanel = new JPanel(cardLayout); //Khai báo cardPanel

    // Các component cho FrontPage
    JLabel frontPageBackground;
    JLabel lblTitle;
    JButton btnLogin;

    // Các component cho Login
    JLabel loginBackground;
    JLabel lblUsername;
    JLabel lblPassword;
    JTextField jtfUsername;
    JPasswordField jPasswordField;
    JButton btnLogin1;
    JButton btnCancel;
    JButton btnForgotPassword;

    // Các phương thức khai báo và xử lý chức năng
    public MainController() {

        // Thiết lập FrontPage Background Image
        frontPageBackground = new JLabel();
        frontPageBackground.setIcon(new ImageIcon("src/nexus/employee/images/frontPage_1.png"));
        frontPageBackground.setBounds(0, 0, 900, 600); //Đặt vị trí và kích thước cho frontPageBackground
        frontPageBackground.setSize(900, 600);

        // Thiết lập Login Background Image
        loginBackground = new JLabel();
        loginBackground.setIcon(new ImageIcon("src/nexus/employee/images/login.png"));
        loginBackground.setBounds(0, 0, 900, 600); //Đặt vị trí và kích thước cho loginBackground
        loginBackground.setSize(900, 600);

        // Thiết lập JFrame
        this.add(frontPageBackground); //Thêm frontPageBackground vào JFrame
        this.setTitle("従業員の管理システム"); //Thêm title cho JFrame
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Đóng chương trình khi nhấn nút đỏ
        this.setResizable(false); //Không cho phép thay đổi kích thước JFrame
        this.setLayout(null); //Không sử dụng Layout Manager
        this.setLocation(300, 200); //Đặt vị trí hiển thị JFrame
        this.setSize(900, 600); //Đặt kích thước JFrame

        // Khởi tạo các component cho FrontPage

        // Thiết lập tittle
        lblTitle = new JLabel("従業員の管理システム");
        lblTitle.setBounds(210, 30, 1100, 100); //Đặt vị trí và kích thước cho lblTitle
        lblTitle.setFont(lblTitle.getFont().deriveFont(50.0f)); //Đặt font cho lblTitle
        lblTitle.setForeground(Color.BLACK); //Đặt màu chữ cho lblTitle

        // Thiết lập nút Login
        btnLogin = new JButton("Login");
        btnLogin.setBounds(315, 393, 270, 70);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 64));
        btnLogin.setBackground(Color.WHITE);
        btnLogin.setForeground(new Color(82, 113, 255)); //Đặt màu chữ cho btnLogin
        btnLogin.setOpaque(false); //Đặt nút btnLogin trong suốt
        btnLogin.setContentAreaFilled(true); //Đặt nút btnLogin trong suốt
        btnLogin.setBorderPainted(false); //Đặt nút btnLogin trong suốt

        cardPanel.setBounds(0, 0, 900, 600); //Đặt vị trí và kích thước cho cardPanel
        this.add(cardPanel); //Thêm cardPanel vào JFrame
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hiển thị màn hình Login
                cardLayout.show(cardPanel, "login");
            }
        }); //Thêm sự kiện cho btnLogin
        btnLogin.addActionListener(this); //Thêm sự kiện cho btnLogin

        // Thêm component vào cardPanel
        JPanel frontPagePanel = new JPanel(null);
        frontPagePanel.add(lblTitle);
        frontPagePanel.add(btnLogin);
        frontPagePanel.add(frontPageBackground);
        cardPanel.add(frontPagePanel, "frontPage");

        // Khởi tạo các component cho Login

        // Thiết lập lblUsername
        lblUsername = new JLabel("ユーザー名");
        lblUsername.setBounds(300, 300, 120, 30); //Đặt vị trí và kích thước cho lblUsername
        lblUsername.setFont(lblUsername.getFont().deriveFont(20.0f)); //Đặt font cho lblUsername
        lblUsername.setForeground(Color.black); //Đặt màu chữ cho lblUsername

        // Thiết lập lblPassword
        lblPassword = new JLabel("パスワード");
        lblPassword.setBounds(275, 350, 120, 30); //Đặt vị trí và kích thước cho lblPassword
        lblPassword.setFont(lblPassword.getFont().deriveFont(20.0f)); //Đặt font cho lblPassword
        lblPassword.setForeground(Color.black); //Đặt màu chữ cho lblPassword

        // Thiết lập tfUsername
        jtfUsername = new JTextField();
        jtfUsername.setBounds(400, 300, 180, 30); //Đặt vị trí và kích thước cho tfUsername
        jtfUsername.setFont(jtfUsername.getFont().deriveFont(20.0f)); //Đặt font cho tfUsername
        jtfUsername.setForeground(Color.black); //Đặt màu chữ cho tfUsername
        jtfUsername.setBackground(Color.white); //Đặt màu nền cho tfUsername

        // Thiết lập tfPassword
        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(400, 350, 180, 30); //Đặt vị trí và kích thước cho tfPassword
        jPasswordField.setFont(jPasswordField.getFont().deriveFont(20.0f)); //Đặt font cho tfPassword
        jPasswordField.setForeground(Color.black); //Đặt màu chữ cho tfPassword
        jPasswordField.setBackground(Color.white); //Đặt màu nền cho tfPassword

        // Thiết lập nút Login
        btnLogin1 = new JButton("ログイン");
        btnLogin1.setBounds(190, 395, 130, 30); //Đặt vị trí và kích thước cho btnLogin
        btnLogin1.setBackground(Color.black); //Đặt màu nền cho btnLogin
        btnLogin1.setForeground(Color.BLACK); //Đặt màu chữ cho btnLogin  ＜ーーー
        btnLogin1.setFont(btnLogin1.getFont().deriveFont(16)); //Đặt font cho btnLogin
        btnLogin1.addActionListener(this); //Thêm sự kiện cho btnLogin

        // Thiết lập nút Cancel
        btnCancel = new JButton("キャンセル");
        btnCancel.setBounds(340, 395, 130, 30); //Đặt vị trí và kích thước cho btnCancel
        btnCancel.setBackground(Color.black); //Đặt màu nền cho btnCancel
        btnCancel.setForeground(Color.BLACK); //Đặt màu chữ cho btnCancel
        btnCancel.setFont(btnCancel.getFont().deriveFont(16)); //Đặt font cho btnCancel
        btnCancel.addActionListener(this); //Thêm sự kiện cho btnCancel

        // Thiết lập nút ForgotPassword
        btnForgotPassword = new JButton("パスワードを忘れた");
        btnForgotPassword.setBounds(490, 395, 200, 30); //Đặt vị trí và kích thước cho btnForgotPassword
        btnForgotPassword.setBackground(Color.black); //Đặt màu nền cho btnForgotPassword
        btnForgotPassword.setForeground(Color.BLACK); //Đặt màu chữ cho btnForgotPassword
        btnForgotPassword.setFont(btnForgotPassword.getFont().deriveFont(16)); //Đặt font cho btnForgotPassword
        btnForgotPassword.addActionListener(this); //Thêm sự kiện cho btnForgotPassword

        // Thêm component vào cardPanel
        JPanel loginPanel = new JPanel(null);
        loginPanel.add(lblUsername);
        loginPanel.add(lblPassword);
        loginPanel.add(jtfUsername);
        loginPanel.add(jPasswordField);
        loginPanel.add(btnLogin1);
        loginPanel.add(btnCancel);
        loginPanel.add(btnForgotPassword);
        loginPanel.add(loginBackground);
        cardPanel.add(loginPanel, "login");

        // Thêm cardPanel vào JFrame
        this.add(cardPanel);

        // Hiển thị JFrame
        cardLayout.show(cardPanel, "frontPage");
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) { //Xử lý sự kiện cho các nút
        if (ae.getSource() == btnLogin) { //Nếu nhấn nút btnLogin
            {try{
                DBConnection dbConnection = new DBConnection();
                String username = jtfUsername.getText();
                String password = jPasswordField.getText();
                String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
                ResultSet resultSet = dbConnection.statement.executeQuery(sql);
                if (resultSet.next()){
                    JOptionPane.showMessageDialog(null, "ログイン成功"); 
                    MainPage mainPage = new MainPage();
                    mainPage.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "ユーザー名またはパスワードが正しくありません");
                    setVisible(true);
                }
            }catch(Exception e){
                e.printStackTrace();
            }

            }
        } else if (ae.getSource() == btnCancel) { //Nếu nhấn nút btnCancel
            System.exit(0); //Thoát chương trình
        } else if (ae.getSource() == btnForgotPassword) { //Nếu nhấn nút btnForgotPassword
            JOptionPane.showMessageDialog(null, "パスワードを忘れた"); //Hiển thị thông báo
        }
    }

    public static void main(String[] args) {
        // Tạo giao diện
        SwingUtilities.invokeLater(() -> {
            new MainController();
        });
    }
}