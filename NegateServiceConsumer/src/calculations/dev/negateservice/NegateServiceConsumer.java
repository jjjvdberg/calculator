package calculations.dev.negateservice;

import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceException;

import calculations.dev.NegateRequest;
import calculations.dev.NegateResponse;
import calculations.dev.negateservice.gen.SharedNegateServiceConsumer;

public class NegateServiceConsumer extends SharedNegateServiceConsumer {

	public NegateServiceConsumer(String clientName) throws ServiceException {
		super(clientName);
		// TODO Auto-generated constructor stub
	}
	
	public static int negate(int x) throws ServiceException {
		NegateServiceConsumer consumer = new NegateServiceConsumer("NegateServiceConsumer");
		NegateRequest request = new NegateRequest();
		request.setX(x);
		NegateResponse response = consumer.negate(request);
		return response.getY();
	}
	
	public static void main(String[] args) throws ServiceException {
		System.out.println(negate(3));
	}

}
