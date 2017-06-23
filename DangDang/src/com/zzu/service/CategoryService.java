package com.zzu.service;

import java.util.List;

import com.zzu.entity.Category;

/**
 * 分类信息service接口
 */
public interface CategoryService {
    /**
     * 获取自连接的数据
     */
	public List<Category> queryAll();
	/**
	 * 根据一级分类id查询分类信息
	 */
	public Category queryCategoryByFirstId(Integer id);
	
}
