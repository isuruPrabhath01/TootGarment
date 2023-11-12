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

public class AgentUpdatePageFormController {
    public AnchorPane AgentUpdatePage;

    @FXML
    public TextField txtAgentSearchNic;
    @FXML
    public TextField txtAgentOldName;
    @FXML
    public TextField txtOldCompanyName;
    @FXML
    public TextField txtAgentOldEmail;
    @FXML
    public TextField txtOldContactNumber;
    @FXML
    public TextField txtAgentNewName;
    @FXML
    public TextField txtNewCompanyName;
    @FXML
    public TextField txtAgentNewEmail;
    @FXML
    public TextField txtNewContactNumber;

    boolean isMatchNic=false;
    boolean isMatchName=false;
    boolean isMatchCompanyName=false;
    boolean isMatchEmail=false;
    boolean isMatchContactNumber=false;


    public void AgentSearchOnAction(ActionEvent actionEvent) {
        if (!isMatchNic){
        }else{
            String searchNic=txtAgentSearchNic.getText();
            try {
                Agent agent=AgentModel.search(searchNic);
                if (agent!=null){
                    txtAgentOldName.setText(agent.getName());
                    txtOldCompanyName.setText(agent.getCompany_name());
                    txtAgentOldEmail.setText(agent.getEmail());
                    txtOldContactNumber.setText(agent.getContacNo());
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    public void AgentSearchNicOnAction(KeyEvent keyEvent) {
        if (Service.isValidNic(txtAgentSearchNic.getText())){
            txtAgentSearchNic.setStyle("-fx-border-color: green;");
            isMatchNic=true;
        }else{
            txtAgentSearchNic.setStyle("-fx-border-color: red;");
            isMatchNic=false;
        }
    }

    public void AddToDatabaseOnAction(ActionEvent actionEvent) {
        if (!isMatchName|!isMatchCompanyName|!isMatchEmail|!isMatchContactNumber){
            new Alert(Alert.AlertType.CONFIRMATION,"Input Data Not Valid!").show();
        }else{
            String nic=txtAgentSearchNic.getText();
            String name=txtAgentNewName.getText();
            String CompanyName=txtNewCompanyName.getText();
            String email=txtAgentNewEmail.getText();
            String contactNumber=txtNewContactNumber.getText();

            Agent agent= new Agent(nic,name,CompanyName,email,contactNumber);
            boolean isAdded=false;
            try {
                isAdded= AgentModel.update(agent);
                if(isAdded){
                    new Alert(Alert.AlertType.CONFIRMATION, "Agent Updated!").show();
                    clearAll();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

    }

    public void AgentNewNameOnAction(KeyEvent keyEvent) {
        if (Service.isValidName(txtAgentNewName.getText())){
            txtAgentNewName.setStyle("-fx-border-color: green;");
            isMatchName=true;
        }else{
            txtAgentNewName.setStyle("-fx-border-color: red;");
            isMatchName=false;
        }
    }

    public void NewCompanyNameOnAction(KeyEvent keyEvent) {
        if (Service.isValidName(txtNewCompanyName.getText())){
            txtNewCompanyName.setStyle("-fx-border-color: green;");
            isMatchCompanyName=true;
        }else{
            txtNewCompanyName.setStyle("-fx-border-color: red;");
            isMatchCompanyName=false;
        }
    }

    public void AgentNewEmailOnAction(KeyEvent keyEvent) {
        if (Service.isValidEmail(txtAgentNewEmail.getText())){
            txtAgentNewEmail.setStyle("-fx-border-color: green;");
            isMatchEmail=true;
        }else{
            txtAgentNewEmail.setStyle("-fx-border-color: red;");
            isMatchEmail=false;
        }
    }

    public void NewContactNumberOnAction(KeyEvent keyEvent) {
        if (Service.isValidTelephoneNumber(txtNewContactNumber.getText())){
            txtNewContactNumber.setStyle("-fx-border-color: green;");
            isMatchContactNumber=true;
        }else{
            txtNewContactNumber.setStyle("-fx-border-color: red;");
            isMatchContactNumber=false;
        }
    }

    public void ClearSerchOnAction(ActionEvent actionEvent) {
        clearAll();
    }
    public void clearAll(){
         txtAgentSearchNic.setText(null);
         txtAgentOldName.setText(null);
         txtOldCompanyName.setText(null);
         txtAgentOldEmail.setText(null);
         txtOldContactNumber.setText(null);
         txtAgentNewName.setText(null);
         txtNewCompanyName.setText(null);
         txtAgentNewEmail.setText(null);
        txtNewContactNumber.setText(null);
    }
    public void AgentAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTADDPAGE, AgentUpdatePage);
    }

    public void AgentUpdatePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTUPDATEPAGE,AgentUpdatePage);
    }

    public void AgentDeletePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTDELETEPAGE,AgentUpdatePage);
    }

    public void AgentViewPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTVIEWPAGE,AgentUpdatePage);
    }

    public void AgentMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTMAINPAGE,AgentUpdatePage);
    }

    public void OrderPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERPLACEPAGE,AgentUpdatePage);
    }

    public void StockMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKMAINPAGE,AgentUpdatePage);
    }

    public void PaymentPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENTPLACEPAGE,AgentUpdatePage);
    }

    public void LogOutPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGOUTPAGE,AgentUpdatePage);
    }
}
