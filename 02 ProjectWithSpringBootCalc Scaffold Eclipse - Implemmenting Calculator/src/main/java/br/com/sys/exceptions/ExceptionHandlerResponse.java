package br.com.sys.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionHandlerResponse implements Serializable{

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	private Date timeStamp;
	
	private String message;
	
	private String details;

	public ExceptionHandlerResponse(Date timeStamp, String message, String details) {
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
}
