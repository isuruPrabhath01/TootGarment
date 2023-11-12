package lk.ijse.tootGarment.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;

import java.io.IOException;

public class AdminLoginDirectionPageFormController {
    public AnchorPane LoginDirection;

    public void ManageStaffAndAssestOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMINDASHBOARD, LoginDirection);
    }

    public void ManageBusinessProcessOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, LoginDirection);
    }
}
