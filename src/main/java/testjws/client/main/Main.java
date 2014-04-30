package testjws.client.main;
import testjws.client.WsUser;
import testjws.client.WsUserList;
import testjws.client.YusrWsService;
import testjws.client.YusrWsServiceItf;

public class Main {

	public static void main(String[] args) {
		
		YusrWsServiceItf service = new YusrWsService().getYusrWsServicePort();		
		long st = System.currentTimeMillis();
		// 自定义单个对象定义
		WsUser user = service.getUser("yh1");
		System.out.println("用户姓名："+user.getUsername());
		long end = System.currentTimeMillis();
		System.out.println("用时："+(end -st));		
		
		// 列表对象
		WsUserList wsUserList = service.getDeptUserList("dept1");
		System.out.println("\n部门用户数量："+ wsUserList.getUserList().size());
		for(WsUser usr : wsUserList.getUserList()){
			System.out.println(usr.getUsername());
		}
	}

}
