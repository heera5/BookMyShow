package com.example.bootproject.BookMyShow.exception;

public class NoPaymentReceived extends RuntimeException {
	
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NoPaymentReceived(String message) {
		
		this.message = message;
	}
	

}
