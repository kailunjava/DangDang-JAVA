package com.zzu.dao;

import java.util.List;

import com.zzu.entity.Category;

/**
 * 分类信息Dao层
 */
public interface CategoryDao {  
	/**
	 * 获取表自连接的数据 
	 */
	public List<Category> queryAll();
	/**
	 * 根据一级id 查询分类信息
	 */	
	public Category queryCategoryByFirstId(Integer id);
	

}
