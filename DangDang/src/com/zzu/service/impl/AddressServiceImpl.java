package com.zzu.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zzu.dao.AddressDao;
import com.zzu.entity.Address;
import com.zzu.service.AddressService;
import com.zzu.util.MybatisUtil;

public class AddressServiceImpl implements AddressService{
    /**
     * 新建地址
     */
	public void insertAddress(Address a) {
		SqlSession ss = null;
		ss = MybatisUtil.openSession();
		AddressDao dao = ss.getMapper(AddressDao.class);
		dao.insertAddress(a);
		MybatisUtil.close(ss);
	}
    /**
     * 根据用户id查询所有地址
     */
	public List<Address> query(Integer id) {
		SqlSession ss = null;
		ss = MybatisUtil.openSession();
		AddressDao dao = ss.getMapper(AddressDao.class);
		List<Address> list = dao.queryAll(id);
		MybatisUtil.close(ss);
		return list;
	}

}
