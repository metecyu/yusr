package com.metecyu.yusr.service;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.metecyu.yusr.dao.DeptDAO;
import com.metecyu.yusr.model.User;


@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
@ContextConfiguration(locations={"/applicationContext.xml","/hibernate.cfg.xml"})
public class DataCenerTest extends AbstractTransactionalJUnit4SpringContextTests {
	private static final Logger log = Logger.getLogger(DataCenerTest.class);
	
	@Resource
	private DeptService deptService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private DeptDAO deptDAO; 
	
	
	@Test
	@Rollback(value=false)  
	public void addTestDate() throws Exception{
		String userid = "yzp";
		deptService.addDept("dept1","部门1", "部门1", "1");
		deptService.addDept("dept2","部门2", "部门2", "1");
		deptService.addDept("dept3","部门3", "部门3", "1");
		userService.addUser(userid, "张三", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept1");
		userService.addUser(userid, "李四", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept1");
	}
	
	
	
	
}