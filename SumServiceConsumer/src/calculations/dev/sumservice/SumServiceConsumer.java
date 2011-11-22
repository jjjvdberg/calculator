package calculations.dev.sumservice;

import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceException;

import calculations.dev.SumRequest;
import calculations.dev.SumResponse;
import calculations.dev.sumservice.gen.SharedSumServiceConsumer;

public class SumServiceConsumer extends SharedSumServiceConsumer {

	public SumServiceConsumer(String clientName) throws ServiceException {
		super(clientName);
		// TODO Auto-generated constructor stub
	}
	
	public static int sum(int x, int y) throws ServiceException {
		SumServiceConsumer consumer = new SumServiceConsumer("SumServiceConsumer");
		SumRequest request = new SumRequest();
		request.setX(x);
		request.setY(y);
		SumResponse response = consumer.sum(request);
		return response.getZ();
	}
	
	public static void main(String[] args) throws ServiceException {
		System.out.println(sum(3,2));
	}

}
