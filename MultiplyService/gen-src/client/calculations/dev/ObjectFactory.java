
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

    private final static QName _MultiplyRequest_QNAME = new QName("http://dev.calculations", "multiplyRequest");
    private final static QName _MultiplyResponse_QNAME = new QName("http://dev.calculations", "multiplyResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: calculations.dev
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MultiplyResponse }
     * 
     */
    public MultiplyResponse createMultiplyResponse() {
        return new MultiplyResponse();
    }

    /**
     * Create an instance of {@link MultiplyRequest }
     * 
     */
    public MultiplyRequest createMultiplyRequest() {
        return new MultiplyRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiplyRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dev.calculations", name = "multiplyRequest")
    public JAXBElement<MultiplyRequest> createMultiplyRequest(MultiplyRequest value) {
        return new JAXBElement<MultiplyRequest>(_MultiplyRequest_QNAME, MultiplyRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiplyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dev.calculations", name = "multiplyResponse")
    public JAXBElement<MultiplyResponse> createMultiplyResponse(MultiplyResponse value) {
        return new JAXBElement<MultiplyResponse>(_MultiplyResponse_QNAME, MultiplyResponse.class, null, value);
    }

}
