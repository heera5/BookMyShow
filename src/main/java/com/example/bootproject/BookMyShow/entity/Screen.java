package com.example.bootproject.BookMyShow.entity;

import java.time.LocalDate;
import java.time.LocalTime;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;
@Entity

public class Screen {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int screenId;
	private LocalTime showTime;
	private LocalDate showDate;
	@OneToOne
	private Movie movie;
	private Status status;
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	public LocalTime getShowTime() {
		return showTime;
	}
	public void setShowTime(LocalTime showTime) {
		this.showTime = showTime;
	}
	public LocalDate getShowDate() {
		return showDate;
	}
	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", showTime=" + showTime + ", showDate=" + showDate + ", movie=" + movie
				+ ", status=" + status + "]";
	}
	
	
	

}
