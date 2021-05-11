package com.org.library.books.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class ExceptionHandeler {

	private static final Logger log = LoggerFactory.getLogger(ExceptionHandeler.class);

	@ExceptionHandler({ BookNotFoundException.class })
	public ResponseEntity<String> bookNotFoundException(BookNotFoundException e) {
		log.error("BookNotFoundException  {}", e);
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ ParseException.class })
	public ResponseEntity<String> parseException(ParseException e) {
		log.error("ParseException  {}", e);
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ RequestValidationException.class })
	public ResponseEntity<String> requestValidationException(RequestValidationException e) {
		log.error("RequestValidationException  {}", e);
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler({ Exception.class })
	public ResponseEntity<String> exception(Exception e) {
		log.error("Exception occured {}", e);
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
