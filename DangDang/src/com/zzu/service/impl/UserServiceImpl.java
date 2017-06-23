package com.zzu.service.impl;



import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;

import com.zzu.dao.UserDao;
import com.zzu.entity.User;
import com.zzu.service.UserService;

import com.zzu.util.MybatisUtil;
/**
 * 用户信息service层
 */


public class UserServiceImpl implements UserService {
    /**
     * 用户注册
     * 
     */	
	public void regist(String email, String nickname, String password,
			String confirmpwd)  {
		SqlSession ss = null;
	
		try {		
			ss = MybatisUtil.openSession();				
			UserDao ud = ss.getMapper(UserDao.class);
			//判断两次输入密码是否一致
			if(!password.equals(confirmpwd)){
				throw new RuntimeException("两次输入密码不一致");
			}
			//将登录邮箱和密码加密
			String md5email = DigestUtils.md5Hex(email);
			String md5password = DigestUtils.md5Hex(password);
			String md5 = DigestUtils.md5Hex(md5email+md5password);
			//创建User对象存入数据
			User u = new User(null,email,nickname,md5,null,null,null,null);
			//调用dao层向数据库插入数据
			ud.insert(u);
			
		} catch (Exception e) {			
			e.printStackTrace();
			//提示异常信息
			
			throw new  RuntimeException("注册用户失败",e);			
		}
		finally{
			MybatisUtil.close(ss);
		}
					
	}
    /**
     * 用户登录
     */
	public void login(String email, String password) {
		SqlSession ss = null;
		try {
			ss = MybatisUtil.openSession();
			UserDao dao = ss.getMapper(UserDao.class);
			User user = dao.query(email);
			//判断用户是否为空
			if (user == null)
				throw new RuntimeException("用户名密码错误");
			// 用相同的加密方式判断密码是否一致
			String md5email = DigestUtils.md5Hex(email);
			String md5password = DigestUtils.md5Hex(password);
			String md5 = DigestUtils.md5Hex(md5email+md5password);	
			
			if (!md5.equals(user.getPassword()))
				throw new RuntimeException("用户名密码错误");
			
		} catch (Exception e) {			
			e.printStackTrace();
			
			//提示异常信息
			throw new RuntimeException("用户登录失败",e);
		}
		finally{
			MybatisUtil.close(ss);
		}
	}
   /**
    * 修改用户信息
    */
	public void update( String email) {
		SqlSession ss = null;
		try {
			ss = MybatisUtil.openSession();
			UserDao dao = ss.getMapper(UserDao.class);
			dao.update( email);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			throw new RuntimeException("修改用户信息失败");
		}
		finally{
			MybatisUtil.close(ss);
		}
	}
	/**
	 * 查询用户所有信息
	 */
public User query(String email) {
	SqlSession ss = null;
	User user;
	try {
		ss = MybatisUtil.openSession();
		UserDao dao = ss.getMapper(UserDao.class);
		user = dao.query(email);
		
		
	} catch (Exception e) {
		
		e.printStackTrace();
		
		throw new RuntimeException("查询用户信息失败",e);
	}
	finally{		
		MybatisUtil.close(ss);
		
	}
	return user;
			
}
	
	
}
