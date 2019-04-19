package com.bdqn.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.JdbcType;

public class MybatisUtils {
	private static SqlSessionFactory sqlSessionFactory = null;
	//加载
	static {
		try {
			InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory =new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			e.printStackTrace();
			// 静态初始化代码块中唯一可以抛出的错误
			throw new ExceptionInInitializerError(e);
		}
	}
	
	//获得SqlSession对象
	public static SqlSession getSqlSession(){
		// openSession方法传入true(默认):表示关闭事务控制，自动提交。false:开启事务控制,手动控制事务
		return sqlSessionFactory.openSession(false);
	}
	
	//关闭SqlSession对象
	public static void closeSqlSession(SqlSession session){
		if(session!=null){
			session.close();
			session=null;
		}
	}
	
	// 不要轻易私有化构造方法
	public MybatisUtils(){
	}	
	/*
	 * 工具方法不要处理异常. 
	 */
	public static void reBuild(String resources) throws Exception{
		sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsStream(resources));
	}
}
