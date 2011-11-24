
package calculations.dev;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the calculations.dev package. 
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

    private final static QName _PowerResponse_QNAME = new QName("http://dev.calculations", "powerResponse");
    private final static QName _PowerRequest_QNAME = new QName("http://dev.calculations", "powerRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: calculations.dev
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PowerResponse }
     * 
     */
    public PowerResponse createPowerResponse() {
        return new PowerResponse();
    }

    /**
     * Create an instance of {@link PowerRequest }
     * 
     */
    public PowerRequest createPowerRequest() {
        return new PowerRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PowerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dev.calculations", name = "powerResponse")
    public JAXBElement<PowerResponse> createPowerResponse(PowerResponse value) {
        return new JAXBElement<PowerResponse>(_PowerResponse_QNAME, PowerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PowerRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dev.calculations", name = "powerRequest")
    public JAXBElement<PowerRequest> createPowerRequest(PowerRequest value) {
        return new JAXBElement<PowerRequest>(_PowerRequest_QNAME, PowerRequest.class, null, value);
    }

}
