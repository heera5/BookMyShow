package com.example.bootproject.BookMyShow.exception;

public class NoListFound extends RuntimeException {

	String message;

	public String getMessage() {
		return message;
	}

	public NoListFound(String message) {
		super();
		this.message = message;
	}

	
	
	
}
