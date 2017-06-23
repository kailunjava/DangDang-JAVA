package com.zzu.entity;


public class CartItem {
  private Product product;//商品信息
  private Integer count;//购买数量
  private Integer isDeleted=0;//购买状态 购买0 删除1
  public CartItem(){}
public CartItem(Product product, Integer count, Integer isDeleted) {
	super();
	this.product = product;
	this.count = count;
	this.isDeleted = isDeleted;
}
public CartItem(Integer id,Integer count) {
	this.product=new Product();
	product.setId(id);
	this.count=count;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public Integer getCount() {
	return count;
}
public void setCount(Integer count) {
	this.count = count;
}

public Integer getIsDeleted() {
	return isDeleted;
}
public void setIsDeleted(Integer isDeleted) {
	this.isDeleted = isDeleted;
}
@Override
public String toString() {
	return "CartItem [product=" + product + ", count=" + count + ", isDeleted="
			+ isDeleted + "]";
}
  
}
