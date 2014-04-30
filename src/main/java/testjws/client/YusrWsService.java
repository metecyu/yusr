
package testjws.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.0
 * 
 */
@WebServiceClient(name = "yusrWsService", targetNamespace = "http://ws.yusr.metecyu.com", wsdlLocation = "http://localhost:8080/yusr/jaxws-spring?wsdl")
public class YusrWsService
    extends Service
{

    private final static URL YUSRWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException YUSRWSSERVICE_EXCEPTION;
    private final static QName YUSRWSSERVICE_QNAME = new QName("http://ws.yusr.metecyu.com", "yusrWsService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/yusr/jaxws-spring?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        YUSRWSSERVICE_WSDL_LOCATION = url;
        YUSRWSSERVICE_EXCEPTION = e;
    }

    public YusrWsService() {
        super(__getWsdlLocation(), YUSRWSSERVICE_QNAME);
    }

    public YusrWsService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @return
     *     returns YusrWsServiceItf
     */
    @WebEndpoint(name = "yusrWsServicePort")
    public YusrWsServiceItf getYusrWsServicePort() {
        return super.getPort(new QName("http://ws.yusr.metecyu.com", "yusrWsServicePort"), YusrWsServiceItf.class);
    }

    private static URL __getWsdlLocation() {
        if (YUSRWSSERVICE_EXCEPTION!= null) {
            throw YUSRWSSERVICE_EXCEPTION;
        }
        return YUSRWSSERVICE_WSDL_LOCATION;
    }

}
