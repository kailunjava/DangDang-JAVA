package com.zzu.service.impl;

import java.util.List;


import org.apache.ibatis.session.SqlSession;

import com.zzu.dao.ProductDao;
import com.zzu.entity.Product;
import com.zzu.service.ProductService;
import com.zzu.util.MybatisUtil;



public class ProductServiceImpl implements ProductService{


	
	public Product queryProductById(Integer id) {
		SqlSession session = MybatisUtil.openSession();
		
		ProductDao pd = session.getMapper(ProductDao.class);
		Product p = pd.queryProductById(id);
		MybatisUtil.close(session);
		return p;
	}
	public List<Product> queryTuiJian() {
		SqlSession ss = null;
		List<Product> list = null;
		try {			
			ss = MybatisUtil.openSession();
			ProductDao dao = ss.getMapper(ProductDao.class);
			list = dao.queryTuiJian();
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException("查询编辑推荐失败",e);
		}
		finally{
		   MybatisUtil.close(ss);
		}
		return list;
	}
	public List<Product> queryNew() {
		SqlSession ss = null;
		List<Product> list = null;
		try {
			ss = MybatisUtil.openSession();
			ProductDao dao = ss.getMapper(ProductDao.class);
			list = dao.queryNew();
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException("最新上架图书service层出错",e);
		}
		finally{
			MybatisUtil.close(ss);
		}
		return list;
	}
	public List<Product> queryHot() {
		SqlSession ss = null;
		List<Product> list = null;
		try {
			ss = MybatisUtil.openSession();
			ProductDao dao = ss.getMapper(ProductDao.class);
			list = dao.queryHot();
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException("热销图书service层出错",e);
		}
		finally{
			MybatisUtil.close(ss);
		}
		return list;
	}
	public List<Product> queryProductHotBorad() {
		SqlSession ss = null;
		List<Product> list = null;
		try {
			ss = MybatisUtil.openSession();
			ProductDao dao = ss.getMapper(ProductDao.class);
			list = dao.queryProductHotBorad();
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException("新书热卖图书service层出错",e);
		}
		finally{
			MybatisUtil.close(ss);
		}
		return list;
	}
	public List<Product> queryProductByTwo(Integer id) {
		SqlSession ss = null;
		List<Product> list = null;
		try {
			ss = MybatisUtil.openSession();
			ProductDao dao = ss.getMapper(ProductDao.class);
			list = dao.queryProductByTwo(id);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException("查询二级分类所属图书出错",e);
		}
		finally{
			MybatisUtil.close(ss);
		}
		return list;
	}
	public List<Product> queryProductByOne(Integer id) {
		SqlSession ss = null;
		List<Product> list = null;
		try {
			ss = MybatisUtil.openSession();
			ProductDao dao = ss.getMapper(ProductDao.class);
			list = dao.queryProductByOne(id);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException("查询一级分类所属图书出错",e);
		}
		finally{
			MybatisUtil.close(ss);
		}
		return list;
	}
	
	
}
