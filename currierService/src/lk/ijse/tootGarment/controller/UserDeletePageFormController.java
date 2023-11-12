package lk.ijse.tootGarment.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tootGarment.model.UserModel;
import lk.ijse.tootGarment.to.User;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserDeletePageFormController implements Initializable {
    public AnchorPane DeleteUserPage;
    public String staffId;
    public String userName;
    public String password;
    public static ArrayList<User> userView= new ArrayList();
    public PasswordField txtPassword;
    public JFXComboBox cmbStaffID;
    public TextField txtUserName;

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

    public void DeleteUserOnAction(ActionEvent actionEvent) {
        if(password.equals(txtPassword.getText())){
            try {
                boolean isDeleted=UserModel.delete(staffId);
                if (isDeleted){
                    new Alert(Alert.AlertType.CONFIRMATION, "User DELETED!").show();
                    clearAll();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            new Alert(Alert.AlertType.CONFIRMATION, "Password Not Match!").show();
            txtPassword.setText(null);
        }
    }
    public void clearAll(){
        txtPassword.setText(null);
        txtUserName.setText(null);
    }

    public void StaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFADDPAGE, DeleteUserPage);
    }

    public void UserAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERADDPAGE, DeleteUserPage);
    }

    public void AttendanceStaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ATTENDANCESTAFFADDPAGE, DeleteUserPage);
    }
    public void LogOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMINLOGOUTPAGE, DeleteUserPage);
    }

    public void UserAddPage2OnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERADDPAGE, DeleteUserPage);
    }

    public void ChangePasswordPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERUPDATEPAGE, DeleteUserPage);
    }

    public void DeleteUserPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERDELETEPAGE, DeleteUserPage);
    }

    public void UserListPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERVIEWPAGE, DeleteUserPage);
    }
}
