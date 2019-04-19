package com.bdqn.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;
/**
 * 测试JDBC调用分页存储过程
 * @author Administrator
 *
 */
public class TestJDBC
{
	@org.junit.Test
	public void testJDBC() throws Exception{
		Connection conn = JDBCUtils.getConn();
		//存储过程语句
		String sql="{call pro_page(?,?,?,?,?,?,?,?,?,?,?)}";
		//CallableStatement执行存储过程
		CallableStatement  stmt=conn.prepareCall(sql);
		//设置输入参数值
		stmt.setInt(1, 1);
		stmt.setInt(2, 8);
		stmt.setString(3, "tb_student");
		stmt.setString(4, null);
		stmt.setInt(5, 1);
		stmt.setString(6, "u_birthday");
		stmt.setString(7, null);
		//注册输出类型
		stmt.registerOutParameter(8, OracleTypes.CURSOR);
		stmt.registerOutParameter(9, OracleTypes.NUMBER);
		stmt.registerOutParameter(10, OracleTypes.NUMBER);
		stmt.registerOutParameter(11, OracleTypes.VARCHAR);
		//执行过程
		stmt.execute();
		//获得输出参数值
		//获得结果集
		ResultSet rs = (ResultSet) stmt.getObject(8);
		//总记录数
		int countrecord=stmt.getInt(9);
		//总页数
		int totalpage=stmt.getInt(10);
		//返回信息
		String message=stmt.getString(11);
		
		System.out.println("总记录数："+countrecord+",总页数:"+totalpage+",返回信息:"+message);
		System.out.println("-------------");
		while(rs.next()){
			String name=rs.getString("u_name");
			System.out.println(name);
		}
		System.out.println("-------------");
		
		JDBCUtils.closeConn(rs, stmt, conn);
	}
}
