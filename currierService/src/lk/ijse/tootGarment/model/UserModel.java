package lk.ijse.tootGarment.model;

import lk.ijse.tootGarment.to.Staff;
import lk.ijse.tootGarment.to.User;
import lk.ijse.tootGarment.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserModel {
    public static boolean add(User user) throws SQLException, ClassNotFoundException {
        boolean i = CrudUtil.execute("INSERT INTO user VALUES(?,?,?)",
                user.getStaff_id(),
                user.getUser_name(),
                user.getPassword()
        );
        System.out.println(i);
        return i;
    }
    public static ArrayList<User> View() throws SQLException, ClassNotFoundException {
        ArrayList<User> userView=new ArrayList<>();
        ResultSet rst=CrudUtil.execute("SELECT * FROM user");
        while(rst.next()){
            userView.add(
                    new User(rst.getString(1),
                            rst.getString(2),
                            rst.getString(3))
            );

        }
        return userView;
    }

    public static User search(String staffId) throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtil.execute("SELECT * FROM user WHERE staff_id='"+staffId+"'");
        if (rst.next()){
            return new User(rst.getString(1),rst.getString(2),rst.getString(3));
        }
        return null;
    }

    public static boolean update(User user) throws SQLException, ClassNotFoundException {
        boolean i =CrudUtil.execute("UPDATE user SET user_name=?, password=? WHERE staff_id=?",
                user.getUser_name(),
                user.getPassword(),
                user.getStaff_id()
        );
        return i;
    }

    public static boolean delete(String staffId) throws SQLException, ClassNotFoundException {
        boolean i=CrudUtil.execute("DELETE FROM user WHERE staff_id='"+staffId+"'");
        return i;
    }
}
