
package calculations.dev.powerservice.gen;

import calculations.dev.PowerRequest;
import calculations.dev.PowerResponse;
import calculations.dev.powerservice.PowerService;
import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceException;
import org.ebayopensource.turmeric.runtime.common.pipeline.Message;
import org.ebayopensource.turmeric.runtime.common.pipeline.MessageContext;
import org.ebayopensource.turmeric.runtime.spf.impl.internal.pipeline.BaseServiceRequestDispatcher;


/**
 * Note : Generated file, any changes will be lost upon regeneration.
 * 
 */
public class PowerServiceRequestDispatcher
    extends BaseServiceRequestDispatcher<PowerService>
{


    public PowerServiceRequestDispatcher() {
        super(PowerService.class);
        addSupportedOperation("power", new Class[] {PowerRequest.class }, new Class[] {PowerResponse.class });
    }

    public boolean dispatch(MessageContext param0, PowerService param1)
        throws ServiceException
    {
        MessageContext msgCtx = param0;
        PowerService service = param1;
        String operationName = msgCtx.getOperationName();
        Message requestMsg = msgCtx.getRequestMessage();
         
        if ("power".equals(operationName)) {
            PowerRequest param2 = ((PowerRequest) requestMsg.getParam(0));
            try {
                Message responseMsg = msgCtx.getResponseMessage();
                PowerResponse result = service.power(param2);
                responseMsg.setParam(0, result);
            } catch (Throwable th) {
                handleServiceException(msgCtx, th);
            }
            return true;
        }
        return false;
    }

}
