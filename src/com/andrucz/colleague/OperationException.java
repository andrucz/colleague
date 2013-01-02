package com.andrucz.colleague;

public class OperationException extends Exception {

	private static final long serialVersionUID = -4784138407716339013L;

	public OperationException() {
	}
	
	public OperationException(String message) {
		super(message);
	}
	
	public OperationException(Throwable cause) {
		super(cause);
	}
	
	public OperationException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
