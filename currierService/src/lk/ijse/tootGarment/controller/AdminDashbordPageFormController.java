package lk.ijse.tootGarment.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;

import java.io.IOException;

public class AdminDashbordPageFormController {
    public AnchorPane AdminDashbordPage;
    public void StaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFADDPAGE, AdminDashbordPage);
    }

    public void UserAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERADDPAGE, AdminDashbordPage);
    }

    public void AttendanceStaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ATTENDANCESTAFFADDPAGE, AdminDashbordPage);
    }

    public void LogOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMINLOGOUTPAGE, AdminDashbordPage);
    }
}
