package lk.ijse.tootGarment.to;

public class Staff {
    private String staff_id;
    private String name;
    private String address;
    private String dob;
    private String nic;
    private String contacNo;
    private double salary;

    public Staff(){

    }

    public Staff(String staff_id, String name, String address, String dob, String nic, String contacNo, double salary){
        this.setStaff_id(staff_id);
        this.setName(name);
        this.setAddress(address);
        this.setDob(dob);
        this.setNic(nic);
        this.setContacNo(contacNo);
        this.setSalary(salary);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getContacNo() {
        return contacNo;
    }

    public void setContacNo(String contacNo) {
        this.contacNo = contacNo;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
