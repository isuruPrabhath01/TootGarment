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
import lk.ijse.tootGarment.model.OrderModel;
import lk.ijse.tootGarment.to.Order;
import lk.ijse.tootGarment.util.Navigation;
import lk.ijse.tootGarment.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class OrderViewPageNewFormController implements Initializable {
        public AnchorPane OrderViewPage;
        public TableView tblOrderView;
        public TableColumn tblOrderId;
        public TableColumn tblOrderDate;
        public TableColumn tblAgentNic;
        public TableColumn tblDescription;
        public TableColumn tblDeadline;
        public TextField txtOrderId;
        public static ArrayList<Order> orderView=new ArrayList<>();
        @Override
        public void initialize(URL location, ResourceBundle resources) {
            tblOrderId.setCellValueFactory(new PropertyValueFactory<>("order_id"));
            tblOrderDate.setCellValueFactory(new PropertyValueFactory<>("date"));
            tblAgentNic.setCellValueFactory(new PropertyValueFactory<>("agent_nic"));
            tblDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            tblDeadline.setCellValueFactory(new PropertyValueFactory<>("deadline"));
        }



        public void DeleteOnAction(ActionEvent actionEvent) {
            try {
                boolean isDeleted=OrderModel.delete(txtOrderId.getText());
                if (isDeleted){
                    new Alert(Alert.AlertType.CONFIRMATION, "Order Deleted!").show();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            load();
            txtOrderId.setText(null);
        }

        public void load(){
            try {
                ObservableList<Order> agentViewOb = FXCollections.observableArrayList();
                orderView= OrderModel.View();
                System.out.println(orderView);
                for (Order order:orderView) {
                    agentViewOb.add(order);
                }
                tblOrderView.setItems(agentViewOb);
            } catch (SQLException | ClassNotFoundException e ) {
                e.printStackTrace();
            }
        }

        public void LoadOnAction(ActionEvent actionEvent) {
            load();
        }

        public void OrderPlaceOnAction(ActionEvent actionEvent) throws IOException {
            Navigation.navigate(Routes.ORDERPLACEPAGE, OrderViewPage);
        }

        public void OrderTerminatedOnAction(ActionEvent actionEvent) throws IOException {
            Navigation.navigate(Routes.ORDERTERMINATED, OrderViewPage);
        }

        public void   OrderManageOnAction(ActionEvent actionEvent) throws IOException {
            Navigation.navigate(Routes.ORDERMANAGE, OrderViewPage);
        }

        public void AgentMainPageOnAction(ActionEvent actionEvent) throws IOException {
            Navigation.navigate(Routes.AGENTMAINPAGE, OrderViewPage);
        }

        public void OrderPlacePageOnAction(ActionEvent actionEvent) throws IOException {
            Navigation.navigate(Routes.ORDERPLACEPAGE, OrderViewPage);
        }

        public void StockMainPageOnAction(ActionEvent actionEvent) throws IOException {
            Navigation.navigate(Routes.STOCKMAINPAGE, OrderViewPage);
        }

        public void PaymentPlacePageOnAction(ActionEvent actionEvent) throws IOException {
            Navigation.navigate(Routes.PAYMENTPLACEPAGE, OrderViewPage);
        }

        public void LogOutPageOnAction(ActionEvent actionEvent) throws IOException {
            Navigation.navigate(Routes.LOGOUTPAGE, OrderViewPage);
        }

}


