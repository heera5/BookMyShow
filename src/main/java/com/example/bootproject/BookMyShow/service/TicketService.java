package com.example.bootproject.BookMyShow.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bootproject.BookMyShow.dao.MovieDao;
import com.example.bootproject.BookMyShow.dao.PaymentDao;
import com.example.bootproject.BookMyShow.dao.ScreenDao;
import com.example.bootproject.BookMyShow.dao.SeatDao;
import com.example.bootproject.BookMyShow.dao.TicketDao;
import com.example.bootproject.BookMyShow.dto.UserDto;
import com.example.bootproject.BookMyShow.entity.Movie;
import com.example.bootproject.BookMyShow.entity.Payment;
import com.example.bootproject.BookMyShow.entity.Seat;

import com.example.bootproject.BookMyShow.entity.SeatType;
import com.example.bootproject.BookMyShow.entity.Ticket;
import com.example.bootproject.BookMyShow.entity.User;
import com.example.bootproject.BookMyShow.exception.NoPaymentReceived;
import com.example.bootproject.BookMyShow.exception.SeatNotFound;

import com.example.bootproject.BookMyShow.exception.TicketNotFound;
import com.example.bootproject.BookMyShow.exception.UserNotFound;
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
	UserService userservice;
	@Autowired
	MovieService movieservice;
	@Autowired
	SeatRepo seatrepo;
	@Autowired
	PaymentDao paymentdao;
	@Autowired
	ScreenDao screendao;
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
	

	public ResponseEntity<ResponseStructure<List<Ticket>>> findAllTicket() {
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
				structure.setMessage("assign Payment to Seat success");
				structure.setStatus(HttpStatus .OK.value());
				structure.setData(ticket);
				return new ResponseEntity<ResponseStructure<Ticket>>(structure,HttpStatus.OK);
			}
			else 
			{
				throw new NoPaymentReceived("payment not assigned to the ticket because,payment not found for the given ticket id");
			}
			
		}
		throw new TicketNotFound("no ticket found");
	
}
	
public ResponseEntity<ResponseStructure<Ticket>> addSeatToTicket(int seatId,int ticketId)
{
	Ticket ticket1=new Ticket();
	ModelMapper mapper=new ModelMapper();

	Ticket ticket = ticketdao.findTicket(ticketId);
	if(ticket!=null)
	{
		    List<Seat> seatList = seatdao.findAllSeat();
		    List<Seat> ticketSeatList = ticket.getTicketSeats();
		    if(ticketSeatList == null)
		    {
		    	List<Seat> newSeatList=new ArrayList<Seat>();
		    	newSeatList.add(seatdao.findSeat(ticketId));
		    	ticket.setTicketSeats(ticketSeatList);	
		    }
		    else 
		    {
		    	for (Seat seat : seatList) 
		    	{
		    		if(seat.getSeatId()== seatId)
		    		{
		    			ticketSeatList.add(seatdao.findSeat(seatId));
		    			ticket.setTicketSeats(ticketSeatList);
		    		}
					
				}
		    }
		    
		    mapper.map(ticketdao.updateTicket(ticket,ticket.getTicketId()), ticket);
		    ResponseStructure<Ticket> structure=new ResponseStructure<Ticket>();
		    structure.setMessage("Seat list assign to Ticket");
		    structure.setStatus(HttpStatus.OK.value());
		    structure.setData(ticket);
		    
		    return new ResponseEntity<ResponseStructure<Ticket>>(structure,HttpStatus.OK);
	}
	throw new TicketNotFound("Ticket object is not found for the given ");
}

public ResponseEntity<ResponseStructure<Ticket>> ticketBooking(String userEmail,String userPassword,int movieId,Payment payment){
	ResponseEntity<ResponseStructure<UserDto>> user=userservice.userLogin(userEmail, userPassword);
	if(user != null) {
		
	Ticket ticket=new Ticket();
	if(ticket!=null)
	{
		int sum=0;
		    	for (Seat seat : ticket.getTicketSeats()) 
		    	{
		    		if(seat.getSeatType() == seat.getSeatType().A)
		    		{
		    			sum=200+sum;
		    		}
		    		else if (seat.getSeatType()==seat.getSeatType().B) {
						sum=170+sum;
					}
		    		else
		    		{
		    			sum=100+sum;
		    		}
		    		
					
				}
		     ticket.setTotalTicketPrice(sum);
		    }
	
	ticket.setBookingDate(ticket.getBookingDate());
	Movie movie=moviedao.findMovie(movieId);
	ticket.setTicketId(ticket.getTicketId());
	ticket.setMovieId(movieId);
	ticket.setMovieName(movie.getMovieName());
	ticket.setMovieLanguage(ticket.getMovieLanguage());
	ticket.setMovieStartTime(ticket.getMovieStartTime());
	ticket.setMoviesEndTime(ticket.getMoviesEndTime());
	ticket.setPayment(payment);
	ticket.setBookingDate(ticket.getBookingDate());
	ticket.setTicketSeats(ticket.getTicketSeats());
	ticket.setTotalTicketPrice(ticket.getTotalTicketPrice());
	
	Ticket newTicket=ticketdao.updateTicket(ticket, movieId);
	ResponseStructure<Ticket> structure=new ResponseStructure<Ticket>();
	structure.setMessage("ticket booked successfully");
	structure.setStatus(HttpStatus.CREATED.value());
	structure.setData(newTicket);
	return new ResponseEntity<ResponseStructure<Ticket>>(structure,HttpStatus.CREATED);
	}
	throw new  SeatNotFound("ticket are not available ,plz check user login ");
	
}



}
