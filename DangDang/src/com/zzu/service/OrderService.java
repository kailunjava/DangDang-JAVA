package com.zzu.service;

import com.zzu.entity.Order;
import com.zzu.entity.OrderItem;

public interface OrderService {
    /**
     * 向订单表中插入数据 
     */
	public void insertOrder(Order o);
	/**
	 * 向订单项目表插入数据
	 */
	public void insertOrderItem(OrderItem oi);
}
