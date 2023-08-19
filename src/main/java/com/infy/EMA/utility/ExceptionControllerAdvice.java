package com.infy.EMA.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infy.EMA.EmployeeException.EmployeeException;


@RestControllerAdvice
public class ExceptionControllerAdvice {
	private static final Log LOGGER =LogFactory.getLog(ExceptionControllerAdvice.class);
	
    @ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ErrorInfo> exceptionHandler2(EmployeeException ex){
    	LOGGER.error(ex.getMessage(),ex);
    	ErrorInfo e=new ErrorInfo();
    	e.setErrorCode(HttpStatus.BAD_REQUEST.value());
    	e.setErrorMessage(ex.getMessage());
    	return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception ex) {
		return ex.getMessage();
	}
}
