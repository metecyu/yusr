package com.metecyu.yusr.bmodel;

// Generated 2014-3-23 22:49:11 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.metecyu.yusr.model.User;

/**
 * User generated by hbm2java
 */
public class UserD extends User {
	private String deptid = "";
	private String deptName = "";
	private String userDeptRelid = "";
	private Integer userDeptOrderno;
	private String isMain;
	
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getUserDeptRelid() {
		return userDeptRelid;
	}
	public void setUserDeptRelid(String userDeptRelid) {
		this.userDeptRelid = userDeptRelid;
	}
	public Integer getUserDeptOrderno() {
		return userDeptOrderno;
	}
	public void setUserDeptOrderno(Integer userDeptOrderno) {
		this.userDeptOrderno = userDeptOrderno;
	}
	public String getIsMain() {
		return isMain;
	}
	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}

	
}