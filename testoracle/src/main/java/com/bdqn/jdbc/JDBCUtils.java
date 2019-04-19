package com.bdqn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	//获得数据库连接
	public static Connection getConn() throws Exception{
		Connection conn=null;
		try {
			//加载驱动类(由各数据库厂商提供jar包)
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "bdqnj16", "bdqn");
		} catch (ClassNotFoundException e) {
			System.out.println("没有相应的驱动!");
			throw e;
		} catch (SQLException e) {
			System.out.println("连接数据库失败!");
			throw e;
		}
		return conn;
	
	}
	//关闭数据库
	public static void closeConn(ResultSet rs,Statement stmt,Connection conn) throws Exception{
		if(rs!=null){
			rs.close();
		}
		if(stmt!=null){
			stmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
	
}
