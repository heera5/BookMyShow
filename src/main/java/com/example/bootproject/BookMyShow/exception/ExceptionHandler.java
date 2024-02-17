package com.example.bootproject.BookMyShow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.bootproject.BookMyShow.util.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
   
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> AdminNotFoundException(AdminNotFound ex)
	{
		 ResponseStructure<String> structure=new ResponseStructure<String>();
		 structure.setData(ex.getMessage());
		 structure.setMessage("Admin not found");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> BookingUnavailableException(BookingUnavailable ex)
	{
		 ResponseStructure<String> structure=new ResponseStructure<String>();
		 structure.setData(ex.getMessage());
		 structure.setMessage("Booking Unavailable");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> NoListFoundException(NoListFound ex)
	{
		 ResponseStructure<String> structure=new ResponseStructure<String>();
		 structure.setData(ex.getMessage());
		 structure.setMessage("No list found ");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> NoMovieFoundException(NoMovieFound ex)
	{
		 ResponseStructure<String> structure=new ResponseStructure<String>();
		 structure.setData(ex.getMessage());
		 structure.setMessage("No moive found in the theatre");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>>ScreenNotFoundException(ScreenNotFound ex)
	{
		 ResponseStructure<String> structure=new ResponseStructure<String>();
		 structure.setData(ex.getMessage());
		 structure.setMessage("Screen not found");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> TheatreAdminNotFoundException(TheatreAdminNotFound ex)
	{
		 ResponseStructure<String> structure=new ResponseStructure<String>();
		 structure.setData(ex.getMessage());
		 structure.setMessage("TheatreAdmin not found");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> TheatreUnreachableException(TheatreUnreachable ex)
	{
		 ResponseStructure<String> structure=new ResponseStructure<String>();
		 structure.setData(ex.getMessage());
		 structure.setMessage("Currently theatre is unreachable now!!!!!!");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> UserNotFoundException(UserNotFound ex)
	{
		 ResponseStructure<String> structure=new ResponseStructure<String>();
		 structure.setData(ex.getMessage());
		 structure.setMessage("User not found");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> ReviewNotFoundException(ReviewNotFound ex)
	{
		 ResponseStructure<String> structure=new ResponseStructure<String>();
		 structure.setData(ex.getMessage());
		 structure.setMessage("Review not found");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> SeatNotFoundException(SeatNotFound ex)
	{
		 ResponseStructure<String> structure=new ResponseStructure<String>();
		 structure.setData(ex.getMessage());
		 structure.setMessage("Seat not found");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> TicketNotFoundException(TicketNotFound ex)
	{
		 ResponseStructure<String> structure=new ResponseStructure<String>();
		 structure.setData(ex.getMessage());
		 structure.setMessage("Ticket not found");
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
