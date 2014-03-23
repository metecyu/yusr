package com.metecyu.flow.service;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.metecyu.yusr.dao.DeptDAO;
import com.metecyu.yusr.model.Dept;
import com.metecyu.yusr.service.DeptService;



@ContextConfiguration(locations={"/applicationContext.xml","/hibernate.cfg.xml"})
public class DeptServiceTest extends AbstractJUnit4SpringContextTests {
	private static final Logger log = Logger.getLogger(DeptServiceTest.class);
	
	@Resource
	private DeptService deptService;
	
	@Resource
	private DeptDAO deptDAO; 
	
	
	@Test
	@Rollback(value=false)  
	public void testSave(){
		// 如果有此部门 先删除
		String deptid = "bgs4";
		Dept deptHis = deptDAO.findById(deptid);
		if(deptHis!=null){
			deptDAO.delete(deptHis);	
		}		
		Dept dept = deptService.addDept(deptid,"办公室","发改委办公室","1");
		log.info("部门id:"+dept.getId());
		
	}
	
	@Test
	public void findAllDept(){
		List list = deptService.findAllDept();
		log.info("部门数量:"+list.size());
		Assert.assertTrue(list.size()>0);
		
	}
	
}