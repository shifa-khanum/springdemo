package com.example.demo_springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=UserAlreadyExistException.class)
	public ResponseEntity<String> userAlreadyExistException(UserAlreadyExistException msg){
		return new ResponseEntity<String>("User Already Exist,Please Try Again.",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=MaximumLengthExceededException.class)
	public ResponseEntity<String> maximumLengthExceededException(MaximumLengthExceededException msg){
		return new ResponseEntity<String>("Maximum Length Exceeded,Please Try Again.",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=AgeException.class)
	public ResponseEntity<String> ageException(AgeException msg){
		return new ResponseEntity<String>("Age Not Less Than 18,Please Try Again.",HttpStatus.CONFLICT);
	}

}
