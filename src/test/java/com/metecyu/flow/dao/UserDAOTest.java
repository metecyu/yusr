package com.metecyu.flow.dao;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.metecyu.yusr.dao.UserDAO;
import com.metecyu.yusr.model.User;



@ContextConfiguration(locations={"/applicationContext.xml","/hibernate.cfg.xml"})
public class UserDAOTest extends AbstractJUnit4SpringContextTests {
	private static final Logger log = Logger.getLogger(UserDAOTest.class);
	
	@Resource
	private UserDAO userDAO; 
	@Test
	@Rollback(value=false)  
	public void testSave(){
		
		//User user = userDAO.save();
		//log.info("用户id"+user.getId());
		//Assert.assertTrue(true);
		//Assert.assertTrue(!"".equals(flowdef.getId()));
	}

	
}