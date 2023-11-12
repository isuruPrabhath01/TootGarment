package lk.ijse.tootGarment.to;

public class User {
    private String staff_id;
    private String user_name;
    private String password;

    public User(){

    }

    public User(String staff_id,String user_name,String password){
        this.staff_id=staff_id;
        this.user_name=user_name;
        this.password=password;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
