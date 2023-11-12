package lk.ijse.tootGarment.to;

public class Salary {
    private String staff_id;
    private int year;
    private int month;
    private String date_of_pay;

    public Salary(){

    }

    public Salary(String staff_id,int year,int month,String date_of_pay){
        this.staff_id=staff_id;
        this.year=year;
        this.month=month;
        this.date_of_pay=date_of_pay;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getDate_of_pay() {
        return date_of_pay;
    }

    public void setDate_of_pay(String date_of_pay) {
        this.date_of_pay = date_of_pay;
    }
}
