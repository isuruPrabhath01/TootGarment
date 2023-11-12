package lk.ijse.tootGarment.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tootGarment.model.Attendance_staffModel;
import lk.ijse.tootGarment.model.StaffModel;
import lk.ijse.tootGarment.to.Attendance_staff;
import lk.ijse.tootGarment.to.Staff;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AttendanceStaffViewPageFormController implements Initializable {
    public AnchorPane ViewAttendancePage;
    public TableView tblViewAttend;
    public TableColumn tblStaffId;
    public TableColumn tblName;
    public TableColumn tblDate;
    public TableColumn tblTime;
    public TableColumn tblAttendsStutes;
    public static ArrayList<Attendance_staff> attendsView= new ArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblStaffId.setCellValueFactory(new PropertyValueFactory<>("staff_id"));
        tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tblTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        tblAttendsStutes.setCellValueFactory(new PropertyValueFactory<>("absent_present"));
    }

    public void searchOnAction(ActionEvent actionEvent) {
        ObservableList<Attendance_staff> staffViewOb = FXCollections.observableArrayList();
        try {
            attendsView= Attendance_staffModel.View();
            for (Attendance_staff attendance_staff:attendsView) {
                staffViewOb.add(attendance_staff);
            }
            tblViewAttend.setItems(staffViewOb);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void StaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFADDPAGE, ViewAttendancePage);
    }

    public void UserAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERADDPAGE, ViewAttendancePage);
    }
    public void AttendanceStaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ATTENDANCESTAFFADDPAGE, ViewAttendancePage);
    }

    public void LogOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMINLOGOUTPAGE, ViewAttendancePage);
    }

    public void MarkAttendancePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ATTENDANCESTAFFADDPAGE, ViewAttendancePage);
    }

    public void ViewAttendancePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ATTENDANCEVIEWPAGE, ViewAttendancePage);
    }
}
