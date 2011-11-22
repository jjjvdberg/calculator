
package calculations.dev.negateservice.gen;

import calculations.dev.NegateRequest;
import calculations.dev.NegateResponse;
import calculations.dev.negateservice.NegateService;
import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceException;
import org.ebayopensource.turmeric.runtime.common.pipeline.Message;
import org.ebayopensource.turmeric.runtime.common.pipeline.MessageContext;
import org.ebayopensource.turmeric.runtime.spf.impl.internal.pipeline.BaseServiceRequestDispatcher;


/**
 * Note : Generated file, any changes will be lost upon regeneration.
 * 
 */
public class NegateServiceRequestDispatcher
    extends BaseServiceRequestDispatcher<NegateService>
{


    public NegateServiceRequestDispatcher() {
        super(NegateService.class);
        addSupportedOperation("negate", new Class[] {NegateRequest.class }, new Class[] {NegateResponse.class });
    }

    public boolean dispatch(MessageContext param0, NegateService param1)
        throws ServiceException
    {
        MessageContext msgCtx = param0;
        NegateService service = param1;
        String operationName = msgCtx.getOperationName();
        Message requestMsg = msgCtx.getRequestMessage();
         
        if ("negate".equals(operationName)) {
            NegateRequest param2 = ((NegateRequest) requestMsg.getParam(0));
            try {
                Message responseMsg = msgCtx.getResponseMessage();
                NegateResponse result = service.negate(param2);
                responseMsg.setParam(0, result);
            } catch (Throwable th) {
                handleServiceException(msgCtx, th);
            }
            return true;
        }
        return false;
    }

}
