
package com.metecyu.yusr.ws;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import com.metecyu.yusr.ws.model.WsUser;
import com.metecyu.yusr.ws.model.WsUserList;

@WebService(name = "YusrWsServiceItf", targetNamespace = "http://ws.yusr.metecyu.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface YusrWsServiceItf {
	
    /**
     * 获取用户对象
     * @param userid
     * @return
     *     returns testjws.client.WsUser
     */
    @WebMethod
    public WsUser getUser(
        @WebParam(name = "userid", partName = "userid")
        String userid);

    /**
     * 获取部门用户列表
     * @param deptid
     * @return
     *     returns testjws.client.WsUserList
     */
    @WebMethod
    public WsUserList getDeptUserList(
        @WebParam(name = "deptid", partName = "deptid")
        String deptid);

}
