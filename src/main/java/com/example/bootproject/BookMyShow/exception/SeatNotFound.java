package com.example.bootproject.BookMyShow.exception;

public class SeatNotFound extends RuntimeException {

	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SeatNotFound(String message) {
		
		this.message = message;
	}
	
	
	
}
