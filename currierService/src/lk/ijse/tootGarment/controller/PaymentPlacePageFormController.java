package lk.ijse.tootGarment.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tootGarment.model.OrderModel;
import lk.ijse.tootGarment.model.PaymentModel;
import lk.ijse.tootGarment.to.Order;
import lk.ijse.tootGarment.to.Payment;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;
import lk.ijse.tootGarment.util.Service;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PaymentPlacePageFormController implements Initializable {
    public AnchorPane PaymentPlacePage;
    public TextField txtPaymentId;
    public JFXComboBox OrderIdComboBox;
    public TextField txtAgentNic2;
    public TextField txtOrderDate2;
    public TextField txtAmount;
    public ArrayList<Order> orderView=new ArrayList<>();
    Order order;
    boolean isValidAmount=false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox();
    }

    public void comboBox(){
        ObservableList<String> orderViewOb= FXCollections.observableArrayList();
        try {
            orderView= OrderModel.View();
            for (Order order:orderView){
                orderViewOb.add(order.getOrder_id());
            }
            OrderIdComboBox.setItems(orderViewOb);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void OrderIdComboBoxOnAction(ActionEvent actionEvent){
        String orderId= (String) OrderIdComboBox.getValue();
        try {
            order=OrderModel.search(orderId);
            txtAgentNic2.setText(order.getAgent_nic());
            txtOrderDate2.setText(Service.setDate());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void AddToDatabaseOnAction(ActionEvent actionEvent) {
        if (!isValidAmount){
        }else{
            Payment payment =new Payment(txtPaymentId.getText(), txtOrderDate2.getText(), txtAgentNic2.getText(), (String) OrderIdComboBox.getValue(), Double.parseDouble(txtAmount.getText()));
            try {
                boolean isAdded=PaymentModel.add(payment);
                if (isAdded){
                    new Alert(Alert.AlertType.CONFIRMATION,"Payment ADDED!").show();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        clearAll();
    }

    public void txtAmountOnAction(KeyEvent keyEvent) {
        if(Service.isValidPrice(txtAmount.getText())){
            txtAmount.setStyle("-fx-border-color: green");
            isValidAmount=true;
        }else{
            txtAmount.setStyle("-fx-border-color: red");
            isValidAmount=false;
        }
    }

    public void clearAll(){
        txtAmount.setText(null);
        txtAgentNic2.setText(null);
        txtPaymentId.setText(null);
    }

    public void AgentMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTMAINPAGE, PaymentPlacePage);
    }

    public void OrderPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERPLACEPAGE, PaymentPlacePage);
    }

    public void StockMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKMAINPAGE, PaymentPlacePage);
    }

    public void PaymentPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENTPLACEPAGE, PaymentPlacePage);
    }

    public void LogOutPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGOUTPAGE, PaymentPlacePage);
    }

    public void PaymentPlacePage2OnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENTPLACEPAGE, PaymentPlacePage);
    }

    public void PaymentManagePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENTMANAGEPAGE, PaymentPlacePage);
    }
}
