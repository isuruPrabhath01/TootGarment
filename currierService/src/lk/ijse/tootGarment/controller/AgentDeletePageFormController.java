package lk.ijse.tootGarment.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tootGarment.model.AgentModel;
import lk.ijse.tootGarment.to.Agent;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;
import lk.ijse.tootGarment.util.Service;

import java.io.IOException;
import java.sql.SQLException;

public class AgentDeletePageFormController {
    public AnchorPane AgentDeletePage;
    @FXML
    public TextField txtAgentNic;
    @FXML
    public TextField txtAgentName;
    @FXML
    public TextField txtAgentCompanyName;
    @FXML
    public TextField txtAgentEmail;
    @FXML
    public TextField txtAgentContactNumber;

    boolean isMatchedNic=false;

    public void AgentDeleteSearchOnAction(ActionEvent actionEvent) {
        if(!isMatchedNic){
        }else{
            String agentNic =txtAgentNic.getText();
            try {
                Agent agent= AgentModel.search(agentNic);
                if (agent!=null){
                    txtAgentName.setText(agent.getName());
                    txtAgentCompanyName.setText(agent.getCompany_name());
                    txtAgentEmail.setText(agent.getEmail());
                    txtAgentContactNumber.setText(agent.getContacNo());
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void txtAgentNicOnAction(KeyEvent keyEvent) {
        if(Service.isValidNic(txtAgentNic.getText())){
            txtAgentNic.setStyle("-fx-border-color: green");
            isMatchedNic=true;
        }else{
            txtAgentNic.setStyle("-fx-border-color: red");
            isMatchedNic=false;
        }
    }

    public void AgentDeleteOnAction(ActionEvent actionEvent) {

        String agentNic=txtAgentNic.getText();
        try {
            boolean isDeleted=AgentModel.delete(agentNic);
            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION, "Agent Deleted!").show();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        clearAll();
    }

    public void ClearSearchOnAction (ActionEvent actionEvent) {
        clearAll();
    }
    public void clearAll(){
         txtAgentNic.setText(null);
         txtAgentName.setText(null);
         txtAgentCompanyName.setText(null);
         txtAgentEmail.setText(null);
         txtAgentContactNumber.setText(null);
    }
    public void txtAgentNameOnAction(KeyEvent keyEvent) {
    }

    public void txtAgentCompanyNameOnAction(KeyEvent keyEvent) {
    }

    public void txtAgentEmailOnAction(KeyEvent keyEvent) {
    }

    public void txtAgentContactNumberOnAction(KeyEvent keyEvent) {
    }

    public void AgentAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTADDPAGE, AgentDeletePage);
    }

    public void AgentUpdatePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTUPDATEPAGE,AgentDeletePage);
    }

    public void AgentDeletePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTDELETEPAGE,AgentDeletePage);
    }

    public void AgentViewPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTVIEWPAGE,AgentDeletePage);
    }

    public void AgentMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTMAINPAGE,AgentDeletePage);
    }

    public void OrderPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERPLACEPAGE,AgentDeletePage);
    }

    public void StockMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKMAINPAGE,AgentDeletePage);
    }

    public void PaymentPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENTPLACEPAGE,AgentDeletePage);
    }

    public void LogOutPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGOUTPAGE,AgentDeletePage);
    }
}
