package lk.ijse.tootGarment.controller;

import com.jfoenix.controls.JFXComboBox;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tootGarment.model.StaffModel;
import lk.ijse.tootGarment.model.UserModel;
import lk.ijse.tootGarment.to.Staff;
import lk.ijse.tootGarment.to.User;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;
import lk.ijse.tootGarment.util.Service;
import org.w3c.dom.ls.LSOutput;



import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserAddPageFormController implements Initializable {
    public AnchorPane AddUserPage;
    public JFXComboBox cmbStaffID;

    public static ArrayList<Staff> staffView= new ArrayList();
    public PasswordField txtConfimpassword;
    public PasswordField txtPassword;
    public TextField txtUserName;
    public String password;

    boolean isMatchUserName=false;
    boolean isMatchPassword=false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadComboBox();
    }

    private void loadComboBox() {
        ObservableList<String> staffViewOb = FXCollections.observableArrayList();
        try {
            staffView= StaffModel.View();
            for (Staff staff:staffView) {
                staffViewOb.add(staff.getStaff_id());
            }
            cmbStaffID.setItems(staffViewOb);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public String passwordChek(){
        if((txtPassword.getText()).equals(txtConfimpassword.getText())){
            password=txtPassword.getText();
            return password;
        }else{
            new Alert(Alert.AlertType.CONFIRMATION, "Password Not Match!").show();
            txtPassword.setText(null);
            txtConfimpassword.setText(null);
            return null;
        }
    }

    public void AddToDatabaseOnAction(ActionEvent actionEvent) {
            String password = passwordChek();
            if(password==null){
                new Alert(Alert.AlertType.CONFIRMATION, "Password Not Found!").show();
            }else {
                System.out.println("reach");
                String staffId = cmbStaffIDOnAction();
                String userName = txtUserName.getText();
                User user = new User(staffId, userName, password);
                boolean isAdded = false;
                try {
                    isAdded = UserModel.add(user);
                    if (isAdded) {
                        new Alert(Alert.AlertType.CONFIRMATION, "User Added!").show();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                clearAll();
            }
    }

    public void clearAll(){
        txtConfimpassword.setText(null);
        txtPassword.setText(null);
        txtUserName.setText(null);

    }
    public void ClearAllOnAction(ActionEvent actionEvent) {
        clearAll();
    }

    public void txtUserNameOnAction(KeyEvent keyEvent) {
    }

    public void txtPasswordOnAction(KeyEvent keyEvent) {
    }

    public String cmbStaffIDOnAction() {
        return (String) cmbStaffID.getValue();
    }

    public void StaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFADDPAGE, AddUserPage);
    }

    public void UserAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERADDPAGE, AddUserPage);
    }

    public void AttendanceStaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ATTENDANCESTAFFADDPAGE, AddUserPage);
    }

    public void LogOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMINLOGOUTPAGE, AddUserPage);
    }

    public void UserAddPage2OnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERADDPAGE,AddUserPage);
    }

    public void ChangePasswordPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERUPDATEPAGE,AddUserPage);
    }

    public void DeleteUserPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERDELETEPAGE,AddUserPage);
    }

    public void UserListPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERVIEWPAGE,AddUserPage);
    }
}
