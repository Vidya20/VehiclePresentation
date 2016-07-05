/**
 * 
 */
package com.mindtree.devops.exceptions;

/**
 * @author Orchard
 *
 */
@SuppressWarnings("serial")
public class PersistException extends Exception {

	/**
	 * 
	 */
	public PersistException() {
	}

	/**
	 * @param message
	 */
	public PersistException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public PersistException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public PersistException(String message, Throwable cause) {
		super(message, cause);
	}

}
