package com.zzu.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zzu.dao.CategoryDao;
import com.zzu.entity.Category;
import com.zzu.service.CategoryService;
import com.zzu.util.MybatisUtil;

/**
 * 分类信息service层
 */
public class CategoryServiceImpl implements CategoryService{

   
	public List<Category> queryAll() {
		SqlSession ss = null;
		List<Category> list = null;
		try {			
			ss = MybatisUtil.openSession();
			CategoryDao dao = ss.getMapper(CategoryDao.class);
			list = dao.queryAll();
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException("查询分类信息失败",e);
		}
		finally{
		   MybatisUtil.close(ss);
		}
		return list;
	}

	public Category queryCategoryByFirstId(Integer id) {
		SqlSession ss = null;
		Category c = null;
		try {			
			ss = MybatisUtil.openSession();
			CategoryDao dao = ss.getMapper(CategoryDao.class);
			c = dao.queryCategoryByFirstId(id);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException("根据一级分类id查询分类信息失败",e);
		}
		finally{
		   MybatisUtil.close(ss);
		}
		return c;
	}
  
}
