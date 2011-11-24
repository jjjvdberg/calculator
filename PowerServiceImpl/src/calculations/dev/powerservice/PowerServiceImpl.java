
package calculations.dev.powerservice;

import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceException;

import calculations.dev.MultiplyRequest;
import calculations.dev.PowerRequest;
import calculations.dev.PowerResponse;
import calculations.dev.multiplyservice.gen.SharedMultiplyServiceConsumer;

public class PowerServiceImpl
    implements PowerService
{


    public PowerResponse power(PowerRequest param0) {
        PowerResponse response = new PowerResponse();
        
    	int total = 0;
    	
    	try {
    		
    		SharedMultiplyServiceConsumer consumer = new SharedMultiplyServiceConsumer("PowerService");
    		
	    	int x = param0.getX();
	        int y = param0.getY();
	                
	        total = x;
        
	    	for(int i = 1; i < y; i++) {
	    		MultiplyRequest request = new MultiplyRequest();
	    		request.setX(total);
	    		request.setY(x);
	    	    total = consumer.multiply(request).getY();	
	    	}
	    	
        } catch(ServiceException e) {
        	e.printStackTrace();
        }

        response.setZ(total);
        return response;
    }

}
