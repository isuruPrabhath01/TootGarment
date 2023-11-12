package lk.ijse.tootGarment.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tootGarment.model.AgentModel;
import lk.ijse.tootGarment.model.StaffModel;
import lk.ijse.tootGarment.to.Agent;
import lk.ijse.tootGarment.to.Staff;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StaffViewPageFormController implements Initializable {
    public AnchorPane StaffViewPage;
    public TableView<Staff> tblStaffView;
    public TableColumn tblStaffId;
    public TableColumn tblStaffName;
    public TableColumn tblStaffAddress;
    public TableColumn tblStaffDOB;
    public TableColumn tblStaffNic;
    public TableColumn tblStaffContactNumber;
    public TableColumn tblStaffSalary;

    public static ArrayList<Staff> staffView= new ArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblStaffId.setCellValueFactory(new PropertyValueFactory<>("staff_id"));
        tblStaffName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStaffAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tblStaffDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        tblStaffNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblStaffContactNumber.setCellValueFactory(new PropertyValueFactory<>("contacNo"));
        tblStaffSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
    }

    public void ViewLoadOnAction(ActionEvent actionEvent) {
        ObservableList<Staff> staffViewOb = FXCollections.observableArrayList();
        try {
            staffView= StaffModel.View();
            for (Staff staff:staffView) {
                staffViewOb.add(staff);
            }
            tblStaffView.setItems(staffViewOb);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void StaffAddPage2OnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFADDPAGE, StaffViewPage);
    }

    public void StaffUpdatePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFUPDATEPAGE, StaffViewPage);
    }
    public void StaffDeletePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFDELETEPAGE, StaffViewPage);
    }

    public void StaffViewPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFVIEWPAGE, StaffViewPage);
    }

    public void StaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STAFFADDPAGE, StaffViewPage);
    }

    public void UserAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USERADDPAGE, StaffViewPage);
    }

    public void AttendanceStaffAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ATTENDANCESTAFFADDPAGE, StaffViewPage);
    }

    public void LogOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ADMINLOGOUTPAGE, StaffViewPage);
    }
}
