package testjws.client.main;
import testjws.client.WsUser;
import testjws.client.WsUserList;
import testjws.client.YusrWsService;
import testjws.client.YusrWsServiceItf;

public class TestWsMain {

	public static void main(String[] args) {
		
		YusrWsServiceItf service = new YusrWsService().getYusrWsServicePort();		
		
		//testGetDeptUserList(service,100);
		testGetUser(service,1000);
		
		
		// testGetDeptUserList(service,1000);
	}
	
	public static void baseTest(){
		YusrWsServiceItf service = new YusrWsService().getYusrWsServicePort();		
		long st = System.currentTimeMillis();
		// 自定义单个对象定义
		WsUser user = service.getUser("yh1");
		// System.out.println("用户姓名："+user.getUsername());
		long end = System.currentTimeMillis();
	}
	
	public static void testGetUser(YusrWsServiceItf service,int times){
		long st = System.currentTimeMillis();
		for(int i=0;i<times;i++){
			// 自定义单个对象定义
			WsUser user = service.getUser("yh1");
		}
		
		// System.out.println("用户姓名："+user.getUsername());
		long end = System.currentTimeMillis();
		System.out.println("调用 ws- getUser -"+times+"次  用时："+(end -st)+"ms");	
	}
	
	public static void testGetDeptUserList(YusrWsServiceItf service,int times){
		long st = System.currentTimeMillis();
		// 列表对象
		for(int i=0;i<times;i++){
			WsUserList wsUserList = service.getDeptUserList("dept1");
			// System.out.println(wsUserList.getUserList().size());
		}	
		
		// System.out.println("用户姓名："+user.getUsername());
		long end = System.currentTimeMillis();
		System.out.println("调用 ws- getDeptUserList -"+times+"次  用时："+(end -st)+"ms");	
		
	}


}
