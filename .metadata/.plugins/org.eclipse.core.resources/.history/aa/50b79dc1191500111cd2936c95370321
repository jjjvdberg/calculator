package dev.log.handler;

import javax.xml.stream.XMLStreamException;

import org.ebayopensource.turmeric.runtime.binding.objectnode.impl.JavaObjectNodeImpl;
import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceException;
import org.ebayopensource.turmeric.runtime.common.impl.handlers.BaseHandler;
import org.ebayopensource.turmeric.runtime.common.impl.protocolprocessor.soap.Axis2Utils;
import org.ebayopensource.turmeric.runtime.common.pipeline.InboundMessage;
import org.ebayopensource.turmeric.runtime.common.pipeline.MessageContext;

public class RequestLogHeaderHandler extends BaseHandler {

	public static final String REQUEST_ID = "LOG-REQUEST-ID";
	public static final String SEQUENCE_ID = "LOG-SEQUENCE-ID";
	
	private String requestId = "";
	private int sequenceId = 0;
	private int requestCount = 0;
	
	@Override
	public void invoke(MessageContext ctx) throws ServiceException {

		System.out.println(ctx.getServiceId().getAdminName() + " RequestLogHeaderHandler for "+ctx.getRequestMessage());
		
		/**
		 * Handle an incoming request
		 */
		if(ctx.getRequestMessage() instanceof InboundMessage) {
			String requestId = ctx.getRequestMessage().getTransportHeader(REQUEST_ID);
			String sequenceId = ctx.getRequestMessage().getTransportHeader(SEQUENCE_ID);

			if(requestId != null && sequenceId != null) {
				this.setRequestId(requestId);
				this.setSequenceId(Integer.parseInt(sequenceId));
			} else if (requestId == null && sequenceId == null) {
				this.setRequestId(ctx.getServiceId().getServiceName() + "_" + increaseRequestCount());
				this.setSequenceId(this.getSequenceId());							
			} else {
				throw new ServiceException("requestId and sequenceId were not both set or unset");
			}
		}
		
		/**
		 * Handle an outgoing request
		 */
		else {
			ctx.getRequestMessage().setTransportHeader(REQUEST_ID, getRequestId());
			ctx.getRequestMessage().setTransportHeader(SEQUENCE_ID, getSequenceId() + 1 + "");
		}
		System.out.println("END OF REQUESTLOGHEADERHANDLER");
	}
	
	private int increaseRequestCount(){
		requestCount++;
		return requestCount;
	}
	
	/**
	 * Returns -1 if not initialized
	 * @return 
	 */
	public String getRequestId() {
		return requestId;
	}
	
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	
	/**
	 * Returns -1 if not initialized
	 * @return
	 */
	public int getSequenceId() {
		return sequenceId;
	}
	
	public void setSequenceId(int sequenceId) {
		this.sequenceId = sequenceId;
	}

}
