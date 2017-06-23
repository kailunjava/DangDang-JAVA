package com.zzu.dao;

import java.util.List;

import com.zzu.entity.Product;

public interface ProductDao {
	/**
	 * 热销图书	  
	 */
	 public List<Product> queryHot();
	 /**
	  * 最新上架图书
	  */	 
	 public List<Product> queryNew();
	 /**
	  * 编辑推荐图书
	  */
	 public List<Product> queryTuiJian();
	 /**
	  * 新书热销图书
	  */
	 public List<Product> queryProductHotBorad();
	/**
	 * 根据id查询图书详情
	 */
	public Product queryProductById(Integer id);
	/**
	 * 根据 商品所属二级分类id查询所有图书
	 */	
	public List<Product> queryProductByTwo(Integer id);
	/**
	 * 根据一级分类id查询所属于他的二级分类的所有图书
	 */
	public List<Product> queryProductByOne(Integer id);
}
