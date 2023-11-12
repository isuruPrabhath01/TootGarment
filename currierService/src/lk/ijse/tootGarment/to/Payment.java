package lk.ijse.tootGarment.to;

public class Payment {
    private String payment_id;
    private String date;
    private String agent_Nic;
    private String order_id;
    private double amount;

    public Payment(){

    }

    public Payment(String payment_id,String date,String agent_Nic,String order_id,double amount){
        this.payment_id=payment_id;
        this.date=date;
        this.agent_Nic=agent_Nic;
        this.order_id=order_id;
        this.amount=amount;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAgent_Nic() {
        return agent_Nic;
    }

    public void setAgent_Nic(String agent_id) {
        this.agent_Nic = agent_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
