package com.hqh.student.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.metecyu.yusr.ws.model.WsUser;
import com.metecyu.yusr.ws.model.WsUserList;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC,parameterStyle = SOAPBinding.ParameterStyle.WRAPPED )


public interface IStudentWSService {
	//SOAPBinding.ParameterStyle.WRAPPED
	//SOAPBinding.Style.RPC
	@WebMethod
	void SayHi(@WebParam(name = "name") String name);
	
	@WebMethod
	@WebResult(name = "valid")
	WsUser getUser(@WebParam(name = "userid") String userid);
	
	@WebMethod
	@WebResult(name = "valid")
	WsUserList getDeptUserList(@WebParam(name = "deptid") String deptid);

}