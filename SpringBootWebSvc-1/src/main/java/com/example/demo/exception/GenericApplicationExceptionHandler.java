package com.example.demo.exception;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GenericApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	Logger log = LoggerFactory.getLogger(GenericApplicationExceptionHandler.class);

	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {
		log.info("handleAllException(+)");
		GenericExceptionResponse genericExceptionResponse = new GenericExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		log.info("handleAllException(-)");
		return new ResponseEntity<Object>(genericExceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		log.info("handleAllException(+)");
		GenericExceptionResponse genericExceptionResponse = new GenericExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		log.info("handleAllException(-)");
		return new ResponseEntity<Object>(genericExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InvalidUserNameException.class)
	public final ResponseEntity<Object> handleInvalidUserNameException(Exception ex, WebRequest request) {
		log.info("handleAllException(+)");
		GenericExceptionResponse genericExceptionResponse = new GenericExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		log.info("handleAllException(-)");
		return new ResponseEntity<Object>(genericExceptionResponse, HttpStatus.FORBIDDEN);
	}
	

}
