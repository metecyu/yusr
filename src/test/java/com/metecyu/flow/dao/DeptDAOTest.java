package com.metecyu.flow.dao;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.metecyu.yusr.dao.DeptDAO;
import com.metecyu.yusr.model.Dept;



@ContextConfiguration(locations={"/applicationContext.xml","/hibernate.cfg.xml"})
public class DeptDAOTest extends AbstractJUnit4SpringContextTests {
	private static final Logger log = Logger.getLogger(DeptDAOTest.class);
	
	@Resource
	private DeptDAO deptDAO; 
	@Test
	@Rollback(value=false)  
	public void testSave(){
		
		//Dept dept = deptDAO.addDept("办公室","发改委办公室","1");
		//log.info("部门id"+dept.getId());
		//Assert.assertTrue(true);
		//Assert.assertTrue(!"".equals(flowdef.getId()));
	}

	
}