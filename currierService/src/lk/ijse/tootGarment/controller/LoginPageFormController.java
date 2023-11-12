package lk.ijse.tootGarment.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;

import java.io.IOException;

public class LoginPageFormController {

    public AnchorPane LoginPage;

    public PasswordField password;
    public TextField username;

    public void LoginOnAction(ActionEvent actionEvent) throws IOException {
        if(username.getText().equals("admin") && password.getText().equals("1234")){
            Navigation.navigate(Routes.ADMINLOGINPAGEDIRECTION,LoginPage);
        }else if (username.getText().equals("user") && password.getText().equals("1234")) {
            Navigation.navigate(Routes.DASHBOARD, LoginPage);
        }else{
            new Alert(Alert.AlertType.CONFIRMATION,"Password WRONG!!").show();
            password.setText(null);
            username.setText(null);
        }
    }

    public void BlackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.WELCOME,LoginPage);
    }

    public void LoginAdminOnAction(ActionEvent actionEvent) throws IOException {
       // Navigation.navigate(Routes.ADMINLOGINPAGEDIRECTION,LoginPage);
    }
}
