package com.zzu.dao;

import com.zzu.entity.Order;
import com.zzu.entity.OrderItem;

public interface OrderDao {
    /**
     * 向订单数据库持久化数据
     */
	public void insertOrder(Order o);
	/**
	 * 向订单项目中持久化数据
	 */
	public void insertOrderItem(OrderItem oi);
}
