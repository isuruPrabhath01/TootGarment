package lk.ijse.tootGarment.to;

public class Finish_order {
    private String order_id;
    private String finish_date;
    private int more_days;
    private int remaining_days;
    private int remainingQty;

    public Finish_order(){

    }

    public Finish_order(String order_id,String finish_date,int more_days,int remaining_days,int remainingQty){
        this.order_id=order_id;
        this.finish_date=finish_date;
        this.more_days=more_days;
        this.remaining_days=remaining_days;
        this.remainingQty=remainingQty;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(String finish_date) {
        this.finish_date = finish_date;
    }

    public int getMore_days() {
        return more_days;
    }

    public void setMore_days(int more_days) {
        this.more_days = more_days;
    }

    public int getRemaining_days() {
        return remaining_days;
    }

    public void setRemaining_days(int remaining_days) {
        this.remaining_days = remaining_days;
    }

    public int getRemainingQty() {
        return remainingQty;
    }

    public void setRemainingQty(int remainingQty) {
        this.remainingQty = remainingQty;
    }
}
