//add,remove,update,view employee

package nexus.employee;

import nexus.employee.userUI.AdminUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeManager {
    public JFrame addFrame, removeFrame, updateFrame, searchFrame;
    JLabel jlbImgUpdate, jlbAddTitle, jlbTitle, jlbId, jlbName, jlbGender, jlbDob, jlbAddress, jlbEmail, jlbPhone, jlbPos, jlbRoleID,
            jlbIdView, jlbGenderView, jlbDobView, jlbAddressView, jlbEmailView, jlbPhoneView, jlbPosView, jlbRoleIDView, jlbNameView;
    JTextField jtxEmployeeID, jtxName, jtxGender, jtxDob, jtxAddress, jtxEmail, jtxPhone, jtxPos, jtxRoleID, jtxInfor, jtxInforSearch;
    JButton btnUpdate, btnCancel, btnReset, btnSearch, btnReturn, btnRemove, btnAdd;
    JTextField jtxNameAdd, jtxAddressAdd, jtxPhoneAdd, jtxEmailAdd, jtxGenderAdd, jtxPosAdd, jtxEmployeeIDAdd, jtxDobAdd, jtxRoleIDAdd;


    public EmployeeManager() {
        ImageIcon img=new ImageIcon("src/nexus/employee/images/frontPage_1.png");

//Component thêm nhân viên
        addFrame=new JFrame("追加");
        addFrame.setSize(900, 600);
        addFrame.setLocation(300, 200);
        addFrame.setResizable(false);
        addFrame.setLayout(null);


        //Background Image
        JLabel jlbImgAdd=new JLabel();
        jlbImgAdd.setBounds(0, 0, 900, 600);
        jlbImgAdd.setLayout(null);
        jlbImgAdd.setIcon(img);
        addFrame.add(jlbImgAdd);

        jlbAddTitle=new JLabel("従業員の追加");
        jlbAddTitle.setBounds(350, 50, 620, 50);
        jlbAddTitle.setFont(new Font("Serif", Font.BOLD, 40));
        jlbAddTitle.setForeground(Color.BLACK);
        jlbImgAdd.add(jlbAddTitle);

        //Label Details
        //1.Name
        jlbName=new JLabel("氏名:");
        jlbName.setBounds(150, 140, 100, 30);
        jlbName.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgAdd.add(jlbName);

        jtxNameAdd=new JTextField();
        jtxNameAdd.setBounds(250, 140, 150, 30);
        jlbImgAdd.add(jtxNameAdd);

        //2.Address
        jlbAddress=new JLabel("住所:");
        jlbAddress.setBounds(450, 140, 200, 30);
        jlbAddress.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgAdd.add(jlbAddress);

        jtxAddressAdd=new JTextField();
        jtxAddressAdd.setBounds(550, 140, 150, 30);
        jlbImgAdd.add(jtxAddressAdd);

        //3.Mobile No.
        jlbPhone=new JLabel("電話番号:");
        jlbPhone.setBounds(150, 190, 100, 30);
        jlbPhone.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgAdd.add(jlbPhone);

        jtxPhoneAdd=new JTextField();
        jtxPhoneAdd.setBounds(250, 190, 150, 30);
        jlbImgAdd.add(jtxPhoneAdd);

        //4.Email Id
        jlbEmail=new JLabel("メール:");
        jlbEmail.setBounds(450, 190, 100, 30);
        jlbEmail.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgAdd.add(jlbEmail);

        jtxEmailAdd=new JTextField();
        jtxEmailAdd.setBounds(550, 190, 150, 30);
        jlbImgAdd.add(jtxEmailAdd);


        //5.Gender
        jlbGender=new JLabel("性別:");
        jlbGender.setBounds(150, 240, 100, 30);
        jlbGender.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgAdd.add(jlbGender);

        jtxGenderAdd=new JTextField();
        jtxGenderAdd.setBounds(250, 240, 150, 30);
        jlbImgAdd.add(jtxGenderAdd);

        //6.Job Position
        jlbPos=new JLabel("職位:");
        jlbPos.setBounds(450, 240, 100, 30);
        jlbPos.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgAdd.add(jlbPos);

        jtxPosAdd=new JTextField();
        jtxPosAdd.setBounds(550, 240, 150, 30);
        jlbImgAdd.add(jtxPosAdd);

        //7.Employee ID
        jlbId=new JLabel("従業員ID:");
        jlbId.setBounds(150, 290, 150, 30);
        jlbId.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgAdd.add(jlbId);

        jtxEmployeeIDAdd=new JTextField();
        jtxEmployeeIDAdd.setBounds(250, 290, 150, 30);
        jlbImgAdd.add(jtxEmployeeIDAdd);

        //8.Date of Birth
        jlbDob=new JLabel("生年月日:");
        jlbDob.setBounds(450, 290, 150, 30);
        jlbDob.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgAdd.add(jlbDob);

        jtxDobAdd=new JTextField();
        jtxDobAdd.setBounds(550, 290, 150, 30);
        jlbImgAdd.add(jtxDobAdd);

        //9.Role ID
        jlbRoleID=new JLabel("役割ID:");
        jlbRoleID.setBounds(150, 340, 150, 30);
        jlbRoleID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgAdd.add(jlbRoleID);

        jtxRoleIDAdd=new JTextField();
        jtxRoleIDAdd.setBounds(250, 340, 150, 30);
        jlbImgAdd.add(jtxRoleIDAdd);

        btnAdd=new JButton("追加");
        btnAdd.setBounds(300, 420, 120, 40);
        btnAdd.setBackground(Color.LIGHT_GRAY);
        btnAdd.setForeground(Color.BLACK);
        btnAdd.setFont(new Font("Arial", Font.BOLD, 18));
        jlbImgAdd.add(btnAdd);

        btnCancel=new JButton("キャンセル");
        btnCancel.setBounds(490, 420, 120, 40);
        btnCancel.setBackground(Color.LIGHT_GRAY);
        btnCancel.setForeground(Color.BLACK);
        btnCancel.setFont(new Font("Arial", Font.BOLD, 18));
        jlbImgAdd.add(btnCancel);

        btnReset=new JButton("リセット");
        btnReset.setBounds(400, 480, 120, 40);
        btnReset.setBackground(Color.LIGHT_GRAY);
        btnReset.setForeground(Color.BLACK);
        btnReset.setFont(new Font("Arial", Font.BOLD, 18));
        jlbImgAdd.add(btnReset);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String employeeId, name, gender, dob, add, email, phone, position, role_id, sql;
                employeeId=jtxEmployeeIDAdd.getText();
                name=jtxNameAdd.getText();
                gender=jtxGenderAdd.getText();
                dob=jtxDobAdd.getText();
                add=jtxAddressAdd.getText();
                email=jtxEmailAdd.getText();
                phone=jtxPhoneAdd.getText();
                position=jtxPosAdd.getText();
                role_id=jtxRoleIDAdd.getText();

                DBConnection dbConnection=new DBConnection(); // Tạo kết nối cơ sở dữ liệu
                try {
                    String strSql="INSERT INTO employees (employee_id, name, gender, dob, address, email, phone, position, role_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement=dbConnection.connection.prepareStatement(strSql);
                    statement.setString(1, employeeId);
                    statement.setString(2, name);
                    statement.setString(3, gender);
                    statement.setString(4, dob);
                    statement.setString(5, add);
                    statement.setString(6, email);
                    statement.setString(7, phone);
                    statement.setString(8, position);
                    statement.setString(9, role_id);
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "従業員を追加できました");
                    addFrame.dispose();
                    AdminUI adminUI=new AdminUI();
                    adminUI.setVisible(true);
                } catch (Exception ae) {
                    System.out.println(ae);
                    ae.printStackTrace();
                }
            }
        });
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtxEmployeeIDAdd.setText("");
                jtxNameAdd.setText("");
                jtxGenderAdd.setText("");
                jtxDobAdd.setText("");
                jtxAddressAdd.setText("");
                jtxEmailAdd.setText("");
                jtxPhoneAdd.setText("");
                jtxPosAdd.setText("");
                jtxRoleIDAdd.setText("");
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFrame.dispose();
                AdminUI adminUI=new AdminUI();
                adminUI.setVisible(true);
            }
        });

//Component xóa nhân viên
        removeFrame=new JFrame("削除");
        removeFrame.setSize(900, 600);
        removeFrame.setLocation(300, 200);
        removeFrame.setResizable(false);
        removeFrame.setLayout(null);

        //Background Image
        JLabel jlbImgRemove=new JLabel();
        jlbImgRemove.setBounds(0, 0, 900, 600);
        jlbImgRemove.setLayout(null);
        jlbImgRemove.setIcon(img);
        removeFrame.add(jlbImgRemove);

        JLabel jlbSearchRemove=new JLabel("従業員の情報");
        jlbSearchRemove.setBounds(230, 250, 250, 50);
        jlbSearchRemove.setForeground(Color.BLACK);
        jlbSearchRemove.setFont(new Font("Times_New_Roman", Font.BOLD, 25));
        jlbImgRemove.add(jlbSearchRemove);

        jtxInfor=new JTextField("氏名、電話番号、メール、従業員のIDを入力");
        jtxInfor.setBounds(390, 250, 420, 50);
        jtxInfor.setFont(new Font("serif", Font.PLAIN, 18));
        jlbImgRemove.add(jtxInfor);


        btnSearch=new JButton("検索");
        btnSearch.setBounds(440, 330, 140, 35);
        btnSearch.setBackground(Color.LIGHT_GRAY);
        btnSearch.setForeground(Color.BLACK);
        btnSearch.setFont(new Font("Arial", Font.BOLD, 18));
        jlbImgRemove.add(btnSearch);


        btnReturn=new JButton("戻る");
        btnReturn.setBounds(600, 330, 140, 35);
        btnReturn.setBackground(Color.LIGHT_GRAY);
        btnReturn.setForeground(Color.BLACK);
        btnReturn.setFont(new Font("Arial", Font.BOLD, 18));
        jlbImgRemove.add(btnReturn);

        btnRemove=new JButton("削除");
        btnRemove.setBounds(400, 420, 120, 40);
        btnRemove.setBackground(Color.LIGHT_GRAY);
        btnRemove.setForeground(Color.BLACK);
        btnRemove.setFont(new Font("Arial", Font.BOLD, 18));
        jlbImgRemove.add(btnRemove);

        btnCancel=new JButton("キャンセル");
        btnCancel.setBounds(490, 420, 120, 40);
        btnCancel.setBackground(Color.LIGHT_GRAY);
        btnCancel.setForeground(Color.BLACK);
        btnCancel.setFont(new Font("Arial", Font.BOLD, 18));
        jlbImgRemove.add(btnCancel);


        //Title
        jlbTitle=new JLabel("従業員を削除");
        jlbTitle.setBounds(350, 50, 620, 50);
        jlbTitle.setFont(new Font("Serif", Font.BOLD, 40));
        jlbTitle.setForeground(Color.BLACK);
        jlbImgRemove.add(jlbTitle);

        //Label Details
        //1.Name
        jlbName=new JLabel("氏名:");
        jlbName.setBounds(150, 140, 100, 30);
        jlbName.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbName);

        jlbNameView=new JLabel();
        jlbNameView.setBounds(250, 140, 150, 30);
        jlbImgRemove.add(jlbNameView);

        //2.Address
        jlbAddress=new JLabel("住所:");
        jlbAddress.setBounds(450, 140, 200, 30);
        jlbAddress.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbAddress);

        jlbAddressView=new JLabel();
        jlbAddressView.setBounds(550, 140, 150, 30);
        jlbImgRemove.add(jlbAddressView);

        //3.Mobile No.
        jlbPhone=new JLabel("電話番号:");
        jlbPhone.setBounds(150, 190, 100, 30);
        jlbPhone.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbPhone);

        jlbPhoneView=new JLabel();
        jlbPhoneView.setBounds(250, 190, 150, 30);
        jlbImgRemove.add(jlbPhoneView);

        //4.Email Id
        jlbEmail=new JLabel("メール:");
        jlbEmail.setBounds(450, 190, 100, 30);
        jlbEmail.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbEmail);

        jlbEmailView=new JLabel();
        jlbEmailView.setBounds(550, 190, 150, 30);
        jlbImgRemove.add(jlbEmailView);

        //5.Gender
        jlbGender=new JLabel("性別:");
        jlbGender.setBounds(150, 240, 100, 30);
        jlbGender.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbGender);

        jlbGenderView=new JLabel();
        jlbGenderView.setBounds(250, 240, 150, 30);
        jlbImgRemove.add(jlbGenderView);

        //6.Job Position
        jlbPos=new JLabel("職位:");
        jlbPos.setBounds(450, 240, 100, 30);
        jlbPos.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbPos);

        jlbPosView=new JLabel();
        jlbPosView.setBounds(550, 240, 150, 30);
        jlbImgRemove.add(jlbPosView);

        //7.Employee ID
        jlbId=new JLabel("従業員ID:");
        jlbId.setBounds(150, 290, 150, 30);
        jlbId.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbId);

        jlbIdView=new JLabel();
        jlbIdView.setBounds(250, 290, 150, 30);
        jlbImgRemove.add(jlbIdView);

        //8.Date of Birth
        jlbDob=new JLabel("生年月日:");
        jlbDob.setBounds(450, 290, 150, 30);
        jlbDob.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbDob);

        jlbDobView=new JLabel();
        jlbDobView.setBounds(550, 290, 150, 30);
        jlbImgRemove.add(jlbDobView);

        //9.Role ID
        jlbRoleID=new JLabel("役割ID:");
        jlbRoleID.setBounds(150, 340, 150, 30);
        jlbRoleID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRoleID);

        jlbRoleIDView=new JLabel();
        jlbRoleIDView.setBounds(250, 340, 150, 30);
        jlbImgRemove.add(jlbRoleIDView);

        jlbId.setVisible(false);
        jlbName.setVisible(false);
        jlbGender.setVisible(false);
        jlbDob.setVisible(false);
        jlbAddress.setVisible(false);
        jlbEmail.setVisible(false);
        jlbPhone.setVisible(false);
        jlbPos.setVisible(false);
        jlbRoleID.setVisible(false);
        btnRemove.setVisible(false);
        btnCancel.setVisible(false);

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
                    if (rs.next()) {
                        // Lấy thông tin từ ResultSet
                        String employeeId=rs.getString("employee_id");
                        String name=rs.getString("name");
                        String gender=rs.getString("gender");
                        String dob=rs.getString("dob");
                        String address=rs.getString("address");
                        String email=rs.getString("email");
                        String phone=rs.getString("phone");
                        String position=rs.getString("position");
                        String role_id=rs.getString("role_id");
                        JOptionPane.showMessageDialog(null, "従業員が見つかりました");
                        removeFrame.setVisible(true);
                        // Hiển thị thông tin (ví dụ: sử dụng System.out.println hoặc hiển thị trong giao diện người dùng)
                        jlbIdView.setText(employeeId);
                        jlbNameView.setText(name);
                        jlbGenderView.setText(gender);
                        jlbDobView.setText(dob);
                        jlbAddressView.setText(address);
                        jlbEmailView.setText(email);
                        jlbPhoneView.setText(phone);
                        jlbPosView.setText(position);
                        jlbRoleIDView.setText(role_id);
                        jlbSearchRemove.setVisible(false);
                        jtxInfor.setVisible(false);
                        jlbIdView.setVisible(true);
                        jlbNameView.setVisible(true);
                        jlbGenderView.setVisible(true);
                        jlbDobView.setVisible(true);
                        jlbAddressView.setVisible(true);
                        jlbEmailView.setVisible(true);
                        jlbPhoneView.setVisible(true);
                        jlbPosView.setVisible(true);
                        jlbRoleIDView.setVisible(true);
                        btnRemove.setVisible(true);
                        btnCancel.setVisible(true);
                        btnSearch.setVisible(false);
                    }
                    // Đóng kết nối cơ sở dữ liệu
                    dbConnection.connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBConnection dbConnection=new DBConnection();
                String searchTerm=jtxInfor.getText();
                String sql="DELETE FROM employees WHERE name = ? OR employee_id = ? OR phone = ? OR email = ?";

                try (PreparedStatement preparedStatement=dbConnection.connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, searchTerm); // name
                    preparedStatement.setString(2, searchTerm); // employee_id
                    preparedStatement.setString(3, searchTerm); // phone
                    preparedStatement.setString(4, searchTerm); // email

                    int rowsDeleted=preparedStatement.executeUpdate();
                    if (rowsDeleted > 0) {
                        JOptionPane.showMessageDialog(null, "従業員を削除できました");
                        removeFrame.dispose();
                        AdminUI adminUI=new AdminUI();
                        adminUI.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, searchTerm + "を削除できませんでした");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });


        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeFrame.dispose();
                AdminUI adminUI=new AdminUI();
            }
        });
//Component cập nhật nhân viên
        updateFrame=new JFrame("更新");
        updateFrame.setSize(900, 600);
        updateFrame.setLocation(300, 200);
        updateFrame.setResizable(false);
        updateFrame.setLayout(null);

        //Background Image
        jlbImgUpdate=new JLabel();
        jlbImgUpdate.setBounds(0, 0, 900, 600);
        jlbImgUpdate.setLayout(null);
        jlbImgUpdate.setIcon(img);
        updateFrame.add(jlbImgUpdate);

        JLabel jlbUpdateTitle=new JLabel("従業員を更新");
        jlbUpdateTitle.setBounds(350, 50, 620, 50);
        jlbUpdateTitle.setFont(new Font("Serif", Font.BOLD, 40));
        jlbUpdateTitle.setForeground(Color.BLACK);
        jlbImgUpdate.add(jlbUpdateTitle);

        //Label Details
        //1.Name
        jlbName=new JLabel("氏名:");
        jlbName.setBounds(150, 140, 100, 30);
        jlbName.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jlbName);

        jtxName=new JTextField();
        jtxName.setBounds(250, 140, 150, 30);
        jlbImgUpdate.add(jtxName);

        //2.Address
        jlbAddress=new JLabel("住所:");
        jlbAddress.setBounds(450, 140, 200, 30);
        jlbAddress.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jlbAddress);

        jtxAddress=new JTextField();
        jtxAddress.setBounds(550, 140, 150, 30);
        jlbImgUpdate.add(jtxAddress);

        //3.Mobile No.
        jlbPhone=new JLabel("電話番号:");
        jlbPhone.setBounds(150, 190, 100, 30);
        jlbPhone.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jlbPhone);

        jtxPhone=new JTextField();
        jtxPhone.setBounds(250, 190, 150, 30);
        jlbImgUpdate.add(jtxPhone);

        //4.Email Id
        jlbEmail=new JLabel("メール:");
        jlbEmail.setBounds(450, 190, 100, 30);
        jlbEmail.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jlbEmail);

        jtxEmail=new JTextField();
        jtxEmail.setBounds(550, 190, 150, 30);
        jlbImgUpdate.add(jtxEmail);


        //5.Gender
        jlbGender=new JLabel("性別:");
        jlbGender.setBounds(150, 240, 100, 30);
        jlbGender.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jlbGender);

        jtxGender=new JTextField();
        jtxGender.setBounds(250, 240, 150, 30);
        jlbImgUpdate.add(jtxGender);

        //6.Job Position
        jlbPos=new JLabel("職位:");
        jlbPos.setBounds(450, 240, 100, 30);
        jlbPos.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jlbPos);

        jtxPos=new JTextField();
        jtxPos.setBounds(550, 240, 150, 30);
        jlbImgUpdate.add(jtxPos);

        //7.Employee ID
        jlbId=new JLabel("従業員ID:");
        jlbId.setBounds(150, 290, 150, 30);
        jlbId.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jlbId);

        jtxEmployeeID=new JTextField();
        jtxEmployeeID.setBounds(250, 290, 150, 30);
        jlbImgUpdate.add(jtxEmployeeID);

        //8.Date of Birth
        jlbDob=new JLabel("生年月日:");
        jlbDob.setBounds(450, 290, 150, 30);
        jlbDob.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jlbDob);

        jtxDob=new JTextField();
        jtxDob.setBounds(550, 290, 150, 30);
        jlbImgUpdate.add(jtxDob);

        //9.Role ID
        jlbRoleID=new JLabel("役割ID:");
        jlbRoleID.setBounds(150, 340, 150, 30);
        jlbRoleID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jlbRoleID);

        jtxRoleID=new JTextField();
        jtxRoleID.setBounds(250, 340, 150, 30);
        jlbImgUpdate.add(jtxRoleID);


        btnUpdate=new JButton("更新");
        btnUpdate.setBounds(300, 420, 120, 40);
        btnUpdate.setBackground(Color.LIGHT_GRAY);
        btnUpdate.setForeground(Color.BLACK);
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 18));
        jlbImgUpdate.add(btnUpdate);

        btnCancel=new JButton("キャンセル");
        btnCancel.setBounds(490, 420, 120, 40);
        btnCancel.setBackground(Color.LIGHT_GRAY);
        btnCancel.setForeground(Color.BLACK);
        btnCancel.setFont(new Font("Arial", Font.BOLD, 18));
        jlbImgUpdate.add(btnCancel);

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DBConnection dbConnection=new DBConnection(); // Tạo kết nối cơ sở dữ liệu
                    String employeeId, name, gender, dob, add, email, phone, position, role_id, sql;
                    employeeId=jtxEmployeeID.getText();
                    name=jtxName.getText();
                    gender=jtxGender.getText();
                    dob=jtxDob.getText();
                    add=jtxAddress.getText();
                    email=jtxEmail.getText();
                    phone=jtxPhone.getText();
                    position=jtxPos.getText();
                    role_id=jtxRoleID.getText();


                    String searchTerm=jtxInfor.getText(); // Lấy giá trị từ JTextField

                    sql="UPDATE employees SET name = ?, gender = ?, dob = ?, address = ?, email = ?, phone = ?, position = ?, role_id = ? WHERE employee_id = ? OR name = ? OR email = ? OR phone = ?";
                    PreparedStatement preparedStatement=dbConnection.connection.prepareStatement(sql);
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, gender);
                    preparedStatement.setString(3, dob);
                    preparedStatement.setString(4, add);
                    preparedStatement.setString(5, email);
                    preparedStatement.setString(6, phone);
                    preparedStatement.setString(7, position);
                    preparedStatement.setString(8, role_id);
                    preparedStatement.setString(9, searchTerm); // Đặt giá trị từ jtxInfor vào tham số cuối cùng
                    preparedStatement.setString(10, searchTerm); // Đặt giá trị từ jtxInfor vào tham số thứ 10
                    preparedStatement.setString(11, searchTerm); // Đặt giá trị từ jtxInfor vào tham số thứ 11
                    preparedStatement.setString(12, searchTerm); // Đặt giá trị từ jtxInfor vào tham số thứ 12

                    int rowsInserted=preparedStatement.executeUpdate();

                    // Kiểm tra kết quả và hiển thị thông báo
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(null, "従業員の情報を更新しました");
                        updateFrame.setVisible(false);
                        updateFrame.dispose();
                        AdminUI adminUI=new AdminUI();
                        adminUI.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "従業員の情報を更新できませんでした");
                    }
                } catch (Exception ae) {
                    ae.printStackTrace();
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFrame.dispose();
                AdminUI adminUI=new AdminUI();
                adminUI.setVisible(true);
            }
        });
//Component tìm kiếm nhân viên

        searchFrame=new JFrame("検索");
        JLabel jlbImgSearch, jlbInfor;
        JButton btnSearchInfor, btnSearchCancel, btnSearchPrint, btnSearchReturn;
        //Frame Details
        searchFrame.setSize(900, 600);
        searchFrame.setLocation(300, 200);
        searchFrame.setResizable(false);
        searchFrame.setLayout(null);

        //Background Image
        jlbImgSearch=new JLabel();
        jlbImgSearch.setBounds(0, 0, 900, 600);
        jlbImgSearch.setLayout(null);
        jlbImgSearch.setIcon(img);
        searchFrame.add(jlbImgSearch);

        JLabel jlbSearchTitle;
        jlbSearchTitle=new JLabel("従業員の検索");
        jlbSearchTitle.setBounds(350, 50, 620, 50);
        jlbSearchTitle.setFont(new Font("Serif", Font.BOLD, 40));
        jlbSearchTitle.setForeground(Color.BLACK);
        jlbImgSearch.add(jlbSearchTitle);


        //Label Details
        jlbInfor=new JLabel("従業員の情報");
        jlbInfor.setBounds(230, 250, 250, 50);
        jlbInfor.setForeground(Color.BLACK);
        jlbInfor.setFont(new Font("Times_New_Roman", Font.BOLD, 25));
        jlbImgSearch.add(jlbInfor);

        jtxInforSearch=new JTextField("氏名、電話番号、メール、従業員のIDを入力");
        jtxInforSearch.setBounds(400, 255, 380, 40);
        jtxInforSearch.setFont(new Font("serif", Font.PLAIN, 18));
        jlbImgSearch.add(jtxInforSearch);

        //Button Details
        btnSearchInfor=new JButton("検索");
        btnSearchInfor.setBounds(300, 330, 140, 35);
        btnSearchInfor.setBackground(Color.LIGHT_GRAY);
        btnSearchInfor.setForeground(Color.BLACK);
        btnSearchInfor.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        jlbImgSearch.add(btnSearchInfor);

        btnSearchCancel=new JButton("キャンセル");
        btnSearchCancel.setBounds(460, 330, 140, 35);
        btnSearchCancel.setBackground(Color.LIGHT_GRAY);
        btnSearchCancel.setForeground(Color.BLACK);
        btnSearchCancel.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        jlbImgSearch.add(btnSearchCancel);

        btnSearchPrint=new JButton("印刷");
        btnSearchPrint.setBounds(300, 440, 120, 40);
        btnSearchPrint.setBackground(Color.LIGHT_GRAY);
        btnSearchPrint.setForeground(Color.BLACK);
        btnSearchPrint.setFont(new Font("serif", Font.BOLD, 18));
        jlbImgSearch.add(btnSearchPrint);

        btnSearchReturn=new JButton("戻る");
        btnSearchReturn.setBounds(500, 440, 120, 40);
        btnSearchReturn.setBackground(Color.LIGHT_GRAY);
        btnSearchReturn.setForeground(Color.BLACK);
        btnSearchReturn.setFont(new Font("serif", Font.BOLD, 18));
        jlbImgSearch.add(btnSearchReturn);

        btnSearchReturn.setVisible(false);
        btnSearchPrint.setVisible(false);

        //Label Details
        //1.Name
        jlbName=new JLabel("氏名:");
        jlbName.setBounds(150, 140, 100, 30);
        jlbName.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbName);

        jlbNameView=new JLabel();
        jlbNameView.setBounds(250, 140, 200, 30);
        jlbNameView.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbNameView);

        //2.Address
        jlbAddress=new JLabel("住所:");
        jlbAddress.setBounds(450, 140, 200, 30);
        jlbAddress.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbAddress);

        jlbAddressView=new JLabel();
        jlbAddressView.setBounds(550, 140, 150, 30);
        jlbAddressView.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbAddressView);

        //3.Mobile No.
        jlbPhone=new JLabel("電話番号:");
        jlbPhone.setBounds(150, 200, 100, 30);
        jlbPhone.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbPhone);

        jlbPhoneView=new JLabel();
        jlbPhoneView.setBounds(250, 200, 150, 30);
        jlbPhoneView.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbPhoneView);

        //4.Email Id
        jlbEmail=new JLabel("メール:");
        jlbEmail.setBounds(450, 200, 100, 30);
        jlbEmail.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbEmail);

        jlbEmailView=new JLabel();
        jlbEmailView.setBounds(550, 200, 200, 30);
        jlbEmailView.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbEmailView);

        //5.Gender
        jlbGender=new JLabel("性別:");
        jlbGender.setBounds(150, 260, 100, 30);
        jlbGender.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbGender);

        jlbGenderView=new JLabel();
        jlbGenderView.setBounds(250, 260, 150, 30);
        jlbGenderView.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbGenderView);

        //6.Job Position
        jlbPos=new JLabel("職位:");
        jlbPos.setBounds(450, 260, 100, 30);
        jlbPos.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbPos);

        jlbPosView=new JLabel();
        jlbPosView.setBounds(550, 260, 150, 30);
        jlbPosView.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbPosView);

        //7.Employee ID
        jlbId=new JLabel("従業員ID:");
        jlbId.setBounds(150, 320, 150, 30);
        jlbId.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbId);

        jlbIdView=new JLabel();
        jlbIdView.setBounds(250, 320, 150, 30);
        jlbIdView.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbIdView);

        //8.Date of Birth
        jlbDob=new JLabel("生年月日:");
        jlbDob.setBounds(450, 320, 150, 30);
        jlbDob.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbDob);

        jlbDobView=new JLabel();
        jlbDobView.setBounds(550, 320, 150, 30);
        jlbDobView.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbDobView);

        //9.Role ID
        jlbRoleID=new JLabel("役割ID:");
        jlbRoleID.setBounds(150, 380, 150, 30);
        jlbRoleID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbRoleID);

        jlbRoleIDView=new JLabel();
        jlbRoleIDView.setBounds(250, 380, 150, 30);
        jlbRoleIDView.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbRoleIDView);

        jlbId.setVisible(false);
        jlbName.setVisible(false);
        jlbGender.setVisible(false);
        jlbDob.setVisible(false);
        jlbAddress.setVisible(false);
        jlbEmail.setVisible(false);
        jlbPhone.setVisible(false);
        jlbPos.setVisible(false);
        jlbRoleID.setVisible(false);

        btnSearchInfor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                        String employeeId=rs.getString("employee_id");
                        String name=rs.getString("name");
                        String gender=rs.getString("gender");
                        String dob=rs.getString("dob");
                        String address=rs.getString("address");
                        String email=rs.getString("email");
                        String phone=rs.getString("phone");
                        String position=rs.getString("position");
                        String role_id=rs.getString("role_id");
                        JOptionPane.showMessageDialog(null, "従業員が見つかりました");
                        searchFrame.setVisible(true);
                        // Hiển thị thông tin (ví dụ: sử dụng System.out.println hoặc hiển thị trong giao diện người dùng)
                        jlbName.setVisible(true);
                        jlbGender.setVisible(true);
                        jlbDob.setVisible(true);
                        jlbAddress.setVisible(true);
                        jlbEmail.setVisible(true);
                        jlbPhone.setVisible(true);
                        jlbPos.setVisible(true);
                        jlbId.setVisible(true);
                        jlbRoleID.setVisible(true);
                        jlbIdView.setText(employeeId);
                        jlbNameView.setText(name);
                        jlbGenderView.setText(gender);
                        jlbDobView.setText(dob);
                        jlbAddressView.setText(address);
                        jlbEmailView.setText(email);
                        jlbPhoneView.setText(phone);
                        jlbPosView.setText(position);
                        jlbRoleIDView.setText(role_id);
                        jlbInfor.setVisible(false);
                        jtxInforSearch.setVisible(false);
                        jlbIdView.setVisible(true);
                        jlbNameView.setVisible(true);
                        jlbGenderView.setVisible(true);
                        jlbDobView.setVisible(true);
                        jlbAddressView.setVisible(true);
                        jlbEmailView.setVisible(true);
                        jlbPhoneView.setVisible(true);
                        jlbPosView.setVisible(true);
                        jlbRoleIDView.setVisible(true);
                        btnSearchInfor.setVisible(false);
                        btnSearchCancel.setVisible(false);
                        btnSearchPrint.setVisible(true);
                        btnSearchReturn.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "従業員が見つかりません");
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
                AdminUI adminUI=new AdminUI();
                adminUI.setVisible(true);
            }
        });
        btnSearchReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbInfor.setVisible(true);
                jtxInforSearch.setVisible(true);
                btnSearchInfor.setVisible(true);
                btnSearchCancel.setVisible(true);
                btnSearchPrint.setVisible(false);
                btnSearchReturn.setVisible(false);
                jlbName.setVisible(false);
                jlbNameView.setVisible(false);
                jlbGender.setVisible(false);
                jlbGenderView.setVisible(false);
                jlbDob.setVisible(false);
                jlbDobView.setVisible(false);
                jlbAddress.setVisible(false);
                jlbAddressView.setVisible(false);
                jlbEmail.setVisible(false);
                jlbEmailView.setVisible(false);
                jlbPhone.setVisible(false);
                jlbPhoneView.setVisible(false);
                jlbPos.setVisible(false);
                jlbPosView.setVisible(false);
                jlbId.setVisible(false);
                jlbIdView.setVisible(false);
                jlbRoleID.setVisible(false);
                jlbRoleIDView.setVisible(false);
            }
        });

    }

    public void showSearchFrame() {
        searchFrame.setVisible(true);
    }

    public void showUpdateFrame() {
        updateFrame.setVisible(true);
    }

    public void showRemoveFrame() {
        removeFrame.setVisible(true);
    }

    public void showAddFrame() {
        addFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EmployeeManager();
        });

    }
}