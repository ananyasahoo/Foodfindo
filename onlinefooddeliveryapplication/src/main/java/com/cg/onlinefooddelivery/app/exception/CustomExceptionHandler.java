package com.cg.onlinefooddelivery.app.exception;
/*
 * global Exception handler
 */
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleRestaurantNotFoundException(ResourceNotFoundException ex,WebRequest request)
	{
		ExceptionResponse restaurantNotFoundException=new ExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(restaurantNotFoundException,HttpStatus.BAD_REQUEST);
	}
	
}
