package com.example.bootproject.BookMyShow.exception;

public class ScreenNotFound extends RuntimeException {

	String message;

	public String getMessage() {
		return message;
	}

	public ScreenNotFound(String message) {
		super();
		this.message = message;
	}
	
	

	
	
}
