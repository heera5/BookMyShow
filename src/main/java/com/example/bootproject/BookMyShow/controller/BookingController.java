package com.example.bootproject.BookMyShow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootproject.BookMyShow.entity.Booking;
import com.example.bootproject.BookMyShow.service.BookingService;
import com.example.bootproject.BookMyShow.util.ResponseStructure;


@RestController
@RequestMapping("Booking")
public class BookingController {
    	@Autowired
		BookingService bookingservice;
		
		@PostMapping
		public ResponseEntity<ResponseStructure<Booking>> saveBooking(@RequestBody Booking booking)
		{
			System.out.println("saved");
		 return bookingservice.saveBooking(booking);
		}
		
		@GetMapping
		public ResponseEntity<ResponseStructure<Booking>> findBooking(@RequestParam int bookingid)
		{
			System.out.println("found");
			return bookingservice.findBooking(bookingid);
		}
		
		@DeleteMapping
		public ResponseEntity<ResponseStructure<Booking>> deleteBooking(@RequestParam int bookingid)
		{
			System.out.println("deleted");
			return bookingservice.deleteBooking(bookingid);
		}
		@PutMapping
		public ResponseEntity<ResponseStructure<Booking>> updateBooking(@RequestBody Booking booking,@RequestParam int bookingid)
		{
			System.out.println("updated");
			return bookingservice.updateBooking(booking, bookingid);
		}
		
		

}
