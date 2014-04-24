package com.hqh.student.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.metecyu.yusr.ws.model.WsUser;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IStudentWSService {
	
	@WebMethod
	void SayHi(@WebParam(name = "name") String name);
	
	@WebMethod
	@WebResult(name = "valid")
	WsUser getUser(@WebParam(name = "userid") String userid);
	

}