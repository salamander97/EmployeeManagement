package nexus.employee;

import nexus.employee.DataBase.DBConnection;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ForgetPassword implements ActionListener {
    JFrame forgotPW,changePW;
    JTextField jtxID;
    JLabel lblID, lblNew, lblConfirm, lblImage,lblImage1, lblKeyID;
    JButton btnCheck, btnCancel, btnChange, btnReturn;
    JPasswordField jtxPConfirm, jtxPNew, jtxKeyID;
    public String key_ID;
    public ForgetPassword() {
        // Frame Details
        forgotPW=new JFrame("FORGOT PASSWORD");
        forgotPW.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        forgotPW.setResizable(false);
        forgotPW.setLayout(null);
        forgotPW.setBackground(Color.green);
        forgotPW.setLayout(null);

        // Background Image
        lblImage1=new JLabel();
        lblImage1.setBounds(0, 0, 900, 600);
        lblImage1.setLayout(null);
        ImageIcon img1=new ImageIcon("src/nexus/employee/images/forgetPassword.png");
        lblImage1.setIcon(img1);

        lblImage=new JLabel();
        lblImage.setBounds(0, 0, 900, 600);
        lblImage.setLayout(null);
        ImageIcon img=new ImageIcon("src/nexus/employee/images/forgetPassword.png");
        lblImage.setIcon(img);
        forgotPW.add(lblImage);

        lblID=new JLabel("KEY ID:");
        lblID.setVisible(true);
        lblID.setBounds(150, 250, 150, 30);
        lblID.setForeground(Color.BLACK);
        lblID.setFont(new Font("serif", Font.BOLD, 20));
        lblImage.add(lblID);

        // Key Id Text Field
        jtxID=new JTextField();
        jtxID.setBounds(320, 250, 200, 30);
        jtxID.setFont(new Font("serif", Font.BOLD, 18));
        lblImage.add(jtxID);

        // Change button
        btnCheck=new JButton("検索");
        btnCheck.setBounds(320, 300, 110, 30);
        btnCheck.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE, 3),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)));
        btnCheck.setBackground(Color.BLACK);
        btnCheck.setForeground(Color.WHITE);
        btnCheck.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        lblImage.add(btnCheck);

        // Cancel button
        btnCancel=new JButton("キャンセル");
        btnCancel.setBounds(435, 300, 140, 30);
        btnCancel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE, 3),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        btnCancel.setBackground(Color.BLACK);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        lblImage.add(btnCancel);

        btnCheck.addActionListener(this);
        btnCancel.addActionListener(this);

        // New, Confirm Password, and Key ID Label Details
        lblNew=new JLabel("新しいパスワード:");
        lblNew.setBounds(40, 200, 250, 30);
        lblNew.setForeground(Color.BLACK);
        lblNew.setFont(new Font("serif", Font.BOLD, 20));
        lblImage.add(lblNew);

        lblConfirm=new JLabel("新しいパスワード（確認）:");
        lblConfirm.setBounds(40, 250, 250, 30);
        lblConfirm.setForeground(Color.BLACK);
        lblConfirm.setFont(new Font("serif", Font.BOLD, 20));
        lblImage.add(lblConfirm);

        lblKeyID=new JLabel("新しい　ID　キー:");
        lblKeyID.setBounds(40, 300, 250, 30);
        lblKeyID.setForeground(Color.BLACK);
        lblKeyID.setFont(new Font("serif", Font.BOLD, 20));
        lblImage.add(lblKeyID);

        // New, Confirm Password, and New Key ID Text Fields
        jtxPNew=new JPasswordField();
        jtxPNew.setBounds(310, 200, 190, 30);
        jtxPNew.setFont(new Font("serif", Font.BOLD, 18));
        lblImage.add(jtxPNew);

        jtxPConfirm=new JPasswordField();
        jtxPConfirm.setBounds(310, 250, 190, 30);
        jtxPConfirm.setFont(new Font("serif", Font.BOLD, 18));
        lblImage.add(jtxPConfirm);

        jtxKeyID=new JPasswordField();
        jtxKeyID.setBounds(310, 300, 190, 30);
        jtxKeyID.setFont(new Font("serif", Font.BOLD, 18));
        lblImage.add(jtxKeyID);

        // Button Change
        btnChange=new JButton("変更");
        btnChange.setBounds(140, 350, 220, 40);
        btnChange.setBackground(Color.WHITE);
        btnChange.setForeground(Color.BLACK);
        btnChange.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        lblImage.add(btnChange);
        btnChange.addActionListener(this);

        // Button Return
        btnReturn=new JButton("戻る");
        btnReturn.setBounds(380, 350, 120, 40);
        btnReturn.setBackground(Color.WHITE);
        btnReturn.setForeground(Color.BLACK);
        btnReturn.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        lblImage.add(btnReturn);
        btnReturn.addActionListener(this);
        btnReturn.setVisible(false);

        lblNew.setVisible(false);
        lblConfirm.setVisible(false);
        lblKeyID.setVisible(false);
        jtxPNew.setVisible(false);
        jtxPConfirm.setVisible(false);
        jtxKeyID.setVisible(false);
        btnChange.setVisible(false);

        forgotPW.setSize(900, 600);
        forgotPW.setLocation(300, 200);
        forgotPW.setVisible(true);


        changePW=new JFrame("パスワードを変更する");
        changePW.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        changePW.setResizable(false);
        changePW.setLayout(null);
        changePW.setBackground(Color.green);
        changePW.setLayout(null);
        changePW.setSize(900, 600);
        changePW.setLocation(300, 200);
        changePW.setVisible(false);
        changePW.add(lblImage1);
        key_ID=String.valueOf(MainUI.keyID);
        System.out.println(key_ID);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnCancel) {
            forgotPW.dispose();
            MainUI mainUI=new MainUI();
        }

        if (ae.getSource() == btnCheck) {
            try {
                DBConnection dbConnection=new DBConnection();
                String keyID=jtxID.getText();
                if (keyID.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "キーIDを入力してください。");
                } else if (!isValidKeyID(keyID)) {
                    JOptionPane.showMessageDialog(null, "キーIDは6桁の数字でなければなりません。");
                } else {
                    String str="select * from login where id = ?";
                    PreparedStatement preparedStatement=dbConnection.connection.prepareStatement(str);
                    preparedStatement.setString(1, keyID);
                    ResultSet rs=preparedStatement.executeQuery();
                    int i=0;
                    if (rs.next()) {
                        String keyid=rs.getString(1);
                        if (keyid.equalsIgnoreCase(keyID)) {
                            i=1;
                        }
                    }
                    if (i == 0) {
                        forgotPW.dispose();
                        JOptionPane.showMessageDialog(null, "キーIDが存在しません");
                        ForgetPassword fp=new ForgetPassword();
                    }
                    if (i == 1) {
                        showChangePasswordFrame();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "エラーが発生しました。もう一度お試しください");
            }
        }

        if (ae.getSource() == btnChange) {
            String newpassword=jtxPNew.getText();
            String confirmpassword=jtxPConfirm.getText();
            String newkeyid=jtxKeyID.getText();
            if (newpassword.isEmpty()) {
                JOptionPane.showMessageDialog(null, "新しいパスワードを入力してください。");
            } else if (confirmpassword.isEmpty()) {
                JOptionPane.showMessageDialog(null, "新しいパスワード(確認)を入力してください。");
            } else if (newkeyid.isEmpty()) {
                JOptionPane.showMessageDialog(null, "新しいキーIDを入力してください。");
            } else if (!isValidKeyID(newkeyid)) {
                JOptionPane.showMessageDialog(null, "キーIDは6桁の数字でなければなりません。");
            } else if (!isValidPassword(newpassword)) {
                JOptionPane.showMessageDialog(null, "パスワードは少なくとも8文字で、" +
                        "少なくとも1つの大文字の文字と1つの数字を含める必要があります.");
            } else if (!newpassword.equals(confirmpassword)) {
                JOptionPane.showMessageDialog(null, "パスワードが同じではありません");
            }else {
                try {
                    DBConnection dbConnection=new DBConnection();
                    String str="SELECT id FROM login WHERE id = ?";
                    PreparedStatement preparedStatement=dbConnection.connection.prepareStatement(str);
                    preparedStatement.setString(1, newkeyid);
                    ResultSet rs=preparedStatement.executeQuery();

                    if (rs.next()) {
                        // Kiểm tra xem newkeyid đã tồn tại trong cơ sở dữ liệu chưa
                        JOptionPane.showMessageDialog(null, "新しいキーIDは既に存在します。");
                    } else {
                        str="UPDATE login SET password=?, id=? WHERE id=?";
                        preparedStatement=dbConnection.connection.prepareStatement(str);
                        preparedStatement.setString(1, newpassword);
                        preparedStatement.setString(2, newkeyid);
                        preparedStatement.setString(3, jtxID.getText());
                        int rowsUpdated=preparedStatement.executeUpdate();
                        if (rowsUpdated > 0) {
                            JOptionPane.showMessageDialog(null, "パスワードの変更に成功しました");
                            forgotPW.dispose();
                            MainUI mainUI=new MainUI();
                        } else {
                            JOptionPane.showMessageDialog(null, "パスワードの変更に失敗しました");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "エラーが発生しました。もう一度お試しください");
                }
            }
        }
        if (ae.getSource() == btnReturn) {
            forgotPW.dispose();
            MainUI mainUI=new MainUI();
            mainUI.showLoginFrame();
        }

// Kiểm tra mật khẩu có đủ tối thiểu 8 ký tự và ít nhất 1 chữ hoa và 1 số

    }

    private boolean isValidKeyID(String keyID) {
        if (keyID.length() != 6) {              // Kiểm tra xem có đủ 6 ký tự không
            return false;
        }
        try {
            Integer.parseInt(keyID);
            return true;                        // Trả về true nếu là số
        } catch (NumberFormatException e) {
            return false;                       // Trả về false nếu không phải là số
        }
    }

    private boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUppercase=false;
        boolean hasDigit=false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase=true;            // Kiểm tra xem có chữ hoa không
            } else if (Character.isDigit(c)) {
                hasDigit=true;                // Kiểm tra xem có số không
            }
        }
        return hasUppercase && hasDigit;        // Trả về true nếu có chữ hoa và số
    }

    public static void main(String[] args) {
        ForgetPassword f=new ForgetPassword();
    }

    public void showForgetPasswordFrame() {
        forgotPW.setVisible(true);
    }
    public void showChangePasswordFrame() {
        lblNew.setVisible(true);
        lblConfirm.setVisible(true);
        lblKeyID.setVisible(true);
        jtxPNew.setVisible(true);
        jtxPConfirm.setVisible(true);
        jtxKeyID.setVisible(true);
        btnChange.setVisible(true);
        btnReturn.setVisible(true);
        lblID.setVisible(false);
        jtxID.setVisible(false);
        btnCheck.setVisible(false);
        btnCancel.setVisible(false);
        changePW.setVisible(true);
    }
    public void setVisible(boolean b) {
    }
}
