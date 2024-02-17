package com.example.bootproject.BookMyShow.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component
public class Payment {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int paymentId;
	private double paymentPrice;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public double getPaymentPrice() {
		return paymentPrice;
	}
	public void setPaymentPrice(double paymentPrice) {
		this.paymentPrice = paymentPrice;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentPrice=" + paymentPrice + "]";
	}
	

}
