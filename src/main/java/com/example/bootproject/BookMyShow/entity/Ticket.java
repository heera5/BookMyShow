package com.example.bootproject.BookMyShow.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@Component
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
	private int movieId;
	private String movieName;
	private LocalTime movieStartTime;
	private LocalTime moviesEndTime;
	private String movieLanguage; 
	private LocalDate bookingDate;
	private double totalTicketPrice; 
	@OneToMany(cascade = CascadeType.ALL)
	private List<Seat> ticketSeats;
	@OneToOne(cascade=CascadeType.ALL)
	private Payment payment;
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public LocalTime getMovieStartTime() {
		return movieStartTime;
	}
	public void setMovieStartTime(LocalTime movieStartTime) {
		this.movieStartTime = movieStartTime;
	}
	public LocalTime getMoviesEndTime() {
		return moviesEndTime;
	}
	public void setMoviesEndTime(LocalTime moviesEndTime) {
		this.moviesEndTime = moviesEndTime;
	}
	public String getMovieLanguage() {
		return movieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public double getTotalTicketPrice() {
		return totalTicketPrice;
	}
	public void setTotalTicketPrice(double totalTicketPrice) {
		this.totalTicketPrice = totalTicketPrice;
	}
	public List<Seat> getTicketSeats() {
		return ticketSeats;
	}
	public void setTicketSeats(List<Seat> ticketSeats) {
		this.ticketSeats = ticketSeats;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", movieId=" + movieId + ", movieName=" + movieName
				+ ", movieStartTime=" + movieStartTime + ", moviesEndTime=" + moviesEndTime + ", movieLanguage="
				+ movieLanguage + ", bookingDate=" + bookingDate + ", totalTicketPrice=" + totalTicketPrice
				+ ", ticketSeats=" + ticketSeats + "]";
	}
	

}
