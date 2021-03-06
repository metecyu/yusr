package com.metecyu.yusr.model;

// Generated 2014-3-23 22:49:11 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Dept generated by hbm2java
 */
public class Dept implements java.io.Serializable {

	private String id;
	private String deptname;
	private String deptwholename;
	private String iseffect;
	private String type;
	private Integer orderno;
	private Set userDeptRels = new HashSet(0);
	private Set deptRoleRels = new HashSet(0);

	public Dept() {
	}

	public Dept(String id) {
		this.id = id;
	}

	public Dept(String id, String deptname, String deptwholename,
			String iseffect, String type, Integer orderno, Set userDeptRels,
			Set deptRoleRels) {
		this.id = id;
		this.deptname = deptname;
		this.deptwholename = deptwholename;
		this.iseffect = iseffect;
		this.type = type;
		this.orderno = orderno;
		this.userDeptRels = userDeptRels;
		this.deptRoleRels = deptRoleRels;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeptname() {
		return this.deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDeptwholename() {
		return this.deptwholename;
	}

	public void setDeptwholename(String deptwholename) {
		this.deptwholename = deptwholename;
	}

	public String getIseffect() {
		return this.iseffect;
	}

	public void setIseffect(String iseffect) {
		this.iseffect = iseffect;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getOrderno() {
		return this.orderno;
	}

	public void setOrderno(Integer orderno) {
		this.orderno = orderno;
	}

	public Set getUserDeptRels() {
		return this.userDeptRels;
	}

	public void setUserDeptRels(Set userDeptRels) {
		this.userDeptRels = userDeptRels;
	}

	public Set getDeptRoleRels() {
		return this.deptRoleRels;
	}

	public void setDeptRoleRels(Set deptRoleRels) {
		this.deptRoleRels = deptRoleRels;
	}

}
