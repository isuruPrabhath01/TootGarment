package lk.ijse.tootGarment.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.tootGarment.model.AgentModel;
import lk.ijse.tootGarment.to.Agent;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;
import lk.ijse.tootGarment.util.Service;


import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class AgentAddPageFormController {

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


    public AnchorPane AddAgentPage;



    boolean isMatchNic=false;
    boolean isMatchName=false;
    boolean isMatchCompanyName=false;
    boolean isMatchEmail=false;
    boolean isMatchContactNumber=false;


    public void AgentAddToDatabaseOnAction(ActionEvent actionEvent) {

        if (!isMatchNic | !isMatchName | !isMatchCompanyName | !isMatchEmail | !isMatchContactNumber){
            new Alert(Alert.AlertType.CONFIRMATION,"Input Data Not Valid!").show();
        }else{
            String nic=txtAgentNic.getText();
            String name=txtAgentName.getText();
            String CompanyName=txtAgentCompanyName.getText();
            String email=txtAgentEmail.getText();
            String contactNumber=txtAgentContactNumber.getText();

            Agent agent= new Agent(nic,name,CompanyName,email,contactNumber);
            boolean isAdded=false;

            try {
                isAdded= AgentModel.add(agent);
                if(isAdded){
                    new Alert(Alert.AlertType.CONFIRMATION, "Agent Added!").show();
                    clearAll();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }


    private void clearAll() {
        txtAgentNic.setText(null);
        txtAgentName.setText(null);
        txtAgentCompanyName.setText(null);
        txtAgentEmail.setText(null);
        txtAgentContactNumber.setText(null);
    }

    public void ClearAllDataOnAction(ActionEvent actionEvent) {
        clearAll();
    }


    public void txtAgentNicOnAction(KeyEvent keyEvent) {
        if (Service.isValidNic(txtAgentNic.getText())){
            txtAgentNic.setStyle("-fx-border-color: green;");
            isMatchNic=true;
        }else{
            txtAgentNic.setStyle("-fx-border-color: red;");
            isMatchNic=false;
        }
    }

    public void txtAgentNameOnAction(KeyEvent keyEvent) {
        if (Service.isValidName(txtAgentName.getText())){
            txtAgentName.setStyle("-fx-border-color: green;");
            isMatchName=true;
        }else{
            txtAgentName.setStyle("-fx-border-color: red;");
            isMatchName=false;
        }
    }

    public void txtAgentCompanyNameOnAction(KeyEvent keyEvent) {
        if (Service.isValidName(txtAgentCompanyName.getText())){
            txtAgentCompanyName.setStyle("-fx-border-color: green;");
            isMatchCompanyName=true;
        }else{
            txtAgentCompanyName.setStyle("-fx-border-color: red;");
            isMatchCompanyName=false;
        }
    }

    public void txtAgentEmailOnAction(KeyEvent keyEvent) {
        if (Service.isValidEmail(txtAgentEmail.getText())){
            txtAgentEmail.setStyle("-fx-border-color: green;");
            isMatchEmail=true;
        }else{
            txtAgentEmail.setStyle("-fx-border-color: red;");
            isMatchEmail=false;
        }
    }

    public void txtAgentContactNumberOnAction(KeyEvent keyEvent) {
        if (Service.isValidTelephoneNumber(txtAgentContactNumber.getText())){
            txtAgentContactNumber.setStyle("-fx-border-color: green;");
            isMatchContactNumber=true;
        }else{
            txtAgentContactNumber.setStyle("-fx-border-color: red;");
            isMatchContactNumber=false;
        }
    }

    public void AgentAddPageOnAction(ActionEvent actionEvent) throws IOException {
            Navigation.navigate(Routes.AGENTADDPAGE,AddAgentPage);
    }

    public void AgentUpdatePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTUPDATEPAGE,AddAgentPage);
    }

    public void AgentDeletePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTDELETEPAGE,AddAgentPage);
    }

    public void AgentViewPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTVIEWPAGE,AddAgentPage);
    }

    public void AgentMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTMAINPAGE,AddAgentPage);
    }

    public void OrderPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERPLACEPAGE,AddAgentPage);
    }

    public void StockMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKMAINPAGE,AddAgentPage);
    }

    public void PaymentPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENTPLACEPAGE,AddAgentPage);
    }

    public void LogOutPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGOUTPAGE,AddAgentPage);
    }
}
