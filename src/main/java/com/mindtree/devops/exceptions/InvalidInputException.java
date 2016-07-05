/**
 * 
 */
package com.mindtree.devops.exceptions;

/**
 * @author Banu Prakash
 *
 */
@SuppressWarnings("serial")
public class InvalidInputException extends Exception {

	/**
	 * 
	 */
	public InvalidInputException() {
	}

	/**
	 * @param message
	 */
	public InvalidInputException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidInputException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidInputException(String message, Throwable cause) {
		super(message, cause);
	}

}
