package lk.ijse.tootGarment.model;

import lk.ijse.tootGarment.to.Agent;
import lk.ijse.tootGarment.to.Order;
import lk.ijse.tootGarment.to.User;
import lk.ijse.tootGarment.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderModel {
    public static boolean add(Order order) throws SQLException, ClassNotFoundException {
        boolean i= CrudUtil.execute("INSERT INTO `order` VALUES(?,?,?,?,?,?)",
                order.getOrder_id(),
                order.getDate(),
                order.getAgent_nic(),
                order.getDescription(),
                order.getDeadline(),
                order.getTerminatedDate()
        );
        return i;
    }

    public static ArrayList<Order> View() throws SQLException, ClassNotFoundException {
        ArrayList<Order> orderView=new ArrayList<>();
        ResultSet rst=CrudUtil.execute("SELECT * FROM `order`");

        while(rst.next()){
            orderView.add(
                    new Order(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6))
            );

        }
        return orderView;
    }

    public static Order search(String orderId) throws SQLException, ClassNotFoundException {
        ResultSet rst =CrudUtil.execute("SELECT * FROM `order` WHERE order_id='"+orderId+"'");
        System.out.println(rst);
        if (rst.next()){
            return new Order(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6));
        }
        return null;
    }

    public static boolean update(Order order) throws SQLException, ClassNotFoundException {
        boolean i=CrudUtil.execute("UPDATE `order` set terminatedDate=? where order_id=?",
                order.getTerminatedDate(),
                order.getOrder_id()
        );
        System.out.println(i);
        return i;
    }

    public static boolean delete(String text) throws SQLException, ClassNotFoundException {
        boolean i=CrudUtil.execute("DELETE FROM `order` WHERE order_id='"+text+"'");
        System.out.println(i);
        return i;
    }
}

