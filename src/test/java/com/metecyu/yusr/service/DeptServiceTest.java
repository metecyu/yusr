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
import com.metecyu.yusr.model.Dept;


@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
@ContextConfiguration(locations={"/applicationContext.xml","/hibernate.cfg.xml"})
public class DeptServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
	private static final Logger log = Logger.getLogger(DeptServiceTest.class);
	
	@Resource
	private DeptService deptService;
	
	@Resource
	private DeptDAO deptDAO; 
	
	

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
	
	
}