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
	private String paymentMadeBy;
	private String paymentMode;
	private long PaymentContact;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentMadeBy() {
		return paymentMadeBy;
	}
	public void setPaymentMadeBy(String paymentMadeBy) {
		this.paymentMadeBy = paymentMadeBy;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public long getPaymentContact() {
		return PaymentContact;
	}
	public void setPaymentContact(long paymentContact) {
		PaymentContact = paymentContact;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentMadeBy=" + paymentMadeBy + ", paymentMode=" + paymentMode
				+ ", PaymentContact=" + PaymentContact + "]";
	}
	
	
	

}
