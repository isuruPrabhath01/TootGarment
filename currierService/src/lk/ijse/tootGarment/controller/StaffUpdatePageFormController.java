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
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffUpdatePageFormController {
    public AnchorPane UpdateStaffPage;
    public TextField StaffIdSearch;
    public TextField txtOldName;
    public TextField txtOldAddress;
    public TextField txtOldDOB;
    public TextField txtOldContactName;
    public TextField txtOldNic;
    public TextField txtOldSalary;
    public TextField txtNewName;
    public TextField txtNewAddress;
    public TextField txtNewDOB;
    public TextField txtNewContactName;
    public TextField txtNewNic;
    public TextField txtNameSalary;

    boolean isMatchStaffSalary=false;
    boolean isMatchStaffNic=false;
    boolean isMatchStaffContactNumber=false;
    boolean isMatchStaffDOB=false;
    boolean isMatchStaffAddress=false;
    boolean isMatchStaffName=false;
    boolean isMatchStaffId=false;

    public void SearchOnAction(ActionEvent actionEvent) {
        if (!isMatchStaffId) {
        } else {
            String id = StaffIdSearch.getText();
            try {
                Staff staff = StaffModel.search(id);
                if(staff!=null){
                    txtOldName.setText(staff.getName());
                    txtOldAddress.setText(staff.getAddress());
                    txtOldDOB.setText(staff.getDob());
                    txtOldNic.setText(staff.getNic());
                    txtOldContactName.setText(staff.getContacNo());
                    txtOldSalary.setText(String.valueOf(staff.getSalary()));
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
        if (!isMatchStaffName|!isMatchStaffNic|!isMatchStaffContactNumber|!isMatchStaffSalary){
            new Alert(Alert.AlertType.CONFIRMATION,"Inputs Are Not Valid!").show();
        }else{
            String id=StaffIdSearch.getText();
            String name=txtNewName.getText();
            String address=txtNewAddress.getText();
            String dob=txtNewDOB.getText();
            String nic=txtNewNic.getText();
            String contactNumber=txtNewContactName.getText();
            double salary= Double.parseDouble(txtNameSalary.getText());
            Staff staff=new Staff(id,name,address,dob,nic,contactNumber,salary);
            try {
                boolean isUpdated=false;
                isUpdated = StaffModel.update(staff);
                if (isUpdated){
                    new Alert(Alert.AlertType.CONFIRMATION, "Staff Updated!").show();
                }

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        clearAll();
    }

    public void StaffIdSearchOnAction(KeyEvent keyEvent) {
        if(Service.isValidStaffId(StaffIdSearch.getText())){
            StaffIdSearch.setStyle("-fx-border-color: green;");
            isMatchStaffId=true;
        }else{
            StaffIdSearch.setStyle("-fx-border-color: red;");
            isMatchStaffId=false;
        }
    }

    public void txtNewNameOnAction(KeyEvent keyEvent) {
        if (Service.isValidName(txtNewName.getText())){
            txtNewName.setStyle("-fx-border-color: green;");
            isMatchStaffName=true;
        }else{
            txtNewName.setStyle("-fx-border-color: red;");
            isMatchStaffName=false;
        }
    }

    public void txtNewAddress(KeyEvent keyEvent) {
    }

    public void txtOldDOBOnAction(KeyEvent keyEvent) {
    }

    public void txtNewContactNameOnAction(KeyEvent keyEvent) {
        if (Service.isValidTelephoneNumber(txtNewContactName.getText())){
            txtNewContactName.setStyle("-fx-border-color: green;");
            isMatchStaffContactNumber=true;
        }else{
            txtNewContactName.setStyle("-fx-border-color: red;");
            isMatchStaffContactNumber=false;
        }
    }

    public void txtNewNicOnAction(KeyEvent keyEvent) {
        if (Service.isValidNic(txtNewNic.getText())){
            txtNewNic.setStyle("-fx-border-color: green;");
            isMatchStaffNic=true;
        }else{
            txtNewNic.setStyle("-fx-border-color: red;");
            isMatchStaffNic=false;
        }
    }

    public void txtNameSalaryOnAction(KeyEvent keyEvent) {
        if (Service.isValidPrice(txtNameSalary.getText())){
            txtNameSalary.setStyle("-fx-border-color: green;");
            isMatchStaffSalary=true;
        }else{
            txtNameSalary.setStyle("-fx-border-color: red;");
            isMatchStaffSalary=false;
        }
    }

    public void ClearOnAction(ActionEvent actionEvent) {
        clearAll();
    }
    public void clearAll(){
        StaffIdSearch.setText(null);
        txtOldName.setText(null);
        txtOldAddress.setText(null);
        txtOldDOB.setText(null);
        txtOldContactName.setText(null);
        txtOldNic.setText(null);
        txtOldSalary.setText(null);
        txtNewName.setText(null);
        txtNewAddress.setText(null);
        txtNewDOB.setText(null);
        txtNewContactName.setText(null);
        txtNewNic.setText(null);
        txtNameSalary.setText(null);
    }
    public void StaffAddPage2OnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFADDPAGE, UpdateStaffPage);
    }
    public void StaffUpdatePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFUPDATEPAGE, UpdateStaffPage);
    }

    public void StaffDeletePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFDELETEPAGE, UpdateStaffPage);
    }

    public void StaffViewPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFVIEWPAGE, UpdateStaffPage);
    }

    public void StaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFADDPAGE, UpdateStaffPage);
    }

    public void UserAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERADDPAGE, UpdateStaffPage);
    }

    public void AttendanceStaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ATTENDANCESTAFFADDPAGE, UpdateStaffPage);
    }

    public void LogOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMINLOGOUTPAGE, UpdateStaffPage);
    }
}
