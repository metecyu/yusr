package com.hqh.student.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IStudentWSService {
	@WebMethod
	void SayHi(@WebParam(name = "name") String name);
	
	/*@WebMethod
	String getUser(@WebParam(name = "userid") String userid);*/
	

}