package lk.ijse.tootGarment.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage)Navigation.pane.getScene().getWindow();

        switch (route) {

            case WELCOME:
                window.setTitle("Welcome");
                window.setResizable(false);
                initUI("WelcomePageForm.fxml");
                break;
            case LOGIN:
                window.setTitle("Login");
                window.setResizable(false);
                initUI("LoginPageForm.fxml");
                break;
            case DASHBOARD:
                window.setTitle("Dashboard");
                window.setResizable(false);
                initUI("DashbordPageForm.fxml");
                break;
            case AGENTMAINPAGE:
                window.setTitle("Agent Main Page");
                window.setResizable(false);
                initUI("AgentMainPageForm.fxml");
                break;
            case ORDERPLACEPAGE:
                window.setTitle("Order Place Page");
                window.setResizable(false);
                initUI("OrderPlacePageForm.fxml");
                break;
            case STOCKMAINPAGE:
                window.setTitle("Stock Main Page");
                window.setResizable(false);
                initUI("StockMainPageForm.fxml");
                break;
            case PAYMENTPLACEPAGE:
                window.setTitle("Payment Place Page");
                window.setResizable(false);
                initUI("PaymentPlacePageForm.fxml");
                break;
            case LOGOUTPAGE:
                window.setTitle("Logout Page");
                window.setResizable(false);
                initUI("LogOutPageForm.fxml");
                break;
            case AGENTADDPAGE:
                window.setTitle("Agent Add Page");
                window.setResizable(false);
                initUI("AgentAddPageForm.fxml");
                break;
            case AGENTUPDATEPAGE:
                window.setTitle("Agent Update Page");
                window.setResizable(false);
                initUI("AgentUpdatePageForm.fxml");
                break;
            case AGENTDELETEPAGE:
                window.setTitle("Agent Delete Page");
                window.setResizable(false);
                initUI("AgentDeletePageForm.fxml");
                break;
            case AGENTVIEWPAGE:
                window.setTitle("Agent View Page");
                window.setResizable(false);
                initUI("AgentViewPageForm.fxml");
                break;
            case ORDERPLACE:
                window.setTitle("Place Order Page");
                window.setResizable(false);
                initUI("OrderPlacePageForm.fxml");
                break;
            case ORDERTERMINATED:
                window.setTitle("Terminated Order Page");
                window.setResizable(false);
                initUI("OrderFinishPageForm.fxml");
                break;
            case ORDERMANAGE:
                window.setTitle("View Order Page");
                window.setResizable(false);
                initUI("OrderViewPageForm.fxml");
                break;
            case STOCKADDPAGE:
                window.setTitle("Add Stock Page");
                window.setResizable(false);
                initUI("StockAddPageForm.fxml");
                break;
            case STOCKUPDATEPAGE:
                window.setTitle("Update Stock Page");
                window.setResizable(false);
                initUI("StockUpdatePageForm.fxml");
                break;
            case STOCKDELETEPAGE:
                window.setTitle("Delete Stock Page");
                window.setResizable(false);
                initUI("StockClearPageForm.fxml");
                break;
            case STOCKVIEWPAGE:
                window.setTitle("View Stock Page");
                window.setResizable(false);
                initUI("StockViewPageForm.fxml");
                break;
            case  PAYMENTMANAGEPAGE:
                window.setTitle("Manage Payment Page");
                window.setResizable(false);
                initUI("PaymentManagePageForm.fxml");
                break;
            case  ADMINLOGINPAGEDIRECTION:
                window.setTitle("Admin LogIn Page Direction");
                window.setResizable(false);
                initUI("AdminLoginDirectionPageForm.fxml");
                break;
            case  ADMINDASHBOARD:
                window.setTitle("Admin Dashboard");
                window.setResizable(false);
                initUI("AdminDashbordPageForm.fxml");
                break;
            case  STAFFADDPAGE:
                window.setTitle("Staff Add Page");
                window.setResizable(false);
                initUI("StaffAddPageForm.fxml");
                break;
            case  USERADDPAGE:
                window.setTitle("Add User Page");
                window.setResizable(false);
                initUI("UserAddPageForm.fxml");
                break;
            case  ATTENDANCESTAFFADDPAGE:
                window.setTitle("Attendance Mark Page");
                window.setResizable(false);
                initUI("AttendanceStaffAddPageForm.fxml");
                break;
            case  STAFFUPDATEPAGE:
                window.setTitle("Update Staff Page");
                window.setResizable(false);
                initUI("StaffUpdatePageForm.fxml");
                break;
            case  STAFFDELETEPAGE:
                window.setTitle("Update Staff Page");
                window.setResizable(false);
                initUI("StaffDeletePageForm.fxml");
                break;
            case  STAFFVIEWPAGE:
                window.setTitle("View Staff Page");
                window.setResizable(false);
                initUI("StaffViewPageForm.fxml");
                break;
            case  USERUPDATEPAGE:
                window.setTitle("Change Password Page");
                window.setResizable(false);
                initUI("UserUpdatePageForm.fxml");
                break;
            case  USERDELETEPAGE:
                window.setTitle("Delete User Page");
                window.setResizable(false);
                initUI("UserDeletePageForm.fxml");
                break;
            case  USERVIEWPAGE:
                window.setTitle("View User Page");
                window.setResizable(false);
                initUI("UserViewPageForm.fxml");
                break;
            case  ATTENDANCEVIEWPAGE:
                window.setTitle("View Attendance Page");
                window.setResizable(false);
                initUI("AttendanceStaffViewPageForm.fxml");
                break;
            case  ADMINLOGOUTPAGE:
                window.setTitle("Admin LogOut Page");
                window.setResizable(false);
                initUI("LogOutAdminPageForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
    public static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/tootGarment/view/" + location)));
    }
}
