package com.example.bootproject.BookMyShow.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Booking {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String showName;
	private LocalDate showDate;
	private LocalTime showTime;
	private int ticketCount;
	private double totalAmount;
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public LocalDate getShowDate() {
		return showDate;
	}
	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}
	public LocalTime getShowTime() {
		return showTime;
	}
	public void setShowTime(LocalTime showTime) {
		this.showTime = showTime;
	}
	public int getTicketCount() {
		return ticketCount;
	}
	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "Booking [showName=" + showName + ", showDate=" + showDate + ", showTime=" + showTime + ", ticketCount="
				+ ticketCount + ", totalAmount=" + totalAmount + ", getShowName()=" + getShowName() + ", getShowDate()="
				+ getShowDate() + ", getShowTime()=" + getShowTime() + ", getTicketCount()=" + getTicketCount()
				+ ", getTotalAmount()=" + getTotalAmount() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
