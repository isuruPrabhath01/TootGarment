package lk.ijse.tootGarment.model;

import lk.ijse.tootGarment.to.Attendance_staff;
import lk.ijse.tootGarment.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Attendance_staffModel {
    public static boolean add(Attendance_staff attendance_staff) throws SQLException, ClassNotFoundException {
        boolean i= CrudUtil.execute("INSERT INTO attendance_staff VALUES(?,?,?,?,?)",
                attendance_staff.getStaff_id(),
                attendance_staff.getName(),
                attendance_staff.getDate(),
                attendance_staff.getTime(),
                attendance_staff.getAbsent_present()
        );
        System.out.println(i);
        return i;
    }

    public static ArrayList<Attendance_staff> View() throws SQLException, ClassNotFoundException {
        ArrayList<Attendance_staff> attendsView= new ArrayList();
        ResultSet rst=CrudUtil.execute("SELECT * FROM attendance_staff");
        while (rst.next()){
            attendsView.add(
                    new Attendance_staff(rst.getString(1),
                                         rst.getString(2),
                                         rst.getString(3),
                                         rst.getString(4),
                                         rst.getString(5)
                    )
            );
        }
        return attendsView;
    }
}
