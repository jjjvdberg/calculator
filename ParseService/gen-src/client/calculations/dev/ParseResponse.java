
package calculations.dev;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.ebayopensource.turmeric.common.v1.types.BaseResponse;


/**
 * 
 * 						Document goes here
 * 					
 * 
 * <p>Java class for ParseResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParseResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ebayopensource.org/turmeric/common/v1/types}BaseResponse">
 *       &lt;sequence>
 *         &lt;element name="output" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParseResponse", propOrder = {
    "output"
})
public class ParseResponse
    extends BaseResponse
{

    protected int output;

    /**
     * Gets the value of the output property.
     * 
     */
    public int getOutput() {
        return output;
    }

    /**
     * Sets the value of the output property.
     * 
     */
    public void setOutput(int value) {
        this.output = value;
    }

}
