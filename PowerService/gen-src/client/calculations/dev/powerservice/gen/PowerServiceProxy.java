
package calculations.dev.powerservice.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Response;
import calculations.dev.PowerRequest;
import calculations.dev.PowerResponse;
import calculations.dev.powerservice.AsyncPowerService;
import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceInvocationException;
import org.ebayopensource.turmeric.runtime.sif.impl.internal.service.BaseServiceProxy;
import org.ebayopensource.turmeric.runtime.sif.service.Service;


/**
 * Note : Generated file, any changes will be lost upon regeneration.
 * 
 */
public class PowerServiceProxy
    extends BaseServiceProxy<AsyncPowerService>
    implements AsyncPowerService
{


    public PowerServiceProxy(Service service) {
        super(service);
    }

    public Future<?> powerAsync(PowerRequest param0, AsyncHandler<PowerResponse> param1) {
        Dispatch dispatch = m_service.createDispatch("power");
        Future<?> result = dispatch.invokeAsync(param0, param1);
        return result;
    }

    public Response<PowerResponse> powerAsync(PowerRequest param0) {
        Dispatch dispatch = m_service.createDispatch("power");
        Response<PowerResponse> result = dispatch.invokeAsync(param0);
        return result;
    }

    public List<Response<?>> poll(boolean block, boolean partial)
        throws InterruptedException
    {
        return m_service.poll(block, partial);
    }

    public PowerResponse power(PowerRequest param0) {
        Object[] params = new Object[ 1 ] ;
        params[ 0 ] = param0;
        List<Object> returnParamList = new ArrayList<Object>();
        try {
            m_service.invoke("power", params, returnParamList);
        } catch (ServiceInvocationException svcInvocationEx) {
            throw wrapInvocationException(svcInvocationEx);
        }
        PowerResponse result = ((PowerResponse) returnParamList.get(0));
        return result;
    }

}
