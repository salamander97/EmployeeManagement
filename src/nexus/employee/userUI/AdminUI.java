package nexus.employee.userUI;

import com.sun.tools.javac.Main;
import nexus.employee.DataBase.AccRegDB;
import nexus.employee.DataBase.DBConnection;
import nexus.employee.EmployeeManager;
import nexus.employee.ForgetPassword;
import nexus.employee.MainUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class AdminUI implements ActionListener {

    JFrame adminJf;
    JLabel jlbImage;
    JButton btnReg,btnAdd, btnRemove, btnView, btnUpdate,btnLogout,btnChangePw;
    private int keyID;
    public AdminUI() {
        MainUI.getKeyIDFromDB(MainUI.username, MainUI.password);
        keyID = MainUI.keyID;
        adminJf=new JFrame("メイン　ページ");
        //Background Image
        jlbImage=new JLabel();
        jlbImage.setBounds(0, 0, 900, 600);
        jlbImage.setLayout(null);
        ImageIcon i=new ImageIcon("src/nexus/employee/images/mainController.png");
        jlbImage.setIcon(i);
        adminJf.add(jlbImage);

        //Adding Buttons
        //1.Add button
        btnAdd=new JButton("追加");
        btnAdd.setBounds(300, 280, 120, 40);
        btnAdd.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        btnAdd.setForeground(Color.BLACK);
        btnAdd.setBackground(Color.LIGHT_GRAY);
        jlbImage.add(btnAdd);

        //2.Remove Button
        btnRemove=new JButton("削除");
        btnRemove.setBounds(300, 350, 120, 40);
        btnRemove.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        btnRemove.setForeground(Color.BLACK);
        btnRemove.setBackground(Color.LIGHT_GRAY);
        jlbImage.add(btnRemove);

        //3.View Button
        btnView=new JButton("閲覧");
        btnView.setBounds(490, 280, 120, 40);
        btnView.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        btnView.setForeground(Color.BLACK);
        btnView.setBackground(Color.LIGHT_GRAY);
        jlbImage.add(btnView);

        //4.Update button
        btnUpdate=new JButton("更新");
        btnUpdate.setBounds(490, 350, 120, 40);
        btnUpdate.setFont(new Font("Times_New_Roman", Font.BOLD,18));
        btnUpdate.setForeground(Color.BLACK);
        btnUpdate.setBackground(Color.LIGHT_GRAY);
        jlbImage.add(btnUpdate);

        btnReg=new JButton("登録");
        btnReg.setBounds(300, 420, 120, 40);
        btnReg.setFont(new Font("Times_New_Roman", Font.BOLD,18));
        btnReg.setForeground(Color.BLACK);
        btnReg.setBackground(Color.LIGHT_GRAY);
        jlbImage.add(btnReg);

        // Thiết lập nút ForgotPassword
        btnChangePw=new JButton("パスワードを変更する");
        btnChangePw.setBounds(350,490,200,35);
        btnChangePw.setBackground(Color.GRAY);
        btnChangePw.setFont(new Font("Times_New_Roman",Font.BOLD,18));
        jlbImage.add(btnChangePw);

        btnLogout=new JButton("ログアウト");
        btnLogout.setBounds(490, 420, 120, 40);
        btnLogout.setFont(new Font("Times_New_Roman", Font.BOLD,18));
        btnLogout.setForeground(Color.BLACK);
        btnLogout.setBackground(Color.LIGHT_GRAY);
        jlbImage.add(btnLogout);

        //Thêm ActionListener cho các nút

        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnView.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnReg.addActionListener(this);
        btnLogout.addActionListener(this);
        btnChangePw.addActionListener(e -> {
            MainUI.keyID = keyID;
            boolean validPassword = false;
            while (!validPassword) {
                try {
                    JPasswordField newPasswordField = new JPasswordField();
                    JPasswordField confirmPasswordField = new JPasswordField();

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
                                JOptionPane.showMessageDialog(null, "パスワードを更新できませんでした。");
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
        adminJf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        adminJf.setResizable(false);
        adminJf.setLayout(null);
        adminJf.setLocation(300, 200);
        adminJf.setSize(900, 600);
        adminJf.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        EmployeeManager employeeManager=new EmployeeManager();
        if (ae.getSource() == btnAdd) {
            adminJf.setVisible(false);
            adminJf.dispose();
            employeeManager.showAddFrame();
        } else if (ae.getSource() == btnRemove) {
            adminJf.setVisible(false);
            adminJf.dispose();
            employeeManager.showRemoveFrame();
        } else if (ae.getSource() == btnView) {
            adminJf.setVisible(false);
            adminJf.dispose();
            employeeManager.showSearchFrame();
        } else if (ae.getSource() == btnUpdate) {
            adminJf.setVisible(false);
            adminJf.dispose();
            employeeManager.showUpdateFrame();
        }else if (ae.getSource()==btnReg){
            adminJf.setVisible(false);
            adminJf.dispose();
            AccRegDB accRegDB=new AccRegDB();
            AccRegDB.showRegFrame();
        }else if (ae.getSource() == btnLogout) {
            DBConnection dbConnection=new DBConnection();
            dbConnection.closeConnection();
            MainUI mainUI=new MainUI();
            mainUI.showFrontPage();
            adminJf.setVisible(false);
            adminJf.dispose();
        }
    }
    public static void main(String[] args) {
        new AdminUI();
    }

    public void setVisible(boolean b) {
        adminJf.setVisible(b);
    }

    public void showAdminFrame() {
        adminJf.setVisible(true);
    }

    // Kiểm tra xem chuỗi có chứa chữ cái viết hoa
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

}


