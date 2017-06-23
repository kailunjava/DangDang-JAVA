package com.zzu.service;


import java.util.HashMap;

import java.util.Map;
import com.zzu.entity.CartItem;
import com.zzu.service.impl.ProductServiceImpl;
import com.zzu.service.ProductService;

public class CartService {
	private double totalPrice;
	private double savePrice;

	// 集合属性 CartItem对象:产品信息，购买数量，购买状态
	private Map<Integer, CartItem> cartItems = new HashMap<Integer, CartItem>();

	public Map<Integer, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<Integer, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	private ProductService ps = new ProductServiceImpl();

	// 添加商品到购物车

	public void addCartItem(CartItem c) {
		// 根据productId在cartItems查询cartItem
		// 如果有的话，更新cartItem属性
		// 如果cartItem属性为已删除，则修改状态为未删除，并更新数量
		// 如果不存在相应的cartItem，根据productId查询product构建cartItem并将其存在cartItems中
		if (cartItems.containsKey(c.getProduct().getId())) {
			if (cartItems.containsKey(c.getProduct().getId())) {
				c = cartItems.get(c.getProduct().getId());
				c.setCount(c.getCount() + 1);
				if (c.getIsDeleted() == 1) {
					c.setIsDeleted(0);

				}
			}
		}
		c.setProduct(ps.queryProductById(c.getProduct().getId()));
		cartItems.put(c.getProduct().getId(), c);

	}

	// 修改购物车里的商品
	public void modifyCartItem(CartItem c) {
		if (cartItems.containsKey(c.getProduct().getId())) {
			if (c.getCount() <= 0)
				c.setCount(1);
			cartItems.get(c.getProduct().getId()).setCount(c.getCount());
		}

	}

	// 移除购物车里的商品
	public void removeCartItem(CartItem c) {
		// 从cartItems里根据productId获取相应的cartItem
		// 修改cartItem的状态为已删除状态
		if (cartItems.containsKey(c.getProduct().getId())) {
			cartItems.get(c.getProduct().getId()).setIsDeleted(1);
		}

	}

	// 恢复购物车里的商品
	public void recoveryCartItem(CartItem c) {
		// 从cartItems里根据productId获取相应的cartItem
		// 修改cartItem的状态为未删除状态
		if (cartItems.containsKey(c.getProduct().getId())) {
			cartItems.get(c.getProduct().getId()).setIsDeleted(0);
		}

	}

	// 商品总计金额
	public double getTotalPrice() {
		// 遍历cartItems获取cartItem
		// 判断cartItem状态是否为未删除，如果状态正常则进行叠加
		totalPrice = 0;
		for (Integer key : cartItems.keySet()) {
			if (cartItems.get(key).getIsDeleted() == 0) {
				double price = cartItems.get(key).getProduct().getDang_price()
						* (cartItems.get(key).getCount());
				totalPrice += price;
			}
		}
		return totalPrice;
	}

	// 总计节省金额
	public double getSavePrice() {
		// 遍历cartItems获取cartItem
		// 判断cartItem状态是否为未删除，如果状态正常则进行叠加
		savePrice = 0;
		for (Integer key : cartItems.keySet()) {
			if (cartItems.get(key).getIsDeleted() == 0) {
				double price = (cartItems.get(key).getProduct()
						.getFixed_price() - cartItems.get(key).getProduct()
						.getDang_price())
						* (cartItems.get(key).getCount());
				savePrice += price;
			}
		}
		return savePrice;
	}
}
