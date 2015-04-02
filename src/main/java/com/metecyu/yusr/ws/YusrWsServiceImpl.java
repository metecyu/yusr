package com.metecyu.yusr.ws;
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
  
  
@WebService(endpointInterface="com.metecyu.yusr.ws.YusrWsServiceItf",  
            serviceName="yusrWsService",  
            portName="yusrWsServicePort",  
            targetNamespace="http://ws.yusr.metecyu.com")  
	//该对象交由spring管理，studentWsService即为该实现类在bean容器中的name  
	@Component("yusrWsServiceImpl")  
	public class YusrWsServiceImpl implements YusrWsServiceItf{ 
	@Resource
	UserService userService;

    @Override
    public WsUser getUser(String id) {
    	
    /*	*/
    	long st = System.currentTimeMillis();
    	User user =this.userService.findById(id);
    	WsUser ws = this.userService.turnToWsUser(user);
    	long end = System.currentTimeMillis();
		System.out.println("数据库用时："+(end -st));	
		
    	/*WsUser ws  = MockData.getOneUser();*/
    	return ws;
    }
    @Override
    public WsUserList getDeptUserList(String deptid) {
    	/**/List<UserD>  userList = userService.findDeptUser(deptid);
    	ArrayList<WsUser> outList = new ArrayList();
    	
    	for(UserD user :userList){
    		WsUser ws = this.userService.turnToWsUser(user);
    		outList.add(ws);
    	}
    	WsUserList usrList= new WsUserList();
    	usrList.userList = outList;
    	/*WsUserList usrList= new WsUserList();
    	usrList.userList = MockData.getUserList();*/
    	return usrList;
    }
}  