package lk.ijse.tootGarment.to;

public class Assest {
   private String assest_id;
   private String description;
   private String purchase_date;
   private double assest_value;

    public Assest(){
    }

    public Assest(String assest_id,String description,String purchase_date,double assest_value){
        this.assest_id= assest_id;
        this.description=description;
        this.purchase_date=purchase_date;
        this.assest_value=assest_value;
    }

    public String getAssest_id() {
        return assest_id;
    }

    public void setAssest_id(String assest_id) {
        this.assest_id = assest_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }

    public double getAssest_value() {
        return assest_value;
    }

    public void setAssest_value(double assest_value) {
        this.assest_value = assest_value;
    }
}
