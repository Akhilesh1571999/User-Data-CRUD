package com.exception;

public class NoSuchUserFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String message;

	public NoSuchUserFoundException(String message) {
		super(message);
	}
	
	

}
