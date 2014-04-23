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

import com.metecyu.yusr.bmodel.UserD;
import com.metecyu.yusr.dao.DeptDAO;


@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class UserServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
	private static final Logger log = Logger.getLogger(UserServiceTest.class);
	
	@Resource
	private DeptService deptService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private DeptDAO deptDAO; 
	
	
	@Test
	@Rollback(value=true)  
	public void testAdd() throws Exception{
		String userid = "yzp";
		deptService.addDept("dept1","部门1", "部门1", "1");
		userService.addUser(userid, "张三", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept1");
		userService.addUser(userid, "李四", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept1");
		
		List<UserD> userList = userService.findDeptUser("dept1");
		Assert.assertEquals(2, userList.size());
		
		Assert.assertEquals("张三",userList.get(0).getUsername());
	}
	
	@Test
	@Rollback(value=true)  
	public void testSave() throws Exception{
		String userid = "yzp";
		deptService.addDept("dept1","部门1", "部门1", "1");
		deptService.addDept("dept2","部门2", "部门2", "1");
		userService.addUser(userid,userid, "张三", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept1");
		List<UserD> userList = userService.findDeptUser("dept1");
		Assert.assertEquals(1, userList.size());
		// Assert.assertEquals("张三",userList.get(0).getUsername());
		
		// 修改部门
		userService.saveUser(userid,userid, "张三", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept2");
		userList = userService.findDeptUser("dept1");
		Assert.assertEquals(0, userList.size());

		userList = userService.findDeptUser("dept2");
		Assert.assertEquals(1, userList.size());
		
	}

	/*@Rollback(value=true)  
	public void findAllDept(){
		String deptid = "testDept4";
		Dept dept = deptService.addDept(deptid,"办公室","发改委办公室","1");
		List list = deptService.findAllDept();
		log.info("部门数量:"+list.size());
		Assert.assertTrue(list.size()>0);
	}
	*/
	
	
}