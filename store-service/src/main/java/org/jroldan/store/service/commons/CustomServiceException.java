package org.jroldan.store.service.commons;

public class CustomServiceException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CustomServiceException() {
		super();
	}
	
	public CustomServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CustomServiceException(String message) {
		super(message);
	}
	
}

