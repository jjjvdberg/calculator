
package calculations.dev.parseservice;

import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceException;

import calculations.dev.MultiplyRequest;
import calculations.dev.NegateRequest;
import calculations.dev.ParseRequest;
import calculations.dev.ParseResponse;
import calculations.dev.PowerRequest;
import calculations.dev.SumRequest;
import calculations.dev.multiplyservice.gen.SharedMultiplyServiceConsumer;
import calculations.dev.negateservice.gen.SharedNegateServiceConsumer;
import calculations.dev.powerservice.gen.SharedPowerServiceConsumer;
import calculations.dev.sumservice.SumServiceConsumer;
import calculations.dev.sumservice.gen.SharedSumServiceConsumer;

public class ParseServiceImpl
    implements ParseService
{


    public ParseResponse parse(ParseRequest param0) {
    	
    	ParseResponse response = new ParseResponse();
		
		try {

			SharedPowerServiceConsumer powerConsumer = new SharedPowerServiceConsumer("ParseService");
			SharedMultiplyServiceConsumer multiplyConsumer = new SharedMultiplyServiceConsumer("ParseService");
			SharedSumServiceConsumer sumConsumer = new SharedSumServiceConsumer("ParseService");
			SharedNegateServiceConsumer negateConsumer = new SharedNegateServiceConsumer("ParseService");

	    	String calculation = param0.getInput();
			int x, y;
			
			if(calculation.contains("+")) {
				String[] splitstring = calculation.split("[+]");
				x = Integer.parseInt(splitstring[0]);
				y = Integer.parseInt(splitstring[1]);
				SumRequest request = new SumRequest();
				request.setX(x);
				request.setY(y);
				response.setOutput(sumConsumer.sum(request).getZ());
			} else if (calculation.contains("*")) {
				String[] splitstring = calculation.split("[*]");
				x = Integer.parseInt(splitstring[0]);
				y = Integer.parseInt(splitstring[1]);
				MultiplyRequest request = new MultiplyRequest();
				request.setX(x);
				request.setY(y);
				response.setOutput(multiplyConsumer.multiply(request).getY());	
			} else if (calculation.contains("^")) {
				String[] splitstring = calculation.split("[\\^]");
				x = Integer.parseInt(splitstring[0]);
				y = Integer.parseInt(splitstring[1]);
				PowerRequest request = new PowerRequest();
				request.setX(x);
				request.setY(y);
				response.setOutput(powerConsumer.power(request).getZ());				
			} else if (calculation.contains("-")) {
				String[] splitstring = calculation.split("[\\-]");
				x = Integer.parseInt(splitstring[1]);
				NegateRequest request = new NegateRequest();
				request.setX(x);
				response.setOutput(negateConsumer.negate(request).getY());
			} else {
				x = Integer.parseInt(calculation);
				response.setOutput(x);
			}
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
			
    	return response;
    }

}
