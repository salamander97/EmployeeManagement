package nexus.employee.Department;

import nexus.employee.DataBase.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Vector;

public class DepartmentMain {
    private JFrame frame;
    private JComboBox<String> departmentComboBox;
    private JTable employeeTable;
    private DefaultTableModel tableModel;

    public DepartmentMain() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Employee Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocation(300, 200);
        ImageIcon i=new ImageIcon("src/nexus/employee/images/mainController.png");
        JLabel jlbImage=new JLabel();
        jlbImage.setBounds(0, 0, 900, 600);
//        jlbImage.setLayout(null);
        jlbImage.setIcon(i);
        frame.add(jlbImage);
        // Tạo combobox để chọn phòng ban


        departmentComboBox = new JComboBox<>();
        departmentComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Software Development", "Testing", "Project Management", "UI/UX Design", "Marketing"}));
        departmentComboBox.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        departmentComboBox.setBounds(0, 30, 270, 150);
        departmentComboBox.revalidate();
        departmentComboBox.repaint();

        departmentComboBox.setForeground(Color.BLACK);
        departmentComboBox.setBackground(Color.LIGHT_GRAY);
        jlbImage.add(departmentComboBox);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(340, 150, 120, 40);
        searchButton.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        searchButton.setForeground(Color.BLACK);
        searchButton.setBackground(Color.LIGHT_GRAY);
        jlbImage.add(searchButton);

        JButton editButton = new JButton("Edit");
        editButton.setBounds(300, 420, 120, 40);
        editButton.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        editButton.setForeground(Color.BLACK);
        editButton.setBackground(Color.LIGHT_GRAY);
        jlbImage.add(editButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(490, 420, 120, 40);
        deleteButton.setFont(new Font("Times_New_Roman", Font.BOLD, 18));
        deleteButton.setForeground(Color.BLACK);
        deleteButton.setBackground(Color.LIGHT_GRAY);
        jlbImage.add(deleteButton);

        // Tạo bảng để hiển thị thông tin nhân viên
        tableModel = new DefaultTableModel();
        employeeTable = new JTable(tableModel){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        employeeTable.setModel(tableModel);
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Tạo các cột cho bảng
        tableModel.addColumn("Name");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Date of Birth");
        tableModel.addColumn("Address");
        tableModel.addColumn("Email");
        tableModel.addColumn("Phone");
        tableModel.addColumn("Position");

        searchButton.addActionListener(e -> {
            String selectedDepartment = Objects.requireNonNull(departmentComboBox.getSelectedItem()).toString();
            displayEmployeesByDepartment(selectedDepartment);
        });

        editButton.addActionListener(e -> {
            int selectedRow = employeeTable.getSelectedRow();
            if (selectedRow >= 0) {
                openEditDialog(selectedRow);
            } else {
                JOptionPane.showMessageDialog(frame, "No row selected. Please select a row to edit.");
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedRow = employeeTable.getSelectedRow();
            if (selectedRow >= 0) {
                deleteEmployee(selectedRow);
            } else {
                JOptionPane.showMessageDialog(frame, "No row selected. Please select a row to delete.");
            }
        });
    }
//    private void showEmployeeInformationTable() {
//        // Create a new JFrame to display the employee information table
//        JFrame employeeInfoFrame = new JFrame("Employee Information Table");
//        employeeInfoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        employeeInfoFrame.setBounds(100, 100, 800, 400);
//
//        // Create a JTable to display employee information
//        JTable employeeTable = new JTable(tableModel);
//        JScrollPane scrollPane = new JScrollPane(employeeTable);
//        employeeInfoFrame.add(scrollPane, BorderLayout.CENTER);
//
//        // Populate the JTable with employee data based on the selected department
//        String selectedDepartment = Objects.requireNonNull(departmentComboBox.getSelectedItem()).toString();
//        displayEmployeesByDepartment(selectedDepartment);
//
//        // Show the frame with the employee information table
//        employeeInfoFrame.setVisible(true);
//    }

    private void openEditDialog(int selectedRow) {
        // Lấy thông tin từ dòng được chọn
        String name = (String) tableModel.getValueAt(selectedRow, 0);
        String gender = (String) tableModel.getValueAt(selectedRow, 1);
        Date dob = (Date) tableModel.getValueAt(selectedRow, 2);
        String address = (String) tableModel.getValueAt(selectedRow, 3);
        String email = (String) tableModel.getValueAt(selectedRow, 4);
        String phone = (String) tableModel.getValueAt(selectedRow, 5);
        String position = (String) tableModel.getValueAt(selectedRow, 6);

        // Tạo cửa sổ dialog
        JDialog editDialog = new JDialog(frame, "Edit Employee");
        editDialog.setSize(400, 300);
        editDialog.setLayout(new GridLayout(9, 2));

        // Tạo các trường nhập liệu cho cửa sổ chỉnh sửa
        JTextField nameField = createTextField(name, false);
        JTextField genderField = createTextField(gender, true);
        JTextField dobField = createTextField(new SimpleDateFormat("yyyy-MM-dd").format(dob), true);
        JTextField addressField = createTextField(address, true);
        JTextField emailField = createTextField(email, true);
        JTextField phoneField = createTextField(phone, true);
        JTextField positionField = createTextField(position, true);

        // Thêm các trường nhập liệu vào cửa sổ dialog
        editDialog.add(new JLabel("Name:"));
        editDialog.add(nameField);
        editDialog.add(new JLabel("Gender:"));
        editDialog.add(genderField);
        editDialog.add(new JLabel("Date of Birth (yyyy-MM-dd):"));
        editDialog.add(dobField);
        editDialog.add(new JLabel("Address:"));
        editDialog.add(addressField);
        editDialog.add(new JLabel("Email:"));
        editDialog.add(emailField);
        editDialog.add(new JLabel("Phone:"));
        editDialog.add(phoneField);
        editDialog.add(new JLabel("Position:"));
        editDialog.add(positionField);

        // Tạo nút "Save" để lưu thông tin chỉnh sửa
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            String newName = nameField.getText();
            String newGender = genderField.getText();
            String newDob = dobField.getText();
            String newAddress = addressField.getText();
            String newEmail = emailField.getText();
            String newPhone = phoneField.getText();
            String newPosition = positionField.getText();

//            updateEmployeeInDatabase(selectedRow, newName, newGender, newDob, newAddress, newEmail, newPhone, newPosition);
            updateEmployeeInDatabase(selectedRow, newName, newGender, newDob, newAddress, newEmail, newPhone, newPosition);
            editDialog.dispose();
        });

        // Thêm nút "Save" vào cửa sổ dialog
        editDialog.add(saveButton);

        // Hiển thị cửa sổ chỉnh sửa
        editDialog.setVisible(true);
    }

    private JTextField createTextField(String text, boolean editable) {
        JTextField textField = new JTextField(text);
        textField.setEditable(editable);
        return textField;
    }

    private void updateEmployeeInDatabase(int selectedRow, String name, String gender, String dob, String address, String email, String phone, String position) {
        // Sử dụng DBConnection để truy vấn cơ sở dữ liệu
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.connection;
        if (connection != null) {
            try {
                String query = "UPDATE Employees SET name = ?, gender = ?, dob = ?, address = ?, email = ?, phone = ?, position = ? WHERE name = ?";
                PreparedStatement statement = connection.prepareStatement(query);

                statement.setString(1, name);
                statement.setString(2, gender);
                statement.setString(3, dob);
                statement.setString(4, address);
                statement.setString(5, email);
                statement.setString(6, phone);
                statement.setString(7, position);
                statement.setString(8, name);

                statement.executeUpdate();
                statement.close();

                // Cập nhật dữ liệu trong bảng
                tableModel.setValueAt(name, selectedRow, 0);
                tableModel.setValueAt(gender, selectedRow, 1);
                tableModel.setValueAt(dob, selectedRow, 2);
                tableModel.setValueAt(address, selectedRow, 3);
                tableModel.setValueAt(email, selectedRow, 4);
                tableModel.setValueAt(phone, selectedRow, 5);
                tableModel.setValueAt(position, selectedRow, 6);

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                dbConnection.closeConnection();
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Failed to connect to the database.");
        }
    }

    private void displayEmployeesByDepartment(String department) {
        // Sử dụng DBConnection để truy vấn cơ sở dữ liệu
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.connection;
        if (connection != null) {
            try {

                String query = "SELECT * FROM employees WHERE departments = ?";
                PreparedStatement statement = connection.prepareStatement(query);

                int departmentID = getDepartmentIDByName(department, connection);

                statement.setInt(1, departmentID);

                ResultSet resultSet = statement.executeQuery();

                tableModel.setRowCount(0);
//                tableModel.addRow(rowData);

                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String gender = resultSet.getString("gender");
                    Date dob = resultSet.getDate("dob");
                    String address = resultSet.getString("address");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    String position = resultSet.getString("position");

                    Vector<Object> row = new Vector<>();
                    row.add(name);
                    row.add(gender);
                    row.add(dob);
                    row.add(address);
                    row.add(email);
                    row.add(phone);
                    row.add(position);
                    tableModel.addRow(row);
                }

                resultSet.close();
                statement.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                dbConnection.closeConnection();
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Failed to connect to the database.");
        }
    }

    private int getDepartmentIDByName(String departmentName, Connection connection) {
        int departmentID = -1;
        try {
//            String query = "SELECT DepartmentID FROM Departments WHERE DepartmentName = ?";
            String query = "SELECT DepartmentID FROM Departments WHERE DepartmentName = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, departmentName);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                departmentID = resultSet.getInt("DepartmentID");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentID;
    }

    private void deleteEmployee(int selectedRow) {
        String name = (String) tableModel.getValueAt(selectedRow, 0);
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.connection;
        if (connection != null) {
            try {
                String query = "DELETE FROM employees WHERE name = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, name);
                statement.executeUpdate();
                statement.close();
                System.out.println("Deleted employee " + name);

                tableModel.removeRow(selectedRow); // Xóa dòng trong bảng

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                dbConnection.closeConnection();
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Failed to connect to the database.");
        }
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                DepartmentMain window = new DepartmentMain();
                window.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
