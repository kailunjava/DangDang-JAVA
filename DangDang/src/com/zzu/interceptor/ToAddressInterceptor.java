package com.zzu.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;

public class ToAddressInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//获得值栈
		ValueStack vs = invocation.getStack();
		//判断session作用域是否有用户信息
		if (vs.findValue("#session.user.nickname") == null) {
			return "error";
		}
		return invocation.invoke();
	}
}
