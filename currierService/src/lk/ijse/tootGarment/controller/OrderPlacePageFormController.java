package lk.ijse.tootGarment.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tootGarment.model.AgentModel;
import lk.ijse.tootGarment.model.OrderModel;
import lk.ijse.tootGarment.to.Agent;
import lk.ijse.tootGarment.to.Order;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;
import lk.ijse.tootGarment.util.Service;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrderPlacePageFormController implements Initializable {
    public AnchorPane OrderPlacePage;
    public JFXComboBox OrderNicComboBox;
    public static ArrayList<Agent> agentView= new ArrayList();
    public TextField txtAgentName;
    public TextField txtAgentCompanyName;
    public TextField txtAgentNic;
    public TextField txtOrderDate;
    public TextField txtDeadLine;
    public TextField txtDescription;
    public TextField txtOrderId;
    String agentNic;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtOrderDate.setText(Service.setDate());
        loadComboBox();
    }

    public void loadComboBox(){
        try {
            ObservableList<String> agentViewOb = FXCollections.observableArrayList();
            agentView= AgentModel.View();
            System.out.println(agentView);
            for (Agent agent:agentView) {
               agentViewOb.add(agent.getAgent_nic());
            }
            OrderNicComboBox.setItems(agentViewOb);
        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }



    public void OrderNicComboBoxOnAction(ActionEvent actionEvent) {
        agentNic= (String) OrderNicComboBox.getValue();
        try {
            Agent agent=AgentModel.search(agentNic);
            txtAgentName.setText(agent.getName());
            txtAgentCompanyName.setText(agent.getCompany_name());
            txtAgentNic.setText(agentNic);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void AddOnAction(ActionEvent actionEvent) {
        txtOrderDate.setText(Service.setDate());
        txtAgentNic.setText(agentNic);
    }

    public void AddToDatabaseOnAction(ActionEvent actionEvent) {
        Order order =new Order(txtOrderId.getText(),txtOrderDate.getText(),txtAgentNic.getText(),txtDescription.getText(),txtDeadLine.getText(),null);
        try {
            boolean isAdded= OrderModel.add(order);
            if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION, "Order Added!").show();
            }
        } catch (SQLException throwables) {
            new Alert(Alert.AlertType.CONFIRMATION, "Check Data Agane").show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ClearAll();
    }

    public void ClearAll(){
        txtOrderId.setText(null);
        txtDescription.setText(null);
        txtAgentNic.setText(null);
        txtDeadLine.setText(null);
    }

    public void OrderPlaceOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERPLACEPAGE,OrderPlacePage);
    }

    public void OrderTerminatedOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERTERMINATED,OrderPlacePage);
    }

    public void OrderManageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERMANAGE,OrderPlacePage);
    }

    public void CantFindAgentOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTADDPAGE,OrderPlacePage);
    }

    public void AgentMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTMAINPAGE,OrderPlacePage);
    }

    public void OrderPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERPLACEPAGE,OrderPlacePage);
    }

    public void StockMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKMAINPAGE,OrderPlacePage);
    }

    public void PaymentPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENTPLACEPAGE,OrderPlacePage);
    }

    public void LogOutPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGOUTPAGE,OrderPlacePage);
    }
}