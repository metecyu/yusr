package com.hqh.student.ws;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.metecyu.yusr.bmodel.UserD;
import com.metecyu.yusr.model.User;
import com.metecyu.yusr.service.UserService;
import com.metecyu.yusr.ws.model.WsUser;
import com.metecyu.yusr.ws.model.WsUserList;
  

  
  
@WebService(endpointInterface="com.hqh.student.ws.IStudentWSService",  
            serviceName="StudentWSService",  
            portName="studentServicePort",  
            targetNamespace="http://ws.student.hqh.com")  
	//该对象交由spring管理，studentWsService即为该实现类在bean容器中的name  
	@Component("studentWsService")  
	public class StudentWSServiceImpl implements IStudentWSService{  
	
	@Resource
	UserService userService;


    @Override
    public void SayHi(String name) {
    	
    	System.out.println("Hi, " + name + "!");
    }
    @Override
    public WsUser getUser(String id) {
    	User user =this.userService.findById(id);
    	WsUser ws = this.userService.turnToWsUser(user);
    	return ws;
    }
    

    @Override
    public WsUserList getDeptUserList(String deptid) {
    	List<UserD>  userList = userService.findDeptUser(deptid);
    	ArrayList<WsUser> outList = new ArrayList();
    	/**/
    	for(UserD user :userList){
    		WsUser ws = this.userService.turnToWsUser(user);
    		outList.add(ws);
    	}
    	WsUserList usrList= new WsUserList();
    	usrList.userList = outList;

    	return usrList;
    }
  
}  