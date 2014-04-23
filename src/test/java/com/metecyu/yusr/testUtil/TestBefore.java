package com.metecyu.yusr.testUtil;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.metecyu.yusr.dao.DataCenter;
import com.metecyu.yusr.dao.DeptDAO;
import com.metecyu.yusr.service.DeptService;
import com.metecyu.yusr.service.UserService;

@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class TestBefore extends AbstractTransactionalJUnit4SpringContextTests {
	private static final Logger log = Logger.getLogger(TestBefore.class);
	
	@Resource
	private DeptService deptService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private DeptDAO deptDAO; 
	@Resource
	DataCenter dataCenter;
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