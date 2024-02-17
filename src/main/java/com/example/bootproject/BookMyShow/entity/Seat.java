package com.example.bootproject.BookMyShow.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component
public class Seat {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int seatId;
		private String seatNumber;
		private boolean seatAvailability;
		private SeatType seatType;
		public int getSeatId() {
			return seatId;
		}
		public void setSeatId(int seatId) {
			this.seatId = seatId;
		}
		public String getSeatNumber() {
			return seatNumber;
		}
		public void setSeatNumber(String seatNumber) {
			this.seatNumber = seatNumber;
		}
		public boolean isSeatAvailability() {
			return seatAvailability;
		}
		public void setSeatAvailability(boolean seatAvailability) {
			this.seatAvailability = seatAvailability;
		}
		public SeatType getSeatType() {
			return seatType;
		}
		public void setSeatType(SeatType seatType) {
			this.seatType = seatType;
		}
		@Override
		public String toString() {
			return "Seat [seatId=" + seatId + ", seatNumber=" + seatNumber + ", seatAvailability=" + seatAvailability
					+ ", seatType=" + seatType + ", getSeatId()=" + getSeatId() + ", getSeatNumber()=" + getSeatNumber()
					+ ", isSeatAvailability()=" + isSeatAvailability() + ", getSeatType()=" + getSeatType()
					+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
					+ "]";
		}
		

}
