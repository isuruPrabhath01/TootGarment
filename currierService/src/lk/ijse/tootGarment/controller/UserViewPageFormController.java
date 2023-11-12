package lk.ijse.tootGarment.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

public class UserViewPageFormController implements Initializable {
    public AnchorPane UserViewPage;
    public TableView tblUserView;
    public TableColumn tblViewStaffId;
    public TableColumn tblViewUserName;
    public static ArrayList<User> userView= new ArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblViewStaffId.setCellValueFactory(new PropertyValueFactory<>("staff_id"));
        tblViewUserName.setCellValueFactory(new PropertyValueFactory<>("user_name"));
    }

    public void LoadOnAction(ActionEvent actionEvent) {
        ObservableList<User> userViewOb = FXCollections.observableArrayList();
        try {
            userView= UserModel.View();
            for (User user:userView) {
                userViewOb.add(user);
            }
            tblUserView.setItems(userViewOb);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void StaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFADDPAGE, UserViewPage);
    }

    public void UserAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERADDPAGE, UserViewPage);
    }
    public void AttendanceStaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ATTENDANCESTAFFADDPAGE, UserViewPage);
    }

    public void LogOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMINLOGOUTPAGE, UserViewPage);
    }

    public void UserAddPage2OnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERADDPAGE, UserViewPage);
    }

    public void ChangePasswordPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERUPDATEPAGE, UserViewPage);
    }

    public void DeleteUserPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERDELETEPAGE, UserViewPage);
    }

    public void UserListPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERVIEWPAGE, UserViewPage);
    }
}
