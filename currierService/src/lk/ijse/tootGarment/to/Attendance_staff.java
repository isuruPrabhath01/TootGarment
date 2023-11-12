package lk.ijse.tootGarment.to;

public class Attendance_staff {
    private String staff_id;
    private String name;
    private String date;
    private String time;
    private String absent_present;

    public Attendance_staff(){

    }

    public Attendance_staff(String staff_id,String name,String date,String time,String absent_present ){
        this.setStaff_id(staff_id);
        this.setName(name);
        this.setDate(date);
        this.setTime(time);
        this.setAbsent_present(absent_present);

    }


    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAbsent_present() {
        return absent_present;
    }

    public void setAbsent_present(String absent_present) {
        this.absent_present = absent_present;
    }
}
