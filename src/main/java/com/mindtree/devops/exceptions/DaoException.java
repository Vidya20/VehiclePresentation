/**
 * 
 */
package com.mindtree.devops.exceptions;

/**
 * @author Orchard
 *
 */
@SuppressWarnings("serial")
public class DaoException extends Exception {

	/**
	 * 
	 */
	public DaoException() { 
	}

	/**
	 * @param message
	 */
	public DaoException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public DaoException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

}
