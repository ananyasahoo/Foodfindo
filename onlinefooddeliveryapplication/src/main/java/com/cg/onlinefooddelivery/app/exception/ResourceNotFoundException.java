package com.cg.onlinefooddelivery.app.exception;

public class ResourceNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5753665955310900939L;
	public ResourceNotFoundException()
	{
		
	}
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}


