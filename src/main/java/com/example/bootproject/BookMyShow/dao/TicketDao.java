package com.example.bootproject.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bootproject.BookMyShow.entity.Ticket;
import com.example.bootproject.BookMyShow.repo.TicketRepo;

@Repository
public class TicketDao {
	
	@Autowired
	TicketRepo ticketrepo;
	
	public Ticket saveTicket(Ticket ticket) {
		return ticketrepo.save(ticket);
	}
	public Ticket findTicket(int ticketId) {
		Optional<Ticket> opTicket=ticketrepo.findById(ticketId);
		if(opTicket.isPresent()){
			return opTicket.get();
		}
		return null;
	}
	public Ticket updateTicket(Ticket ticket,int ticketId) {
		Ticket newTicket=findTicket(ticketId);
		if(newTicket != null) {
			ticket.setTicketId(ticketId);
			return ticketrepo.save(ticket);
		}
		return null;
	}
	public Ticket deleteTicket(int ticketId) {
		Ticket ticket=findTicket(ticketId);
		ticketrepo.delete(ticket);
		return ticket;
	}
	public List<Ticket> findAllTicket() {
		return ticketrepo.findAll();
	}


}
