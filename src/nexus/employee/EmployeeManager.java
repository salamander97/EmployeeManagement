//add,remove,update,view employee

package nexus.employee;

import nexus.employee.userUI.AdminUI;
import nexus.employee.userUI.EmployeeUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class EmployeeManager {
    public JFrame addFrame, removeFrame, updateFrame, searchFrame;
    private String employeeId, name, gender, dob, address, email, phone, salary, role_id;
    public JTextField jtxAAddress, jtxAName, jtxAGender, jtxADob, jtxAEmail, jtxAPhone, jtxASalary, jtxARoleID, jtxAID;
    MainUI mainUI;

    public EmployeeManager() {
        ImageIcon img=new ImageIcon("src/nexus/employee/images/frontPage_1.png");
        //Hiển thị lương dưới dạng số nguyên
        DecimalFormat decimalFormat = new DecimalFormat("#");
//Component thêm nhân viên
        JLabel jlbAddTitle, jlbTitle, jlbAddID, jlbAddName, jlbAddGender, jlbAddDob, jlbAddAddress,
                jlbAddEmail, jlbAddPhone, jlbAddSalary, jlbAddRoleID;
        JButton btnAddCancel, btnReset, btnAdd;

        addFrame=new JFrame("追加");
        addFrame.setSize(900, 600);
        addFrame.setLocation(300, 200);
        addFrame.setResizable(false);
        addFrame.setLayout(null);


        //Background
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

        //Label
        //1.Name
        jlbAddName=new JLabel("氏名:");
        jlbAddName.setBounds(150, 140, 100, 30);
        jlbAddName.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgAdd.add(jlbAddName);

        jtxAName=new JTextField();
        jtxAName.setBounds(250, 140, 150, 30);
        jlbImgAdd.add(jtxAName);

        //2.Address
        jlbAddAddress=new JLabel("住所:");
        jlbAddAddress.setBounds(450, 140, 200, 30);
        jlbAddAddress.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgAdd.add(jlbAddAddress);

        jtxAAddress=new JTextField();
        jtxAAddress.setBounds(550, 140, 150, 30);
        jlbImgAdd.add(jtxAAddress);

        //3.Mobile No.
        jlbAddPhone=new JLabel("電話番号:");
        jlbAddPhone.setBounds(150, 190, 100, 30);
        jlbAddPhone.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgAdd.add(jlbAddPhone);

        jtxAPhone=new JTextField();
        jtxAPhone.setBounds(250, 190, 150, 30);
        jlbImgAdd.add(jtxAPhone);

        //4.Email Id
        jlbAddEmail=new JLabel("メール:");
        jlbAddEmail.setBounds(450, 190, 100, 30);
        jlbAddEmail.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgAdd.add(jlbAddEmail);

        jtxAEmail=new JTextField();
        jtxAEmail.setBounds(550, 190, 150, 30);
        jlbImgAdd.add(jtxAEmail);


        //5.Gender
        jlbAddGender=new JLabel("性別:");
        jlbAddGender.setBounds(150, 240, 100, 30);
        jlbAddGender.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgAdd.add(jlbAddGender);

        jtxAGender=new JTextField();
        jtxAGender.setBounds(250, 240, 150, 30);
        jlbImgAdd.add(jtxAGender);

        //6.Job salary
        jlbAddSalary=new JLabel("職位:");
        jlbAddSalary.setBounds(450, 240, 100, 30);
        jlbAddSalary.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgAdd.add(jlbAddSalary);

        jtxASalary=new JTextField();
        jtxASalary.setBounds(550, 240, 150, 30);
        jlbImgAdd.add(jtxASalary);

        //7.Employee ID
        jlbAddID=new JLabel("従業員ID:");
        jlbAddID.setBounds(150, 290, 150, 30);
        jlbAddID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgAdd.add(jlbAddID);

        jtxAID=new JTextField();
        jtxAID.setBounds(250, 290, 150, 30);
        jlbImgAdd.add(jtxAID);

        //8.Date of Birth
        jlbAddDob=new JLabel("生年月日:");
        jlbAddDob.setBounds(450, 290, 150, 30);
        jlbAddDob.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgAdd.add(jlbAddDob);

        jtxADob=new JTextField();
        jtxADob.setBounds(550, 290, 150, 30);
        jlbImgAdd.add(jtxADob);

        //9.Role ID
        jlbAddRoleID=new JLabel("役割ID:");
        jlbAddRoleID.setBounds(150, 340, 150, 30);
        jlbAddRoleID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgAdd.add(jlbAddRoleID);

        jtxARoleID=new JTextField();
        jtxARoleID.setBounds(250, 340, 150, 30);
        jlbImgAdd.add(jtxARoleID);

        btnAdd=new JButton("追加");
        btnAdd.setBounds(300, 420, 120, 40);
        btnAdd.setBackground(Color.LIGHT_GRAY);
        btnAdd.setForeground(Color.BLACK);
        btnAdd.setFont(new Font("Arial", Font.BOLD, 18));
        jlbImgAdd.add(btnAdd);

        btnAddCancel=new JButton("キャンセル");
        btnAddCancel.setBounds(490, 420, 120, 40);
        btnAddCancel.setBackground(Color.LIGHT_GRAY);
        btnAddCancel.setForeground(Color.BLACK);
        btnAddCancel.setFont(new Font("Arial", Font.BOLD, 18));
        jlbImgAdd.add(btnAddCancel);

        btnReset=new JButton("リセット");
        btnReset.setBounds(400, 480, 120, 40);
        btnReset.setBackground(Color.LIGHT_GRAY);
        btnReset.setForeground(Color.BLACK);
        btnReset.setFont(new Font("Arial", Font.BOLD, 18));
        jlbImgAdd.add(btnReset);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                employeeId=jtxAID.getText();
                name=jtxAName.getText();
                gender=jtxAGender.getText();
                dob=jtxADob.getText();
                address=jtxAAddress.getText();
                email=jtxAEmail.getText();
                phone=jtxAPhone.getText();
                salary=jtxASalary.getText();
                role_id=jtxARoleID.getText();

                DBConnection dbConnection=new DBConnection(); // Tạo kết nối cơ sở dữ liệu
                try {
                    String strSql="INSERT INTO employees (employee_id, name, gender, dob, address, email, phone, salary, role_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement=dbConnection.connection.prepareStatement(strSql);
                    statement.setString(1, employeeId);
                    statement.setString(2, name);
                    statement.setString(3, gender);
                    statement.setString(4, dob);
                    statement.setString(5, address);
                    statement.setString(6, email);
                    statement.setString(7, phone);
                    statement.setString(8, salary);
                    statement.setString(9, role_id);
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "従業員を追加できました");
                    addFrame.dispose();
                    AdminUI adminUI=new AdminUI();
                    adminUI.setVisible(true);
                } catch (Exception ae) {
                    ae.printStackTrace();
                }
            }
        });
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetJTextField();
            }
        });
        btnAddCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFrame.dispose();
                AdminUI adminUI=new AdminUI();
                adminUI.setVisible(true);
            }
        });

//Component xóa nhân viên
        JButton btnRemoveSearch, btnRemoveDelete, btnRemoveCancel, btnRemoveReturn;
        JTextField jtxInforRemove;
        JLabel jlbImgRemove, jlbRemoveTittle, jlbRemoveGender, jlbRemoveDob, jlbRemoveAddress, jlbRemoveEmail,
                jlbRemovePhone, jlbRemoveSalary, jlbRemoveRoleID, jlbRemoveName, jlbRemoveID, jlbRID, jlbRName,
                jlbRGender, jlbRDob, jlbRAddress, jlbREmail, jlbRPhone, jlbRSalary, jlbRRoleID;
        removeFrame=new JFrame("削除");
        removeFrame.setSize(900, 600);
        removeFrame.setLocation(300, 200);
        removeFrame.setResizable(false);
        removeFrame.setLayout(null);

        //Background Image
        jlbImgRemove=new JLabel();
        jlbImgRemove.setBounds(0, 0, 900, 600);
        jlbImgRemove.setLayout(null);
        jlbImgRemove.setIcon(img);
        removeFrame.add(jlbImgRemove);

        jlbRemoveTittle=new JLabel("従業員の情報");
        jlbRemoveTittle.setBounds(230, 250, 250, 50);
        jlbRemoveTittle.setForeground(Color.BLACK);
        jlbRemoveTittle.setFont(new Font("Times_New_Roman", Font.BOLD, 25));

        jtxInforRemove=new JTextField("氏名、電話番号、メール、従業員のIDを入力");
        jtxInforRemove.setBounds(390, 250, 420, 50);
        jtxInforRemove.setFont(new Font("serif", Font.PLAIN, 18));


        btnRemoveSearch=new JButton("検索");
        btnRemoveSearch.setBounds(440, 330, 140, 35);
        btnRemoveSearch.setBackground(Color.LIGHT_GRAY);
        btnRemoveSearch.setForeground(Color.BLACK);
        btnRemoveSearch.setFont(new Font("Arial", Font.BOLD, 18));
        jlbImgRemove.add(btnRemoveSearch);

        btnRemoveReturn=new JButton("戻る");
        btnRemoveReturn.setBounds(600, 330, 140, 35);
        btnRemoveReturn.setBackground(Color.LIGHT_GRAY);
        btnRemoveReturn.setForeground(Color.BLACK);
        btnRemoveReturn.setFont(new Font("Arial", Font.BOLD, 18));

        btnRemoveDelete=new JButton("削除");
        btnRemoveDelete.setBounds(330, 440, 120, 40);
        btnRemoveDelete.setBackground(Color.LIGHT_GRAY);
        btnRemoveDelete.setForeground(Color.BLACK);
        btnRemoveDelete.setFont(new Font("Arial", Font.BOLD, 18));

        btnRemoveCancel=new JButton("キャンセル");
        btnRemoveCancel.setBounds(490, 440, 120, 40);
        btnRemoveCancel.setBackground(Color.LIGHT_GRAY);
        btnRemoveCancel.setForeground(Color.BLACK);
        btnRemoveCancel.setFont(new Font("Arial", Font.BOLD, 18));


        //Title
        jlbTitle=new JLabel("従業員を削除");
        jlbTitle.setBounds(350, 50, 620, 50);
        jlbTitle.setFont(new Font("Serif", Font.BOLD, 40));
        jlbTitle.setForeground(Color.BLACK);
        jlbImgRemove.add(jlbRemoveTittle);
        jlbImgRemove.add(jtxInforRemove);
        jlbImgRemove.add(btnRemoveSearch);
        jlbImgRemove.add(btnRemoveReturn);
        jlbImgRemove.add(btnRemoveDelete);
        jlbImgRemove.add(btnRemoveCancel);
        jlbImgRemove.add(jlbTitle);

        //Label Details
        //1.Name
        jlbRemoveName=new JLabel("氏名:");
        jlbRemoveName.setBounds(150, 140, 100, 30);
        jlbRemoveName.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRemoveName);

        jlbRName=new JLabel();
        jlbRName.setBounds(250, 140, 200, 30);
        jlbRName.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRName);

        //2.Address
        jlbRemoveAddress=new JLabel("住所:");
        jlbRemoveAddress.setBounds(450, 140, 200, 30);
        jlbRemoveAddress.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRemoveAddress);

        jlbRAddress=new JLabel();
        jlbRAddress.setBounds(550, 140, 150, 30);
        jlbRAddress.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRAddress);

        //3.Mobile No.
        jlbRemovePhone=new JLabel("電話番号:");
        jlbRemovePhone.setBounds(150, 190, 100, 30);
        jlbRemovePhone.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRemovePhone);

        jlbRPhone=new JLabel();
        jlbRPhone.setBounds(250, 190, 150, 30);
        jlbRPhone.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRPhone);

        //4.Email Id
        jlbRemoveEmail=new JLabel("メール:");
        jlbRemoveEmail.setBounds(450, 190, 100, 30);
        jlbImgRemove.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRemoveEmail);

        jlbREmail=new JLabel();
        jlbREmail.setBounds(550, 190, 200, 30);
        jlbREmail.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbREmail);

        //5.Gender
        jlbRemoveGender=new JLabel("性別:");
        jlbRemoveGender.setBounds(150, 240, 100, 30);
        jlbRemoveGender.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRemoveGender);

        jlbRGender=new JLabel();
        jlbRGender.setBounds(250, 240, 150, 30);
        jlbRGender.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRGender);

        //6.Job salary
        jlbRemoveSalary=new JLabel("職位:");
        jlbRemoveSalary.setBounds(450, 240, 100, 30);
        jlbRemoveSalary.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRemoveSalary);

        jlbRSalary=new JLabel();
        jlbRSalary.setBounds(550, 240, 150, 30);
        jlbRSalary.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRSalary);

        //7.Employee ID
        jlbRemoveID=new JLabel("従業員ID:");
        jlbRemoveID.setBounds(150, 290, 150, 30);
        jlbRemoveID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRemoveID);

        jlbRID=new JLabel();
        jlbRID.setBounds(250, 290, 150, 30);
        jlbRID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRID);

        //8.Date of Birth
        jlbRemoveDob=new JLabel("生年月日:");
        jlbRemoveDob.setBounds(450, 290, 150, 30);
        jlbRemoveDob.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRemoveDob);

        jlbRDob=new JLabel();
        jlbRDob.setBounds(550, 290, 150, 30);
        jlbRDob.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRDob);

        //9.Role ID
        jlbRemoveRoleID=new JLabel("役割ID:");
        jlbRemoveRoleID.setBounds(150, 340, 150, 30);
        jlbRemoveRoleID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRemoveRoleID);

        jlbRRoleID=new JLabel();
        jlbRRoleID.setBounds(250, 340, 150, 30);
        jlbRRoleID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRRoleID);

        jlbRemoveName.setVisible(false);
        jlbRemoveAddress.setVisible(false);
        jlbRemovePhone.setVisible(false);
        jlbRemoveEmail.setVisible(false);
        jlbRemoveGender.setVisible(false);
        jlbRemoveSalary.setVisible(false);
        jlbRemoveID.setVisible(false);
        jlbRemoveDob.setVisible(false);
        jlbRemoveRoleID.setVisible(false);
        btnRemoveDelete.setVisible(false);
        btnRemoveCancel.setVisible(false);

        btnRemoveSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DBConnection dbConnection=new DBConnection(); // Tạo kết nối cơ sở dữ liệu
                String searchTerm=jtxInforRemove.getText(); // Lấy giá trị từ JTextField

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
                        salary=rs.getString("position");
                        role_id=rs.getString("role_id");
                        JOptionPane.showMessageDialog(null, "従業員が見つかりました");
                        removeFrame.setVisible(true);

                        jlbRID.setVisible(true);
                        jlbRName.setVisible(true);
                        jlbRGender.setVisible(true);
                        jlbRDob.setVisible(true);
                        jlbRAddress.setVisible(true);
                        jlbREmail.setVisible(true);
                        jlbRPhone.setVisible(true);
                        jlbRSalary.setVisible(true);
                        jlbRRoleID.setVisible(true);
                        jlbRID.setText(employeeId);
                        jlbRName.setText(name);
                        jlbRGender.setText(gender);
                        jlbRDob.setText(dob);
                        jlbRAddress.setText(address);
                        jlbREmail.setText(email);
                        jlbRPhone.setText(phone);
                        jlbRSalary.setText(salary);
                        jlbRRoleID.setText(role_id);
                        jlbRemoveID.setVisible(true);
                        jlbRemoveName.setVisible(true);
                        jlbRemoveGender.setVisible(true);
                        jlbRemoveDob.setVisible(true);
                        jlbRemoveAddress.setVisible(true);
                        jlbRemoveEmail.setVisible(true);
                        jlbRemovePhone.setVisible(true);
                        jlbRemoveSalary.setVisible(true);
                        jlbRemoveRoleID.setVisible(true);

                        jtxInforRemove.setVisible(false);
                        jlbRemoveTittle.setVisible(false);

                        btnRemoveSearch.setVisible(false);
                        btnRemoveReturn.setVisible(false);

                        btnRemoveCancel.setVisible(true);
                        btnRemoveDelete.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "従業員が見つかりませんでした");
                    }
                    // Đóng kết nối cơ sở dữ liệu
                    dbConnection.connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnRemoveDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(removeFrame, "従業員を削除しますか？", "削除", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    DBConnection dbConnection=new DBConnection();
                    String searchTerm=jtxInforRemove.getText();
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
            }
        });
        btnRemoveReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeFrame.dispose();
                AdminUI adminUI=new AdminUI();
                adminUI.setVisible(true);
            }
        });
        btnRemoveCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeFrame.dispose();
                AdminUI adminUI=new AdminUI();
                adminUI.setVisible(true);
            }
        });

//Component cập nhật nhân viên

        JLabel jlbSearchUpdate, jlbInfoUpdate, jlbImgUpdate, jlbUpdateName, jlbUpdateGender, jlbUpdateDob,
                jlbUpdateAddress, jlbUpdateEmail, jlbUpdatePhone, jlbUpdateSalary, jlbUpdateRoleID, jlbUpdateID;
        JTextField jtxEmployeeID, jtxName, jtxGender, jtxDob, jtxAddress, jtxEmail, jtxPhone, jtxSalary, jtxRoleID, jtxInforUpdate;
        JButton btnUpdate, btnCancel, btnUpdateSearch, btnUpdateCancel;
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

        jlbSearchUpdate=new JLabel("従業員の検索");
        jlbSearchUpdate.setBounds(350, 50, 620, 50);
        jlbSearchUpdate.setFont(new Font("Serif", Font.BOLD, 40));
        jlbSearchUpdate.setForeground(Color.BLACK);
        jlbImgUpdate.add(jlbSearchUpdate);


        //Label Details
        jlbInfoUpdate=new JLabel("従業員の情報");
        jlbInfoUpdate.setBounds(230, 250, 250, 50);
        jlbInfoUpdate.setForeground(Color.BLACK);
        jlbInfoUpdate.setFont(new Font("Times_New_Roman", Font.BOLD, 25));
        jlbImgUpdate.add(jlbInfoUpdate);

        jtxInforUpdate=new JTextField("氏名、電話番号、メール、従業員のIDを入力");
        jtxInforUpdate.setBounds(390, 250, 420, 50);
        jtxInforUpdate.setFont(new Font("serif", Font.PLAIN, 18));
        jlbImgUpdate.add(jtxInforUpdate);

        //Button Details
        btnUpdateSearch=new JButton("検索");
        btnUpdateSearch.setBounds(300, 330, 140, 35);
        btnUpdateSearch.setBackground(Color.LIGHT_GRAY);
        btnUpdateSearch.setForeground(Color.BLACK);
        btnUpdateSearch.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        jlbImgUpdate.add(btnUpdateSearch);

        btnUpdateCancel=new JButton("キャンセル");
        btnUpdateCancel.setBounds(460, 330, 140, 35);
        btnUpdateCancel.setBackground(Color.LIGHT_GRAY);
        btnUpdateCancel.setForeground(Color.BLACK);
        btnUpdateCancel.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        jlbImgUpdate.add(btnUpdateCancel);


        JLabel jlbUpdateTitle=new JLabel("従業員を更新");
        jlbUpdateTitle.setBounds(350, 50, 620, 50);
        jlbUpdateTitle.setFont(new Font("Serif", Font.BOLD, 40));
        jlbUpdateTitle.setForeground(Color.BLACK);
        jlbImgUpdate.add(jlbUpdateTitle);

        //Label Details
        //1.Name
        jlbUpdateName=new JLabel("氏名:");
        jlbUpdateName.setBounds(150, 140, 100, 30);
        jlbUpdateName.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jlbUpdateName);

        jtxName=new JTextField();
        jtxName.setBounds(250, 140, 150, 30);
        jtxName.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jtxName);

        //2.Address
        jlbUpdateAddress=new JLabel("住所:");
        jlbUpdateAddress.setBounds(450, 140, 200, 30);
        jlbUpdateAddress.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jlbUpdateAddress);

        jtxAddress=new JTextField();
        jtxAddress.setBounds(550, 140, 150, 30);
        jtxAddress.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jtxAddress);

        //3.Mobile No.
        jlbUpdatePhone=new JLabel("電話番号:");
        jlbUpdatePhone.setBounds(150, 190, 100, 30);
        jlbUpdatePhone.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jlbUpdatePhone);

        jtxPhone=new JTextField();
        jtxPhone.setBounds(250, 190, 150, 30);
        jtxPhone.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jtxPhone);

        //4.Email Id
        jlbUpdateEmail=new JLabel("メール:");
        jlbUpdateEmail.setBounds(450, 190, 100, 30);
        jlbUpdateEmail.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jlbUpdateEmail);

        jtxEmail=new JTextField();
        jtxEmail.setBounds(550, 190, 150, 30);
        jtxEmail.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jtxEmail);


        //5.Gender
        jlbUpdateGender=new JLabel("性別:");
        jlbUpdateGender.setBounds(150, 240, 100, 30);
        jlbUpdateGender.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jlbUpdateGender);

        jtxGender=new JTextField();
        jtxGender.setBounds(250, 240, 150, 30);
        jtxGender.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jtxGender);

        //6.Job salary
        jlbUpdateSalary=new JLabel("職位:");
        jlbUpdateSalary.setBounds(450, 240, 100, 30);
        jlbUpdateSalary.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jlbUpdateSalary);

        jtxSalary=new JTextField();
        jtxSalary.setBounds(550, 240, 150, 30);
        jtxSalary.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jtxSalary);

        //7.Employee ID
        jlbUpdateID=new JLabel("従業員ID:");
        jlbUpdateID.setBounds(150, 290, 150, 30);
        jlbUpdateID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jlbUpdateID);

        jtxEmployeeID=new JTextField();
        jtxEmployeeID.setBounds(250, 290, 150, 30);
        jtxEmployeeID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jtxEmployeeID);

        //8.Date of Birth
        jlbUpdateDob=new JLabel("生年月日:");
        jlbUpdateDob.setBounds(450, 290, 150, 30);
        jlbUpdateDob.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jlbUpdateDob);

        jtxDob=new JTextField();
        jtxDob.setBounds(550, 290, 150, 30);
        jtxDob.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jtxDob);

        //9.Role ID
        jlbUpdateRoleID=new JLabel("役割ID:");
        jlbUpdateRoleID.setBounds(150, 340, 150, 30);
        jlbUpdateRoleID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jlbUpdateRoleID);

        jtxRoleID=new JTextField();
        jtxRoleID.setBounds(250, 340, 150, 30);
        jtxRoleID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jtxRoleID);


        btnUpdate=new JButton("更新");
        btnUpdate.setBounds(300, 420, 120, 40);
        btnUpdate.setBackground(Color.LIGHT_GRAY);
        btnUpdate.setForeground(Color.BLACK);
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 18));
        jlbImgUpdate.add(btnUpdate);

        btnCancel=new JButton("戻る");
        btnCancel.setBounds(490, 420, 120, 40);
        btnCancel.setBackground(Color.LIGHT_GRAY);
        btnCancel.setForeground(Color.BLACK);
        btnCancel.setFont(new Font("Arial", Font.BOLD, 18));
        jlbImgUpdate.add(btnCancel);

        jlbUpdateName.setVisible(false);
        jlbUpdateTitle.setVisible(false);
        jlbUpdateAddress.setVisible(false);
        jlbUpdatePhone.setVisible(false);
        jlbUpdateEmail.setVisible(false);
        jlbUpdateGender.setVisible(false);
        jlbUpdateSalary.setVisible(false);
        jlbUpdateID.setVisible(false);
        jlbUpdateDob.setVisible(false);
        jlbUpdateRoleID.setVisible(false);
        jtxName.setVisible(false);
        jtxAddress.setVisible(false);
        jtxPhone.setVisible(false);
        jtxEmail.setVisible(false);
        jtxGender.setVisible(false);
        jtxSalary.setVisible(false);
        jtxEmployeeID.setVisible(false);
        jtxDob.setVisible(false);
        jtxRoleID.setVisible(false);

        btnUpdate.setVisible(false);
        btnCancel.setVisible(false);

        btnUpdateSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBConnection dbConnection=new DBConnection(); // Tạo kết nối cơ sở dữ liệu
                String searchTerm=jtxInforUpdate.getText(); // Lấy giá trị từ JTextField

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
                        salary=rs.getString("position");
                        role_id=rs.getString("role_id");
                        JOptionPane.showMessageDialog(null, "従業員が見つかりました");
                        // Hiển thị thông tin (ví dụ: sử dụng System.out.println hoặc hiển thị trong giao diện người dùng)
                        jlbUpdateID.setVisible(true);
                        jlbUpdateName.setVisible(true);
                        jlbUpdateGender.setVisible(true);
                        jlbUpdateDob.setVisible(true);
                        jlbUpdateAddress.setVisible(true);
                        jlbUpdateEmail.setVisible(true);
                        jlbUpdatePhone.setVisible(true);
                        jlbUpdateSalary.setVisible(true);
                        jlbUpdateRoleID.setVisible(true);
                        jtxName.setVisible(true);
                        jtxAddress.setVisible(true);
                        jtxPhone.setVisible(true);
                        jtxEmail.setVisible(true);
                        jtxGender.setVisible(true);
                        jtxSalary.setVisible(true);
                        jtxEmployeeID.setVisible(true);
                        jtxDob.setVisible(true);
                        jtxRoleID.setVisible(true);
                        jtxName.setText(name);
                        jtxAddress.setText(address);
                        jtxPhone.setText(phone);
                        jtxEmail.setText(email);
                        jtxGender.setText(gender);
                        jtxSalary.setText(salary);
                        jtxEmployeeID.setText(employeeId);
                        jtxDob.setText(dob);
                        jtxRoleID.setText(role_id);

                        jlbSearchUpdate.setVisible(false);
                        jlbInfoUpdate.setVisible(false);
                        jtxInforUpdate.setVisible(false);
                        btnUpdateSearch.setVisible(false);
                        btnUpdateCancel.setVisible(false);
                        btnUpdate.setVisible(true);
                        btnCancel.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "従業員が見つかりません");
                        jtxInforUpdate.setText("氏名、電話番号、メール、従業員のIDを入力");
                    }
                    // Đóng kết nối cơ sở dữ liệu
                    dbConnection.connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DBConnection dbConnection=new DBConnection(); // Tạo kết nối cơ sở dữ liệu
                    String sql;
                    employeeId=jtxEmployeeID.getText();
                    name=jtxName.getText();
                    gender=jtxGender.getText();
                    dob=jtxDob.getText();
                    address=jtxAddress.getText();
                    email=jtxEmail.getText();
                    phone=jtxPhone.getText();
                    salary=jtxSalary.getText();
                    role_id=jtxRoleID.getText();

                    String searchTerm=jtxInforUpdate.getText(); // Lấy giá trị từ JTextField

                    sql="UPDATE employees SET name = ?, gender = ?, dob = ?, address = ?, email = ?, phone = ?, salary = ?, role_id = ? WHERE employee_id = ? OR name = ? OR email = ? OR phone = ?";
                    PreparedStatement preparedStatement=dbConnection.connection.prepareStatement(sql);
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, gender);
                    preparedStatement.setString(3, dob);
                    preparedStatement.setString(4, address);
                    preparedStatement.setString(5, email);
                    preparedStatement.setString(6, phone);
                    preparedStatement.setInt(7, Integer.parseInt(salary));
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
                        JOptionPane.showMessageDialog(null, "従業員の情報を更新できませんでした");
                    }
                } catch (Exception ae) {
                    ae.printStackTrace();
                }
            }
        });
        btnUpdateCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFrame.dispose();
                AdminUI adminUI=new AdminUI();
                adminUI.setVisible(true);

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
        JLabel jlbImgSearch, jlbInfor, jlbSearchTitle, jlbSearchName, jlbSearchAddress, jlbSearchPhone,
                jlbSearchEmail, jlbSearchGender, jlbSearchSalary, jlbSearchId, jlbSearchDob, jlbSearchRoleID,
                jlbSName, jlbSAddress, jlbSPhone, jlbSEmail, jlbSGender, jlbSSalary, jlbSID, jlbSDob, jlbSRoleID;
        JButton btnSearchInfor, btnSearchCancel, btnSearchUpdate, btnSearchReturn;
        JTextField jtxInforSearch;

        //Frame Details
        searchFrame=new JFrame("閲覧");
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
        jtxInforSearch.setFont(new Font("serif", Font.BOLD, 18));
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

        btnSearchUpdate=new JButton("更新");
        btnSearchUpdate.setBounds(300, 440, 120, 40);
        btnSearchUpdate.setBackground(Color.LIGHT_GRAY);
        btnSearchUpdate.setForeground(Color.BLACK);
        btnSearchUpdate.setFont(new Font("serif", Font.BOLD, 18));
        jlbImgSearch.add(btnSearchUpdate);

        btnSearchReturn=new JButton("戻る");
        btnSearchReturn.setBounds(500, 440, 120, 40);
        btnSearchReturn.setBackground(Color.LIGHT_GRAY);
        btnSearchReturn.setForeground(Color.BLACK);
        btnSearchReturn.setFont(new Font("serif", Font.BOLD, 18));
        jlbImgSearch.add(btnSearchReturn);

        btnSearchReturn.setVisible(false);
        btnSearchUpdate.setVisible(false);

        //Label Details

        //1.Name
        jlbSearchName=new JLabel("氏名:");
        jlbSearchName.setBounds(150, 140, 100, 30);
        jlbSearchName.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbSearchName);
        jlbSName=new JLabel();
        jlbSName.setBounds(250, 140, 200, 30);
        jlbSName.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbSName);

        //2.Address
        jlbSearchAddress=new JLabel("住所:");
        jlbSearchAddress.setBounds(450, 140, 200, 30);
        jlbSearchAddress.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbSearchAddress);

        jlbSAddress=new JLabel();
        jlbSAddress.setBounds(550, 140, 150, 30);
        jlbSAddress.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbSAddress);

        //3.Mobile No.
        jlbSearchPhone=new JLabel("電話番号:");
        jlbSearchPhone.setBounds(150, 200, 100, 30);
        jlbSearchPhone.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbSearchPhone);

        jlbSPhone=new JLabel();
        jlbSPhone.setBounds(250, 200, 150, 30);
        jlbSPhone.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbSPhone);

        //4.Email Id
        jlbSearchEmail=new JLabel("メール:");
        jlbSearchEmail.setBounds(450, 200, 100, 30);
        jlbSearchEmail.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbSearchEmail);

        jlbSEmail=new JLabel();
        jlbSEmail.setBounds(550, 200, 300, 30);
        jlbSEmail.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbSEmail);

        //5.Gender
        jlbSearchGender=new JLabel("性別:");
        jlbSearchGender.setBounds(150, 260, 100, 30);
        jlbSearchGender.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbSearchGender);

        jlbSGender=new JLabel();
        jlbSGender.setBounds(250, 260, 150, 30);
        jlbSGender.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbSGender);

        //6.Position
        jlbSearchSalary=new JLabel("職位:");
        jlbSearchSalary.setBounds(450, 260, 100, 30);
        jlbSearchSalary.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbSearchSalary);

        jlbSSalary=new JLabel();
        jlbSSalary.setBounds(550, 260, 150, 30);
        jlbSSalary.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbSSalary);

        //7.Employee ID
        jlbSearchId=new JLabel("従業員ID:");
        jlbSearchId.setBounds(150, 320, 150, 30);
        jlbSearchId.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbSearchId);

        jlbSID=new JLabel();
        jlbSID.setBounds(250, 320, 150, 30);
        jlbSID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbSID);

        //8.Date of Birth
        jlbSearchDob=new JLabel("生年月日:");
        jlbSearchDob.setBounds(450, 320, 150, 30);
        jlbSearchDob.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbSearchDob);

        jlbSDob=new JLabel();
        jlbSDob.setBounds(550, 320, 150, 30);
        jlbSDob.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbSDob);

        //9.Role ID
        jlbSearchRoleID=new JLabel("役割:");
        jlbSearchRoleID.setBounds(150, 380, 150, 30);
        jlbSearchRoleID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbSearchRoleID);

        jlbSRoleID=new JLabel();
        jlbSRoleID.setBounds(250, 380, 150, 30);
        jlbSRoleID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgSearch.add(jlbSRoleID);

        jlbSearchId.setVisible(false);
        jlbSearchName.setVisible(false);
        jlbSearchAddress.setVisible(false);
        jlbSearchPhone.setVisible(false);
        jlbSearchEmail.setVisible(false);
        jlbSearchGender.setVisible(false);
        jlbSearchSalary.setVisible(false);
        jlbSearchDob.setVisible(false);
        jlbSearchRoleID.setVisible(false);

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
                        employeeId=rs.getString("employee_id");
                        name=rs.getString("name");
                        gender=rs.getString("gender");
                        dob=rs.getString("dob");
                        address=rs.getString("address");
                        email=rs.getString("email");
                        phone=rs.getString("phone");
                        salary=rs.getString("position");
//                        salary = decimalFormat.format(rs.getDouble("salary"));
                        role_id=rs.getString("role_id");
                        JOptionPane.showMessageDialog(null, "従業員が見つかりました");
                        searchFrame.setVisible(true);
                        // Hiển thị thông tin (ví dụ: sử dụng System.out.println hoặc hiển thị trong giao diện người dùng)
                        jlbSearchName.setVisible(true);
                        jlbSearchAddress.setVisible(true);
                        jlbSearchPhone.setVisible(true);
                        jlbSearchEmail.setVisible(true);
                        jlbSearchGender.setVisible(true);
                        jlbSearchSalary.setVisible(true);
                        jlbSearchId.setVisible(true);
                        jlbSearchDob.setVisible(true);
                        jlbSearchRoleID.setVisible(true);
                        jlbSID.setText(employeeId);
                        jlbSName.setText(name);
                        jlbSGender.setText(gender);
                        jlbSDob.setText(dob);
                        jlbSAddress.setText(address);
                        jlbSEmail.setText(email);
                        jlbSPhone.setText(phone);
                        jlbSSalary.setText(salary);
                        jlbSRoleID.setText(role_id);
                        jlbSID.setVisible(true);
                        jlbSName.setVisible(true);
                        jlbSGender.setVisible(true);
                        jlbSDob.setVisible(true);
                        jlbSAddress.setVisible(true);
                        jlbSEmail.setVisible(true);
                        jlbSPhone.setVisible(true);
                        jlbSSalary.setVisible(true);
                        jlbSRoleID.setVisible(true);
                        jtxInforSearch.setVisible(false);
                        jlbInfor.setVisible(false);
                        btnSearchInfor.setVisible(false);
                        btnSearchCancel.setVisible(false);
                        btnSearchUpdate.setVisible(true);
                        btnSearchReturn.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "従業員が見つかりません");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnSearchCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainUI=new MainUI();
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
                btnSearchUpdate.setVisible(false);
                btnSearchReturn.setVisible(false);
                jlbSearchName.setVisible(false);
                jlbSName.setVisible(false);
                jlbSearchGender.setVisible(false);
                jlbSGender.setVisible(false);
                jlbSearchDob.setVisible(false);
                jlbSDob.setVisible(false);
                jlbSearchAddress.setVisible(false);
                jlbSAddress.setVisible(false);
                jlbSearchEmail.setVisible(false);
                jlbSEmail.setVisible(false);
                jlbSearchPhone.setVisible(false);
                jlbSPhone.setVisible(false);
                jlbSearchSalary.setVisible(false);
                jlbSSalary.setVisible(false);
                jlbSearchId.setVisible(false);
                jlbSID.setVisible(false);
                jlbSearchRoleID.setVisible(false);
                jlbSRoleID.setVisible(false);
            }
        });
        btnSearchUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFrame.setVisible(false);
                updateFrame.setVisible(true);
            }
        });
    }

    public void resetJTextField() {
        jtxAAddress.setText(""); // Đặt lại JTextField của địa chỉ
        jtxAEmail.setText(""); // Đặt lại JTextField của email
        jtxAGender.setText(""); // Đặt lại JTextField của giới tính
        jtxAName.setText(""); // Đặt lại JTextField của tên
        jtxAPhone.setText(""); // Đặt lại JTextField của số điện thoại
        jtxASalary.setText(""); // Đặt lại JTextField của vị trí
        jtxARoleID.setText(""); // Đặt lại JTextField của ID vai trò
        jtxADob.setText(""); // Đặt lại JTextField của ngày sinh
        jtxAID.setText("");
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
        new EmployeeManager();
    }
}