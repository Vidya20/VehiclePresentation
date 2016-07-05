package com.mindtree.awsfinalpresentation.exception;

/*
 *RequestFailedException extends ApplicationException, it throws exception when request 
 * is not able to send to the business layer. 
 */

public class RequestFailedException extends ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RequestFailedException() {
		super();

	}

	public RequestFailedException(String message, Throwable cause) {
		super(message, cause);

	}

	public RequestFailedException(String message) {
		super(message);

	}

	public RequestFailedException(Throwable cause) {
		super(cause);

	}

}
