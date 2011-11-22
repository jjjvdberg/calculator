
package calculations.dev.multiplyservice.gen;

import calculations.dev.MultiplyRequest;
import calculations.dev.MultiplyResponse;
import calculations.dev.multiplyservice.MultiplyService;
import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceException;
import org.ebayopensource.turmeric.runtime.common.pipeline.Message;
import org.ebayopensource.turmeric.runtime.common.pipeline.MessageContext;
import org.ebayopensource.turmeric.runtime.spf.impl.internal.pipeline.BaseServiceRequestDispatcher;


/**
 * Note : Generated file, any changes will be lost upon regeneration.
 * 
 */
public class MultiplyServiceRequestDispatcher
    extends BaseServiceRequestDispatcher<MultiplyService>
{


    public MultiplyServiceRequestDispatcher() {
        super(MultiplyService.class);
        addSupportedOperation("multiply", new Class[] {MultiplyRequest.class }, new Class[] {MultiplyResponse.class });
    }

    public boolean dispatch(MessageContext param0, MultiplyService param1)
        throws ServiceException
    {
        MessageContext msgCtx = param0;
        MultiplyService service = param1;
        String operationName = msgCtx.getOperationName();
        Message requestMsg = msgCtx.getRequestMessage();
         
        if ("multiply".equals(operationName)) {
            MultiplyRequest param2 = ((MultiplyRequest) requestMsg.getParam(0));
            try {
                Message responseMsg = msgCtx.getResponseMessage();
                MultiplyResponse result = service.multiply(param2);
                responseMsg.setParam(0, result);
            } catch (Throwable th) {
                handleServiceException(msgCtx, th);
            }
            return true;
        }
        return false;
    }

}
