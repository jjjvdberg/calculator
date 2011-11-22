
package calculations.dev.sumservice.gen;

import calculations.dev.SumRequest;
import calculations.dev.SumResponse;
import calculations.dev.sumservice.SumService;
import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceException;
import org.ebayopensource.turmeric.runtime.common.pipeline.Message;
import org.ebayopensource.turmeric.runtime.common.pipeline.MessageContext;
import org.ebayopensource.turmeric.runtime.spf.impl.internal.pipeline.BaseServiceRequestDispatcher;


/**
 * Note : Generated file, any changes will be lost upon regeneration.
 * 
 */
public class SumServiceRequestDispatcher
    extends BaseServiceRequestDispatcher<SumService>
{


    public SumServiceRequestDispatcher() {
        super(SumService.class);
        addSupportedOperation("sum", new Class[] {SumRequest.class }, new Class[] {SumResponse.class });
    }

    public boolean dispatch(MessageContext param0, SumService param1)
        throws ServiceException
    {
        MessageContext msgCtx = param0;
        SumService service = param1;
        String operationName = msgCtx.getOperationName();
        Message requestMsg = msgCtx.getRequestMessage();
         
        if ("sum".equals(operationName)) {
            SumRequest param2 = ((SumRequest) requestMsg.getParam(0));
            try {
                Message responseMsg = msgCtx.getResponseMessage();
                SumResponse result = service.sum(param2);
                responseMsg.setParam(0, result);
            } catch (Throwable th) {
                handleServiceException(msgCtx, th);
            }
            return true;
        }
        return false;
    }

}
