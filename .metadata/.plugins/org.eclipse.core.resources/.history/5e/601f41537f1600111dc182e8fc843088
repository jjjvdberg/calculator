package calculations.dev.parseservice;

import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceException;

import calculations.dev.ParseRequest;
import calculations.dev.ParseResponse;
import calculations.dev.parseservice.gen.SharedParseServiceConsumer;

public class ParseServiceConsumer extends SharedParseServiceConsumer {

	public ParseServiceConsumer(String clientName) throws ServiceException {
		super(clientName);
		// TODO Auto-generated constructor stub
	}
	
	public static int parse(String x) throws ServiceException {
		ParseServiceConsumer consumer = new ParseServiceConsumer("ParseServiceConsumer");
		ParseRequest request = new ParseRequest();
		request.setInput(x);
		ParseResponse response = consumer.parse(request);
		return response.getOutput();
	}
	
	public static void main(String[] args) throws ServiceException {
		System.out.println(parse("-3*2"));
	}

}
