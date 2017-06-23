package com.zzu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	public void destroy() {
		
		
	}

	public void doFilter(ServletRequest sreq ,ServletResponse sresp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)sreq;
		HttpServletResponse resp = (HttpServletResponse)sresp;
		HttpSession session = req.getSession();
		//获取session作用域的用户昵称
		Object obj = session.getAttribute("user");
		//如果用户没有登录，则跳转至登录页面
		if(obj == null){
			resp.sendRedirect("/DangDang/user/login_form.jsp");
		}else{
			chain.doFilter(sreq, sresp);
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
