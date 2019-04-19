package com.bdqn.mybatis;

import java.util.Map;

public interface IStudentDao {
	//分页查询学生
	public void callProcedure(Map<String,Object> map);  
}
