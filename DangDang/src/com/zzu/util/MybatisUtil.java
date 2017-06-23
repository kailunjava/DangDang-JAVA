package com.zzu.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	//读取配置文件
	private static SqlSessionFactory factory = null;
	static{
		Reader reader = null;
		try {
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			factory = builder.build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(reader != null){
				try {reader.close();} catch (IOException e) {e.printStackTrace();}
			}
		}
	}
	
	//添加线程�?��变量解决多用户并发?
	private static final ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();
	
	//获得session回话
	public static SqlSession openSession(){
		SqlSession session = tl.get();
		if(session == null){
			session = factory.openSession();
			tl.set(session);
		}
		return session;
	}
	
	//释放资源
	public static void close(SqlSession session){
		if(session != null){
			session.commit();
			session.close();
			tl.remove();
		}
	}

}
