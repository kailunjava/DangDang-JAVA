package com.zzu.service;

import java.util.List;

import com.zzu.entity.Product;



public interface ProductService {
	/**
	 * 编辑推荐
	 */
	public List<Product> queryTuiJian();
	/**
	 * 最新上架图书
	 */
	public List<Product> queryNew();
	/**
	 * 热销图书
	 */
	public List<Product> queryHot();
	 /**
	  * 新书热销图书
	  */
	 public List<Product> queryProductHotBorad();
	/**
	 * 根据id 查询图书信息
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
