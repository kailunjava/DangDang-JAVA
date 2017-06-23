package com.zzu.entity;

public class Address {
   private Integer id;             //收货地址id
   private String receive_name;    //收件人姓名
   private String full_address;    //详细地址
   private String postal_code;     //邮政编码
   private Integer mobile;         //手机
   private Integer phone;          //电话
   private Integer u_id;           //用户id
   public Address(){}
public Address(Integer id, String receive_name, String full_address,
		String postal_code, Integer mobile, Integer phone, Integer u_id) {
	super();
	this.id = id;
	this.receive_name = receive_name;
	this.full_address = full_address;
	this.postal_code = postal_code;
	this.mobile = mobile;
	this.phone = phone;
	this.u_id = u_id;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
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
public Integer getU_id() {
	return u_id;
}
public void setU_id(Integer u_id) {
	this.u_id = u_id;
}
@Override
public String toString() {
	return "Address [id=" + id + ", receive_name=" + receive_name
			+ ", full_address=" + full_address + ", postal_code=" + postal_code
			+ ", mobile=" + mobile + ", phone=" + phone + ", u_id=" + u_id
			+ "]";
}
   
}
