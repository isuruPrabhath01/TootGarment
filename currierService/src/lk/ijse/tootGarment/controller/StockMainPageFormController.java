package lk.ijse.tootGarment.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;

import java.io.IOException;
public class StockMainPageFormController {
    public AnchorPane StockManegePage;

    public void AgentMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTMAINPAGE, StockManegePage);
    }

    public void OrderPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERPLACEPAGE, StockManegePage);
    }

    public void StockMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKMAINPAGE, StockManegePage);
    }

    public void PaymentPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENTPLACEPAGE, StockManegePage);
    }

    public void LogOutPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGOUTPAGE, StockManegePage);
    }

    public void StockAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKADDPAGE, StockManegePage);
    }

    public void StockUpdatePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKUPDATEPAGE, StockManegePage);
    }

    public void StockClearPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKDELETEPAGE, StockManegePage);
    }

    public void StockViewPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKVIEWPAGE, StockManegePage);
    }
}
