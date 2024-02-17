package com.example.bootproject.BookMyShow.exception;

public class TicketNotFound extends RuntimeException {
	
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TicketNotFound(String message) {
		
		this.message = message;
	}

	
	

}
