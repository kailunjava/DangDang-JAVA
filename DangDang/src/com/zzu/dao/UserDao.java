package com.zzu.dao;



import com.zzu.entity.User;
/**
 * 用户信息Dao层
 */
public interface UserDao {
    /**
     * 插入新用户
     */
	public void insert(User u);
	/**
	 * 查询单个用户信息
	 */
	public User query(String email);
	/**
	 * 修改用户信息
	 */
	public void update(String email);
}
