package testjws.client.main;

import testjws.client.WsUser;
import testjws.client.WsUserList;
import testjws.client.YusrWsSevice;
import testjws.client.YusrWsSeviceItf;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		YusrWsSeviceItf service = new YusrWsSevice().getYusrWsSevicePort();		
		long st = System.currentTimeMillis();
		// 基本类型
		service.sayHi("出搓");
		
		// 自定义单个对象定义
		WsUser user = service.getUser("yh1");
		System.out.println("用户姓名："+user.getUsername());
		long end = System.currentTimeMillis();
		System.out.println(end -st);
		// 列表对象
		WsUserList wsUserList = service.getDeptUserList("dept1");
		System.out.println(wsUserList.getUserList().size());
		for(WsUser usr : wsUserList.getUserList()){
			System.out.println(usr.getUsername());
		}
		
		
	}

}
