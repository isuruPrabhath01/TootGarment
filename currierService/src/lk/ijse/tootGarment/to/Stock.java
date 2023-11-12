package lk.ijse.tootGarment.to;

public class Stock {
   private String updated_date;
   private String stock_id;
   private String order_id;
   private String description;
   private String type;
   private int qty;
   private int remainingQty;

   public Stock(){

   }

    public Stock(String updated_date,String stock_id,String order_id,String description,String type,int qty,int remainingQty){
        this.updated_date=updated_date;
        this.stock_id=stock_id;
        this.order_id=order_id;
        this.description=description;
        this.type=type;
        this.qty=qty;
        this.remainingQty=remainingQty;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }

    public String getStock_id() {
        return stock_id;
    }

    public void setStock_id(String stock_id) {
        this.stock_id = stock_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getRemainingQty() {
        return remainingQty;
    }

    public void setRemainingQty(int remainingQty) {
        this.remainingQty = remainingQty;
    }
}
