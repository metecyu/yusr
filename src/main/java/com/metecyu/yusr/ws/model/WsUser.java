package com.metecyu.yusr.ws.model;

// Generated 2014-3-23 22:49:11 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class WsUser implements java.io.Serializable {
	

	private String id;
	private String loginid;
	private String username;
	private String iseffect;
	private String password;
	private Date birthday;
	private String mobile;
	private String fjh;
	private String fphone;
	private String workstate;
	private String orgtype;
	private String sfzid;
	private String duty;
	private String dutydetails;

	

	




	public WsUser() {
	}

	

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginid() {
		return this.loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIseffect() {
		return this.iseffect;
	}

	public void setIseffect(String iseffect) {
		this.iseffect = iseffect;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFjh() {
		return this.fjh;
	}

	public void setFjh(String fjh) {
		this.fjh = fjh;
	}

	public String getFphone() {
		return this.fphone;
	}

	public void setFphone(String fphone) {
		this.fphone = fphone;
	}

	public String getWorkstate() {
		return this.workstate;
	}

	public void setWorkstate(String workstate) {
		this.workstate = workstate;
	}

	public String getOrgtype() {
		return this.orgtype;
	}

	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}

	public String getSfzid() {
		return this.sfzid;
	}

	public void setSfzid(String sfzid) {
		this.sfzid = sfzid;
	}

	public String getDuty() {
		return this.duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getDutydetails() {
		return this.dutydetails;
	}

	public void setDutydetails(String dutydetails) {
		this.dutydetails = dutydetails;
	}

	


}