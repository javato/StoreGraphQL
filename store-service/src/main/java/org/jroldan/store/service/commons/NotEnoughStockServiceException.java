package org.jroldan.store.service.commons;

public class NotEnoughStockServiceException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public NotEnoughStockServiceException() {
		super();
	}
	
	public NotEnoughStockServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public NotEnoughStockServiceException(String message) {
		super(message);
	}
}
