
package calculations.dev.parseservice.gen;

import calculations.dev.ParseRequest;
import calculations.dev.ParseResponse;
import calculations.dev.parseservice.ParseService;
import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceException;
import org.ebayopensource.turmeric.runtime.common.pipeline.Message;
import org.ebayopensource.turmeric.runtime.common.pipeline.MessageContext;
import org.ebayopensource.turmeric.runtime.spf.impl.internal.pipeline.BaseServiceRequestDispatcher;


/**
 * Note : Generated file, any changes will be lost upon regeneration.
 * 
 */
public class ParseServiceRequestDispatcher
    extends BaseServiceRequestDispatcher<ParseService>
{


    public ParseServiceRequestDispatcher() {
        super(ParseService.class);
        addSupportedOperation("parse", new Class[] {ParseRequest.class }, new Class[] {ParseResponse.class });
    }

    public boolean dispatch(MessageContext param0, ParseService param1)
        throws ServiceException
    {
        MessageContext msgCtx = param0;
        ParseService service = param1;
        String operationName = msgCtx.getOperationName();
        Message requestMsg = msgCtx.getRequestMessage();
         
        if ("parse".equals(operationName)) {
            ParseRequest param2 = ((ParseRequest) requestMsg.getParam(0));
            try {
                Message responseMsg = msgCtx.getResponseMessage();
                ParseResponse result = service.parse(param2);
                responseMsg.setParam(0, result);
            } catch (Throwable th) {
                handleServiceException(msgCtx, th);
            }
            return true;
        }
        return false;
    }

}
