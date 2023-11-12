package lk.ijse.tootGarment.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tootGarment.model.StaffModel;
import lk.ijse.tootGarment.to.Staff;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;
import lk.ijse.tootGarment.util.Service;

import java.io.IOException;
import java.sql.SQLException;

public class StaffDeletePageFormController {
    public AnchorPane DeleteStaffPage;
    public TextField txtStaffId;
    public TextField txtStaffName;
    public TextField txtStaffAddress;
    public TextField txtStaffDOB;
    public TextField txtStaffContactNumber;
    public TextField txtStaffNic;
    public TextField txtStaffSalary;
    boolean isMatchStaffId=false;

    public void txtStaffId(KeyEvent keyEvent) {
        if(Service.isValidStaffId(txtStaffId.getText())){
            txtStaffId.setStyle("-fx-border-color: green;");
            isMatchStaffId=true;
        }else{
            txtStaffId.setStyle("-fx-border-color: red;");
            isMatchStaffId=false;
        }
    }

    public void SearchOnAction(ActionEvent actionEvent) {
        if (!isMatchStaffId){
        }else{
            String id = txtStaffId.getText();
            try{
                Staff staff = StaffModel.search(id);
                if(staff!=null){
                    txtStaffName.setText(staff.getName());
                    txtStaffAddress.setText(staff.getAddress());
                    txtStaffDOB.setText(staff.getDob());
                    txtStaffNic.setText(staff.getNic());
                    txtStaffContactNumber.setText(staff.getContacNo());
                    txtStaffSalary.setText(String.valueOf(staff.getSalary()));
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        boolean isDeleted=false;
        String id=txtStaffId.getText();
        try {
            isDeleted=StaffModel.delete(id);
            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION, "Staff DELETED!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        clearAll();
    }

    public void ClearOnAction(ActionEvent actionEvent) {
        clearAll();
    }
    public  void clearAll(){
        txtStaffId.setText(null);
        txtStaffName.setText(null);
        txtStaffAddress.setText(null);
        txtStaffDOB.setText(null);
        txtStaffContactNumber.setText(null);
        txtStaffNic.setText(null);
        txtStaffSalary.setText(null);
    }
    public void StaffAddPage2OnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFADDPAGE, DeleteStaffPage);
    }

    public void StaffUpdatePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFUPDATEPAGE, DeleteStaffPage);
    }

    public void StaffDeletePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFDELETEPAGE, DeleteStaffPage);
    }
    public void StaffViewPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFVIEWPAGE, DeleteStaffPage);
    }

    public void StaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFADDPAGE, DeleteStaffPage);
    }

    public void UserAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERADDPAGE, DeleteStaffPage);
    }

    public void AttendanceStaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ATTENDANCESTAFFADDPAGE, DeleteStaffPage);
    }

    public void LogOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMINLOGOUTPAGE, DeleteStaffPage);
    }
}
