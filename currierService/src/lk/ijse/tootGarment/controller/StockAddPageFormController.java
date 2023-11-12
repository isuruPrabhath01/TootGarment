package lk.ijse.tootGarment.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tootGarment.model.OrderModel;
import lk.ijse.tootGarment.model.StockModel;
import lk.ijse.tootGarment.to.Order;
import lk.ijse.tootGarment.to.Stock;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;
import lk.ijse.tootGarment.util.Service;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StockAddPageFormController implements Initializable {
    public AnchorPane StockAddPage;
    public TextField txtStockId;
    public TextField txtDescription;
    public TextField txtQty;
    public TextField txtType;
    public JFXComboBox OrderIdComboBox;
    public TextField txtOrderDate;
    public ArrayList<Order> orderView = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtOrderDate.setText(Service.setDate());
    }
    public void loadComboBox(){
        ObservableList<String> orderViewOb = FXCollections.observableArrayList();
        try {
            orderView= OrderModel.View();
            for (Order order:orderView) {
                orderViewOb.add(order.getOrder_id());
            }
            OrderIdComboBox.setItems(orderViewOb);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void AddToDatabaseOnAction(ActionEvent actionEvent) {
    }

    public void ClearAllDataOnAction(ActionEvent actionEvent) {
    }

    public void OrderIdComboBoxOnAction(ActionEvent actionEvent) {
    }

    public void AgentMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTMAINPAGE, StockAddPage);
    }

    public void OrderPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERPLACEPAGE, StockAddPage);
    }

    public void StockMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKMAINPAGE, StockAddPage);
    }

    public void PaymentPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENTPLACEPAGE, StockAddPage);
    }

    public void LogOutPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGOUTPAGE, StockAddPage);
    }

    public void StockAddPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKADDPAGE, StockAddPage);
    }

    public void StockUpdatePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKUPDATEPAGE, StockAddPage);
    }

    public void StockClearPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKDELETEPAGE, StockAddPage);
    }

    public void StockViewPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKVIEWPAGE, StockAddPage);
    }
}
