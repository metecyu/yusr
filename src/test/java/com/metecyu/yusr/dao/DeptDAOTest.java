package com.metecyu.yusr.dao;
import javax.annotation.Resource;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.metecyu.yusr.model.UserDeptRel;
import com.metecyu.yusr.service.DeptService;
import com.metecyu.yusr.service.UserService;

@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)  
@ContextConfiguration(locations={"/applicationContext.xml"})
public class DeptDAOTest  extends AbstractTransactionalJUnit4SpringContextTests  {
	private static final Logger log = Logger.getLogger(DeptDAOTest.class);
	
	@Resource
	private DeptDAO deptDAO; 
	@Resource
	DeptService deptService;
	@Resource
	private UserService userService;
	

	
	
	@Test
	@Rollback(value=true)  
	public void testGetNewId(){
		String deptid = "testDept";
		String newDeptid = deptDAO.getNewDeptid(deptid);
		Assert.assertEquals("和原id相同",newDeptid, deptid); 
		
		deptService.addDept(deptid,"测试部门","测试部门","1");
		newDeptid = deptDAO.getNewDeptid(deptid);
		Assert.assertEquals("第一次id重复,编号为01",newDeptid, deptid+"@01"); 
		
		
		deptService.addDept(deptid+"@01","测试部门@01","","1");
		deptService.addDept(deptid+"@02","测试部门@02","","1");
		deptService.addDept(deptid+"@03","测试部门@03","","1");
		newDeptid = deptDAO.getNewDeptid(deptid);
		Assert.assertEquals("多条id重复,编号为当前末尾编号加1",newDeptid, deptid+"@04");
		
		deptService.addDept(deptid+"@20","测试部门@20","","1");
		newDeptid = deptDAO.getNewDeptid(deptid);
		Assert.assertEquals("多条id重复,编号为当前末尾编号加1",newDeptid, deptid+"@21"); 
		
		
		deptService.addDept(deptid+"@99","测试部门@99","","1");
		newDeptid = deptDAO.getNewDeptid(deptid);
		Assert.assertNotSame("第一次id重复,编号为01",newDeptid, deptid+"@00"); 
		
		
	}
	
	
	@Test
	@Rollback(value=true)  
	public void testGenarateDeptId() throws BadHanyuPinyinOutputFormatCombination{
		String deptname = "测试部门";
		String newDeptid = deptDAO.genarateDeptId(deptname);
		Assert.assertEquals("和原id相同",newDeptid, "csbm"); 
		
		deptService.addDept("csbm","测试部门","测试部门","1");
		newDeptid = deptDAO.genarateDeptId(deptname);
		Assert.assertEquals("第一次id重复,编号为01",newDeptid, "csbm@01"); 
		
		
	}
	
	
	@Test
	@Rollback(value=true)  
	public void testFindMainDept() throws Exception{
		String userid = "zs";
		String deptid = "dept1";
		deptService.addDept("dept1","部门1", "部门1", "1");
		userService.addUser(userid, "张三", "111111", "1982-10-31", "13718992931", "2879", "58523345", "1", "1", "3101115198210310123", "程序员", "程序开发", "dept1");
		
		UserDeptRel rel = this.deptDAO.findMainUserDeptRel(userid);
		Assert.assertEquals(deptid, rel.getDept().getId());
	}
	
	/*@Test
	@Rollback(value=true)  
	public void testFindDeptId(){
		String deptid = "testDept";
		Dept dept = deptService.addDept(deptid,"测试部门","测试部门","1");
		
		List<Dept> list = deptDAO.findReIdDeptList("testNoDept");  //没有此编号情况
		Assert.assertTrue(list.size() ==0 );
		
		list = deptDAO.findReIdDeptList(deptid);  // 没有此编号
		Assert.assertTrue(list.size() ==0 );
		
		deptService.addDept(deptid+"@01","测试部门@01","","1");
		deptService.addDept(deptid+"@02","测试部门@02","","1");
		deptService.addDept(deptid+"@03","测试部门@03","","1");
		list = deptDAO.findReIdDeptList(deptid);  // 有此编号
		Assert.assertTrue(list.size() ==3 );
		Assert.assertEquals( deptid+"@03", list.get(0).getId());
	}*/
	
	
	
	

}