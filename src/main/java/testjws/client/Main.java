package testjws.client;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IStudentWSService service = new StudentWSService().getStudentServicePort();
		
		service.sayHi("出搓");

	}

}
