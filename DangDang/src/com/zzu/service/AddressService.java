package com.zzu.service;

import java.util.List;

import com.zzu.entity.Address;

public interface AddressService {
    /**
     * 添加新的收货地址
     */
	public void insertAddress(Address a);
	/**
	 * 根据用户id查询收货地址信息
	 */
	public List<Address> query(Integer id);
}
