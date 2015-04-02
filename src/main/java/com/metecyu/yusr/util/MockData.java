package com.metecyu.yusr.util;

import java.util.ArrayList;
import java.util.List;

import com.metecyu.yusr.ws.model.WsUser;

public class MockData {
	public static WsUser getOneUser(){
		WsUser user = new WsUser();
		user.setUsername("俞张平");
		return user;
	}
	public static List<WsUser> getUserList(){
		List outList = new ArrayList();
		WsUser user = new WsUser();
		user.setUsername("俞张平1");
		outList.add(user);
		
		user = new WsUser();
		user.setUsername("俞张平2");
		outList.add(user);
		
		user = new WsUser();
		user.setUsername("俞张平3");
		outList.add(user);
		
		user = new WsUser();
		user.setUsername("俞张平4");
		outList.add(user);
		
		user = new WsUser();
		user.setUsername("俞张平5");
		outList.add(user);
		
		
		user = new WsUser();
		user.setUsername("俞张平1");
		outList.add(user);
		
		user = new WsUser();
		user.setUsername("俞张平2");
		outList.add(user);
		
		user = new WsUser();
		user.setUsername("俞张平3");
		outList.add(user);
		
		user = new WsUser();
		user.setUsername("俞张平4");
		outList.add(user);
		
		user = new WsUser();
		user.setUsername("俞张平5");
		outList.add(user);
		
		return outList;
	}
}
