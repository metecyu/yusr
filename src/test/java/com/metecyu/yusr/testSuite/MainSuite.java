package com.metecyu.yusr.testSuite;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

import com.metecyu.yusr.dao.DeptDAOTest;
import com.metecyu.yusr.dao.UserDAOTest;
import com.metecyu.yusr.service.DeptServiceTest;
import com.metecyu.yusr.service.UserServiceTest;
import com.metecyu.yusr.testUtil.TestAfter;
import com.metecyu.yusr.testUtil.TestBefore;

public class MainSuite {
	public static Test suite() {
        TestSuite suite = new TestSuite("Root Test");
        /**/
        // 测试开始前执行(清空数据库)
        suite.addTest(new JUnit4TestAdapter(TestBefore.class));
        
        // dao
        suite.addTest(new JUnit4TestAdapter(DeptDAOTest.class));
        suite.addTest(new JUnit4TestAdapter(UserDAOTest.class));
        // service
        suite.addTest(new JUnit4TestAdapter(DeptServiceTest.class));
        suite.addTest(new JUnit4TestAdapter(UserServiceTest.class));
        // 测试结束后执行(添加demo数据)
        suite.addTest(new JUnit4TestAdapter(TestAfter.class));
        
        
        
        
     return suite;
    }
}
