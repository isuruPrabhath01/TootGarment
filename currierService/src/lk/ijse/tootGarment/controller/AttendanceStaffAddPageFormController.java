package lk.ijse.tootGarment.controller;


import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tootGarment.model.Attendance_staffModel;
import lk.ijse.tootGarment.model.StaffModel;
import lk.ijse.tootGarment.to.Attendance_staff;
import lk.ijse.tootGarment.to.Staff;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;
import lk.ijse.tootGarment.util.Service;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AttendanceStaffAddPageFormController implements Initializable {
    public AnchorPane StaffAttendanceMarkPage;
    public TextField txtStaffIdOnAction;
    public TextField txtName;
    public ToggleGroup Attendance;
    public TextField txtDate;
    public TextField txtTime;
    public RadioButton rbtnPresent;
    boolean isMatchedStaffId;
    String attendanceStatus;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtDate.setText(Service.setDate());
        txtTime.setText(Service.setTime());
    }



    public void StaffIdOnAction(KeyEvent keyEvent) {
        if(Service.isValidStaffId(txtStaffIdOnAction.getText())){
            txtStaffIdOnAction.setStyle("-fx-border-color: green;");
            isMatchedStaffId=true;
        }else{
            txtStaffIdOnAction.setStyle("-fx-border-color: red;");
            isMatchedStaffId=false;
        }
    }

    public void SearchOnAction(ActionEvent actionEvent) {
        txtDate.setText(Service.setDate());
        txtTime.setText(Service.setTime());
        if (!isMatchedStaffId){
        }else{
            try {
                Staff staff= StaffModel.search(txtStaffIdOnAction.getText());
                txtName.setText(staff.getName());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void rbtnAbsentOnAction(ActionEvent actionEvent) {
        if(rbtnPresent.isSelected()){
            attendanceStatus="Present";
        }else{
            attendanceStatus="Absent";
        }
        System.out.println(attendanceStatus);
    }

    public void rbtnPresentOnAction(ActionEvent actionEvent) {
        if(rbtnPresent.isSelected()){
            attendanceStatus="Present";
        }else{
            attendanceStatus="Absent";
        }
        System.out.println(attendanceStatus);
    }


    public void AddToDatabaseOnAction(ActionEvent actionEvent) {
        txtDate.setText(Service.setDate());
        txtTime.setText(Service.setTime());
        Attendance_staff attendance_staff=new Attendance_staff(txtStaffIdOnAction.getText(),txtName.getText(),txtDate.getText(),txtTime.getText(),attendanceStatus);
        try {
            boolean isAdded= Attendance_staffModel.add(attendance_staff);
            if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION, "Attendance Added!").show();
                clearAll();
            }else{

            }
        } catch (SQLException throwables) {
            new Alert(Alert.AlertType.CONFIRMATION, "Allredy added !").show();
            clearAll();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void clearAll(){
        txtStaffIdOnAction.setText(null);
        txtName.setText(null);
    }


    public void StaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFADDPAGE, StaffAttendanceMarkPage);
    }

    public void UserAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERADDPAGE, StaffAttendanceMarkPage);
    }

    public void AttendanceStaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ATTENDANCESTAFFADDPAGE, StaffAttendanceMarkPage);
    }

    public void LogOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMINLOGOUTPAGE, StaffAttendanceMarkPage);
    }

    public void MarkAttendancePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ATTENDANCESTAFFADDPAGE,StaffAttendanceMarkPage);
    }

    public void ViewAttendancePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ATTENDANCEVIEWPAGE,StaffAttendanceMarkPage);
    }

}
