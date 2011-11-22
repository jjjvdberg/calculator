
package calculations.dev;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.ebayopensource.turmeric.common.v1.types.BaseRequest;


/**
 * 
 * 						Document goes here
 * 					
 * 
 * <p>Java class for NegateRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NegateRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ebayopensource.org/turmeric/common/v1/types}BaseRequest">
 *       &lt;sequence>
 *         &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NegateRequest", propOrder = {
    "x"
})
public class NegateRequest
    extends BaseRequest
{

    protected int x;

    /**
     * Gets the value of the x property.
     * 
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the value of the x property.
     * 
     */
    public void setX(int value) {
        this.x = value;
    }

}
