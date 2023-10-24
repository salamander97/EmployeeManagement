package nexus.employee;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ForgetPassword implements ActionListener {
    JFrame jFrame;
    JTextField jtxID;
    JLabel lblID, lblNew, lblConfirm, lblImage, lblKeyID;
    JButton btnCheck, btnCancel, btnChange, btnReturn;
    JPasswordField jtxPConfirm, jtxPNew, jtxKeyID;

    ForgetPassword() {
        // Frame Details
        jFrame = new JFrame("FORGOT PASSWORD");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLayout(null);
        jFrame.setBackground(Color.green);
        jFrame.setLayout(null);

        // Background Image
        lblImage = new JLabel();
        lblImage.setBounds(0, 0, 900, 600);
        lblImage.setLayout(null);
        ImageIcon img = new ImageIcon("src/nexus/employee/images/forgetPassword.png");
        lblImage.setIcon(img);
        jFrame.add(lblImage);

        lblID = new JLabel("KEY ID:");
        lblID.setVisible(true);
        lblID.setBounds(150, 250, 150, 30);
        lblID.setForeground(Color.BLACK);
        lblID.setFont(new Font("serif", Font.BOLD, 20));
        lblImage.add(lblID);

        // Key Id Text Field
        jtxID = new JTextField();
        jtxID.setBounds(320, 250, 200, 30);
        jtxID.setFont(new Font("serif", Font.BOLD, 18));
        lblImage.add(jtxID);

        // Change button
        btnCheck = new JButton("検索");
        btnCheck.setBounds(320, 300, 110, 30);
        btnCheck.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.WHITE, 3),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)));
        btnCheck.setBackground(Color.BLACK);
        btnCheck.setForeground(Color.WHITE);
        btnCheck.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        lblImage.add(btnCheck);

        // Cancel button
        btnCancel = new JButton("キャンセル");
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
        lblNew = new JLabel("新しいパスワード:");
        lblNew.setBounds(40, 200, 250, 30);
        lblNew.setForeground(Color.BLACK);
        lblNew.setFont(new Font("serif", Font.BOLD, 20));
        lblImage.add(lblNew);

        lblConfirm = new JLabel("新しいパスワード（確認）:");
        lblConfirm.setBounds(40, 250, 250, 30);
        lblConfirm.setForeground(Color.BLACK);
        lblConfirm.setFont(new Font("serif", Font.BOLD, 20));
        lblImage.add(lblConfirm);

        lblKeyID = new JLabel("新しい　ID　キー:");
        lblKeyID.setBounds(40, 300, 250, 30);
        lblKeyID.setForeground(Color.BLACK);
        lblKeyID.setFont(new Font("serif", Font.BOLD, 20));
        lblImage.add(lblKeyID);

        // New, Confirm Password, and New Key ID Text Fields
        jtxPNew = new JPasswordField();
        jtxPNew.setBounds(310, 200, 190, 30);
        jtxPNew.setFont(new Font("serif", Font.BOLD, 18));
        lblImage.add(jtxPNew);

        jtxPConfirm = new JPasswordField();
        jtxPConfirm.setBounds(310, 250, 190, 30);
        jtxPConfirm.setFont(new Font("serif", Font.BOLD, 18));
        lblImage.add(jtxPConfirm);

        jtxKeyID = new JPasswordField();
        jtxKeyID.setBounds(310, 300, 190, 30);
        jtxKeyID.setFont(new Font("serif", Font.BOLD, 18));
        lblImage.add(jtxKeyID);

        // Button Change
        btnChange = new JButton("CHANGE PASSWORD");
        btnChange.setBounds(140, 350, 220, 40);
        btnChange.setBackground(Color.WHITE);
        btnChange.setForeground(Color.BLACK);
        btnChange.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        lblImage.add(btnChange);
        btnChange.addActionListener(this);

        // Button Return
        btnReturn = new JButton("RETURN");
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

        jFrame.setSize(900, 600);
        jFrame.setLocation(300, 200);
        jFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnCancel) {
            jFrame.dispose();
            MainUI mainUI = new MainUI();
        }

        if (ae.getSource() == btnCheck) {
            try {
                DBConnection dbConnection = new DBConnection();
                String keyID = jtxID.getText();
                String str = "select * from login where id = ?";
                PreparedStatement preparedStatement = dbConnection.connection.prepareStatement(str);
                preparedStatement.setString(1, keyID);
                ResultSet rs = preparedStatement.executeQuery();
                int i = 0; // i=0 thì keyid không tồn tại
                if (rs.next()) {
                    String keyid = rs.getString(1);
                    if (keyid.equalsIgnoreCase(keyID)) {
                        i = 1; // i=1 thì keyid tồn tại
                    }
                }
                if (i == 0) {
                    jFrame.dispose();
                    JOptionPane.showMessageDialog(null, "キーIDが存在しません");
                    ForgetPassword fp = new ForgetPassword();
                }
                if (i == 1) {
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
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "エラーが発生しました。もう一度お試しください");
            }
        }

        if (ae.getSource() == btnChange) {
            String newpassword = jtxPNew.getText();
            String confirmpassword = jtxPConfirm.getText();
            String newkeyid = jtxKeyID.getText();
            try {
                DBConnection dbConnection = new DBConnection();
                if (newpassword.equals(confirmpassword)) {
                    if (newpassword.length() < 8) {
                        JOptionPane.showMessageDialog(null, "パスワードは8文字以上でなければなりません");
                    } else {
                        String str = "UPDATE login SET password=?, id=? WHERE id=?";
                        PreparedStatement preparedStatement = dbConnection.connection.prepareStatement(str);
                        preparedStatement.setString(1, newpassword);
                        preparedStatement.setString(2, newkeyid);
                        preparedStatement.setString(3, jtxID.getText());
                        int rowsUpdated = preparedStatement.executeUpdate();
                        if (rowsUpdated > 0) {
                            JOptionPane.showMessageDialog(null, "パスワードの変更に成功しました");
                            jFrame.dispose();
                            MainUI mainUI = new MainUI();
                        } else {
                            JOptionPane.showMessageDialog(null, "パスワードの変更に失敗しました");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "新しいパスワードが一致しません");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "エラーが発生しました。もう一度お試しください");
            }
        }
        if (ae.getSource() == btnReturn) {
            jFrame.dispose();
            MainUI mainUI = new MainUI();
            mainUI.showLoginFrame();
        }
    }

    public static void main(String[] args) {
        ForgetPassword f = new ForgetPassword();
    }

    public void setVisible(boolean b) {
        if (b == true)
            jFrame.setVisible(true);
        else
            jFrame.setVisible(false);
    }
}
