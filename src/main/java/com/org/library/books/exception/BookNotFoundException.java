package com.org.library.books.exception;

public class BookNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(long id) {
		super(String.format("Book not found with id %s", id));

	}

}
