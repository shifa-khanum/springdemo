package com.example.demo_springboot.exception;

public class MaximumLengthExceededException extends Exception{
	
	private String msg;

	public MaximumLengthExceededException(String msg) {
		super();
		this.msg = msg;
	}

	public MaximumLengthExceededException() {
		super();
	}
	

}
