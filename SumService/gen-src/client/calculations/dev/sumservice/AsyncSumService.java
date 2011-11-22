
package calculations.dev.sumservice;

import java.util.List;
import java.util.concurrent.Future;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import calculations.dev.SumRequest;
import calculations.dev.SumResponse;

public interface AsyncSumService
    extends SumService
{


    public Future<?> sumAsync(SumRequest param0, AsyncHandler<SumResponse> handler);

    public Response<SumResponse> sumAsync(SumRequest param0);

    public List<Response<?>> poll(boolean block, boolean partial)
        throws InterruptedException
    ;

}
