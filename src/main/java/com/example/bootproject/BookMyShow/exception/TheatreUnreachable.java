package com.example.bootproject.BookMyShow.exception;

public class TheatreUnreachable extends RuntimeException{

	String message;

	public String getMessage() {
		return message;
	}

	public TheatreUnreachable(String message) {
		
		this.message = message;
	}
	
	
}
