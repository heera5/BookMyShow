package com.example.bootproject.BookMyShow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bootproject.BookMyShow.dao.MovieDao;
import com.example.bootproject.BookMyShow.dao.PaymentDao;
import com.example.bootproject.BookMyShow.dao.SeatDao;
import com.example.bootproject.BookMyShow.dao.TicketDao;
import com.example.bootproject.BookMyShow.entity.Movie;
import com.example.bootproject.BookMyShow.entity.Payment;
import com.example.bootproject.BookMyShow.entity.Seat;
import com.example.bootproject.BookMyShow.entity.SeatType;
import com.example.bootproject.BookMyShow.entity.Ticket;
import com.example.bootproject.BookMyShow.exception.NoPaymentReceived;
import com.example.bootproject.BookMyShow.exception.SeatNotFound;
import com.example.bootproject.BookMyShow.exception.TicketNotFound;
import com.example.bootproject.BookMyShow.repo.SeatRepo;
import com.example.bootproject.BookMyShow.repo.UserRepo;
import com.example.bootproject.BookMyShow.util.ResponseStructure;
@Service
public class TicketService {
	@Autowired
	UserRepo userepo;
	@Autowired
	TicketDao ticketdao;
	@Autowired
	SeatDao seatdao;
	@Autowired
	MovieService movieservice;
	@Autowired
	SeatRepo seatrepo;
	@Autowired
	PaymentDao paymentdao;
	@Autowired
	MovieDao moviedao;
	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(Ticket ticket) {
		ResponseStructure<Ticket> structure=new ResponseStructure<Ticket>();
		structure.setMessage("Ticket save success");
		structure.setStatus(HttpStatus .CREATED.value());
		structure.setData(ticketdao.saveTicket(ticket));
		return new ResponseEntity<ResponseStructure<Ticket>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Ticket>> findTicket(int ticketId) {
		ResponseStructure<Ticket> structure=new ResponseStructure<Ticket>();
		Ticket ticket=ticketdao.findTicket(ticketId);
		if(ticket != null) {
		structure.setMessage("Ticket found success");
		structure.setStatus(HttpStatus .FOUND.value());
		structure.setData(ticket);
		return new ResponseEntity<ResponseStructure<Ticket>>(structure,HttpStatus.FOUND);
		}
		throw new TicketNotFound("ticket not found for the given id");
	}
	public ResponseEntity<ResponseStructure<Ticket>> deleteTicket(int ticketId) {
		ResponseStructure<Ticket> structure=new ResponseStructure<Ticket>();
		Ticket ticket=ticketdao.findTicket(ticketId);
		if(ticket != null) {
		structure.setMessage("Ticket Delete success");
		structure.setStatus(HttpStatus .OK.value());
		structure.setData(ticketdao.deleteTicket(ticketId));
		return new ResponseEntity<ResponseStructure<Ticket>>(structure,HttpStatus.OK);
		}
		throw new TicketNotFound("ticket not deleted because,ticket not found for the given id");
	}
  	
	public ResponseEntity<ResponseStructure<Ticket>> updateTicket(Ticket ticket,int ticketId) {
		ResponseStructure<Ticket> structure=new ResponseStructure<Ticket>();
		Ticket newTicket=ticketdao.updateTicket(ticket,ticketId);
		if(newTicket != null) {
		structure.setMessage("Ticket update success");
		structure.setStatus(HttpStatus .OK.value());
		structure.setData(newTicket);
		return new ResponseEntity<ResponseStructure<Ticket>>(structure,HttpStatus.OK);
		}
		throw new TicketNotFound("ticket not updated because,ticket not found for the given id");
	}
	public List<Seat> bookSeat(List<Seat> availableSeats, List<Integer> seatIds, int movieId){
		List<Seat> seats=new ArrayList<Seat>();
		for (Seat seatAvail : availableSeats) {
			for (Integer integer : seatIds) {
				if(seatAvail.getSeatId()==integer) {
					seats.add(seatAvail);
					Movie movie=moviedao.findMovie(movieId);
				//	movie.setTotalNoSeats(movie.getTotalNoSeats()-1);
					moviedao.updateMovie(movie, movieId);
					seatAvail.setSeatAvailability(false);
					seatdao.updateSeat(seatAvail, seatAvail.getSeatId());
				}
			}
		}
		return seats;
	}
	

	public ResponseEntity<ResponseStructure<List<Ticket>>> findAllTicket(List<Ticket> ticket) {
		ResponseStructure<List<Ticket>> structure=new ResponseStructure<List<Ticket>>();
		structure.setMessage("find all Ticket success");
		structure.setStatus(HttpStatus .FOUND.value());
		structure.setData(ticketdao.findAllTicket());
		return new ResponseEntity<ResponseStructure<List<Ticket>>>(structure,HttpStatus.FOUND);
	}

public ResponseEntity<ResponseStructure<Ticket>> assignPaymentToTicket(int paymentId,int ticketId){
		
	    Payment payment = paymentdao.findPayment(paymentId);
	    Ticket ticket = ticketdao.findTicket(ticketId);
		
		if(ticket != null) 
		{
			if(payment != null) 
			{
				ticket.setPayment(payment);
				ResponseStructure<Ticket> structure=new ResponseStructure<Ticket>();
				structure.setMessage("assign Payment to Screen success");
				structure.setStatus(HttpStatus .OK.value());
				structure.setData(ticket);
				return new ResponseEntity<ResponseStructure<Ticket>>(structure,HttpStatus.OK);
			}
			else 
			{
				throw new NoPaymentReceived("movie not assigned to the screen because, movie not found for the given id");
			}
			
		}
		throw new TicketNotFound("we can't assign screen to movie because,screen not found for the given id");
	
}
	

}
