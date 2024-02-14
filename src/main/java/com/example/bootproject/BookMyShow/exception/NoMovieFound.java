package com.example.bootproject.BookMyShow.exception;

public class NoMovieFound extends RuntimeException{

	String message;

	public String getMessage() {
		return message;
	}

	public NoMovieFound(String message) {
		super();
		this.message = message;
	}
	
}
