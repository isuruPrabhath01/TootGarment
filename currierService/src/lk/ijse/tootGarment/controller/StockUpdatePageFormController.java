package lk.ijse.tootGarment.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;

import java.io.IOException;

public class StockUpdatePageFormController {
    public AnchorPane StockUpdatePage;

    public void AgentMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTMAINPAGE, StockUpdatePage);
    }

    public void OrderPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERPLACEPAGE, StockUpdatePage);
    }

    public void StockMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKMAINPAGE, StockUpdatePage);
    }

    public void PaymentPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENTPLACEPAGE, StockUpdatePage);
    }

    public void LogOutPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGOUTPAGE, StockUpdatePage);
    }

    public void StockAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKADDPAGE, StockUpdatePage);
    }

    public void StockUpdatePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKUPDATEPAGE, StockUpdatePage);
    }

    public void StockClearPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKDELETEPAGE, StockUpdatePage);
    }

    public void StockViewPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKVIEWPAGE, StockUpdatePage);
    }
}
