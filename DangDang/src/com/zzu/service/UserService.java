package com.zzu.service;

import java.io.IOException;

import com.zzu.entity.User;
/**
 * 用户信息service接口

 */
public interface UserService {
	/**
	 * 用户注册的接口
	 */
	public void regist(String email,String nickname,String password,String confirmpwd) throws IOException;
	/**
	 * 用户登录的接口
	 */
	public void login(String email,String password);
	/**
	 * 修改用户信息的接口
	 */
	public void update(String email);
	/**
	 * 查询用户信息的接口
	 */
	public User query(String email);
}
