//Tạo tài khoản kết nối cơ sở dữ liệu
//アカウントを作成するデータベース接続
package nexus.employee.DataBase;

import nexus.employee.userUI.AdminUI;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;

public class AccRegDB {
    private static JFrame regFrame;
    JLabel userName, passWord, roleId, ID;
    JTextField jtxName, jtxPW, jtxRoleId, jtxID;

    public AccRegDB() {
        ImageIcon img=new ImageIcon("src/nexus/employee/images/register.png");

        regFrame=new JFrame("アカウントを作成する");
        regFrame.setSize(900, 600);
        regFrame.setLocation(300, 200);
        regFrame.setLayout(null);
        regFrame.setResizable(false);
        regFrame.setVisible(true);

        JLabel jlbImgReg=new JLabel();
        jlbImgReg.setBounds(0, 0, 900, 600);
        jlbImgReg.setLayout(null);
        jlbImgReg.setIcon(img);
        regFrame.add(jlbImgReg);

        userName=new JLabel("Username：");
        userName.setBounds(580, 60, 200, 30);
        userName.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgReg.add(userName);

        jtxName=new JTextField();
        jtxName.setBounds(580, 90, 200, 30);
        jtxName.setFont(new Font("serif", Font.BOLD, 20));
        jtxName.setBackground(Color.WHITE);
        jlbImgReg.add(jtxName);

        passWord=new JLabel("Password：");
        passWord.setBounds(580, 140, 200, 30);
        passWord.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgReg.add(passWord);

        jtxPW=new JTextField();
        jtxPW.setBounds(580, 170, 200, 30);
        jtxPW.setFont(new Font("serif", Font.BOLD, 20));
        jtxPW.setBackground(Color.WHITE);
        jlbImgReg.add(jtxPW);

        ID=new JLabel("ID：");
        ID.setBounds(580, 220, 200, 30);
        ID.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgReg.add(ID);

        jtxID=new JTextField();
        jtxID.setBounds(580, 250, 200, 30);
        jtxID.setFont(new Font("serif", Font.BOLD, 20));
        jtxID.setBackground(Color.WHITE);
        jlbImgReg.add(jtxID);

        roleId=new JLabel("Position：");
        roleId.setBounds(580, 300, 200, 30);
        roleId.setFont(new Font("serif", Font.BOLD, 20));
        jlbImgReg.add(roleId);

        jtxRoleId=new JTextField();
        jtxRoleId.setBounds(580, 330, 200, 30);
        jtxRoleId.setFont(new Font("serif", Font.BOLD, 20));
        jtxRoleId.setBackground(Color.WHITE);
        jlbImgReg.add(jtxRoleId);

        JButton btnReg, btnReturn;
        btnReg=new JButton("登録");
        btnReg.setBounds(570, 400, 100, 35);
        btnReg.setFont(new Font("serif", Font.BOLD, 25));
        btnReg.setForeground(Color.BLACK);
        btnReg.setBackground(Color.YELLOW);
        jlbImgReg.add(btnReg);

        btnReturn=new JButton("戻る");
        btnReturn.setBounds(710, 400, 100, 35);
        btnReturn.setFont(new Font("serif", Font.BOLD, 25));
        jlbImgReg.add(btnReturn);

        btnReturn.addActionListener(e -> {
            regFrame.setVisible(false);
            AdminUI adminUI=new AdminUI();
            adminUI.showAdminFrame();
        });
        btnReg.addActionListener(e -> {
            try {
                String username, password, id, roleId;
                username=jtxName.getText();
                password=jtxPW.getText();
                id=jtxID.getText();
                roleId=jtxRoleId.getText();
            if(!id.matches("^[0-9]{6}")){
                JOptionPane.showMessageDialog(regFrame, "IDは6桁で入力してください。");
                return;
            }
            if(!roleId.matches("^[1-2]{1}")){
                JOptionPane.showMessageDialog(regFrame, "役職は1か2で入力してください。\n1は管理者、2は従業員です");
                return;
            }
            if(!username.matches("(?i).* \\badmin\\b.*")){
                JOptionPane.showMessageDialog(regFrame, "他のユーザー名を入力してください。");
                return;
            }
                DBConnection dbConnection=new DBConnection();
                String checkId="SELECT id FROM login WHERE id=?";
                String checkUsername="SELECT username FROM login WHERE username=?";
                PreparedStatement checkUsernameStatement=dbConnection.connection.prepareStatement(checkUsername);
                checkUsernameStatement.setString(1, username);
                PreparedStatement checkIdStatement=dbConnection.connection.prepareStatement(checkId);
                checkIdStatement.setString(1, id);
                if(checkIdStatement.executeQuery().next()){
                    JOptionPane.showMessageDialog(regFrame, "このIDは既に存在します。");
                    return;
                }
                if(checkUsernameStatement.executeQuery().next()){
                    JOptionPane.showMessageDialog(regFrame, "このユーザー名は既に存在します。");
                    return;
                }
                String sql="INSERT INTO login(id, username, password, role_id) VALUES(?,?,?,?)";
                PreparedStatement preparedStatement=dbConnection.connection.prepareStatement(sql);
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, username);
                preparedStatement.setString(3, password);
                preparedStatement.setString(4, roleId);
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(regFrame, "アカウントを作成することに成功しました！");
                System.out.println("アカウントを作成することに成功しました！");
                dbConnection.closeConnection();
                regFrame.setVisible(false);
                AdminUI adminUI=new AdminUI();
                adminUI.showAdminFrame();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        showRegFrame();
    }

    public static void showRegFrame() {
        if (regFrame != null) {
            EventQueue.invokeLater(() -> regFrame.setVisible(true));
        }
    }
}
