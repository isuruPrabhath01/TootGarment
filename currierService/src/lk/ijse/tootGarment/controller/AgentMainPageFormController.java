package lk.ijse.tootGarment.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;

import java.io.IOException;

public class AgentMainPageFormController {
    public AnchorPane AgentMainPage;
    public void AgentAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTADDPAGE,AgentMainPage);
    }

    public void AgentUpdatePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTUPDATEPAGE,AgentMainPage);
    }

    public void AgentDeletePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTDELETEPAGE,AgentMainPage);
    }

    public void AgentViewPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTVIEWPAGE,AgentMainPage);
    }

    public void AgentMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTMAINPAGE,AgentMainPage);
    }

    public void OrderPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERPLACEPAGE,AgentMainPage);
    }

    public void StockMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKMAINPAGE,AgentMainPage);
    }

    public void PaymentPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENTPLACEPAGE,AgentMainPage);
    }

    public void LogOutPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGOUTPAGE,AgentMainPage);
    }
}
