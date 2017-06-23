package com.zzu.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.zzu.dao.AddressDao;
import com.zzu.dao.CategoryDao;
import com.zzu.dao.OrderDao;
import com.zzu.dao.ProductDao;
import com.zzu.dao.UserDao;
import com.zzu.entity.Address;
import com.zzu.entity.CartItem;
import com.zzu.entity.Category;
import com.zzu.entity.Order;
import com.zzu.entity.OrderItem;
import com.zzu.entity.Product;
import com.zzu.entity.User;
import com.zzu.service.CartService;
import com.zzu.service.ProductService;
import com.zzu.service.impl.ProductServiceImpl;
import com.zzu.util.MybatisUtil;


public class UserTest {
  
   @Test
   public void xiugai(){
	   SqlSession ss =null;
	   ss = MybatisUtil.openSession();
	   UserDao dao = ss.getMapper(UserDao.class);
	   //User u = new User(0,"1","1","1",0,null,null,null,null);
	   @SuppressWarnings("unused")
	User u = dao.query("123");
	   //System.out.println(u);
   }
   @Test
   public void chaxun(){
	   SqlSession ss =null;
	   ss = MybatisUtil.openSession();
	   CategoryDao dao = ss.getMapper(CategoryDao.class);
	   List<Category> list = dao.queryAll();
	   @SuppressWarnings("unused")
	Category c1 = new Category();
	   
	   for(@SuppressWarnings("unused") Category c:list){
		   ///System.out.println(c);
	   }
   }
   @Test
   public void chaxun10(){
	   SqlSession ss =null;
	   ss = MybatisUtil.openSession();
	   CategoryDao dao = ss.getMapper(CategoryDao.class);
	   List<Category> list = dao.queryAll();
	   System.out.println(list);
   }
   @Test
   public void chaxun2(){
	   SqlSession ss =null;
	   ss = MybatisUtil.openSession();
	   CategoryDao dao = ss.getMapper(CategoryDao.class);
	   List<Category> list = dao.queryAll();
	   System.out.println(list);
	   
	   System.out.println("--------");
	   List<Category> list2 = dao.queryAll();
	   System.out.println(list2);
   }

   @Test
   public void xiangxi(){
	   SqlSession ss = null;
	   ss = MybatisUtil.openSession();
	   ProductDao dao = ss.getMapper(ProductDao.class);
	   @SuppressWarnings("unused")
	List<Integer> list = new ArrayList<Integer>();

	   List<Product> list2 = dao.queryProductByOne(7);
	   for(Product p:list2){
		   System.out.println(p);
	   }
   }
   @Test
   public void xiangxi2(){
	   SqlSession ss = null;
	   ss = MybatisUtil.openSession();
	   ProductDao dao = ss.getMapper(ProductDao.class);
	   @SuppressWarnings("unused")
	List<Integer> list = new ArrayList<Integer>();

	   List<Product> list2 = dao.queryProductByTwo(9);
	   for(Product p:list2){
		   System.out.println(p);
	   }
   }
   @Test
   public void xiangxi3(){
	   SqlSession ss = null;
	   ss = MybatisUtil.openSession();
	   AddressDao dao = ss.getMapper(AddressDao.class);
	   Address a = new Address(null,"张三","郑州","121",4545,443,1);
	   dao.insertAddress(a);
   }
   @Test
   public void xiangxi4(){
	   SqlSession ss = null;
	   ss = MybatisUtil.openSession();
	   AddressDao dao = ss.getMapper(AddressDao.class);
	   List<Address> list= dao.queryAll(1222);
	   for(Address a:list){
		   System.out.println(a);
	   }
   }
   @Test
   public void xiangxi5(){
	   SqlSession ss = null;
	   ss = MybatisUtil.openSession();
	   OrderDao dao = ss.getMapper(OrderDao.class);
	   Order o = new Order(null,1222,null,null,null,"好",500.00,"长痘","郑州","12",12,12);
	   dao.insertOrder(o);
	   
   }
   @Test
   public void xiangxi6(){
	   SqlSession ss = null;
	   ss = MybatisUtil.openSession();
	   OrderDao dao = ss.getMapper(OrderDao.class);
	   OrderItem oi = new OrderItem(null,1,1,"1",500.00,5,5.00);
	   dao.insertOrderItem(oi);
	   
   }
   @Test
   public void id(){
	    @SuppressWarnings("unused")
		CartService cs = new CartService();
	    CartItem cartItem = new CartItem();
	    Map<Integer,CartItem> cartItems = new HashMap<Integer,CartItem>();
        //cartItems = cs.addCartItem(2, 0);
	    ProductService s = new ProductServiceImpl();
		Product p = s.queryProductById(1);
	    cartItem.setProduct(p);
	    cartItem.setCount(10);
	    cartItem.setIsDeleted(1);
	       cartItems.put(1, cartItem);
		   cartItems.put(2, cartItem);
		   cartItems.put(3, cartItem);
		   double zonghe = 0;
        for (Integer key : cartItems.keySet()) {
        	double sum = (cartItems.get(key).getProduct().getFixed_price()-cartItems.get(key).getProduct().getDang_price())
 				   *(cartItems.get(key).getCount());
 		   zonghe+=sum;
        	
    	   }
        System.out.println(zonghe);
   }
   @Test
   public void id2(){
	   ProductService s = new ProductServiceImpl();
	   Product p = s.queryProductById(1);
	   System.out.println(p);
   }
   @Test
   public void addCartItem(){	   
	   Map<Integer,String> cartItems = new HashMap<Integer,String>();
	   
	   cartItems.put(1, "123");
	   cartItems.put(2, "123");
	   cartItems.put(3, "123");
	   if(cartItems.containsKey(1)) {
		    
			@SuppressWarnings("unused")
			String cartItem1=cartItems.get(1);
			//System.out.println(cartItem);
			//cartItem.setCount(count+1);
			//if(cartItem.isDeleted()==true) {
				//cartItem.setDeleted(false);				
			//}
	   }
	   //第一种：普遍使用，二次取值
	   //System.out.println("通过Map.keySet遍历key和value：");
	  /* for (Integer key : map.keySet()) {
	    System.out.println("key= "+ key + " and value= " + map.get(key));
	   }*/
	   
	   //第二种
	   //System.out.println("通过Map.entrySet使用iterator遍历key和value：");
	   //Iterator<Entry<Integer, String>> it = map.entrySet().iterator();
	   //while (it.hasNext()) {
	   // Entry<Integer, String> entry = it.next();
	   // System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
	  // }
	   
	   //第三种：推荐，尤其是容量大时
	  // System.out.println("通过Map.entrySet遍历key和value");
	  // for (Entry<Integer, String> entry : map.entrySet()) {
	  //  System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
	  // }

	   //第四种
	   //System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
	   //for (String v : map.values()) {
	   // System.out.println("value= " + v);
	  // }
	   }
}
