package testjws.client;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		IStudentWSService service = new StudentWSService().getStudentServicePort();		
		// 基本类型
		service.sayHi("出搓");
		
		// 自定义单个对象定义
		WsUser user = service.getUser("yh1");
		System.out.println("用户姓名："+user.getUsername());
		
		// 列表对象
		WsUserList wsUserList = service.getDeptUserList("dept1");
		System.out.println(wsUserList.userList.size());
		for(WsUser usr : wsUserList.userList){
			System.out.println(usr.getUsername());
		}
		
	}

}
