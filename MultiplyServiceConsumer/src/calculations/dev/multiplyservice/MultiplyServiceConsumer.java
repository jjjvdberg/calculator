package calculations.dev.multiplyservice;

import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceException;

import calculations.dev.MultiplyRequest;
import calculations.dev.MultiplyResponse;
import calculations.dev.multiplyservice.gen.SharedMultiplyServiceConsumer;

public class MultiplyServiceConsumer extends SharedMultiplyServiceConsumer {

	public MultiplyServiceConsumer(String clientName) throws ServiceException {
		super(clientName);
		// TODO Auto-generated constructor stub
	}
	
	public static int multiply(int x, int y) throws ServiceException {
		MultiplyServiceConsumer consumer = new MultiplyServiceConsumer("MultiplyServiceConsumer");
		MultiplyRequest request = new MultiplyRequest();
		request.setX(x);
		request.setY(y);
		MultiplyResponse response = consumer.multiply(request);
		return response.getY();
	}
	
	public static void main(String[] args) throws ServiceException {
		System.out.println(multiply(-3,6));
	}

}
