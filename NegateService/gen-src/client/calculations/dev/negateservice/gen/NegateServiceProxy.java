
package calculations.dev.negateservice.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Response;
import calculations.dev.NegateRequest;
import calculations.dev.NegateResponse;
import calculations.dev.negateservice.AsyncNegateService;
import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceInvocationException;
import org.ebayopensource.turmeric.runtime.sif.impl.internal.service.BaseServiceProxy;
import org.ebayopensource.turmeric.runtime.sif.service.Service;


/**
 * Note : Generated file, any changes will be lost upon regeneration.
 * 
 */
public class NegateServiceProxy
    extends BaseServiceProxy<AsyncNegateService>
    implements AsyncNegateService
{


    public NegateServiceProxy(Service service) {
        super(service);
    }

    public Future<?> negateAsync(NegateRequest param0, AsyncHandler<NegateResponse> param1) {
        Dispatch dispatch = m_service.createDispatch("negate");
        Future<?> result = dispatch.invokeAsync(param0, param1);
        return result;
    }

    public Response<NegateResponse> negateAsync(NegateRequest param0) {
        Dispatch dispatch = m_service.createDispatch("negate");
        Response<NegateResponse> result = dispatch.invokeAsync(param0);
        return result;
    }

    public List<Response<?>> poll(boolean block, boolean partial)
        throws InterruptedException
    {
        return m_service.poll(block, partial);
    }

    public NegateResponse negate(NegateRequest param0) {
        Object[] params = new Object[ 1 ] ;
        params[ 0 ] = param0;
        List<Object> returnParamList = new ArrayList<Object>();
        try {
            m_service.invoke("negate", params, returnParamList);
        } catch (ServiceInvocationException svcInvocationEx) {
            throw wrapInvocationException(svcInvocationEx);
        }
        NegateResponse result = ((NegateResponse) returnParamList.get(0));
        return result;
    }

}
