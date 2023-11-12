package lk.ijse.tootGarment.model;

import lk.ijse.tootGarment.to.Payment;
import lk.ijse.tootGarment.util.CrudUtil;

import javax.print.DocFlavor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentModel {
    public static boolean add(Payment payment) throws SQLException, ClassNotFoundException {
        boolean i = CrudUtil.execute("INSERT INTO payment VALUES(?,?,?,?,?)",
                payment.getPayment_id(),
                payment.getDate(),
                payment.getAgent_Nic(),
                payment.getOrder_id(),
                payment.getAmount()
        );
        System.out.println(i);
        return i;
    }

    public static ArrayList<Payment> View() throws SQLException, ClassNotFoundException {
        ArrayList<Payment> paymentView=new ArrayList<>();
        ResultSet rst=CrudUtil.execute("SELECT * FROM payment");
            while(rst.next()){
                paymentView.add(new Payment(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getDouble(5)));
        }
        return paymentView;
    }

    public static boolean delete(String text) throws SQLException, ClassNotFoundException {
        boolean i = CrudUtil.execute("DELETE FROM payment WHERE payment_id='"+text+"'");
        return i;
    }
}
