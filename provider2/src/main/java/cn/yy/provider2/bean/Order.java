package cn.yy.provider2.bean;

public class Order {
  private long id;
  private long customer_id;
  private long commodity_id;
  private java.sql.Timestamp order_t;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getCustomer_id() {
    return customer_id;
  }

  public void setCustomer_id(long customer_id) {
    this.customer_id = customer_id;
  }

  public long getCommodity_id() {
    return commodity_id;
  }

  public void setCommodity_id(long commodity_id) {
    this.commodity_id = commodity_id;
  }

  public java.sql.Timestamp getOrder_t() {
    return order_t;
  }

  public void setOrder_t(java.sql.Timestamp order_t) {
    this.order_t = order_t;
  }

}
