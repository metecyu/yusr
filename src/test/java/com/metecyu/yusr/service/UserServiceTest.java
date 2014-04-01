package com.metecyu.yusr.service;
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
public class UserServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
	private static final Logger log = Logger.getLogger(UserServiceTest.class);
	
	@Resource
	private DeptService deptService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private DeptDAO deptDAO; 
	
	
	@Test
	@Rollback(value=false)  
	public void testSave() throws Exception{
		String userid = "yzp";
		deptService.addDept("dept1","部门1", "部门1", "1");
		userService.addUser(userid, "俞张平", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310113", "程序员", "程序开发", "dept1");
		userService.addUser(userid, "俞张平", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310113", "程序员", "程序开发", "dept1");
		
		//log.info("用户id:"+user.getId());
		//Assert.assertEquals(userid,user.getId());
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