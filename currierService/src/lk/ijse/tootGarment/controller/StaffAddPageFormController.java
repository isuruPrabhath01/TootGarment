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

public class StaffAddPageFormController {
    public AnchorPane AddStaffPage;
    public TextField StaffSalary;
    public TextField StaffNic;
    public TextField StaffContactNumber;
    public TextField StaffDOB;
    public TextField StaffAddress;
    public TextField StaffName;
    public TextField StaffId;


    boolean isMatchStaffSalary=false;
    boolean isMatchStaffNic=false;
    boolean isMatchStaffContactNumber=false;
    boolean isMatchStaffDOB=false;
    boolean isMatchStaffAddress=false;
    boolean isMatchStaffName=false;
    boolean isMatchStaffId=false;

    public void StaffIdOnAction(KeyEvent keyEvent) {
        if(Service.isValidStaffId(StaffId.getText())){
            StaffId.setStyle("-fx-border-color: green;");
            isMatchStaffId=true;
        }else{
            StaffId.setStyle("-fx-border-color: red;");
            isMatchStaffId=false;
        }
    }

    public void StaffNameOnAction(KeyEvent keyEvent) {
        if (Service.isValidName(StaffName.getText())){
            StaffName.setStyle("-fx-border-color: green;");
            isMatchStaffName=true;
        }else{
            StaffName.setStyle("-fx-border-color: red;");
            isMatchStaffName=false;
        }
    }

    public void StaffAddressOnAction(KeyEvent keyEvent) {
    }

    public void StaffDOBOnAction(KeyEvent keyEvent) {
    }

    public void StaffContactNumberOnAction(KeyEvent keyEvent) {
        if (Service.isValidTelephoneNumber(StaffContactNumber.getText())){
            StaffContactNumber.setStyle("-fx-border-color: green;");
            isMatchStaffContactNumber=true;
        }else{
            StaffContactNumber.setStyle("-fx-border-color: red;");
            isMatchStaffContactNumber=false;
        }
    }

    public void StaffNicOnAction(KeyEvent keyEvent) {
        if (Service.isValidNic(StaffNic.getText())){
            StaffNic.setStyle("-fx-border-color: green;");
            isMatchStaffNic=true;
        }else{
            StaffNic.setStyle("-fx-border-color: red;");
            isMatchStaffNic=false;
        }
    }

    public void StaffSalaryOnAction(KeyEvent keyEvent) {
        if (Service.isValidPrice(StaffSalary.getText())){
            StaffSalary.setStyle("-fx-border-color: green;");
            isMatchStaffSalary=true;
        }else{
            StaffSalary.setStyle("-fx-border-color: red;");
            isMatchStaffSalary=false;
        }
    }

    public void AddToDatabaseOnAction(ActionEvent actionEvent) {
        boolean isAdded=false;
        if (!isMatchStaffId|!isMatchStaffName|!isMatchStaffNic|!isMatchStaffContactNumber|!isMatchStaffSalary){
            new Alert(Alert.AlertType.CONFIRMATION,"Inputs Are Not Valid!").show();
        }else{
            String id=StaffId.getText();
            String name=StaffName.getText();
            String address=StaffAddress.getText();
            String dob=StaffDOB.getText();
            String nic=StaffNic.getText();
            String contactNumber=StaffContactNumber.getText();
            double salary= Double.parseDouble(StaffSalary.getText());
            Staff staff=new Staff(id,name,address,dob,nic,contactNumber,salary);
            try {
                isAdded= StaffModel.add(staff);
                if (isAdded){
                    new Alert(Alert.AlertType.CONFIRMATION, "Staff Added!").show();
                    clearAll();
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void ClearAllDataOnAction(ActionEvent actionEvent) {
        clearAll();
    }
    public void clearAll(){
        StaffSalary.setText(null);
        StaffNic.setText(null);
        StaffContactNumber.setText(null);
        StaffDOB.setText(null);
        StaffAddress.setText(null);
        StaffName.setText(null);
        StaffId.setText(null);

    }

    public void StaffAddPage2OnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFADDPAGE, AddStaffPage);
    }

    public void StaffUpdatePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFUPDATEPAGE, AddStaffPage);
    }

    public void StaffDeletePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFDELETEPAGE, AddStaffPage);
    }
    public void StaffViewPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFVIEWPAGE, AddStaffPage);
    }

    public void StaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFADDPAGE, AddStaffPage);
    }

    public void UserAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERADDPAGE, AddStaffPage);
    }

    public void AttendanceStaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ATTENDANCESTAFFADDPAGE, AddStaffPage);
    }

    public void LogOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMINLOGOUTPAGE, AddStaffPage);
    }
}
