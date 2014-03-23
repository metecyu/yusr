package com.metecyu.yusr.model;

// Generated 2014-3-23 22:49:11 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Role generated by hbm2java
 */
public class Role implements java.io.Serializable {

	private String id;
	private String rolename;
	private String rolesign;
	private String iseffect;
	private String type;
	private Integer orderno;
	private Set rolerels = new HashSet(0);

	public Role() {
	}

	public Role(String rolename, String rolesign, String iseffect, String type,
			Integer orderno, Set rolerels) {
		this.rolename = rolename;
		this.rolesign = rolesign;
		this.iseffect = iseffect;
		this.type = type;
		this.orderno = orderno;
		this.rolerels = rolerels;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRolesign() {
		return this.rolesign;
	}

	public void setRolesign(String rolesign) {
		this.rolesign = rolesign;
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

	public Set getRolerels() {
		return this.rolerels;
	}

	public void setRolerels(Set rolerels) {
		this.rolerels = rolerels;
	}

}
