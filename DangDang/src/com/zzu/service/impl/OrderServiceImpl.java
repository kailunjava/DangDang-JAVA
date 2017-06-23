package com.zzu.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.zzu.dao.OrderDao;
import com.zzu.entity.Order;
import com.zzu.entity.OrderItem;
import com.zzu.service.OrderService;
import com.zzu.util.MybatisUtil;

public class OrderServiceImpl implements OrderService{
    /**
     * 新建订单
     */
	public void insertOrder(Order o) {
		SqlSession ss = null;
		ss = MybatisUtil.openSession();
		OrderDao dao = ss.getMapper(OrderDao.class);
		dao.insertOrder(o);
		MybatisUtil.close(ss);
		
	}
    /**
     * 新建订单商品详情
     */
	public void insertOrderItem(OrderItem oi) {
		SqlSession ss = null;
		ss = MybatisUtil.openSession();
		OrderDao dao = ss.getMapper(OrderDao.class);
		dao.insertOrderItem(oi);
		MybatisUtil.close(ss);
		
	}

}
