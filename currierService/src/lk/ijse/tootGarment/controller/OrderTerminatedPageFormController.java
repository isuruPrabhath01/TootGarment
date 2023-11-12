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
import lk.ijse.tootGarment.db.DBConnection;
import lk.ijse.tootGarment.model.AgentModel;
import lk.ijse.tootGarment.model.OrderModel;
import lk.ijse.tootGarment.model.PaymentModel;
import lk.ijse.tootGarment.model.UserModel;
import lk.ijse.tootGarment.to.Agent;
import lk.ijse.tootGarment.to.Order;
import lk.ijse.tootGarment.to.Payment;
import lk.ijse.tootGarment.to.User;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;
import lk.ijse.tootGarment.util.Service;
import sun.text.resources.cldr.ti.FormatData_ti_ER;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrderTerminatedPageFormController implements Initializable {
    public AnchorPane OrderFinishPage;
    public JFXComboBox OrderIdComboBox;
    public TextField txtPlaceDate;
    public TextField txtAgentNic;
    public TextField txtDeadline;
    public TextField txtOrderDate2;
    public TextField txtOrderDate;
    public TextField txtPaymentId;
    public TextField txtAmount;
    public TextField txtOrderId;
    public TextField txtAgentNic2;
    Order order;
    String orderId;
    boolean isValedValue=false;

    public static ArrayList<Order> orderView=new ArrayList<>();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadComboBox();
        txtOrderDate.setText(Service.setDate());
        txtOrderDate2.setText(Service.setDate());
    }
    public void loadComboBox(){
        try {
            ObservableList<String> agentViewOb = FXCollections.observableArrayList();
            orderView= OrderModel.View();
            System.out.println(orderView);
            for (Order order:orderView) {
                agentViewOb.add(order.getOrder_id());
            }
            OrderIdComboBox.setItems(agentViewOb);
        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }
    public void OrderIdComboBoxOnAction(ActionEvent actionEvent) {
        orderId=(String) OrderIdComboBox.getValue();
        System.out.println(orderId);
        try {
            order = OrderModel.search(orderId);
            txtPlaceDate.setText(order.getDate());
            txtAgentNic.setText(order.getAgent_nic());
            txtDeadline.setText(order.getDeadline());
            txtOrderId.setText(orderId);
            txtAgentNic2.setText(order.getAgent_nic());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void AddToDatabaseOnAction(ActionEvent actionEvent) {
        order.setTerminatedDate(txtOrderDate.getText());
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            order.setTerminatedDate(txtOrderDate2.getText());
            if (OrderModel.update(order)) {
                Payment payment = new Payment(txtPaymentId.getText(), txtOrderDate2.getText(), txtAgentNic2.getText(), orderId, Double.parseDouble(txtAmount.getText()));
                if(PaymentModel.add(payment)){
                    DBConnection.getInstance().getConnection().commit();
                    new Alert(Alert.AlertType.CONFIRMATION, "Payment Added").show();
                }else {
                    DBConnection.getInstance().getConnection().rollback();
                }
            }else {

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                DBConnection.getInstance().getConnection().setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        ClearAll();
    }

    public void ClearAll(){
        txtOrderId.setText(null);
        txtPlaceDate.setText(null);
        txtAgentNic.setText(null);
        txtDeadline.setText(null);
        txtOrderDate.setText(null);
        txtOrderDate2.setText(null);
        txtAgentNic2.setText(null);
        txtPaymentId.setText(null);
        txtAmount.setText(null);
    }

    public void txtAmountOnAction(KeyEvent keyEvent) {
        if (Service.isValidPrice(txtAmount.getText())){
            txtAmount.setStyle("-fx-border-color: green;");
            isValedValue=true;
        }else{
            txtAmount.setStyle("-fx-border-color: red;");
            isValedValue=false;
        }
    }

    public void OrderPlaceOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERPLACEPAGE, OrderFinishPage);
    }

    public void OrderTerminatedOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERTERMINATED, OrderFinishPage);
    }

    public void OrderManageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERMANAGE, OrderFinishPage);
    }

    public void AgentMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTMAINPAGE, OrderFinishPage);
    }

    public void OrderPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERPLACEPAGE, OrderFinishPage);
    }

    public void StockMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKMAINPAGE, OrderFinishPage);
    }

    public void PaymentPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENTPLACEPAGE, OrderFinishPage);
    }

    public void LogOutPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGOUTPAGE, OrderFinishPage);
    }
}
