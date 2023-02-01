package com.example.demo_springboot.exception;

public class UserAlreadyExistException extends Exception{
	
	private String msg;

	public UserAlreadyExistException(String msg) {
		super();
		this.msg = msg;
	}

	public UserAlreadyExistException() {
		super();
	}
	
	

}
