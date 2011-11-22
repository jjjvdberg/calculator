
package calculations.dev.parseservice;

import java.util.List;
import java.util.concurrent.Future;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import calculations.dev.ParseRequest;
import calculations.dev.ParseResponse;

public interface AsyncParseService
    extends ParseService
{


    public Future<?> parseAsync(ParseRequest param0, AsyncHandler<ParseResponse> handler);

    public Response<ParseResponse> parseAsync(ParseRequest param0);

    public List<Response<?>> poll(boolean block, boolean partial)
        throws InterruptedException
    ;

}
