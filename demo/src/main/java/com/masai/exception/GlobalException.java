package com.masai.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<MyError> GetEmployeeExcetion(EmployeeException ce,WebRequest req){
		
		MyError err=new MyError();
		err.setDate(LocalDate.now());
		err.setMessage(ce.getMessage());
		err.setDiscription(req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.OK);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> HndalAllException(Exception ce,WebRequest req){
		MyError err=new MyError();
		err.setDate(LocalDate.now());
		err.setMessage(ce.getMessage());
		err.setDiscription(req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.OK);
		
	}

}
