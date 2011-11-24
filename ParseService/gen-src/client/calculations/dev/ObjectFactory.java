
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

    private final static QName _ParseRequest_QNAME = new QName("http://dev.calculations", "parseRequest");
    private final static QName _ParseResponse_QNAME = new QName("http://dev.calculations", "parseResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: calculations.dev
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ParseResponse }
     * 
     */
    public ParseResponse createParseResponse() {
        return new ParseResponse();
    }

    /**
     * Create an instance of {@link ParseRequest }
     * 
     */
    public ParseRequest createParseRequest() {
        return new ParseRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dev.calculations", name = "parseRequest")
    public JAXBElement<ParseRequest> createParseRequest(ParseRequest value) {
        return new JAXBElement<ParseRequest>(_ParseRequest_QNAME, ParseRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dev.calculations", name = "parseResponse")
    public JAXBElement<ParseResponse> createParseResponse(ParseResponse value) {
        return new JAXBElement<ParseResponse>(_ParseResponse_QNAME, ParseResponse.class, null, value);
    }

}
