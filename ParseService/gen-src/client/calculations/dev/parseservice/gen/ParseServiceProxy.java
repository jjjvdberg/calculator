
package calculations.dev.parseservice.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Response;
import calculations.dev.ParseRequest;
import calculations.dev.ParseResponse;
import calculations.dev.parseservice.AsyncParseService;
import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceInvocationException;
import org.ebayopensource.turmeric.runtime.sif.impl.internal.service.BaseServiceProxy;
import org.ebayopensource.turmeric.runtime.sif.service.Service;


/**
 * Note : Generated file, any changes will be lost upon regeneration.
 * 
 */
public class ParseServiceProxy
    extends BaseServiceProxy<AsyncParseService>
    implements AsyncParseService
{


    public ParseServiceProxy(Service service) {
        super(service);
    }

    public Future<?> parseAsync(ParseRequest param0, AsyncHandler<ParseResponse> param1) {
        Dispatch dispatch = m_service.createDispatch("parse");
        Future<?> result = dispatch.invokeAsync(param0, param1);
        return result;
    }

    public Response<ParseResponse> parseAsync(ParseRequest param0) {
        Dispatch dispatch = m_service.createDispatch("parse");
        Response<ParseResponse> result = dispatch.invokeAsync(param0);
        return result;
    }

    public List<Response<?>> poll(boolean block, boolean partial)
        throws InterruptedException
    {
        return m_service.poll(block, partial);
    }

    public ParseResponse parse(ParseRequest param0) {
        Object[] params = new Object[ 1 ] ;
        params[ 0 ] = param0;
        List<Object> returnParamList = new ArrayList<Object>();
        try {
            m_service.invoke("parse", params, returnParamList);
        } catch (ServiceInvocationException svcInvocationEx) {
            throw wrapInvocationException(svcInvocationEx);
        }
        ParseResponse result = ((ParseResponse) returnParamList.get(0));
        return result;
    }

}
