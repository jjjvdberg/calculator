
package calculations.dev.sumservice.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Response;
import calculations.dev.SumRequest;
import calculations.dev.SumResponse;
import calculations.dev.sumservice.AsyncSumService;
import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceInvocationException;
import org.ebayopensource.turmeric.runtime.sif.impl.internal.service.BaseServiceProxy;
import org.ebayopensource.turmeric.runtime.sif.service.Service;


/**
 * Note : Generated file, any changes will be lost upon regeneration.
 * 
 */
public class SumServiceProxy
    extends BaseServiceProxy<AsyncSumService>
    implements AsyncSumService
{


    public SumServiceProxy(Service service) {
        super(service);
    }

    public Future<?> sumAsync(SumRequest param0, AsyncHandler<SumResponse> param1) {
        Dispatch dispatch = m_service.createDispatch("sum");
        Future<?> result = dispatch.invokeAsync(param0, param1);
        return result;
    }

    public Response<SumResponse> sumAsync(SumRequest param0) {
        Dispatch dispatch = m_service.createDispatch("sum");
        Response<SumResponse> result = dispatch.invokeAsync(param0);
        return result;
    }

    public List<Response<?>> poll(boolean block, boolean partial)
        throws InterruptedException
    {
        return m_service.poll(block, partial);
    }

    public SumResponse sum(SumRequest param0) {
        Object[] params = new Object[ 1 ] ;
        params[ 0 ] = param0;
        List<Object> returnParamList = new ArrayList<Object>();
        try {
            m_service.invoke("sum", params, returnParamList);
        } catch (ServiceInvocationException svcInvocationEx) {
            throw wrapInvocationException(svcInvocationEx);
        }
        SumResponse result = ((SumResponse) returnParamList.get(0));
        return result;
    }

}
