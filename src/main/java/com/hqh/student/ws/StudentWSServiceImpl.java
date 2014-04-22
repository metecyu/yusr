package com.hqh.student.ws;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.metecyu.yusr.service.UserService;
  

  
  
@WebService(endpointInterface="com.hqh.student.ws.IStudentWSService",  
            serviceName="StudentWSService",  
            portName="studentServicePort",  
            targetNamespace="http://ws.student.hqh.com")  
//该对象交由spring管理，studentWsService即为该实现类在bean容器中的name  
	@Component("studentWsService")  
	public class StudentWSServiceImpl implements IStudentWSService{  
	@Resource
	UserService userService;
//  private static final BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");  
//  public StudentWSServiceImpl() {  
//      if(studentService==null) {  
//          studentService = factory.getBean(StudentService.class);  
//      }  
//  }  
      
  
    @Override
    public void SayHi(String name) {
    	System.out.println("Hi, " + name + "!");
    }
    

  
  
}  