package com.org.library.books.exception;

public class RequestValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RequestValidationException(String messeage) {
		super(messeage);
	}

}
