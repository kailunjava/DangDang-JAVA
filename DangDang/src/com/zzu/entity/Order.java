package com.zzu.entity;

public class Order {
	private Integer id;            //订单id
	private Integer user_id;       //用户id
	private Integer pay_status;    //付款状态  0为未付款,1为已付款
	private Integer deliver_status;//交付状态  0为未收到,1为已接收
	private Integer order_time;    //订单日期
	private String order_desc;     //订单描述
	private Double total_price;   //订单总价
	private String receive_name;   //收货人姓名
	private String full_address;   //收货人完整地址
	private String postal_code;    //邮政编码
	private Integer mobile;         //收货人手机
	private Integer phone;          //收货人电话
	public Order(){}
	public Order(Integer id, Integer user_id, Integer pay_status,
			Integer deliver_status, Integer order_time, String order_desc,
			Double total_price, String receive_name, String full_address,
			String postal_code, Integer mobile, Integer phone) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.pay_status = pay_status;
		this.deliver_status = deliver_status;
		this.order_time = order_time;
		this.order_desc = order_desc;
		this.total_price = total_price;
		this.receive_name = receive_name;
		this.full_address = full_address;
		this.postal_code = postal_code;
		this.mobile = mobile;
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getPay_status() {
		return pay_status;
	}
	public void setPay_status(Integer pay_status) {
		this.pay_status = pay_status;
	}
	public Integer getDeliver_status() {
		return deliver_status;
	}
	public void setDeliver_status(Integer deliver_status) {
		this.deliver_status = deliver_status;
	}
	public Integer getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Integer order_time) {
		this.order_time = order_time;
	}
	public String getOrder_desc() {
		return order_desc;
	}
	public void setOrder_desc(String order_desc) {
		this.order_desc = order_desc;
	}
	public Double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}
	public String getReceive_name() {
		return receive_name;
	}
	public void setReceive_name(String receive_name) {
		this.receive_name = receive_name;
	}
	public String getFull_address() {
		return full_address;
	}
	public void setFull_address(String full_address) {
		this.full_address = full_address;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public Integer getMobile() {
		return mobile;
	}
	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", user_id=" + user_id + ", pay_status="
				+ pay_status + ", deliver_status=" + deliver_status
				+ ", order_time=" + order_time + ", order_desc=" + order_desc
				+ ", total_price=" + total_price + ", receive_name="
				+ receive_name + ", full_address=" + full_address
				+ ", postal_code=" + postal_code + ", mobile=" + mobile
				+ ", phone=" + phone + "]";
	}
	
}
