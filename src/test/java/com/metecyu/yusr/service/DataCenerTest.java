package com.metecyu.yusr.service;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.metecyu.yusr.dao.DataCenter;
import com.metecyu.yusr.dao.DeptDAO;


@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class DataCenerTest extends AbstractTransactionalJUnit4SpringContextTests {
	private static final Logger log = Logger.getLogger(DataCenerTest.class);
	
	@Resource
	private DeptService deptService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private DeptDAO deptDAO; 
	@Resource
	DataCenter dataCenter;
	
	
	@Rollback(value=false)  
	public void addTestDate() throws Exception{
		// dataCenter.addTestData();
		deptService.addDept("dept1","部门1", "部门1", "1");
		userService.addUser("yh1","", "用户1", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept1");
		userService.addUser("yh2","", "用户2", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept1");
		
		deptService.addDept("dept2","部门2", "部门2", "1");
		userService.addUser("yh3","", "用户3", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept2");
		userService.addUser("yh4","", "用户4", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept2");
		// 用户3 同时在2个部门
		deptService.addNoMainDeptUser("dept1", "yh3");
		
	}
	
	/**
	 * 清空所有数据
	 * @throws Exception
	 */
	@Test
	@Rollback(value=false)  
	public void delteAllDate() throws Exception{
		dataCenter.deleteAllUserDeptRel();
		dataCenter.deleteAllDept();
		dataCenter.deleteAllUser();
	}
	
	
	
}