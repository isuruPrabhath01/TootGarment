package lk.ijse.tootGarment.model;

import lk.ijse.tootGarment.to.Agent;
import lk.ijse.tootGarment.to.Staff;
import lk.ijse.tootGarment.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StaffModel {
    public static boolean add(Staff staff) throws SQLException, ClassNotFoundException {
        boolean i = CrudUtil.execute("INSERT INTO staff VALUES(?,?,?,?,?,?,?)",
                staff.getStaff_id(),
                staff.getName(),
                staff.getAddress(),
                staff.getDob(),
                staff.getNic(),
                staff.getContacNo(),
                staff.getSalary()
        );
        System.out.println(i);
        return i;
    }

    public static Staff search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst =CrudUtil.execute("SELECT * FROM staff WHERE staff_id='"+id+"'");
        System.out.println(rst);
        if (rst.next()){
            return new Staff(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getDouble(7));
        }
        return null;
    }

    public static boolean update(Staff staff) throws SQLException, ClassNotFoundException {
        boolean i=CrudUtil.execute("UPDATE staff set name=?, address=?, dob=?, nic=?, contacNo=?, salary=? where staff_id=?",
                staff.getName(),
                staff.getAddress(),
                staff.getDob(),
                staff.getNic(),
                staff.getContacNo(),
                staff.getSalary(),
                staff.getStaff_id()
        );
        return i;
    }

    public static boolean delete(String id) throws SQLException, ClassNotFoundException {
        boolean i=CrudUtil.execute("DELETE FROM staff WHERE staff_id='"+id+"'");
        System.out.println(i);
        return i;
    }

    public static ArrayList<Staff> View() throws SQLException, ClassNotFoundException {
        ArrayList<Staff> staffView=new ArrayList<>();
        ResultSet rst=CrudUtil.execute("SELECT * FROM staff");
        while(rst.next()){
            staffView.add(
                    new Staff(rst.getString(1),
                              rst.getString(2),
                              rst.getString(3),
                              rst.getString(4),
                              rst.getString(5),
                              rst.getString(6),
                              rst.getDouble(7))
            );

        }
        return staffView;
    }
}
