
package calculations.dev.multiplyservice;

import java.util.List;
import java.util.concurrent.Future;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import calculations.dev.MultiplyRequest;
import calculations.dev.MultiplyResponse;

public interface AsyncMultiplyService
    extends MultiplyService
{


    public Future<?> multiplyAsync(MultiplyRequest param0, AsyncHandler<MultiplyResponse> handler);

    public Response<MultiplyResponse> multiplyAsync(MultiplyRequest param0);

    public List<Response<?>> poll(boolean block, boolean partial)
        throws InterruptedException
    ;

}
