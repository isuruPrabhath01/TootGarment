package lk.ijse.tootGarment.model;

import lk.ijse.tootGarment.to.Stock;
import lk.ijse.tootGarment.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StockModel {
    public static ArrayList<Stock> view() throws SQLException, ClassNotFoundException {
        ArrayList<Stock> stockView = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT ALL FROM stock");
        while(rst.next()){
            stockView.add(new Stock(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getInt(6),rst.getInt(7)));
        }
        return stockView;
    }
}
