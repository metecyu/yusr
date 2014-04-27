
package testjws.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.0
 * 
 */
@WebServiceClient(name = "YusrWsSevice", targetNamespace = "http://ws.student.hqh.com", wsdlLocation = "http://localhost:8080/yusr/jaxws-spring?wsdl")
public class YusrWsSevice
    extends Service
{

    private final static URL YUSRWSSEVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(testjws.client.YusrWsSevice.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = testjws.client.YusrWsSevice.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8080/yusr/jaxws-spring?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/yusr/jaxws-spring?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        YUSRWSSEVICE_WSDL_LOCATION = url;
    }

    public YusrWsSevice(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public YusrWsSevice() {
        super(YUSRWSSEVICE_WSDL_LOCATION, new QName("http://ws.student.hqh.com", "YusrWsSevice"));
    }

    /**
     * 
     * @return
     *     returns YusrWsSeviceItf
     */
    @WebEndpoint(name = "yusrWsSevicePort")
    public YusrWsSeviceItf getYusrWsSevicePort() {
        return super.getPort(new QName("http://ws.student.hqh.com", "yusrWsSevicePort"), YusrWsSeviceItf.class);
    }

}
