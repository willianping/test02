package com.bdqn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	//������ݿ�����
	public static Connection getConn() throws Exception{
		Connection conn=null;
		try {
			//����������(�ɸ����ݿ⳧���ṩjar��)
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "bdqnj16", "bdqn");
		} catch (ClassNotFoundException e) {
			System.out.println("û����Ӧ������!");
			throw e;
		} catch (SQLException e) {
			System.out.println("�������ݿ�ʧ��!");
			throw e;
		}
		return conn;
	
	}
	//�ر����ݿ�
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
