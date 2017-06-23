package com.zzu.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.zzu.entity.Address;
import com.zzu.entity.CartItem;
import com.zzu.entity.Order;
import com.zzu.entity.OrderItem;
import com.zzu.entity.User;
import com.zzu.service.AddressService;
import com.zzu.service.OrderService;
import com.zzu.service.impl.AddressServiceImpl;
import com.zzu.service.impl.OrderServiceImpl;

public class OrderAction {
	private Address address;
	private List<Address> addresses;// 将数据库中获取的地址信息存入list

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	private AddressService as = new AddressServiceImpl();// 获得地址信息的service层
	private OrderService os = new OrderServiceImpl();// 获得订单的service层

	/**
	 * 从订单结算跳转到选择地址
	 */
	public String toAddress() {
		// 从session中获取用户信息
		User u = (User) ActionContext.getContext().getValueStack()
				.findValue("#session.user");
		
		// 根据用户id查询与用户相关的所有地址 dd_address
		addresses = as.query(u.getId());
		
		return "yes";
	}
	/**
	 * 添加新地址
	 */
	public String addAddress() {
		@SuppressWarnings("unused")
		User u = (User) ActionContext.getContext().getValueStack()
				.findValue("#session.user");
		try {
			as.insertAddress(address);
		} catch (Exception e) {
			
			return "no";
		}
		return "yes";
	}

	/**
	 * 将订单数据持久化到数据库
	 */
	public String addOrder() {
		// 如果用户没有选择地址则返回异常页面
		if (address == null) {
			return "no";
		}
		// session获取cart，
		@SuppressWarnings("unchecked")
		Map<Integer, CartItem> cartItems = (Map<Integer, CartItem>) ActionContext
				.getContext().getValueStack()
				.findValue("#session.cart.cartItems");
		Double totalPrice = (Double) ActionContext.getContext().getValueStack()
				.findValue("#session.cart.totalPrice");

		// 一个cart 对应一个订单
		// 调用OrderService 中下单方法，把cart信息持久化到数据库中，删除cart信息
		User u = (User) ActionContext.getContext().getValueStack()
				.findValue("#session.user");
		
		Order o = new Order(null, u.getId(), null, null, null, "暂无描述",
				totalPrice, address.getReceive_name(),
				address.getFull_address(), address.getPostal_code(),
				address.getMobile(), address.getPhone());
		os.insertOrder(o);
		ActionContext.getContext().getValueStack()
				.setValue("#session.oid", o.getId() + 1);
		// o.getId()+1,mybatis获取插入订单表返回的序列生成的id
		for (CartItem c : cartItems.values()) {
			OrderItem oi = new OrderItem(null, o.getId() + 1, c.getProduct()
					.getId(), c.getProduct().getProduct_name(), c.getProduct()
					.getDang_price(), c.getCount(), c.getCount()
					* c.getProduct().getDang_price());
			os.insertOrderItem(oi);
		}
		
		return "yes";
	}
}
