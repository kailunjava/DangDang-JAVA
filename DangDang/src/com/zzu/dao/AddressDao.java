package com.zzu.dao;

import java.util.List;

import com.zzu.entity.Address;

public interface AddressDao {
   /**
    * 添加新的收货地址
    */
   public void insertAddress(Address a);
   /**
    * 根据用户id查询用户地址信息
    */
   public List<Address> queryAll(Integer id);
}
