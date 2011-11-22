
package calculations.dev.sumservice;

import calculations.dev.SumRequest;
import calculations.dev.SumResponse;

public class SumServiceImpl
    implements SumService
{


    public SumResponse sum(SumRequest param0) {
        SumResponse response = new SumResponse();
        response.setZ(param0.getX() + param0.getY());
        return response;
    }

}
