
package calculations.dev.powerservice;

import java.util.List;
import java.util.concurrent.Future;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import calculations.dev.PowerRequest;
import calculations.dev.PowerResponse;

public interface AsyncPowerService
    extends PowerService
{


    public Future<?> powerAsync(PowerRequest param0, AsyncHandler<PowerResponse> handler);

    public Response<PowerResponse> powerAsync(PowerRequest param0);

    public List<Response<?>> poll(boolean block, boolean partial)
        throws InterruptedException
    ;

}
