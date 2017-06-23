package com.zzu.entity;

import java.util.List;

/**
 * 分类信息的实体
 * @author Administrator
 *
 */
public class Category {
    private Integer id;            //类别id
    private String category_name;  //类别名称
    private Integer parent_id;     //上级类别id
    private Integer product_count; //分类商品的数量
    private Integer count;//所属的图书数量
    private List<Category> categorys;//一对多中的多
   public Category(){}

public Category(Integer id, String category_name, Integer parent_id,
		Integer product_count, List<Category> categorys) {
	super();
	this.id = id;
	this.category_name = category_name;
	this.parent_id = parent_id;
	this.product_count = product_count;
	this.categorys = categorys;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getCategory_name() {
	return category_name;
}
public void setCategory_name(String category_name) {
	this.category_name = category_name;
}
public Integer getParent_id() {
	return parent_id;
}
public void setParent_id(Integer parent_id) {
	this.parent_id = parent_id;
}
public Integer getProduct_count() {
	return product_count;
}
public void setProduct_count(Integer product_count) {
	this.product_count = product_count;
}

public List<Category> getCategorys() {
	return categorys;
}

public void setCategorys(List<Category> categorys) {
	this.categorys = categorys;
}

public Integer getCount() {
	return count;
}

public void setCount(Integer count) {
	this.count = count;
}

@Override
public String toString() {
	return "Category [id=" + id + ", category_name=" + category_name
			+ ", parent_id=" + parent_id + ", product_count=" + product_count
			+ ", categorys=" + categorys + "]";
}


   
}
