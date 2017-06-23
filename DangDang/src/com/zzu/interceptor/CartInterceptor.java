package com.zzu.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;

import com.zzu.service.CartService;

public class CartInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//获得值栈
		ValueStack vs = invocation.getStack();
		//判断session作用域中是否有购物车,如果没有,创建购物车对象
		if(vs.findValue("#session.cart") == null){
			vs.setValue("#session.cart", new CartService());
		}
		return invocation.invoke();
	}

}
