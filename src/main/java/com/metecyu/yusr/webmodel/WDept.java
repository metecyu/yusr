package com.metecyu.yusr.webmodel;

// Generated 2014-3-23 22:49:11 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Dept generated by hbm2java
 */
public class WDept implements java.io.Serializable {

	private String snum; //序号
	private String id;
	private String deptname;
	private String peoples;
	private String monitor;
	private String iseffect;
	private String type;
	
	
	public String getSnum() {
		return snum;
	}


	public void setSnum(String snum) {
		this.snum = snum;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDeptname() {
		return deptname;
	}


	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}


	public String getPeoples() {
		return peoples;
	}


	public void setPeoples(String peoples) {
		this.peoples = peoples;
	}


	public String getMonitor() {
		return monitor;
	}


	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}


	public String getIseffect() {
		return iseffect;
	}


	public void setIseffect(String iseffect) {
		this.iseffect = iseffect;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	


	public WDept() {
	}

	
}
