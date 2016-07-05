/**
 * 
 */
package com.mindtree.devops.exceptions;

/**
 * @author Orchard
 *
 */
@SuppressWarnings("serial")
public class FetchException extends Exception {

	/**
	 * 
	 */
	public FetchException() {
	}

	/**
	 * @param message
	 */
	public FetchException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public FetchException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public FetchException(String message, Throwable cause) {
		super(message, cause);
	}

}
