package com.zzu.action;

import com.opensymphony.xwork2.ActionContext;
import com.zzu.entity.CartItem;
import com.zzu.service.CartService;

public class CartAction {
	private Integer id;// map的key：所属商品id

	private Integer count = 1;// 用户选择购物图书的数量

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	private CartService cs;// 购物车service层

	/**
	 * 向购物车中添加新商品
	 */
	public String addCartItem() {
		// 获得值栈，从值栈中获取session作用域中cart对象
		cs = (CartService) ActionContext.getContext().getValueStack()
				.findValue("#session.cart");
		cs.addCartItem(new CartItem(id, count));
		return "yes";
	}

	/**
	 * 从购物车中移除商品
	 */
	public String removeCartItem() {
		// 获得值栈，从值栈中获取session作用域中cart对象
		cs = (CartService) ActionContext.getContext().getValueStack()
				.findValue("#session.cart");
		cs.removeCartItem(new CartItem(id, count));
		return "yes";
	}

	/**
	 * 修改购物车中的商品,主要修改数量
	 */
	public String modifyCartItem() {
		cs = (CartService) ActionContext.getContext().getValueStack()
				.findValue("#session.cart");
		cs.modifyCartItem(new CartItem(id, count));
		return "yes";
	}

	/**
	 * 从已删除列表将商品恢复至购物车
	 */
	public String recoveryCartItem() {
		cs = (CartService) ActionContext.getContext().getValueStack()
				.findValue("#session.cart");
		cs.recoveryCartItem(new CartItem(id, count));
		return "yes";
	}

}
