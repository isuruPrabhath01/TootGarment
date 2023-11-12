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
import lk.ijse.tootGarment.to.Agent;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AgentViewPageFormController implements Initializable {
    public AnchorPane AgentList;

    public static ArrayList<Agent> agentView= new ArrayList();
    public TableView<Agent> AgentTable;
    public TableColumn AgentTableNic;
    public TableColumn AgentTableName;
    public TableColumn AgentTableCompanyName;
    public TableColumn AgentTableEmail;
    public TableColumn AgentTableontactNumber;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AgentTableNic.setCellValueFactory(new PropertyValueFactory<>("agent_nic"));
        //AgentTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("agent_nic"));
        AgentTableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        AgentTableCompanyName.setCellValueFactory(new PropertyValueFactory<>("company_name"));
        AgentTableEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        AgentTableontactNumber.setCellValueFactory(new PropertyValueFactory<>("contacNo"));
    }

    public void AgentTableLoadOnAction(ActionEvent actionEvent) {
        agentLoadData();
    }

    private void agentLoadData() {

        try {
            ObservableList<Agent> agentViewOb = FXCollections.observableArrayList();
            agentView= AgentModel.View();
            for (Agent agent:agentView) {
                agentViewOb.add(agent);
            }
            AgentTable.setItems(agentViewOb);
        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
        }

    }


    public void AgentAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTADDPAGE, AgentList);
    }

    public void AgentUpdatePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTUPDATEPAGE, AgentList);
    }

    public void AgentDeletePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTDELETEPAGE, AgentList);
    }

    public void AgentViewPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTVIEWPAGE, AgentList);
    }

    public void AgentMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTMAINPAGE, AgentList);
    }

    public void OrderPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERPLACEPAGE, AgentList);
    }

    public void StockMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKMAINPAGE, AgentList);
    }

    public void PaymentPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENTPLACEPAGE, AgentList);
    }

    public void LogOutPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGOUTPAGE, AgentList);
    }
}

