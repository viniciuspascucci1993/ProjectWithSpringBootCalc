package br.com.sys.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.sys.exceptions.ExceptionHandlerResponse;
import br.com.sys.exceptions.UnsupportedMathOperationException;

@RestController
@ControllerAdvice
public class CustomizedExceptionHandlerResponse extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionHandlerResponse> handleAllExceptions( Exception ex, WebRequest req ) {
		
		ExceptionHandlerResponse exceptionHandlerResponse = new ExceptionHandlerResponse(new Date(), ex.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<>(exceptionHandlerResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UnsupportedMathOperationException.class)
	public final ResponseEntity<ExceptionHandlerResponse> handleBadRequestExceptions( Exception ex, WebRequest req ) {
		
		ExceptionHandlerResponse exceptionHandlerResponse = new ExceptionHandlerResponse(new Date(), ex.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<>(exceptionHandlerResponse, HttpStatus.BAD_REQUEST);
	}

}
