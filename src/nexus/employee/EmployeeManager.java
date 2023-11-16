//add,remove,update,view employee

package nexus.employee;

import nexus.employee.userUI.AdminUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeManager {
    public JFrame addFrame, removeFrame, updateFrame, searchFrame;
    private String searchTemp, employeeId, name, gender, dob, address, email, phone, position, role_id;
    public JTextField jtxAAddress, jtxAName, jtxAGender, jtxADob, jtxAEmail, jtxAPhone, jtxAPos, jtxARoleID, jtxAID;
    MainUI mainUI;
    private String selectedImagePath=""; // Khởi tạo với giá trị mặc định là chuỗi rỗng

    public EmployeeManager() {
        ImageIcon img=new ImageIcon("src/nexus/employee/images/frontPage_1.png");
        //Hiển thị lương dưới dạng số nguyên
//Component thêm nhân viên
        JLabel jlbAddTitle, jlbTitle, jlbAddID, jlbAddName, jlbAddGender, jlbAddDob, jlbAddAddress, jlbAddEmail, jlbAddPhone, jlbAddPos, jlbAddRoleID;
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

        //6.Position
        jlbAddPos=new JLabel("職位:");
        jlbAddPos.setBounds(450, 240, 100, 30);
        jlbAddPos.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgAdd.add(jlbAddPos);

        jtxAPos=new JTextField();
        jtxAPos.setBounds(550, 240, 150, 30);
        jlbImgAdd.add(jtxAPos);

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

        //ImageChoose
        JButton btnChooseImage=new JButton("写真を選択");
        btnChooseImage.setBounds(440, 340, 150, 30);
        btnChooseImage.setBackground(Color.LIGHT_GRAY);
        btnChooseImage.setForeground(Color.BLACK);
        btnChooseImage.setFont(new Font("Arial", Font.BOLD, 18));
        jlbImgAdd.add(btnChooseImage);

        JLabel imagePathLabel=new JLabel(selectedImagePath);
        imagePathLabel.setBounds(600, 240, 200, 450);
        jlbImgAdd.add(imagePathLabel);
        jlbImgAdd.revalidate();
        jlbImgAdd.repaint();

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

        btnChooseImage.addActionListener(e -> {
            JFileChooser fileChooser=new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif"));

            int result=fileChooser.showOpenDialog(addFrame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile=fileChooser.getSelectedFile();
                // Cập nhật giá trị cho selectedImagePath
                selectedImagePath=selectedFile.getAbsolutePath();
                // Hiển thị ảnh trên JLabel hoặc thực hiện các thao tác khác tùy ý
            }
        });


        btnAdd.addActionListener(actionEvent -> {
            employeeId=jtxAID.getText();
            name=jtxAName.getText();
            gender=jtxAGender.getText();
            dob=jtxADob.getText();
            address=jtxAAddress.getText();
            email=jtxAEmail.getText();
            phone=jtxAPhone.getText();
            position=jtxAPos.getText();
            role_id=jtxARoleID.getText();
            // Kiểm tra địa chỉ email có chứa @ hay không
            // Kiểm tra số điện thoại có đúng định dạng không (11 số, bắt đầu bằng 0, số thứ 2 là 9, 8, 7)
            if (!phone.matches("^0[987][0-9]{4}[0-9]{4}$")) {
                JOptionPane.showMessageDialog(null, "電話番号が無効です。11桁の電話番号を入力してください。");
                return;
            }
            if (!email.contains("@.")) {
                JOptionPane.showMessageDialog(null, "メールアドレスは間違いましたー" + "\"" + "@" + "\"" + "が必要です");
                return;
            }
            String dateFormat="\\d{4}-\\d{2}-\\d{2}";
            if (!dob.matches(dateFormat)) {
                JOptionPane.showMessageDialog(null, "生年月日はyyyy-MM-ddの形式で入力してください");
                return;
            }
//                String employeeID=jtxAID.getText();
            // Kiểm tra xem JTextField có giá trị hay không
            if (employeeId.isEmpty()) {
                JOptionPane.showMessageDialog(null, "従業員IDを入力してください。");
                return;
            }

            // Kiểm tra xem ảnh đã được chọn chưa
            if (selectedImagePath == null || selectedImagePath.isEmpty()) {
                JOptionPane.showMessageDialog(null, "写真を選択してください。");
                return;
            }

            DBConnection dbConnection=new DBConnection(); // Tạo kết nối cơ sở dữ liệu
            try {
                String strSql="INSERT INTO employees (employee_id, name, gender, dob, address, email, phone, position, role_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement=dbConnection.connection.prepareStatement(strSql);
                statement.setString(1, employeeId);
                statement.setString(2, name);
                statement.setString(3, gender);
                statement.setString(4, dob);
                statement.setString(5, address);
                statement.setString(6, email);
                statement.setString(7, phone);
                statement.setString(8, position);
                statement.setString(9, role_id);
                statement.executeUpdate();
                // Lưu hình ảnh vào đường dẫn cụ thể
                Path sourcePath=Paths.get(selectedImagePath);
                Path destinationPath=Paths.get("src/nexus/employee/images/employeeImg/" + employeeId + ".jpg");
                Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(null, "従業員を追加できました");
                addFrame.dispose();
                AdminUI adminUI=new AdminUI();
                adminUI.setVisible(true);
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        });
        btnReset.addActionListener(e -> resetJTextField());
        btnAddCancel.addActionListener(e -> {
            addFrame.dispose();
            AdminUI adminUI=new AdminUI();
            adminUI.setVisible(true);
        });

//Component xóa nhân viên
        JButton btnRemoveSearch, btnRemoveDelete, btnRemoveCancel, btnRemoveReturn;
        JTextField jtxInforRemove;
        JLabel jlbImgRemove, jlbRemoveTittle, jlbRemoveGender, jlbRemoveDob, jlbRemoveAddress, jlbRemoveEmail, jlbRemovePhone, jlbRemoveposition, jlbRemoveRoleID, jlbRemoveName, jlbRemoveID, jlbRID, jlbRName, jlbRGender, jlbRDob, jlbRAddress, jlbREmail, jlbRPhone, jlbRposition, jlbRRoleID;
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

//        final String IMAGE_FOLDER_PATH="src/nexus/employee/images/employeeImg/";


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
        jlbRemoveName.setBounds(50, 140, 100, 30);
        jlbRemoveName.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRemoveName);

        jlbRName=new JLabel();
        jlbRName.setBounds(150, 140, 200, 30);
        jlbRName.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRName);

        //2.Address
        jlbRemoveAddress=new JLabel("住所:");
        jlbRemoveAddress.setBounds(300, 140, 200, 30);
        jlbRemoveAddress.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRemoveAddress);

        jlbRAddress=new JLabel();
        jlbRAddress.setBounds(400, 140, 150, 30);
        jlbRAddress.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRAddress);

        //3.Mobile No.
        jlbRemovePhone=new JLabel("電話番号:");
        jlbRemovePhone.setBounds(50, 190, 100, 30);
        jlbRemovePhone.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRemovePhone);

        jlbRPhone=new JLabel();
        jlbRPhone.setBounds(150, 190, 150, 30);
        jlbRPhone.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRPhone);

        //4.Email Id
        jlbRemoveEmail=new JLabel("メール:");
        jlbRemoveEmail.setBounds(300, 190, 100, 30);
        jlbImgRemove.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRemoveEmail);

        jlbREmail=new JLabel();
        jlbREmail.setBounds(400, 190, 200, 30);
        jlbREmail.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbREmail);

        //5.Gender
        jlbRemoveGender=new JLabel("性別:");
        jlbRemoveGender.setBounds(50, 240, 100, 30);
        jlbRemoveGender.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRemoveGender);

        jlbRGender=new JLabel();
        jlbRGender.setBounds(150, 240, 150, 30);
        jlbRGender.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRGender);

        //6.Job position
        jlbRemoveposition=new JLabel("職位:");
        jlbRemoveposition.setBounds(300, 240, 100, 30);
        jlbRemoveposition.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRemoveposition);

        jlbRposition=new JLabel();
        jlbRposition.setBounds(400, 240, 150, 30);
        jlbRposition.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRposition);

        //7.Employee ID
        jlbRemoveID=new JLabel("従業員ID:");
        jlbRemoveID.setBounds(50, 290, 150, 30);
        jlbRemoveID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRemoveID);

        jlbRID=new JLabel();
        jlbRID.setBounds(150, 290, 150, 30);
        jlbRID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRID);

        //8.Date of Birth
        jlbRemoveDob=new JLabel("生年月日:");
        jlbRemoveDob.setBounds(300, 290, 150, 30);
        jlbRemoveDob.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRemoveDob);

        jlbRDob=new JLabel();
        jlbRDob.setBounds(400, 290, 150, 30);
        jlbRDob.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRDob);

        //9.Role ID
        jlbRemoveRoleID=new JLabel("役割ID:");
        jlbRemoveRoleID.setBounds(50, 340, 150, 30);
        jlbRemoveRoleID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRemoveRoleID);

        jlbRRoleID=new JLabel();
        jlbRRoleID.setBounds(150, 340, 150, 30);
        jlbRRoleID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgRemove.add(jlbRRoleID);

        JLabel jlbRmvFace=new JLabel();
        jlbRmvFace.setBounds(650, 70, 200, 390);
        jlbImgRemove.add(jlbRmvFace);
        jlbRmvFace.setVisible(false);


        jlbRemoveName.setVisible(false);
        jlbRemoveAddress.setVisible(false);
        jlbRemovePhone.setVisible(false);
        jlbRemoveEmail.setVisible(false);
        jlbRemoveGender.setVisible(false);
        jlbRemoveposition.setVisible(false);
        jlbRemoveID.setVisible(false);
        jlbRemoveDob.setVisible(false);
        jlbRemoveRoleID.setVisible(false);
        btnRemoveDelete.setVisible(false);
        btnRemoveCancel.setVisible(false);

        btnRemoveSearch.addActionListener(e -> {
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
                    position=rs.getString("position");
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
                    jlbRposition.setVisible(true);
                    jlbRRoleID.setVisible(true);
                    jlbRID.setText(employeeId);
                    jlbRName.setText(name);
                    jlbRGender.setText(gender);
                    jlbRDob.setText(dob);
                    jlbRAddress.setText(address);
                    jlbREmail.setText(email);
                    jlbRPhone.setText(phone);
                    jlbRposition.setText(position);
                    jlbRRoleID.setText(role_id);
                    jlbRemoveID.setVisible(true);
                    jlbRemoveName.setVisible(true);
                    jlbRemoveGender.setVisible(true);
                    jlbRemoveDob.setVisible(true);
                    jlbRemoveAddress.setVisible(true);
                    jlbRemoveEmail.setVisible(true);
                    jlbRemovePhone.setVisible(true);
                    jlbRemoveposition.setVisible(true);
                    jlbRemoveRoleID.setVisible(true);

                    jtxInforRemove.setVisible(false);
                    jlbRemoveTittle.setVisible(false);

                    btnRemoveSearch.setVisible(false);
                    btnRemoveReturn.setVisible(false);

                    btnRemoveCancel.setVisible(true);
                    btnRemoveDelete.setVisible(true);
                    String imagePath="src/nexus/employee/images/employeeImg/" + employeeId + ".jpg";
                    try {
                        BufferedImage image=ImageIO.read(new File(imagePath));

                        // Lấy kích thước thực của hình ảnh
                        int imgWidth=image.getWidth();
                        int imgHeight=image.getHeight();

                        // Kích thước của jlbFace
                        int labelWidth=200;
                        int labelHeight=300;

                        // Tính toán tỷ lệ để điều chỉnh kích thước hình ảnh
                        double scaleFactor=Math.min(1.0 * labelWidth / imgWidth, 1.0 * labelHeight / imgHeight);

                        // Tính toán kích thước mới dựa trên tỷ lệ
                        int newWidth=(int) (imgWidth * scaleFactor);
                        int newHeight=(int) (imgHeight * scaleFactor);

                        // Sử dụng getScaledInstance để điều chỉnh kích thước hình ảnh
                        Image scaledImage=image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

                        // Đặt hình ảnh điều chỉnh vào jlbFace
                        jlbRmvFace.setIcon(new ImageIcon(scaledImage));
                        jlbRmvFace.setVisible(true);
                    } catch (Exception ae) {
                        ae.printStackTrace();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "従業員が見つかりませんでした");
                }
                // Đóng kết nối cơ sở dữ liệu
                dbConnection.connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        btnRemoveDelete.addActionListener(e -> {
            int confirm=JOptionPane.showConfirmDialog(removeFrame, "従業員を削除しますか？", "削除", JOptionPane.YES_NO_OPTION);
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
                        // Xóa ảnh từ local
                        String imagePath="src/nexus/employee/images/employeeImg/" + searchTerm + ".jpg";
                        File imageFile=new File(imagePath);
                        if (imageFile.exists()) {
                            if (imageFile.delete()) {
                                JOptionPane.showMessageDialog(null, "従業員を削除できました");
                                removeFrame.dispose();
                                AdminUI adminUI=new AdminUI();
                                adminUI.setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "Ảnh không thể xóa");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Ảnh không tồn tại");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, searchTerm + "を削除できませんでした");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnRemoveReturn.addActionListener(e -> {
            removeFrame.dispose();
            AdminUI adminUI=new AdminUI();
            adminUI.setVisible(true);
        });
        btnRemoveCancel.addActionListener(e -> {
            removeFrame.dispose();
            AdminUI adminUI=new AdminUI();
            adminUI.setVisible(true);
        });

//Component cập nhật nhân viên

        JLabel jlbSearchUpdate, jlbInfoUpdate, jlbImgUpdate, jlbUpdateName, jlbUpdateGender, jlbUpdateDob, jlbUpdateAddress, jlbUpdateEmail, jlbUpdatePhone, jlbUpdateposition, jlbUpdateRoleID, jlbUpdateID;
        JTextField jtxEmployeeID, jtxName, jtxGender, jtxDob, jtxAddress, jtxEmail, jtxPhone, jtxposition, jtxRoleID, jtxInforUpdate;
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

        //6.Job position
        jlbUpdateposition=new JLabel("職位:");
        jlbUpdateposition.setBounds(450, 240, 100, 30);
        jlbUpdateposition.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jlbUpdateposition);

        jtxposition=new JTextField();
        jtxposition.setBounds(550, 240, 150, 30);
        jtxposition.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgUpdate.add(jtxposition);

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
        jlbUpdateposition.setVisible(false);
        jlbUpdateID.setVisible(false);
        jlbUpdateDob.setVisible(false);
        jlbUpdateRoleID.setVisible(false);
        jtxName.setVisible(false);
        jtxAddress.setVisible(false);
        jtxPhone.setVisible(false);
        jtxEmail.setVisible(false);
        jtxGender.setVisible(false);
        jtxposition.setVisible(false);
        jtxEmployeeID.setVisible(false);
        jtxDob.setVisible(false);
        jtxRoleID.setVisible(false);

        btnUpdate.setVisible(false);
        btnCancel.setVisible(false);

        btnUpdateSearch.addActionListener(e -> {
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
                    position=rs.getString("position");
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
                    jlbUpdateposition.setVisible(true);
                    jlbUpdateRoleID.setVisible(true);
                    jtxName.setVisible(true);
                    jtxAddress.setVisible(true);
                    jtxPhone.setVisible(true);
                    jtxEmail.setVisible(true);
                    jtxGender.setVisible(true);
                    jtxposition.setVisible(true);
                    jtxEmployeeID.setVisible(true);
                    jtxDob.setVisible(true);
                    jtxRoleID.setVisible(true);
                    jtxName.setText(name);
                    jtxAddress.setText(address);
                    jtxPhone.setText(phone);
                    jtxEmail.setText(email);
                    jtxGender.setText(gender);
                    jtxposition.setText(position);
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
        });

        btnUpdate.addActionListener(e -> {
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
                position=jtxposition.getText();
                role_id=jtxRoleID.getText();

                if (!phone.matches("^0[987]0[0-9]{4}[0-9]{4}$")) {
                    JOptionPane.showMessageDialog(null, "電話番号が無効です。11桁の電話番号を入力してください。");
                    return;
                }
                if (!email.contains("@.")) {
                    JOptionPane.showMessageDialog(null, "メールアドレスは間違いましたー" + "\"" + "@" + "\"" + "が必要です");
                    return;
                }
                String dateFormat="\\d{4}-\\d{2}-\\d{2}";
                if (!dob.matches(dateFormat)) {
                    JOptionPane.showMessageDialog(null, "生年月日はyyyy-MM-ddの形式で入力してください");
                    return;
                }
//                    String employeeID=jtxAID.getText();
                // Kiểm tra xem JTextField có giá trị hay không
                if (employeeId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "従業員IDを入力してください。");
                    return;
                }

                String searchTerm=jtxInforUpdate.getText(); // Lấy giá trị từ JTextField

                sql="UPDATE employees SET name = ?, gender = ?, dob = ?, address = ?, email = ?, phone = ?, position = ?, role_id = ? WHERE employee_id = ? OR name = ? OR email = ? OR phone = ?";
                PreparedStatement preparedStatement=dbConnection.connection.prepareStatement(sql);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, gender);
                preparedStatement.setString(3, dob);
                preparedStatement.setString(4, address);
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
        });
        btnUpdateCancel.addActionListener(e -> {
            updateFrame.dispose();
            AdminUI adminUI=new AdminUI();
            adminUI.setVisible(true);

        });
        btnCancel.addActionListener(e -> {
            updateFrame.dispose();
            AdminUI adminUI=new AdminUI();
            adminUI.setVisible(true);
        });
//Component tìm kiếm nhân viên
        JLabel jlbImgSearch, jlbInfor, jlbSearchTitle, jlbSearchName, jlbSearchAddress, jlbSearchPhone, jlbSearchEmail, jlbSearchGender, jlbSearchposition, jlbSearchId, jlbSearchDob, jlbSearchRoleID, jlbSName, jlbSAddress, jlbSPhone, jlbSEmail, jlbSGender, jlbSposition, jlbSID, jlbSDob, jlbSRoleID;
        JButton btnSearchInfor, btnSearchCancel, btnSearchUpdate, btnSearchReturn, btnDatabaseUpdate;
        JTextField jtxInforSearch, jtxSName, jtxSAddress, jtxSPhone, jtxSEmail, jtxSGender, jtxSposition, jtxSID, jtxSDob, jtxSRoleID;
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
        btnSearchUpdate.setBounds(300, 460, 120, 35);
        btnSearchUpdate.setBackground(Color.LIGHT_GRAY);
        btnSearchUpdate.setForeground(Color.BLACK);
        btnSearchUpdate.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        jlbImgSearch.add(btnSearchUpdate);

        btnDatabaseUpdate=new JButton("更新");
        btnDatabaseUpdate.setBounds(300, 460, 120, 35);
        btnDatabaseUpdate.setBackground(Color.LIGHT_GRAY);
        btnDatabaseUpdate.setForeground(Color.BLACK);
        btnDatabaseUpdate.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        jlbImgSearch.add(btnDatabaseUpdate);

        btnSearchReturn=new JButton("戻る");
        btnSearchReturn.setBounds(500, 460, 120, 35);
        btnSearchReturn.setBackground(Color.LIGHT_GRAY);
        btnSearchReturn.setForeground(Color.BLACK);
        btnSearchReturn.setFont(new Font("Times_New_Roman   ", Font.BOLD, 18));
        jlbImgSearch.add(btnSearchReturn);

        btnSearchReturn.setVisible(false);
        btnSearchUpdate.setVisible(false);
        btnDatabaseUpdate.setVisible(false);

        //Label Details

        //1.Name
        jlbSearchName=new JLabel("氏名:");
        jlbSearchName.setBounds(50, 140, 100, 30);
        jlbSearchName.setFont(new Font("serif", Font.BOLD, 20));

        jlbSName=new JLabel();
        jlbSName.setBounds(150, 140, 200, 30);
        jlbSName.setFont(new Font("serif", Font.BOLD, 20));

        jtxSName=new JTextField();
        jtxSName.setBounds(150, 140, 150, 30);
        jtxSName.setFont(new Font("serif", Font.BOLD, 20));

        jlbImgSearch.add(jlbSearchName);
        jlbImgSearch.add(jlbSName);
        jlbImgSearch.add(jtxSName);


        //2.Address
        jlbSearchAddress=new JLabel("住所:");
        jlbSearchAddress.setBounds(320, 140, 200, 30);
        jlbSearchAddress.setFont(new Font("serif", Font.BOLD, 20));

        jlbSAddress=new JLabel();
        jlbSAddress.setBounds(420, 140, 150, 30);
        jlbSAddress.setFont(new Font("serif", Font.BOLD, 20));

        jtxSAddress=new JTextField();
        jtxSAddress.setBounds(420, 140, 150, 30);
        jtxSAddress.setFont(new Font("serif", Font.BOLD, 20));

        jlbImgSearch.add(jlbSearchAddress);
        jlbImgSearch.add(jlbSAddress);
        jlbImgSearch.add(jtxSAddress);

        //3.Mobile No.
        jlbSearchPhone=new JLabel("電話番号:");
        jlbSearchPhone.setBounds(50, 200, 100, 30);
        jlbSearchPhone.setFont(new Font("serif", Font.BOLD, 20));

        jlbSPhone=new JLabel();
        jlbSPhone.setBounds(150, 200, 150, 30);
        jlbSPhone.setFont(new Font("serif", Font.BOLD, 20));

        jtxSPhone=new JTextField();
        jtxSPhone.setBounds(150, 200, 150, 30);
        jtxSPhone.setFont(new Font("serif", Font.BOLD, 20));

        jlbImgSearch.add(jlbSPhone);
        jlbImgSearch.add(jlbSearchPhone);
        jlbImgSearch.add(jtxSPhone);

        //4.Email Id
        jlbSearchEmail=new JLabel("メール:");
        jlbSearchEmail.setBounds(320, 200, 100, 30);
        jlbSearchEmail.setFont(new Font("serif", Font.BOLD, 20));

        jlbSEmail=new JLabel();
        jlbSEmail.setBounds(420, 200, 300, 30);
        jlbSEmail.setFont(new Font("serif", Font.BOLD, 20));

        jtxSEmail=new JTextField();
        jtxSEmail.setBounds(420, 200, 150, 30);
        jtxSEmail.setFont(new Font("serif", Font.BOLD, 20));

        jlbImgSearch.add(jlbSEmail);
        jlbImgSearch.add(jlbSearchEmail);
        jlbImgSearch.add(jtxSEmail);

        //5.Gender
        jlbSearchGender=new JLabel("性別:");
        jlbSearchGender.setBounds(50, 260, 100, 30);
        jlbSearchGender.setFont(new Font("serif", Font.BOLD, 20));

        jlbSGender=new JLabel();
        jlbSGender.setBounds(150, 260, 150, 30);
        jlbSGender.setFont(new Font("serif", Font.BOLD, 20));

        jtxSGender=new JTextField();
        jtxSGender.setBounds(150, 260, 150, 30);
        jtxSGender.setFont(new Font("serif", Font.BOLD, 20));

        jlbImgSearch.add(jlbSGender);
        jlbImgSearch.add(jlbSearchGender);
        jlbImgSearch.add(jtxSGender);

        //6.Position
        jlbSearchposition=new JLabel("職位:");
        jlbSearchposition.setBounds(320, 260, 100, 30);
        jlbSearchposition.setFont(new Font("serif", Font.BOLD, 20));

        jlbSposition=new JLabel();
        jlbSposition.setBounds(420, 260, 150, 30);
        jlbSposition.setFont(new Font("serif", Font.BOLD, 20));

        jtxSposition=new JTextField();
        jtxSposition.setBounds(420, 260, 150, 30);
        jtxSposition.setFont(new Font("serif", Font.BOLD, 20));

        jlbImgSearch.add(jlbSposition);
        jlbImgSearch.add(jlbSearchposition);
        jlbImgSearch.add(jtxSposition);

        //7.Employee ID
        jlbSearchId=new JLabel("従業員ID:");
        jlbSearchId.setBounds(50, 320, 150, 30);
        jlbSearchId.setFont(new Font("serif", Font.BOLD, 20));

        jlbSID=new JLabel();
        jlbSID.setBounds(150, 320, 150, 30);
        jlbSID.setFont(new Font("serif", Font.BOLD, 20));

        jtxSID=new JTextField();
        jtxSID.setBounds(150, 320, 150, 30);
        jtxSID.setFont(new Font("serif", Font.BOLD, 20));

        jlbImgSearch.add(jlbSID);
        jlbImgSearch.add(jlbSearchId);
        jlbImgSearch.add(jtxSID);

        //8.Date of Birth
        jlbSearchDob=new JLabel("生年月日:");
        jlbSearchDob.setBounds(320, 320, 150, 30);
        jlbSearchDob.setFont(new Font("serif", Font.BOLD, 20));

        jlbSDob=new JLabel();
        jlbSDob.setBounds(420, 320, 150, 30);
        jlbSDob.setFont(new Font("serif", Font.BOLD, 20));

        jtxSDob=new JTextField();
        jtxSDob.setBounds(420, 320, 150, 30);
        jtxSDob.setFont(new Font("serif", Font.BOLD, 20));

        jlbImgSearch.add(jlbSDob);
        jlbImgSearch.add(jlbSearchDob);
        jlbImgSearch.add(jtxSDob);

        //9.Role ID
        jlbSearchRoleID=new JLabel("役割:");
        jlbSearchRoleID.setBounds(50, 380, 150, 30);
        jlbSearchRoleID.setFont(new Font("serif", Font.BOLD, 20));

        jlbSRoleID=new JLabel();
        jlbSRoleID.setBounds(150, 380, 150, 30);
        jlbSRoleID.setFont(new Font("serif", Font.BOLD, 20));

        jtxSRoleID=new JTextField();
        jtxSRoleID.setBounds(150, 380, 150, 30);
        jtxSRoleID.setFont(new Font("serif", Font.BOLD, 20));

        jlbImgSearch.add(jlbSRoleID);
        jlbImgSearch.add(jlbSearchRoleID);
        jlbImgSearch.add(jtxSRoleID);

        JLabel jlbFace=new JLabel();
        jlbFace.setBounds(650, 70, 200, 390);
        jlbImgSearch.add(jlbFace);
        jlbFace.setVisible(false);


        jlbSearchId.setVisible(false);
        jlbSearchName.setVisible(false);
        jlbSearchAddress.setVisible(false);
        jlbSearchPhone.setVisible(false);
        jlbSearchEmail.setVisible(false);
        jlbSearchGender.setVisible(false);
        jlbSearchposition.setVisible(false);
        jlbSearchDob.setVisible(false);
        jlbSearchRoleID.setVisible(false);
        jtxSName.setVisible(false);
        jtxSAddress.setVisible(false);
        jtxSPhone.setVisible(false);
        jtxSEmail.setVisible(false);
        jtxSGender.setVisible(false);
        jtxSposition.setVisible(false);
        jtxSID.setVisible(false);
        jtxSDob.setVisible(false);
        jtxSRoleID.setVisible(false);

        btnSearchInfor.addActionListener(e -> {
            DBConnection dbConnection=new DBConnection(); // Tạo kết nối cơ sở dữ liệu
            String searchTerm=jtxInforSearch.getText(); // Lấy giá trị từ JTextField
            searchTemp=searchTerm;
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
//                        position = decimalFormat.format(rs.getDouble("position"));
                    role_id=rs.getString("role_id");
                    JOptionPane.showMessageDialog(null, "従業員が見つかりました");
                    searchFrame.setVisible(true);
                    String imagePath="src/nexus/employee/images/employeeImg/" + employeeId + ".jpg";
                    try {
                        BufferedImage image=ImageIO.read(new File(imagePath));
                        // Lấy kích thước thực của hình ảnh
                        int imgWidth=image.getWidth();
                        int imgHeight=image.getHeight();
                        // Kích thước của jlbFace
                        int labelWidth=200;
                        int labelHeight=300;
                        // Tính toán tỷ lệ để điều chỉnh kích thước hình ảnh
                        double scaleFactor=Math.min(1.0 * labelWidth / imgWidth, 1.0 * labelHeight / imgHeight);
                        // Tính toán kích thước mới dựa trên tỷ lệ
                        int newWidth=(int) (imgWidth * scaleFactor);
                        int newHeight=(int) (imgHeight * scaleFactor);
                        // Sử dụng getScaledInstance để điều chỉnh kích thước hình ảnh
                        Image scaledImage=image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                        // Đặt hình ảnh điều chỉnh vào jlbFace
                        jlbFace.setIcon(new ImageIcon(scaledImage));
                        jlbFace.repaint(); // Cập nhật lại vùng vẽ của JLabel
                        jlbFace.revalidate(); // Xác nhận lại kích thước và bố trí của JLabel
                        jlbFace.setVisible(true);
                    } catch (Exception ae) {
                        JOptionPane.showMessageDialog(null, "従業員の写真が見つかりません");
                        int option=JOptionPane.showConfirmDialog(null, "従業員の写真を追加しますか", "写真追加", JOptionPane.YES_NO_OPTION);
                        // Kiểm tra lựa chọn của người dùng
                        if (option == JOptionPane.YES_OPTION) {
                            JFileChooser fileChooser=new JFileChooser();
                            fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif"));
                            int result=fileChooser.showOpenDialog(addFrame);
                            if (result == JFileChooser.APPROVE_OPTION) {
                                File selectedFile=fileChooser.getSelectedFile();
                                // Cập nhật giá trị cho selectedImagePath
                                selectedImagePath=selectedFile.getAbsolutePath();
                                // Hiển thị ảnh trên JLabel hoặc thực hiện các thao tác khác tùy ý
                                try {
                                    Path sourcePath=Paths.get(selectedImagePath);
                                    Path destinationPath=Paths.get("src/nexus/employee/images/employeeImg/" + employeeId + ".jpg");
                                    Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                                    JOptionPane.showMessageDialog(null, "従業員の写真を追加できました");
                                } catch (Exception eException) {
                                    eException.printStackTrace();
                                }
                            }
                        } else {
                            jlbFace.setIcon(null);
                            jlbFace.setVisible(false);
                            jlbSearchName.setVisible(true);
                            jlbSearchAddress.setVisible(true);
                            jlbSearchPhone.setVisible(true);
                            jlbSearchEmail.setVisible(true);
                            jlbSearchGender.setVisible(true);
                            jlbSearchposition.setVisible(true);
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
                            jlbSposition.setText(position);
                            jlbSRoleID.setText(role_id);
                            jlbSID.setVisible(true);
                            jlbSName.setVisible(true);
                            jlbSGender.setVisible(true);
                            jlbSDob.setVisible(true);
                            jlbSAddress.setVisible(true);
                            jlbSEmail.setVisible(true);
                            jlbSPhone.setVisible(true);
                            jlbSposition.setVisible(true);
                            jlbSRoleID.setVisible(true);

                            jtxSName.setVisible(false);
                            jtxSAddress.setVisible(false);
                            jtxSPhone.setVisible(false);
                            jtxSEmail.setVisible(false);
                            jtxSGender.setVisible(false);
                            jtxSposition.setVisible(false);
                            jtxSID.setVisible(false);
                            jtxSDob.setVisible(false);
                            jtxSRoleID.setVisible(false);

                            jtxInforSearch.setVisible(false);
                            jlbInfor.setVisible(false);
                            btnSearchInfor.setVisible(false);
                            btnSearchCancel.setVisible(false);
                            btnSearchUpdate.setVisible(true);
                            btnSearchReturn.setVisible(true);
                            btnDatabaseUpdate.setVisible(false);
                            jlbFace.setVisible(false);
                        }
                    }
                    jlbSearchName.setVisible(true);
                    jlbSearchAddress.setVisible(true);
                    jlbSearchPhone.setVisible(true);
                    jlbSearchEmail.setVisible(true);
                    jlbSearchGender.setVisible(true);
                    jlbSearchposition.setVisible(true);
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
                    jlbSposition.setText(position);
                    jlbSRoleID.setText(role_id);
                    jlbSID.setVisible(true);
                    jlbSName.setVisible(true);
                    jlbSGender.setVisible(true);
                    jlbSDob.setVisible(true);
                    jlbSAddress.setVisible(true);
                    jlbSEmail.setVisible(true);
                    jlbSPhone.setVisible(true);
                    jlbSposition.setVisible(true);
                    jlbSRoleID.setVisible(true);
                    jlbFace.setVisible(true);
                    jtxSName.setVisible(false);
                    jtxSAddress.setVisible(false);
                    jtxSPhone.setVisible(false);
                    jtxSEmail.setVisible(false);
                    jtxSGender.setVisible(false);
                    jtxSposition.setVisible(false);
                    jtxSID.setVisible(false);
                    jtxSDob.setVisible(false);
                    jtxSRoleID.setVisible(false);
                    jtxInforSearch.setVisible(false);
                    jlbInfor.setVisible(false);
                    btnSearchInfor.setVisible(false);
                    btnSearchCancel.setVisible(false);
                    btnDatabaseUpdate.setVisible(false);
                    btnSearchUpdate.setVisible(true);
                    btnSearchReturn.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "従業員が見つかりません");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        btnSearchCancel.addActionListener(e -> {
            mainUI=new MainUI();
            searchFrame.dispose();
            AdminUI adminUI=new AdminUI();
            adminUI.setVisible(true);

        });
        btnSearchReturn.addActionListener(e -> {
            jlbInfor.setVisible(true);
            jtxInforSearch.setVisible(true);
            btnSearchInfor.setVisible(true);
            btnSearchCancel.setVisible(true);
            btnSearchUpdate.setVisible(false);
            btnSearchReturn.setVisible(false);
            btnDatabaseUpdate.setVisible(false);

            jlbSearchName.setVisible(false);
            jlbSearchGender.setVisible(false);
            jlbSearchDob.setVisible(false);
            jlbSearchAddress.setVisible(false);
            jlbSearchEmail.setVisible(false);
            jlbSearchPhone.setVisible(false);
            jlbSearchposition.setVisible(false);
            jlbSearchId.setVisible(false);
            jlbSearchRoleID.setVisible(false);

            jtxSName.setVisible(false);
            jtxSAddress.setVisible(false);
            jtxSPhone.setVisible(false);
            jtxSEmail.setVisible(false);
            jtxSGender.setVisible(false);
            jtxSposition.setVisible(false);
            jtxSID.setVisible(false);
            jtxSDob.setVisible(false);
            jtxSRoleID.setVisible(false);


            jlbSName.setVisible(false);
            jlbSGender.setVisible(false);
            jlbSDob.setVisible(false);
            jlbSAddress.setVisible(false);
            jlbSEmail.setVisible(false);
            jlbSPhone.setVisible(false);
            jlbSposition.setVisible(false);
            jlbSID.setVisible(false);
            jlbSRoleID.setVisible(false);
            jlbFace.setVisible(false);
        });
        btnSearchUpdate.addActionListener(e -> {
            jtxSName.setText(jlbSName.getText());
            jtxSAddress.setText(jlbSAddress.getText());
            jtxSPhone.setText(jlbSPhone.getText());
            jtxSEmail.setText(jlbSEmail.getText());
            jtxSGender.setText(jlbSGender.getText());
            jtxSposition.setText(jlbSposition.getText());
            jtxSID.setText(jlbSID.getText());
            jtxSDob.setText(jlbSDob.getText());
            jtxSRoleID.setText(jlbSRoleID.getText());

            jlbSearchName.setVisible(true);
            jlbSearchAddress.setVisible(true);
            jlbSearchPhone.setVisible(true);
            jlbSearchEmail.setVisible(true);
            jlbSearchGender.setVisible(true);
            jlbSearchposition.setVisible(true);
            jlbSearchId.setVisible(true);
            jlbSearchDob.setVisible(true);
            jlbSearchRoleID.setVisible(true);

            jtxSName.setVisible(true);
            jtxSAddress.setVisible(true);
            jtxSPhone.setVisible(true);
            jtxSEmail.setVisible(true);
            jtxSGender.setVisible(true);
            jtxSposition.setVisible(true);
            jtxSID.setVisible(true);
            jtxSDob.setVisible(true);
            jtxSRoleID.setVisible(true);

            jlbSName.setVisible(false);
            jlbSGender.setVisible(false);
            jlbSDob.setVisible(false);
            jlbSAddress.setVisible(false);
            jlbSEmail.setVisible(false);
            jlbSPhone.setVisible(false);
            jlbSposition.setVisible(false);
            jlbSID.setVisible(false);
            jlbSRoleID.setVisible(false);
            jlbFace.setVisible(true);
            btnDatabaseUpdate.setVisible(true);
            btnSearchUpdate.setVisible(false);
            btnDatabaseUpdate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        DBConnection dbConnection=new DBConnection(); // Tạo kết nối cơ sở dữ liệu
                        String sql;
                        employeeId=jtxSID.getText();
                        name=jtxSName.getText();
                        gender=jtxSGender.getText();
                        dob=jtxSDob.getText();
                        address=jtxSAddress.getText();
                        email=jtxSEmail.getText();
                        phone=jtxSPhone.getText();
                        position=jtxSposition.getText();
                        role_id=jtxSRoleID.getText();

                        char secondDigit = phone.charAt(1);
                        if (!phone.matches("^0[987]{1}[0]{1}[0-9]{4}[0-9]{4}$")) {
                            if (phone.charAt(0) != '0') {
                                JOptionPane.showMessageDialog(null, "電話番号の１番目は０である必要があります");
                                return;
                            }
                            else if (!(secondDigit == '7' || secondDigit == '8' || secondDigit == '9')) {
                                JOptionPane.showMessageDialog(null, "電話番号の2番目の数字は7、8、9である必要があります。");
                                return;
                            } else if (phone.charAt(2) != '0') {
                                JOptionPane.showMessageDialog(null, "電話番号の3番目の数字は0である必要があります。");
                                return;
                            } else {
                                JOptionPane.showMessageDialog(null, "電話番号が無効です。11桁の電話番号を入力してください。");
                                return;
                            }
                        }

                        String emailRegex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
                        if (!email.matches(emailRegex)) {
                            JOptionPane.showMessageDialog(null, "メールは正しくない");
                            return;
                        }
                        if (!employeeId.matches("^TH[0-9]{6}$")){
                            JOptionPane.showMessageDialog(null,"従業員IDはTHで始まり、その後に6桁の数字でなければなりません。");
                            return;
                        }
                        String dateFormat="\\d{4}-\\d{2}-\\d{2}";
                        if (!dob.matches(dateFormat)) {
                            JOptionPane.showMessageDialog(null, "生年月日はyyyy-MM-ddの形式で入力してください");
                            return;
                        }
                        // Kiểm tra xem JTextField có giá trị hay không
                        if (employeeId.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "従業員IDを入力してください。");
                            return;
                        }
                        if (!role_id.equals("1") && !role_id.equals("2")) {
                            JOptionPane.showMessageDialog(null, "役割は1、2のいずれかである必要があります。");
                            return;
                        }


                        sql="UPDATE employees SET employee_id = ?, name = ?, gender = ?, dob = ?, address = ?, email = ?, phone = ?, position = ?, role_id = ? WHERE employee_id = ? OR name = ? OR email = ? OR phone = ?";
                        PreparedStatement preparedStatement=dbConnection.connection.prepareStatement(sql);
                        preparedStatement.setString(1,employeeId);
                        preparedStatement.setString(2, name);
                        preparedStatement.setString(3, gender);
                        preparedStatement.setString(4, dob);
                        preparedStatement.setString(5, address);
                        preparedStatement.setString(6, email);
                        preparedStatement.setString(7, phone);
                        preparedStatement.setString(8, position);
                        preparedStatement.setString(9, role_id);
                        preparedStatement.setString(10,searchTemp);
                        preparedStatement.setString(11, searchTemp); // Đặt giá trị từ jtxInfor vào tham số thứ 10
                        preparedStatement.setString(12, searchTemp); // Đặt giá trị từ jtxInfor vào tham số thứ 11
                        preparedStatement.setString(13, searchTemp); // Đặt giá trị từ jtxInfor vào tham số thứ 12

                        int rowsInserted=preparedStatement.executeUpdate();
                        System.out.println("Update");
                        System.out.println("Đây là dữ liệu JTextField" + searchTemp);
                        boolean result=preparedStatement.execute();
                        System.out.println("Đây là dữ liệu result" + result);
                        System.out.println(name + gender + dob + address + email + phone + position + role_id + employeeId);
                        // Kiểm tra kết quả và hiển thị thông báo
                        if (rowsInserted > 0) {
                            JOptionPane.showMessageDialog(null, "従業員の情報を更新しました");
                            updateFrame.setVisible(false);
                            updateFrame.dispose();
                            searchFrame.setVisible(false);
                            searchFrame.dispose();
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
        });
    }

    public void resetJTextField() {
        jtxAAddress.setText(""); // Đặt lại JTextField của địa chỉ
        jtxAEmail.setText(""); // Đặt lại JTextField của email
        jtxAGender.setText(""); // Đặt lại JTextField của giới tính
        jtxAName.setText(""); // Đặt lại JTextField của tên
        jtxAPhone.setText(""); // Đặt lại JTextField của số điện thoại
        jtxAPos.setText(""); // Đặt lại JTextField của vị trí
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