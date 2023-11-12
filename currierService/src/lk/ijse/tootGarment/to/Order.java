package lk.ijse.tootGarment.to;

public class Order {
    private String order_id;
    private String date;
    private String agent_nic;
    private String description;
    private String deadline;
    private String terminatedDate;

    public Order(){

    }

    public Order(String order_id,String date,String agent_nic,String description,String deadline,String terminatedDate){
        this.order_id=order_id;
        this.date=date;
        this.agent_nic=agent_nic;
        this.description=description;
        this.deadline=deadline;
        this.terminatedDate=terminatedDate;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAgent_nic() {
        return agent_nic;
    }

    public void setAgent_nic(String agent_nic) {
        this.agent_nic = agent_nic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getTerminatedDate() {
        return terminatedDate;
    }
    public void setTerminatedDate(String terminatedDate) {
        this.terminatedDate = terminatedDate;
    }
}
