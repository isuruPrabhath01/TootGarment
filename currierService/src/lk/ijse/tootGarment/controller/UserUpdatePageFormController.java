package lk.ijse.tootGarment.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tootGarment.model.StaffModel;
import lk.ijse.tootGarment.model.UserModel;
import lk.ijse.tootGarment.to.Staff;
import lk.ijse.tootGarment.to.User;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserUpdatePageFormController implements Initializable {
    public static ArrayList<User> userView= new ArrayList();
    public AnchorPane ChangePasswordPage;
    public JFXComboBox cmbStaffID;
    public TextField txtUserName;
    public PasswordField txtOldPassword;
    public PasswordField txtNewPassword;
    public PasswordField txtConfimPassword;
    public String staffId;
    public String userName;
    public String password;
    public String newPassword;


    private void loadComboBox() {
        ObservableList<String> userViewOb = FXCollections.observableArrayList();
        try {
            userView= UserModel.View();
            for (User user:userView) {
                userViewOb.add(user.getStaff_id());
            }
            cmbStaffID.setItems(userViewOb);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadComboBox();
    }


    public void cmbStaffIDOnAction(ActionEvent actionEvent) {
        staffId=(String) cmbStaffID.getValue();
        System.out.println(staffId);
        try {
            User user =UserModel.search(staffId);
            userName=user.getUser_name();
            password=user.getPassword();
            txtUserName.setText(userName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String passwordChek(){
        if(password.equals(txtOldPassword.getText())){
            if((txtNewPassword.getText()).equals(txtConfimPassword.getText())){
                System.out.println("reach");
                newPassword=txtNewPassword.getText();
                return newPassword;
            }else{
                new Alert(Alert.AlertType.CONFIRMATION, "New Password Not Match!").show();
                txtNewPassword.setText(null);
                txtConfimPassword.setText(null);
                return newPassword;
            }
        }else{
            new Alert(Alert.AlertType.CONFIRMATION, "Old Password Not Match!").show();
            txtOldPassword.setText(null);
            txtNewPassword.setText(null);
            txtConfimPassword.setText(null);
            return newPassword;
        }
    }
    public void ChangePasswordOnAction(ActionEvent actionEvent) {
        newPassword=passwordChek();
        if(password.equals(txtOldPassword.getText())&&(txtNewPassword.getText()).equals(txtConfimPassword.getText())) {
            System.out.println(password);
            User user = new User(staffId, userName, newPassword);
            try {
                boolean isAdded = UserModel.update(user);
                if (isAdded) {
                    new Alert(Alert.AlertType.CONFIRMATION, "PASSWORD Changed!").show();
                    clearAll();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{ }
    }

    public void clearAll(){
     txtUserName.setText(null);
     txtOldPassword.setText(null);
     txtConfimPassword.setText(null);
     txtNewPassword.setText(null);
    }
    public void StaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFADDPAGE, ChangePasswordPage);
    }

    public void UserAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERADDPAGE, ChangePasswordPage);
    }

    public void AttendanceStaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ATTENDANCESTAFFADDPAGE, ChangePasswordPage);
    }

    public void LogOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMINLOGOUTPAGE, ChangePasswordPage);
    }

    public void UserAddPage2OnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERADDPAGE, ChangePasswordPage);
    }

    public void ChangePasswordPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERUPDATEPAGE, ChangePasswordPage);
    }

    public void DeleteUserPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERDELETEPAGE, ChangePasswordPage);
    }

    public void UserListPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERVIEWPAGE, ChangePasswordPage);
    }
}
