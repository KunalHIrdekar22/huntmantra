package com.userRegidtrstion.exceptionHandler;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

	/*
	 * @ExceptionHandler(Exception.class) public final ResponseEntity<Object>
	 * handleAllExceptions(Exception ex, WebRequest request) { List<String> details
	 * = new ArrayList<>(); details.add(ex.getLocalizedMessage()); ErrorResponse
	 * error = new ErrorResponse("Server Error", details); return new
	 * ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR); }
	 */
	/*
	 * public ResponseEntity<?> handleResourceNotoundExceptioin() {}
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotoundExceptioin(ResourceNotFoundException exception,WebRequest req)
	{
			ErrorResponse response=new ErrorResponse(new Date(), exception.getMessage(), req.getDescription(false));
		
		return new ResponseEntity(response,HttpStatus.NOT_FOUND);}

	
	@ExceptionHandler(EmailAlreadyExist.class)
	public ResponseEntity<?> handleEmailALreadyExist(EmailAlreadyExist exception,WebRequest req)
	{
			ErrorResponse response=new ErrorResponse(new Date(), exception.getMessage(), req.getDescription(false));
		
		return new ResponseEntity(response,HttpStatus.ALREADY_REPORTED);}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobleException(Exception exception,WebRequest req) {
		//ErrorResponse response=new ErrorResponse(new Date(), exception.getMessage(), req.getDescription(false), )
		ErrorResponse response=new ErrorResponse(new Date(), exception.getMessage(), req.getDescription(false));
		
		return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);}
}
