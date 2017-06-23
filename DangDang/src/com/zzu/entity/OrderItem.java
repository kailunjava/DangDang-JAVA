package com.zzu.entity;

public class OrderItem {
     private Integer id;          //id
     private Integer order_id;    //订单id
     private Integer product_id;  //商品id
     private String product_name; //商品名字
     private Double dang_price;  //商品当当价
     private Integer product_num; //商品数目
     private Double amount;      //商品价格小结
     public OrderItem(){}
	public OrderItem(Integer id, Integer order_id, Integer product_id,
			String product_name, Double dang_price, Integer product_num,
			Double amount) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.dang_price = dang_price;
		this.product_num = product_num;
		this.amount = amount;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Double getDang_price() {
		return dang_price;
	}
	public void setDang_price(Double dang_price) {
		this.dang_price = dang_price;
	}
	public Integer getProduct_num() {
		return product_num;
	}
	public void setProduct_num(Integer product_num) {
		this.product_num = product_num;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", order_id=" + order_id
				+ ", product_id=" + product_id + ", product_name="
				+ product_name + ", dang_price=" + dang_price
				+ ", product_num=" + product_num + ", amount=" + amount + "]";
	}
     
}
