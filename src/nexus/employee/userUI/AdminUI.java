package nexus.employee.userUI;

import nexus.employee.DBConnection;
import nexus.employee.EmployeeManager;
import nexus.employee.MainUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUI implements ActionListener {

    JFrame adminJf, userJf;
    JLabel jlbImage, jlbTitle;
    JButton btnAdd, btnRemove, btnView, btnUpdate,btnLogout;
    public AdminUI() {
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
        btnAdd.setBounds(300, 350, 120, 40);
        btnAdd.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        btnAdd.setForeground(Color.BLACK);
        btnAdd.setBackground(Color.LIGHT_GRAY);
        jlbImage.add(btnAdd);

        //2.Remove Button
        btnRemove=new JButton("削除");
        btnRemove.setBounds(300, 420, 120, 40);
        btnRemove.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        btnRemove.setForeground(Color.BLACK);
        btnRemove.setBackground(Color.LIGHT_GRAY);
        jlbImage.add(btnRemove);

        //3.View Button
        btnView=new JButton("検索");
        btnView.setBounds(490, 350, 120, 40);
        btnView.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        btnView.setForeground(Color.BLACK);
        btnView.setBackground(Color.LIGHT_GRAY);
        jlbImage.add(btnView);

        //4.Update button
        btnUpdate=new JButton("更新");
        btnUpdate.setBounds(490, 420, 120, 40);
        btnUpdate.setFont(new Font("Times_New_Roman", Font.BOLD,18));
        btnUpdate.setForeground(Color.BLACK);
        btnUpdate.setBackground(Color.LIGHT_GRAY);
        jlbImage.add(btnUpdate);

        btnLogout=new JButton("ログアウト");
        btnLogout.setBounds(400, 490, 120, 40);
        btnLogout.setFont(new Font("Times_New_Roman", Font.BOLD,18));
        btnLogout.setForeground(Color.BLACK);
        btnLogout.setBackground(Color.LIGHT_GRAY);
        jlbImage.add(btnLogout);

        //Thêm ActionListener cho các nút

        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnView.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnLogout.addActionListener(this);

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
            employeeManager.showSearchFrame();
        } else if (ae.getSource() == btnLogout) {
            DBConnection dbConnection=new DBConnection();
            dbConnection.closeConnection();
            MainUI mainUI=new MainUI();
            mainUI.showFrontPage();
            adminJf.setVisible(false);
            adminJf.dispose();
        }
    }
    public static void main(String args[]) {
        new AdminUI();
    }

    public void setVisible(boolean b) {
        adminJf.setVisible(b);
    }
}


