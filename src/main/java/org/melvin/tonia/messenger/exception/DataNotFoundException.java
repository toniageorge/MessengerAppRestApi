package org.melvin.tonia.messenger.exception;

import javax.ws.rs.ext.Provider;


public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7615543723521194747L;
	
	

	public DataNotFoundException(String message) {
		super(message);
		
	}

}
