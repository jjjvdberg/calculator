
package calculations.dev.negateservice;

import java.util.List;
import java.util.concurrent.Future;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import calculations.dev.NegateRequest;
import calculations.dev.NegateResponse;

public interface AsyncNegateService
    extends NegateService
{


    public Future<?> negateAsync(NegateRequest param0, AsyncHandler<NegateResponse> handler);

    public Response<NegateResponse> negateAsync(NegateRequest param0);

    public List<Response<?>> poll(boolean block, boolean partial)
        throws InterruptedException
    ;

}
