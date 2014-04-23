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
import com.metecyu.yusr.dao.DataCenter;
import com.metecyu.yusr.dao.DeptDAO;
import com.metecyu.yusr.model.Dept;
import com.metecyu.yusr.model.UserDeptRel;


@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class DeptServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
	private static final Logger log = Logger.getLogger(DeptServiceTest.class);
	
	@Resource
	private DeptService deptService;
	
	@Resource
	private DeptDAO deptDAO; 
	@Resource
	private DataCenter dataCenter;
	@Resource
	private UserService userService;

	@Rollback(value=true)  
	public void testSave(){
		// 如果有此部门 先删除
		String deptid = "testDept4";
		
		Dept dept = deptService.addDept(deptid,"办公室","发改委办公室","1");
		log.info("部门id:"+dept.getId());
		Assert.assertEquals(deptid,dept.getId());
	}
	

	@Rollback(value=true)  
	public void findAllDept(){
		String deptid = "testDept4";
		Dept dept = deptService.addDept(deptid,"办公室","发改委办公室","1");
		List list = deptService.findAllDept();
		log.info("部门数量:"+list.size());
		Assert.assertTrue(list.size()>0);
	}
	
	
	@Test
	@Rollback(value=true)  
	public void adjustDeptOrder(){
		deptService.addDept("dept1","","","1");
		deptService.addDept("dept2","","","1");
		deptService.addDept("dept3","","","1");
		
		deptService.adjustDeptOrder("dept3", "dept1");
		Assert.assertEquals("2", ""+deptService.findById("dept1").getOrderno());
		Assert.assertEquals("3", ""+deptService.findById("dept2").getOrderno());
		Assert.assertEquals("1", ""+deptService.findById("dept3").getOrderno());
	}
	
	@Test
	@Rollback(value=true)  
	public void adjustDeptOrder2(){
		deptService.addDept("dept1","","","1");
		deptService.addDept("dept2","","","1");
		deptService.addDept("dept3","","","1");
		
		deptService.adjustDeptOrder("dept3", "dept2");
		Assert.assertEquals("1", ""+deptService.findById("dept1").getOrderno());
		Assert.assertEquals("2", ""+deptService.findById("dept3").getOrderno());
		Assert.assertEquals("3", ""+deptService.findById("dept2").getOrderno());
	}
	
	@Test
	@Rollback(value=true)  
	public void adjustDeptOrder3(){
		deptService.addDept("dept1","","","1");
		deptService.addDept("dept2","","","1");
		deptService.addDept("dept3","","","1");
		deptService.addDept("dept4","","","1");
		
		deptService.adjustDeptOrder("dept3", "dept1");
		Assert.assertEquals("1", ""+deptService.findById("dept3").getOrderno());
		Assert.assertEquals("2", ""+deptService.findById("dept1").getOrderno());
		Assert.assertEquals("3", ""+deptService.findById("dept2").getOrderno());
		Assert.assertEquals("5", ""+deptService.findById("dept4").getOrderno());
	}
	
	
	@Test
	@Rollback(value=true)  
	public void adjustUserOrder() throws Exception{
		deptService.addDept("dept1","部门1", "部门1", "1");
		deptService.addDept("dept2","部门2", "部门2", "1");
		deptService.addDept("dept3","部门3", "部门3", "1");
		deptService.addDept("dept4","部门4", "部门4", "1");
		userService.addUser("yh1","", "用户1", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept1");
		userService.addUser("yh2","", "用户2", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept1");
		userService.addUser("yh3","", "用户3", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept1");
		userService.addUser("yh4","", "用户4", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept1");

		deptService.adjustUserOrder("dept1","yh3", "yh1");
		Assert.assertEquals("1", ""+deptDAO.findUserDeptRelByDeptId("dept1", "yh3").getOrderno());
		Assert.assertEquals("2", ""+deptDAO.findUserDeptRelByDeptId("dept1", "yh1").getOrderno());
		Assert.assertEquals("3", ""+deptDAO.findUserDeptRelByDeptId("dept1", "yh2").getOrderno());
		Assert.assertEquals("5", ""+deptDAO.findUserDeptRelByDeptId("dept1", "yh4").getOrderno());
		
	}
	
	
	@Test
	@Rollback(value=true)  
	public void addNoMainDeptUser() throws Exception{
		deptService.addDept("dept1","部门1", "部门1", "1");
		userService.addUser("yh1","", "用户1", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept1");
		userService.addUser("yh2","", "用户2", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept1");
		
		deptService.addDept("dept2","部门2", "部门2", "1");
		userService.addUser("yh3","", "用户3", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept2");
		userService.addUser("yh4","", "用户4", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept2");
		
		// 用户3 同时在2个部门
		deptService.addNoMainDeptUser("dept1", "yh3");
		UserDeptRel rel = this.deptService.findMainUserDeptRel("yh3");
		// 主办部门
		Assert.assertEquals("dept2", rel.getDept().getId());
		
		// 部门1 中有三个用户
		List<UserD> userList = this.userService.findDeptUser("dept1");
		Assert.assertEquals(3, userList.size());
		
		// 部门2 中有两个个用户
		userList = this.userService.findDeptUser("dept2");
		Assert.assertEquals(2, userList.size());
	}
	
	
	@Test
	@Rollback(value=true)  
	public void delUserDeptRel() throws Exception{
		deptService.addDept("dept1","部门1", "部门1", "1");
		userService.addUser("yh1","", "用户1", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept1");
		userService.addUser("yh2","", "用户2", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept1");
		
		deptService.addDept("dept2","部门2", "部门2", "1");
		userService.addUser("yh3","", "用户3", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept2");
		userService.addUser("yh4","", "用户4", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept2");
		
		// 用户3 同时在2个部门
		deptService.addNoMainDeptUser("dept1", "yh3");
		UserDeptRel rel = deptService.findMainUserDeptRel("yh3");

		// 部门1 中有三个用户
		List<UserD> userList = userService.findDeptUser("dept1");
		Assert.assertEquals(3, userList.size());		
		// 删除用户1，因为是主办部门所以应该不发生变化
		deptService.delUserDeptRel("dept1", "yh1");
		userList = userService.findDeptUser("dept1");
		Assert.assertEquals(3, userList.size());		
		
		// 删除用户1，因为是主办部门所以应该不发生变化
		deptService.delUserDeptRel("dept1", "yh3");
		userList = userService.findDeptUser("dept1");
		Assert.assertEquals(2, userList.size());		
				
		
		
	}
	
	
	
	
	
}