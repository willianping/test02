package com.bdqn.mybatis;

import java.io.Serializable;
import java.sql.Date;

public class Student implements Serializable{
	private Integer uid;
	private String uname;
	private String ugender;
	private Date birthday;
	private String udesc;
	public Integer getUid() {
		return uid;
	}
	@Override
	public String toString() {
		return "Student [uid=" + uid + ", uname=" + uname + ", ugender="
				+ ugender + ", birthday=" + birthday + ", udesc=" + udesc + "]";
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUgender() {
		return ugender;
	}
	public void setUgender(String ugender) {
		this.ugender = ugender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getUdesc() {
		return udesc;
	}
	public void setUdesc(String udesc) {
		this.udesc = udesc;
	}
	
	
}
