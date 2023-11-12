package lk.ijse.tootGarment.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;

import java.io.IOException;

public class StockViewPageFormController {
    public AnchorPane StockViewPage;

    public void AgentMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTMAINPAGE, StockViewPage);
    }

    public void OrderPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERPLACEPAGE, StockViewPage);
    }

    public void StockMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKMAINPAGE, StockViewPage);
    }

    public void PaymentPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENTPLACEPAGE, StockViewPage);
    }

    public void LogOutPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGOUTPAGE, StockViewPage);
    }

    public void StockAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKADDPAGE, StockViewPage);
    }

    public void StockUpdatePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKUPDATEPAGE, StockViewPage);
    }

    public void StockClearPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKDELETEPAGE, StockViewPage);
    }

    public void StockViewPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKVIEWPAGE, StockViewPage);
    }
}
