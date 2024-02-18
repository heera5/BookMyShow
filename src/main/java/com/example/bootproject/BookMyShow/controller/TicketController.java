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

import com.example.bootproject.BookMyShow.entity.Ticket;
import com.example.bootproject.BookMyShow.service.TicketService;
import com.example.bootproject.BookMyShow.util.ResponseStructure;
@RestController
@RequestMapping("Ticket")
public class TicketController {
	
	
		    	@Autowired
				TicketService ticketservice;
				
				@PostMapping
				public ResponseEntity<ResponseStructure<Ticket>> saveTicket(@RequestBody Ticket ticket)
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
				public ResponseEntity<ResponseStructure<List<Ticket>>>  findAllTicket(@RequestBody List<Ticket> ticket){
					System.out.println("found all ticket");
					return ticketservice.findAllTicket(ticket);
				}

}
