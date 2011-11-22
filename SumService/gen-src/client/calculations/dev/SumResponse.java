
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
 * <p>Java class for SumResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SumResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ebayopensource.org/turmeric/common/v1/types}BaseResponse">
 *       &lt;sequence>
 *         &lt;element name="z" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SumResponse", propOrder = {
    "z"
})
public class SumResponse
    extends BaseResponse
{

    protected int z;

    /**
     * Gets the value of the z property.
     * 
     */
    public int getZ() {
        return z;
    }

    /**
     * Sets the value of the z property.
     * 
     */
    public void setZ(int value) {
        this.z = value;
    }

}
