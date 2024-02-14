package com.example.bootproject.BookMyShow.exception;

public class BookingUnavailable extends RuntimeException{

	String message;

	public String getMessage() {
		return message;
	}

	public BookingUnavailable(String message) {
		super();
		this.message = message;
	}

	

}
