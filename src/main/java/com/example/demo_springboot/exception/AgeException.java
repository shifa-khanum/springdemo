package com.example.demo_springboot.exception;

public class AgeException extends Exception{
	private String msg;

	public AgeException(String msg) {
		super();
		this.msg = msg;
	}

	public AgeException() {
		super();
	}
	

}
