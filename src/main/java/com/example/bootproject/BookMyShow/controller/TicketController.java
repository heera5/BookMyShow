package com.example.bootproject.BookMyShow.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootproject.BookMyShow.entity.Payment;
import com.example.bootproject.BookMyShow.entity.SeatType;
import com.example.bootproject.BookMyShow.entity.Ticket;
import com.example.bootproject.BookMyShow.service.TicketService;
import com.example.bootproject.BookMyShow.util.ResponseStructure;

import jakarta.validation.Valid;
@RestController
@RequestMapping("Ticket")
public class TicketController {
	
	
		    	@Autowired
				TicketService ticketservice;
				
				@PostMapping
				public ResponseEntity<ResponseStructure<Ticket>> saveTicket(@Valid @RequestBody Ticket ticket,BindingResult Result)
				{
					System.out.println("saved");
				 return ticketservice.saveTicket(ticket);
				}
				
				@GetMapping
				public ResponseEntity<ResponseStructure<Ticket>> findTicket(@RequestParam int ticketid)
				{
					System.out.println("found");
					return ticketservice.findTicket(ticketid);
				}
				
				@DeleteMapping
				public ResponseEntity<ResponseStructure<Ticket>> deleteTicket(@RequestParam int ticketid)
				{
					System.out.println("deleted");
					return ticketservice.deleteTicket(ticketid);
				}
				@PutMapping
				public ResponseEntity<ResponseStructure<Ticket>> updateTicket(@RequestBody Ticket ticket,@RequestParam int ticketid)
				{
					System.out.println("updated");
					return ticketservice.updateTicket(ticket, ticketid);
				}
				
				@GetMapping("found all")
				public ResponseEntity<ResponseStructure<List<Ticket>>>  findAllTicket(){
					System.out.println("found all ticket");
					return ticketservice.findAllTicket();
				}
				@GetMapping("assign")
				public ResponseEntity<ResponseStructure<Ticket>> assignPaymentToTicket(@RequestParam int paymentId,@RequestParam int ticketId){
					System.out.println("assigning paymentdetails to ticket don!!!!!!!!!!!!");
					return ticketservice.assignPaymentToTicket(paymentId, ticketId);
				}
				
				@PutMapping("ticketbooking")
				public ResponseEntity<ResponseStructure<Ticket>> ticketBooking(@RequestParam String userEmail,@RequestParam String userPassword,@RequestParam int movieId,
					@RequestBody	Payment payment){
					System.out.println(" ticketbooking don!!!!!!!!!!!!");
					return ticketservice.ticketBooking(userEmail, userPassword, movieId, payment);
				}
				}

