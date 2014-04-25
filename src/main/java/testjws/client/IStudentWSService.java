
package testjws.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.0
 * 
 */
@WebService(name = "IStudentWSService", targetNamespace = "http://ws.student.hqh.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IStudentWSService {


    /**
     * 
     * @param name
     */
    @WebMethod(operationName = "SayHi")
    public void sayHi(
        @WebParam(name = "name", partName = "name")
        String name);

    /**
     * 
     * @param userid
     * @return
     *     returns testjws.client.WsUser
     */
    @WebMethod
    @WebResult(name = "valid", partName = "valid")
    public WsUser getUser(
        @WebParam(name = "userid", partName = "userid")
        String userid);

    /**
     * 
     * @param deptid
     * @return
     *     returns testjws.client.WsUserList
     */
    @WebMethod
    @WebResult(name = "valid", partName = "valid")
    public WsUserList getDeptUserList(
        @WebParam(name = "deptid", partName = "deptid")
        String deptid);

}
