package com.metecyu.yusr.rs;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.metecyu.yusr.model.User;
import com.metecyu.yusr.service.UserService;
import com.metecyu.yusr.util.MockData;
import com.metecyu.yusr.ws.model.WsUser;
import com.metecyu.yusr.ws.model.WsUserList;

	@Component
	@Path("/users")
	public class UserResource {
		@Resource
		UserService userService;
		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public WsUserList getContacts() {
		WsUserList usrList= new WsUserList();
    	usrList.userList = MockData.getUserList();
    	return usrList;
	}
	@GET
	@Path("{user}")
	@Produces(MediaType.APPLICATION_JSON)
	public WsUser  getUser(@PathParam("user") String userid){
		
		
		long st = System.currentTimeMillis();
    	User user =this.userService.findById(userid);
    	WsUser ws = this.userService.turnToWsUser(user);
    	long end = System.currentTimeMillis();
		System.out.println("数据库用时："+(end -st));	
		// WsUser wsUser = MockData.getOneUser();
		return ws;
	}
	
	
} 
