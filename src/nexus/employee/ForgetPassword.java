package nexus.employee;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ForgetPassword implements ActionListener
{
    JFrame jFrame;
    JTextField jtxID;
    JLabel lblid,lblnew,lblconfirm,lblimage,lblkeyid;
    JButton btnCheck,btnCancel,btnChange,btnReturn;
    JPasswordField jtxPConfirm,jtxPNew,jtxKeyID;
    ForgetPassword()
    {
        //Frame Details
        jFrame=new JFrame("FORGOT PASSWORD");
        jFrame.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLayout(null);
        jFrame.setBackground(Color.green);
        jFrame.setLayout(null);

        //Background Image
        lblimage=new JLabel();
        lblimage.setBounds(0,0,900,600);
        lblimage.setLayout(null);
        ImageIcon img=new ImageIcon("src/nexus/employee/images/forgetPassword.png");
        lblimage.setIcon(img);
        jFrame.add(lblimage);

        lblid=new JLabel("ENTER KEY ID:");
        lblid.setVisible(true);
        lblid.setBounds(150,250,150,30);
        lblid.setForeground(Color.BLACK);
        lblid.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lblid);

        //Key Id Text Field
        jtxID=new JTextField();
        jtxID.setBounds(320,250,200,30);
        jtxID.setFont(new Font("serif",Font.PLAIN,18));
        lblimage.add(jtxID);

        //Change button
        btnCheck=new JButton("CHECK");
        btnCheck.setBounds(320,300,110,30);
        btnCheck.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.WHITE,3), 
            BorderFactory.createEmptyBorder(10, 15, 10, 15)));
        // btnCheck.setOpaque(false);
        // btnCheck.setContentAreaFilled(true);
        // btnCheck.setBorderPainted(false);
        btnCheck.setBackground(Color.BLACK);
        btnCheck.setForeground(Color.WHITE);
        btnCheck.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        lblimage.add(btnCheck);

        //Cancel button
        btnCancel=new JButton("CANCEL");
        btnCancel.setBounds(435,300,110,30);
        btnCancel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.WHITE,3), 
            BorderFactory.createEmptyBorder(5, 15, 5, 15)));
        btnCancel.setBackground(Color.BLACK);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        lblimage.add(btnCancel);

        btnCheck.addActionListener(this);
        btnCancel.addActionListener(this);

        //New,Confirm Password and Key ID Label Details
        lblnew=new JLabel("NEW PASSWORD:");
        lblnew.setVisible(true);
        lblnew.setBounds(40,200,250,30);
        lblnew.setForeground(Color.BLACK);
        lblnew.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lblnew);

        lblconfirm=new JLabel("CONFIRM PASSWORD:");
        lblconfirm.setVisible(true);
        lblconfirm.setBounds(40,250,250,30);
        lblconfirm.setForeground(Color.BLACK);
        lblconfirm.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lblconfirm);

        lblkeyid=new JLabel("NEW KEY ID:");
        lblkeyid.setVisible(true);
        lblkeyid.setBounds(40,300,250,30);
        lblkeyid.setForeground(Color.BLACK);
        lblkeyid.setFont(new Font("serif",Font.BOLD,20));
        lblimage.add(lblkeyid);

        //New, Confirm Password and New Key Id TextField
        jtxPNew=new JPasswordField();
        jtxPNew.setBounds(310,200,190,30);
        jtxPNew.setFont(new Font("serif",Font.PLAIN,18));
        lblimage.add(jtxPNew);

        jtxPConfirm=new JPasswordField();
        jtxPConfirm.setBounds(310,250,190,30);
        jtxPConfirm.setFont(new Font("serif",Font.PLAIN,18));
        lblimage.add(jtxPConfirm);

        jtxKeyID=new JPasswordField();
        jtxKeyID.setBounds(310,300,190,30);
        jtxKeyID.setFont(new Font("serif",Font.PLAIN,18));
        lblimage.add(jtxKeyID);

        //Button Change
        btnChange=new JButton("CHANGE PASSWORD");
        btnChange.setBounds(140,350,220,40);
        btnChange.setBackground(Color.WHITE);
        btnChange.setForeground(Color.BLACK);
        btnChange.setFont(new Font("Times_New_Roman",Font.BOLD,18));
        lblimage.add(btnChange);
        btnChange.addActionListener(this);

        //Button Return
        btnReturn=new JButton("RETURN");
        btnReturn.setBounds(380,350,120,40);
        btnReturn.setBackground(Color.WHITE);
        btnReturn.setForeground(Color.BLACK);
        btnReturn.setFont(new Font("Times_New_Roman",Font.BOLD,18));
        lblimage.add(btnReturn);
        btnReturn.addActionListener(this);
        btnReturn.setVisible(false);

        
        lblnew.setVisible(false);
        lblconfirm.setVisible(false);
        lblkeyid.setVisible(false);
        jtxPNew.setVisible(false);
        jtxPConfirm.setVisible(false);
        jtxKeyID.setVisible(false);
        btnChange.setVisible(false);

        jFrame.setSize(900,600);
        jFrame.setLocation(300,200);
        jFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == btnCancel) {
            jFrame.dispose();
            MainUI mainUI = new MainUI();
        }
    
        if (ae.getSource() == btnCheck) {
            try {
                DBConnection c = new DBConnection();
                String s = jtxID.getText();
                String str = "select * from login where id = '" + s + "' ";
                ResultSet rs = c.statement.executeQuery(str);
                int i = 0;
                if (rs.next()) {
                    String keyid = rs.getString(1);
                    if (keyid.equalsIgnoreCase(s)) {
                        i = 1;
                    }
                }
                if (i == 0) {
                    jFrame.dispose();
                    JOptionPane.showMessageDialog(null, "Mã khóa không chính xác");
                    ForgetPassword fp = new ForgetPassword();
                }
                if (i == 1) {
                    lblnew.setVisible(true);
                    lblconfirm.setVisible(true);
                    lblkeyid.setVisible(true);
                    jtxPNew.setVisible(true);
                    jtxPConfirm.setVisible(true);
                    jtxKeyID.setVisible(true);
                    btnChange.setVisible(true);
                    btnReturn.setVisible(true);
                    lblid.setVisible(false);
                    jtxID.setVisible(false);
                    btnCheck.setVisible(false);
                    btnCancel.setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
        if (ae.getSource() == btnChange) {
            String newpassword = jtxPNew.getText();
            String confirmpassword = jtxPConfirm.getText();
            String newkeyid = jtxKeyID.getText();
            try {
                DBConnection dbConnection = new DBConnection();
                if (newpassword.equals(confirmpassword)) {
                    // UPDATE login SET password = 'new_password', id = 'new_key_id' WHERE id = 1;
                    String str1 = "UPDATE login SET password='" + newpassword + "', id='" + newkeyid + "' WHERE id='" + jtxID.getText() + "';";
                    int rowsUpdated = dbConnection.statement.executeUpdate(str1);
                    if (rowsUpdated > 0) {
                        String str2 = "select * from login;";
                        ResultSet rs1 = dbConnection.statement.executeQuery(str2);
                        String displaykeyid = "";
                        while (rs1.next()) {
                            displaykeyid = rs1.getString(1);
                        }
                        jFrame.dispose();
                        JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
                        MainUI mainUI = new MainUI();
                    } else {
                        // Xử lý ngoại lệ ở đây
                        JOptionPane.showMessageDialog(null, "Thay đổi mật khẩu thất bại");
                    }
                } else {
//                    jFrame.dispose();
                    JOptionPane.showMessageDialog(null, "Mật khẩu mới không khớp");
//                    ForgetPassword fp = new ForgetPassword();
                }
            } catch (Exception e) {
                // Xử lý ngoại lệ ở đây
                System.out.println(e);
            }
        }
        if (ae.getSource() == btnReturn) {
            jFrame.dispose();
            MainUI mainUI = new MainUI();
            mainUI.showLoginFrame();
        }
    }

    public static void main(String[]ar)
    {
        ForgetPassword f=new ForgetPassword();
    }

    public void setVisible(boolean b) {
        if (b == true)
            jFrame.setVisible(true);
        else
            jFrame.setVisible(false);
    }
}
