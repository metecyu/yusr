package testjRw.client.main;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestRsMain {

	public static void main(String[] args) {
		Client c = Client.create();
		long st = System.currentTimeMillis();
		for(int i=0;i<1000;i++){
			WebResource r=c.resource("http://127.0.0.1:8080/yusr/rest/users/yh1");
			ClientResponse response = r.get(ClientResponse.class);
			//System.out.println( response.getStatus() );
			//System.out.println( response.getHeaders().get("Content-Type") );
			String entity = response.getEntity(String.class);
			//System.out.println(entity);
		}
		long end = System.currentTimeMillis();
		System.out.println("rest耗时:"+(end-st));
		
		// System.out.println(entity);
		
	}
	
	

}
