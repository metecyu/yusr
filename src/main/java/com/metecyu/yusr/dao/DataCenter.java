package com.metecyu.yusr.dao;
import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.metecyu.yusr.service.DeptService;
import com.metecyu.yusr.service.UserService;

@Repository
public class DataCenter extends HibernateDaoSupport {
	private static final Logger log = LogManager
			.getLogger(DataCenter.class);
	
	@Resource
	private DeptService deptService;
	
	@Resource
	private UserService userService; 
	public void addTestData() throws Exception{
		deptService.addDept("dept1","部门1", "部门1", "1");
		deptService.addDept("dept2","部门2", "部门2", "1");
		deptService.addDept("dept3","部门3", "部门3", "1");
		deptService.addDept("dept4","部门4", "部门4", "1");
		userService.addUser("", "用户1", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept1");
		userService.addUser("", "用户2", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept1");
		userService.addUser("", "用户3", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept1");
		userService.addUser("", "用户4", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept1");

	}
	/**
	 * 保存	
	 */
	public void deleteAllUserDeptRel() {
		
        StringBuffer sb=new StringBuffer();
        sb.append("delete UserDeptRel rel");  
        int count = getSession().createQuery(sb.toString()).executeUpdate();   
        
	}
	public void deleteAllDept() {
        StringBuffer sb=new StringBuffer();
        sb.append("delete Dept dept");  
        int count = getSession().createQuery(sb.toString()).executeUpdate();
	}
	public void deleteAllUser() {
        StringBuffer sb=new StringBuffer();
        sb.append("delete User user");  
        int count = getSession().createQuery(sb.toString()).executeUpdate();
	}
	
	
	
	
	
	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
}