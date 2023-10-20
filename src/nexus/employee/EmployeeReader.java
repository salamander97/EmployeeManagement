
//Search employee

package nexus.employee;
import nexus.employee.userUI.AdminUI;
import nexus.employee.userUI.EmployeeUI;
public class EmployeeReader {
    AdminUI adminUI;
    EmployeeUI employeeUI;
    public EmployeeReader() {
        //
        adminUI = new AdminUI();            //AdminUI
        employeeUI = new EmployeeUI();      //EmployeeUI
    }
    void showAdminUI() {                    //showAdminUI
        adminUI.setVisible(true);
        employeeUI.setVisible(false);
    }

    void showEmployeeUI() {                 //showEmployeeUI
        employeeUI.setVisible(true);
        adminUI.setVisible(false);
    }

    public static void main(String[] args) {
        EmployeeReader employeeReader = new EmployeeReader();   //EmployeeReader
        employeeReader.showAdminUI();                           //showAdminUI
        employeeReader.showEmployeeUI();                        //showEmployeeUI
    }
}
