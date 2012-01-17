package dev.log.handler;

import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceException;
import org.ebayopensource.turmeric.runtime.common.impl.handlers.BaseHandler;
import org.ebayopensource.turmeric.runtime.common.pipeline.InboundMessage;
import org.ebayopensource.turmeric.runtime.common.pipeline.Message;
import org.ebayopensource.turmeric.runtime.common.pipeline.MessageContext;

import dev.log.trace.ServiceHit;

public class RequestLogHeaderHandler extends BaseHandler {

	public static final String EXECUTION_HEADER = "EXECUTION-ID";
	
	private final boolean debug = false;
	private final boolean easytoread = true;	
	
	private String service_id;
	
	public void init(InitContext ctx) throws ServiceException {
		if(ctx.getServiceId().getNamespace() != null) {
			String namespace = ctx.getServiceId().getNamespace().split("//")[1];
			if(!easytoread)
				service_id = namespace + "_" + ctx.getServiceId().getAdminName();
			else 
				service_id = ctx.getServiceId().getAdminName();
		} else {
			service_id = ctx.getServiceId().getAdminName();
		}
	}
	
	@Override
	public void invoke(MessageContext ctx) throws ServiceException {

		if(debug)System.out.println(ctx.getServiceId().getAdminName() + " RequestLogHeaderHandler for "+ctx.getRequestMessage());
		

		Message requestMsg = ctx.getRequestMessage();
		String executionId = requestMsg.getTransportHeader(EXECUTION_HEADER);
		
		/**
		 * Handle an incoming request
		 */
		if(requestMsg instanceof InboundMessage) {
			
			if(debug)System.out.println("Handling incoming message:");
			if(debug)System.out.println(executionId);
			
			/**
			 * The request doesn't contain headers
			 */
			if(executionId == null) {
				/**
				 * Initialize the request chain at this service
				 */
				executionId = service_id + "_" + ServiceHit.getCounter();
			}

			requestMsg.setTransportHeader(EXECUTION_HEADER, executionId);

			logIncomingMessage(ctx);
		}
		
		/**
		 * Handle an outgoing request
		 */
		else {
			if(debug)System.out.println("Handling outgoing message:");
		}
		
		if(debug)System.out.println("END OF REQUESTLOGHEADERHANDLER");
	}
	
	private void logIncomingMessage(MessageContext ctx) throws ServiceException {
		Message requestMsg = ctx.getRequestMessage();
		String execution_id = requestMsg.getTransportHeader(EXECUTION_HEADER);
		
		String interface_id;
		String service_id;

		if(!easytoread) {
			interface_id = ctx.getOperationName() + "_" + ctx.getRequestMessage().getParam(0);
			service_id = ctx.getServiceAddress().getServiceLocationUrl() + "@" + this.service_id;
		}
		else {
			interface_id = ctx.getOperationName();
			service_id = this.service_id;
		}
		
		boolean failure = false; /* TODO fix this */
		ServiceHit.writeToDatabase(service_id, interface_id, execution_id, failure);
		
	}

}
