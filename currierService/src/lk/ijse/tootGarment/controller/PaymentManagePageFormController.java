package lk.ijse.tootGarment.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tootGarment.model.PaymentModel;
import lk.ijse.tootGarment.to.Payment;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PaymentManagePageFormController implements Initializable {
    public AnchorPane PaymentManagePage;
    public TableView tblPaymentView;
    public TableColumn tblPaymentId;
    public TableColumn tblPaymentDate;
    public TableColumn tblAgentNic;
    public TableColumn tblOrderId;
    public TableColumn tblAmount;
    public TextField txtPaymentId;
    public ArrayList<Payment> paymentView=new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblPaymentId.setCellValueFactory(new PropertyValueFactory<>("payment_id"));
        tblPaymentDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tblAgentNic.setCellValueFactory(new PropertyValueFactory<>("agent_Nic"));
        tblOrderId.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        tblAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));

    }
    public void LoadTable(){
        ObservableList<Payment> paymentViewOb = FXCollections.observableArrayList();
        try {
            paymentView= PaymentModel.View();
            for (Payment payment:paymentView) {
                paymentViewOb.add(payment);
            }
            tblPaymentView.setItems(paymentViewOb);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void LoadOnAction(ActionEvent actionEvent) {
        LoadTable();
    }

    public void DeletePaymentOnAction(ActionEvent actionEvent) {
        try {
            boolean isDeleted=PaymentModel.delete(txtPaymentId.getText());
            if(isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Payment DELETED!").show();
                LoadTable();
                txtPaymentId.setText(null);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void AgentMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.AGENTMAINPAGE, PaymentManagePage);
    }

    public void OrderPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ORDERPLACEPAGE, PaymentManagePage);
    }

    public void StockMainPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STOCKMAINPAGE, PaymentManagePage);
    }

    public void PaymentPlacePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENTPLACEPAGE, PaymentManagePage);
    }

    public void LogOutPageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGOUTPAGE, PaymentManagePage);
    }

    public void PaymentPlacePage2OnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENTPLACEPAGE, PaymentManagePage);
    }

    public void PaymentManagePageOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENTMANAGEPAGE, PaymentManagePage);
    }
}
