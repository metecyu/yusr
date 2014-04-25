
package testjws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the testjws.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetUser_QNAME = new QName("http://ws.student.hqh.com/", "getUser");
    private final static QName _GetDeptUserListResponse_QNAME = new QName("http://ws.student.hqh.com/", "getDeptUserListResponse");
    private final static QName _SayHiResponse_QNAME = new QName("http://ws.student.hqh.com/", "SayHiResponse");
    private final static QName _SayHi_QNAME = new QName("http://ws.student.hqh.com/", "SayHi");
    private final static QName _GetDeptUserList_QNAME = new QName("http://ws.student.hqh.com/", "getDeptUserList");
    private final static QName _GetUserResponse_QNAME = new QName("http://ws.student.hqh.com/", "getUserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: testjws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUser }
     * 
     */
    public GetUser createGetUser() {
        return new GetUser();
    }

    /**
     * Create an instance of {@link GetDeptUserListResponse }
     * 
     */
    public GetDeptUserListResponse createGetDeptUserListResponse() {
        return new GetDeptUserListResponse();
    }

    /**
     * Create an instance of {@link SayHiResponse }
     * 
     */
    public SayHiResponse createSayHiResponse() {
        return new SayHiResponse();
    }

    /**
     * Create an instance of {@link GetUserResponse }
     * 
     */
    public GetUserResponse createGetUserResponse() {
        return new GetUserResponse();
    }

    /**
     * Create an instance of {@link GetDeptUserList }
     * 
     */
    public GetDeptUserList createGetDeptUserList() {
        return new GetDeptUserList();
    }

    /**
     * Create an instance of {@link SayHi }
     * 
     */
    public SayHi createSayHi() {
        return new SayHi();
    }

    /**
     * Create an instance of {@link WsUser }
     * 
     */
    public WsUser createWsUser() {
        return new WsUser();
    }

    /**
     * Create an instance of {@link WsUserList }
     * 
     */
    public WsUserList createWsUserList() {
        return new WsUserList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.student.hqh.com/", name = "getUser")
    public JAXBElement<GetUser> createGetUser(GetUser value) {
        return new JAXBElement<GetUser>(_GetUser_QNAME, GetUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDeptUserListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.student.hqh.com/", name = "getDeptUserListResponse")
    public JAXBElement<GetDeptUserListResponse> createGetDeptUserListResponse(GetDeptUserListResponse value) {
        return new JAXBElement<GetDeptUserListResponse>(_GetDeptUserListResponse_QNAME, GetDeptUserListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.student.hqh.com/", name = "SayHiResponse")
    public JAXBElement<SayHiResponse> createSayHiResponse(SayHiResponse value) {
        return new JAXBElement<SayHiResponse>(_SayHiResponse_QNAME, SayHiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.student.hqh.com/", name = "SayHi")
    public JAXBElement<SayHi> createSayHi(SayHi value) {
        return new JAXBElement<SayHi>(_SayHi_QNAME, SayHi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDeptUserList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.student.hqh.com/", name = "getDeptUserList")
    public JAXBElement<GetDeptUserList> createGetDeptUserList(GetDeptUserList value) {
        return new JAXBElement<GetDeptUserList>(_GetDeptUserList_QNAME, GetDeptUserList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.student.hqh.com/", name = "getUserResponse")
    public JAXBElement<GetUserResponse> createGetUserResponse(GetUserResponse value) {
        return new JAXBElement<GetUserResponse>(_GetUserResponse_QNAME, GetUserResponse.class, null, value);
    }

}
