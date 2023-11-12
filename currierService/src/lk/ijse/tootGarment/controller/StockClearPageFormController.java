package lk.ijse.tootGarment.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;

import java.io.IOException;

public class StockClearPageFormController {
    public AnchorPane StockClearPage;

    public void AgentMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTMAINPAGE, StockClearPage);
    }

    public void OrderPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERPLACEPAGE, StockClearPage);
    }

    public void StockMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKMAINPAGE, StockClearPage);
    }

    public void PaymentPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENTPLACEPAGE, StockClearPage);
    }

    public void LogOutPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGOUTPAGE, StockClearPage);
    }

    public void StockAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKADDPAGE, StockClearPage);
    }

    public void StockUpdatePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKUPDATEPAGE, StockClearPage);
    }

    public void StockClearPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKDELETEPAGE, StockClearPage);
    }

    public void StockViewPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKVIEWPAGE, StockClearPage);
    }
}
