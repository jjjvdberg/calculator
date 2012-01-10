package dev.log.handler;

import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceException;
import org.ebayopensource.turmeric.runtime.common.impl.handlers.BaseHandler;
import org.ebayopensource.turmeric.runtime.common.pipeline.Message;
import org.ebayopensource.turmeric.runtime.common.pipeline.MessageContext;
import org.ebayopensource.turmeric.runtime.common.pipeline.OutboundMessage;

import dev.log.barinel.translate.Execution;

/**
 * This is the hackiest way of determining the endpoint of the process:
 * A request is always initialized from the parseservice when the parseservice
 * returns a response, this is automatically the end point of the process.
 * @author Joel
 *
 */

public class ResponseLogHeaderHandler extends BaseHandler {

	public static final String PROCESS_ID = "LOG-PROCESS-ID";
	public static final String INVOKER_ID = "LOG-INVOKER-ID";
	
	@Override
	public void invoke(MessageContext ctx) throws ServiceException {

//		System.out.println("RESPONSE HANDLER ADDED");
//		Message responseMsg = ctx.getResponseMessage();
//		 
//		/* Handle outgoing responses */
//		if(responseMsg instanceof OutboundMessage) { 
//			Execution.addToMatrix(ctx.getRequestMessage().getTransportHeader(PROCESS_ID),1);
//		}
	}

}
