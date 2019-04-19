package com.bdqn.mybatis;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.type.JdbcType;
import org.junit.After;
import org.junit.Before;


public class TestMybatis
{
	SqlSession sqlsession;
	IStudentDao sd;
	@After
	public void after(){
		//提交事务
		sqlsession.commit();
		//关闭SqlSession
		MybatisUtils.closeSqlSession(sqlsession);
	}
	
	@Before
	public void before(){
		//获得SqlSession
		sqlsession=MybatisUtils.getSqlSession();
		//获得接口的代理
		sd=sqlsession.getMapper(IStudentDao.class);
	}
	
	@org.junit.Test
	public void testMybatis() throws Exception{
		//封装分页过程参数(11个)
		Map<String,Object> map=new HashMap<String,Object>();
		//设置参数到集合
		map.put("currentpage", 2);
		map.put("pagesize", null);
		map.put("tablename", "tb_student");
		map.put("sqlwhere","");
		map.put("ordertype", 1);
		map.put("ordercolumn", "u_birthday");
		map.put("returncolumn", null);
		//调用存储过程
		sd.callProcedure(map);
		
		//获得返回值
		List<Student> list=(List<Student>) map.get("resultlist");
		BigDecimal countrecord=(BigDecimal)map.get("countrecord");
		BigDecimal totalpage=(BigDecimal) map.get("totalpage");
		String message=map.get("message").toString();
		
		//输出结果
		System.out.println("总记录数："+countrecord+",总页数:"+totalpage+",返回信息:"+message);
		System.out.println("-------------");
		for(Student stu:list){
			System.out.println(stu);
		}
		System.out.println("-------------");
		
		
	}
}
