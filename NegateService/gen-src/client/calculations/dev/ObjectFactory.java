
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

    private final static QName _NegateResponse_QNAME = new QName("http://dev.calculations", "negateResponse");
    private final static QName _NegateRequest_QNAME = new QName("http://dev.calculations", "negateRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: calculations.dev
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NegateResponse }
     * 
     */
    public NegateResponse createNegateResponse() {
        return new NegateResponse();
    }

    /**
     * Create an instance of {@link NegateRequest }
     * 
     */
    public NegateRequest createNegateRequest() {
        return new NegateRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NegateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dev.calculations", name = "negateResponse")
    public JAXBElement<NegateResponse> createNegateResponse(NegateResponse value) {
        return new JAXBElement<NegateResponse>(_NegateResponse_QNAME, NegateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NegateRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dev.calculations", name = "negateRequest")
    public JAXBElement<NegateRequest> createNegateRequest(NegateRequest value) {
        return new JAXBElement<NegateRequest>(_NegateRequest_QNAME, NegateRequest.class, null, value);
    }

}
