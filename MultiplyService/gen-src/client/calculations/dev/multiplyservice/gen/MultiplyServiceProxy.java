
package calculations.dev.multiplyservice.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Response;
import calculations.dev.MultiplyRequest;
import calculations.dev.MultiplyResponse;
import calculations.dev.multiplyservice.AsyncMultiplyService;
import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceInvocationException;
import org.ebayopensource.turmeric.runtime.sif.impl.internal.service.BaseServiceProxy;
import org.ebayopensource.turmeric.runtime.sif.service.Service;


/**
 * Note : Generated file, any changes will be lost upon regeneration.
 * 
 */
public class MultiplyServiceProxy
    extends BaseServiceProxy<AsyncMultiplyService>
    implements AsyncMultiplyService
{


    public MultiplyServiceProxy(Service service) {
        super(service);
    }

    public Future<?> multiplyAsync(MultiplyRequest param0, AsyncHandler<MultiplyResponse> param1) {
        Dispatch dispatch = m_service.createDispatch("multiply");
        Future<?> result = dispatch.invokeAsync(param0, param1);
        return result;
    }

    public Response<MultiplyResponse> multiplyAsync(MultiplyRequest param0) {
        Dispatch dispatch = m_service.createDispatch("multiply");
        Response<MultiplyResponse> result = dispatch.invokeAsync(param0);
        return result;
    }

    public List<Response<?>> poll(boolean block, boolean partial)
        throws InterruptedException
    {
        return m_service.poll(block, partial);
    }

    public MultiplyResponse multiply(MultiplyRequest param0) {
        Object[] params = new Object[ 1 ] ;
        params[ 0 ] = param0;
        List<Object> returnParamList = new ArrayList<Object>();
        try {
            m_service.invoke("multiply", params, returnParamList);
        } catch (ServiceInvocationException svcInvocationEx) {
            throw wrapInvocationException(svcInvocationEx);
        }
        MultiplyResponse result = ((MultiplyResponse) returnParamList.get(0));
        return result;
    }

}
