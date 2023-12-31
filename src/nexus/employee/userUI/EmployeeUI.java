package nexus.employee.userUI;

import nexus.employee.DataBase.DBConnection;
import nexus.employee.MainUI;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeUI {
    JFrame userJf;
    JLabel jlbImage,jlbFace;
    JButton btnView,btnChangePW,btnLogout,btnSearchInfor,btnCancel,btnReturn;
    private String employeeId, name, gender, dob, address, email, phone, position, role_id;
    private MainUI mainUI;
    private  int keyID;


    public EmployeeUI() {

        // Background Image
        jlbImage=new JLabel();
        jlbImage.setBounds(0, 0, 900, 600);
        jlbImage.setLayout(null);
        ImageIcon img=new ImageIcon("src/nexus/employee/images/frontPage.png");
        ImageIcon i=new ImageIcon("src/nexus/employee/images/mainController.png");

        userJf=new JFrame("閲覧");
        userJf.setSize(900, 600);
        userJf.setLocation(300, 200);
        userJf.setResizable(false);
        userJf.setLayout(null);
        userJf.add(jlbImage);
        jlbImage.setIcon(i);

        btnView=new JButton("検索");
        btnView.setBounds(310, 400, 120, 40);
        btnView.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        btnView.setForeground(Color.BLACK);
        btnView.setBackground(Color.LIGHT_GRAY);
        jlbImage.add(btnView);

        btnChangePW=new JButton("パスワードを変更");
        btnChangePW.setBounds(340, 460, 200, 40);
        btnChangePW.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        btnChangePW.setForeground(Color.BLACK);
        btnChangePW.setBackground(Color.LIGHT_GRAY);
        jlbImage.add(btnChangePW);

        btnLogout=new JButton("ログアウト");
        btnLogout.setBounds(470, 400, 120, 40);
        btnLogout.setFont(new Font("Times_New_Roman", Font.BOLD,18));
        btnLogout.setForeground(Color.BLACK);
        btnLogout.setBackground(Color.LIGHT_GRAY);
        jlbImage.add(btnLogout);


        JLabel jlbTitle,jlbInfor,jlbName,jlbAddress,jlbPhone,jlbEmail,jlbGender,jlbPos,jlbID,jlbDob,jlbRoleID,
                jlbSName,jlbSAddress,jlbSPhone,jlbSEmail,jlbSGender,jlbSPos,jlbSID,jlbSDob,jlbSRoleID;
        JTextField jtxInforSearch;

        jlbTitle =new JLabel("従業員の検索");
        jlbTitle.setBounds(350, 50, 620, 50);
        jlbTitle.setFont(new Font("Serif", Font.BOLD, 40));
        jlbTitle.setForeground(Color.BLACK);
        jlbImage.add(jlbTitle);


        //Label Details
        jlbInfor=new JLabel("従業員の情報");
        jlbInfor.setBounds(230, 250, 250, 50);
        jlbInfor.setForeground(Color.BLACK);
        jlbInfor.setFont(new Font("Times_New_Roman", Font.BOLD, 25));
        jlbImage.add(jlbInfor);

        jtxInforSearch=new JTextField("氏名、電話番号、メール、従業員のIDを入力");
        jtxInforSearch.setBounds(400, 255, 380, 40);
        jtxInforSearch.setFont(new Font("serif", Font.BOLD, 18));
        jlbImage.add(jtxInforSearch);

        //Button Details
        btnSearchInfor=new JButton("検索");
        btnSearchInfor.setBounds(300, 330, 140, 35);
        btnSearchInfor.setBackground(Color.LIGHT_GRAY);
        btnSearchInfor.setForeground(Color.BLACK);
        btnSearchInfor.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        jlbImage.add(btnSearchInfor);
        btnCancel=new JButton("キャンセル");
        btnCancel.setBounds(460, 330, 140, 35);
        btnCancel.setBackground(Color.LIGHT_GRAY);
        btnCancel.setForeground(Color.BLACK);
        btnCancel.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        jlbImage.add(btnCancel);

        btnReturn=new JButton("戻る");
        btnReturn.setBounds(400, 480, 120, 40);
        btnReturn.setBackground(Color.LIGHT_GRAY);
        btnReturn.setForeground(Color.BLACK);
        btnReturn.setFont(new Font("serif", Font.BOLD, 18));
        jlbImage.add(btnReturn);

        //Label Details

        //1.Name
        jlbName=new JLabel("氏名:");
        jlbName.setBounds(150, 140, 100, 30);
        jlbName.setFont(new Font("serif", Font.BOLD, 20));
        jlbImage.add(jlbName);

        jlbSName=new JLabel();
        jlbSName.setBounds(250, 140, 200, 30);
        jlbSName.setFont(new Font("serif", Font.BOLD, 20));
        jlbImage.add(jlbSName);

        //2.Address
        jlbAddress=new JLabel("住所:");
        jlbAddress.setBounds(450, 140, 200, 30);
        jlbAddress.setFont(new Font("serif", Font.BOLD, 20));
        jlbImage.add(jlbAddress);

        jlbSAddress=new JLabel();
        jlbSAddress.setBounds(550, 140, 150, 30);
        jlbSAddress.setFont(new Font("serif", Font.BOLD, 20));
        jlbImage.add(jlbSAddress);

        //3.Mobile No.
        jlbPhone=new JLabel("電話番号:");
        jlbPhone.setBounds(150, 200, 100, 30);
        jlbPhone.setFont(new Font("serif", Font.BOLD, 20));
        jlbImage.add(jlbPhone);

        jlbSPhone=new JLabel();
        jlbSPhone.setBounds(250, 200, 150, 30);
        jlbSPhone.setFont(new Font("serif", Font.BOLD, 20));
        jlbImage.add(jlbSPhone);

        //4.Email Id
        jlbEmail=new JLabel("メール:");
        jlbEmail.setBounds(150, 200, 100, 30);
        jlbEmail.setFont(new Font("serif", Font.BOLD, 20));
        jlbImage.add(jlbEmail);

        jlbSEmail=new JLabel();
        jlbSEmail.setBounds(250, 200, 200, 30);
        jlbSEmail.setFont(new Font("serif", Font.BOLD, 20));
        jlbImage.add(jlbSEmail);

        //5.Gender
        jlbGender=new JLabel("性別:");
        jlbGender.setBounds(150, 260, 100, 30);
        jlbGender.setFont(new Font("serif", Font.BOLD, 20));
        jlbImage.add(jlbGender);

        jlbSGender=new JLabel();
        jlbSGender.setBounds(250, 260, 150, 30);
        jlbSGender.setFont(new Font("serif", Font.BOLD, 20));
        jlbImage.add(jlbSGender);

        //6.Job Position
        jlbPos=new JLabel("職位:");
        jlbPos.setBounds(150, 380, 100, 30);
        jlbPos.setFont(new Font("serif", Font.BOLD, 20));
        jlbImage.add(jlbPos);

        jlbSPos=new JLabel();
        jlbSPos.setBounds(250, 380, 150, 30);
        jlbSPos.setFont(new Font("serif", Font.BOLD, 20));
        jlbImage.add(jlbSPos);

        //7.Employee ID
        jlbID=new JLabel("従業員ID:");
        jlbID.setBounds(150, 320, 150, 30);
        jlbID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImage.add(jlbID);

        jlbSID=new JLabel();
        jlbSID.setBounds(250, 320, 150, 30);
        jlbSID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImage.add(jlbSID);

        //8.Date of Birth
        jlbDob=new JLabel("生年月日:");
        jlbDob.setBounds(450, 320, 150, 30);
        jlbDob.setFont(new Font("serif", Font.BOLD, 20));
        jlbImage.add(jlbDob);

        jlbSDob=new JLabel();
        jlbSDob.setBounds(550, 320, 150, 30);
        jlbSDob.setFont(new Font("serif", Font.BOLD, 20));
        jlbImage.add(jlbSDob);

        //9.Role ID
        jlbRoleID=new JLabel("役割ID:");
        jlbRoleID.setBounds(150, 380, 150, 30);
        jlbRoleID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImage.add(jlbRoleID);

        jlbSRoleID=new JLabel();
        jlbSRoleID.setBounds(250, 380, 150, 30);
        jlbSRoleID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImage.add(jlbSRoleID);
        jlbFace = new JLabel();  // Initialize jlbFace
        jlbFace.setBounds(550, 40, 300, 450);
        jlbImage.add(jlbFace);

        jlbFace.setVisible(false);

        // Đặt hình ảnh điều chỉnh vào jlbFace
        jlbFace.setVisible(false);
        jlbTitle.setVisible(false);
        jlbName.setVisible(false);
        jlbAddress.setVisible(false);
        jlbPhone.setVisible(false);
        jlbEmail.setVisible(false);
        jlbGender.setVisible(false);
        jlbPos.setVisible(false);
        jlbID.setVisible(false);
        jlbDob.setVisible(false);
        jlbRoleID.setVisible(false);
        jlbInfor.setVisible(false);
        jtxInforSearch.setVisible(false);

        btnReturn.setVisible(false);
        btnSearchInfor.setVisible(false);
        btnCancel.setVisible(false);

        btnSearchInfor.addActionListener(e -> {
            DBConnection dbConnection=new DBConnection(); // Tạo kết nối cơ sở dữ liệu
            String searchTerm=jtxInforSearch.getText(); // Lấy giá trị từ JTextField
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
                if (rs.next()) {
                    // Lấy thông tin từ ResultSet
                    employeeId=rs.getString("employee_id");
                    name=rs.getString("name");
                    gender=rs.getString("gender");
                    dob=rs.getString("dob");
                    address=rs.getString("address");
                    email=rs.getString("email");
                    phone=rs.getString("phone");
                    position=rs.getString("position");
                    role_id=rs.getString("role_id");
                    JOptionPane.showMessageDialog(null, "従業員が見つかりました");
                    String imagePath = "src/nexus/employee/images/employeeImg/" + employeeId + ".jpg";
                    try {
                        BufferedImage image = ImageIO.read(new File(imagePath));

                        // Lấy kích thước thực của hình ảnh
                        int imgWidth = image.getWidth();
                        int imgHeight = image.getHeight();

                        // Kích thước của jlbFace
                        int labelWidth = 200;
                        int labelHeight = 450;

                        // Tính toán tỷ lệ để điều chỉnh kích thước hình ảnh
                        double scaleFactor = Math.min(1.0 * labelWidth / imgWidth, 1.0 * labelHeight / imgHeight);

                        // Tính toán kích thước mới dựa trên tỷ lệ
                        int newWidth = (int) (imgWidth * scaleFactor);
                        int newHeight = (int) (imgHeight * scaleFactor);

                        // Sử dụng getScaledInstance để điều chỉnh kích thước hình ảnh
                        Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

                        // Đặt hình ảnh điều chỉnh vào jlbFace
                        jlbFace.setIcon(new ImageIcon(scaledImage));
                        jlbFace.setVisible(true);
                    } catch (Exception ae) {
                        imagePath = "src/nexus/employee/images/employeeImg/Default.png";
                        BufferedImage image = ImageIO.read(new File(imagePath));
                        int imgWidth = image.getWidth();
                        int imgHeight = image.getHeight();

                        // Kích thước của jlbFace
                        int labelWidth = 300;
                        int labelHeight = 350;

                        // Tính toán tỷ lệ để điều chỉnh kích thước hình ảnh
                        double scaleFactor = Math.min(1.0 * labelWidth / imgWidth, 1.0 * labelHeight / imgHeight);

                        // Tính toán kích thước mới dựa trên tỷ lệ
                        int newWidth = (int) (imgWidth * scaleFactor);
                        int newHeight = (int) (imgHeight * scaleFactor);

                        // Sử dụng getScaledInstance để điều chỉnh kích thước hình ảnh
                        Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

                        jlbFace.setIcon(new ImageIcon(image));
                        jlbFace.setVisible(true);
                        Logger.getLogger(EmployeeUI.class.getName()).log(Level.SEVERE, "Exception occurred", ae);
                    }
                    // Hiển thị thông tin (ví dụ: sử dụng System.out.println hoặc hiển thị trong giao diện người dùng)
                    jlbName.setVisible(true);
                    jlbAddress.setVisible(false);
                    jlbPhone.setVisible(false);
                    jlbEmail.setVisible(true);
                    jlbGender.setVisible(true);
                    jlbPos.setVisible(true);
                    jlbID.setVisible(true);
                    jlbDob.setVisible(false);
                    jlbRoleID.setVisible(false);
                    jlbSID.setText(employeeId);
                    jlbSName.setText(name);
                    jlbSGender.setText(gender);
                    jlbSDob.setText(dob);
                    jlbSAddress.setText(address);
                    jlbSEmail.setText(email);
                    jlbSPhone.setText(phone);
                    jlbSPos.setText(position);
                    jlbSRoleID.setText(role_id);
                    jlbSID.setVisible(true);
                    jlbSName.setVisible(true);
                    jlbSGender.setVisible(true);
                    jlbSDob.setVisible(false);
                    jlbSAddress.setVisible(false);
                    jlbSEmail.setVisible(true);
                    jlbSPhone.setVisible(false);
                    jlbSPos.setVisible(true);
                    jlbSRoleID.setVisible(false);
                    jtxInforSearch.setVisible(false);
                    jlbInfor.setVisible(false);
                    btnChangePW.setVisible(false);
                    jlbFace.setVisible(true);
                    btnLogout.setVisible(false);
                    btnView.setVisible(false);
                    btnSearchInfor.setVisible(false);
                    btnCancel.setVisible(false);
                    btnReturn.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "従業員が見つかりません");
                }
            } catch (Exception ex) {
                Logger.getLogger(EmployeeUI.class.getName()).log(Level.SEVERE, "Exception occurred", ex);
            }
        });
        btnReturn.addActionListener(e -> {
            jlbInfor.setVisible(true);
            jtxInforSearch.setVisible(true);
            jtxInforSearch.setText("氏名、電話番号、メール、従業員のIDを入力");
            btnSearchInfor.setVisible(true);
            btnCancel.setVisible(true);
            btnReturn.setVisible(false);
            jlbName.setVisible(false);
            jlbSName.setVisible(false);
            jlbGender.setVisible(false);
            jlbSGender.setVisible(false);
            jlbDob.setVisible(false);
            jlbSDob.setVisible(false);
            jlbAddress.setVisible(false);
            jlbSAddress.setVisible(false);
            jlbEmail.setVisible(false);
            jlbSEmail.setVisible(false);
            jlbPhone.setVisible(false);
            jlbSPhone.setVisible(false);
            jlbPos.setVisible(false);
            jlbSPos.setVisible(false);
            jlbID.setVisible(false);
            jlbSID.setVisible(false);
            jlbRoleID.setVisible(false);
            jlbSRoleID.setVisible(false);
            jlbFace.setVisible(false);
        });

        btnView.addActionListener(e -> {
            jlbImage.setIcon(img);
            btnSearchInfor.setVisible(true);
            btnCancel.setVisible(true);
            btnChangePW.setVisible(false);
            jlbInfor.setVisible(true);
            jtxInforSearch.setVisible(true);
            jlbTitle.setVisible(false);

            btnView.setVisible(false);
            btnReturn.setVisible(false);
            btnLogout.setVisible(false);
            jlbName.setVisible(false);
            jlbSName.setVisible(false);
            jlbGender.setVisible(false);
            jlbSGender.setVisible(false);
            jlbDob.setVisible(false);
            jlbSDob.setVisible(false);
            jlbAddress.setVisible(false);
            jlbSAddress.setVisible(false);
            jlbEmail.setVisible(false);
            jlbSEmail.setVisible(false);
            jlbPhone.setVisible(false);
            jlbSPhone.setVisible(false);
            jlbPos.setVisible(false);
            jlbSPos.setVisible(false);
            jlbID.setVisible(false);
            jlbSID.setVisible(false);
            jlbRoleID.setVisible(false);
            jlbSRoleID.setVisible(false);

        });
        btnCancel.addActionListener(e -> {
            jlbImage.setIcon(i);
            btnView.setVisible(true);
            btnLogout.setVisible(true);
            btnChangePW.setVisible(true);

            btnSearchInfor.setVisible(false);
            btnCancel.setVisible(false);

            jlbInfor.setVisible(false);
            jtxInforSearch.setVisible(false);
            jlbTitle.setVisible(false);
            jlbName.setVisible(false);
            jlbSName.setVisible(false);
            jlbGender.setVisible(false);
            jlbSGender.setVisible(false);
            jlbDob.setVisible(false);
            jlbSDob.setVisible(false);
            jlbAddress.setVisible(false);
            jlbSAddress.setVisible(false);
            jlbEmail.setVisible(false);
            jlbSEmail.setVisible(false);
            jlbPhone.setVisible(false);
            jlbSPhone.setVisible(false);
            jlbPos.setVisible(false);
            jlbSPos.setVisible(false);
            jlbID.setVisible(false);
            jlbSID.setVisible(false);
            jlbRoleID.setVisible(false);
            jlbSRoleID.setVisible(false);
        });
        btnChangePW.addActionListener(e -> {
            boolean validPassword = false;
            while (!validPassword) {
                try {
                    JPasswordField newPasswordField = new JPasswordField();
                    JPasswordField confirmPasswordField = new JPasswordField();
                    keyID = MainUI.keyID;
                    JPanel panel = new JPanel(new GridLayout(0, 1));
                    panel.add(new JLabel("新しいパスワード:"));
                    panel.add(newPasswordField);
                    panel.add(new JLabel("新しいパスワードを再入力:"));
                    panel.add(confirmPasswordField);

                    int option = JOptionPane.showConfirmDialog(null, panel, "パスワードを変更:", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION) {
                        char[] newPasswordChars = newPasswordField.getPassword();
                        char[] confirmPasswordChars = confirmPasswordField.getPassword();
                        String newPassword = new String(newPasswordChars);
                        String confirmPassword = new String(confirmPasswordChars);

                        if (!newPassword.equals(confirmPassword)) {
                            JOptionPane.showMessageDialog(null, "パスワードが一致しません。");
                        } else if (newPassword.length() < 8 || !containsUppercase(newPassword) || !containsLowercase(newPassword) || !containsDigit(newPassword)) {
                            JOptionPane.showMessageDialog(null, "パスワードは少なくとも8文字で、少なくとも1つの大文字の文字と1つの数字を含める必要があります.");
                        } else {
                            DBConnection dbConnection = new DBConnection();
                            String sql = "UPDATE login SET password=? WHERE id=?";
                            PreparedStatement preparedStatement = dbConnection.connection.prepareStatement(sql);
                            preparedStatement.setString(1, newPassword);
                            preparedStatement.setInt(2, keyID);

                            int rowsAffected = preparedStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(null, "パスワードを更新しました。");
                                validPassword = true;
                            } else {
                                JOptionPane.showMessageDialog(null, "パスワードを更新できませんでした。もう１度お試しください。");
                            }
                        }
                    } else {
                        break;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnLogout.addActionListener(e -> {
           userJf.setVisible(false);
           userJf.dispose();
           mainUI = new MainUI();
           mainUI.showLoginFrame();
       });
    }
    private boolean containsUppercase(String s) {
        return !s.equals(s.toLowerCase());
    }

    // Kiểm tra xem chuỗi có chứa chữ cái viết thường
    private boolean containsLowercase(String s) {
        return !s.equals(s.toUpperCase());
    }

    // Kiểm tra xem chuỗi có chứa chữ số
    private boolean containsDigit(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
    public void setVisible(boolean b) {
        userJf.setVisible(b);
    }

    public static void main(String[] args) {
        new EmployeeUI();
    }
}
