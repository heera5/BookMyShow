package com.example.bootproject.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bootproject.BookMyShow.entity.Payment;
import com.example.bootproject.BookMyShow.repo.PaymentRepo;


@Repository
public class PaymentDao {
	
	@Autowired
	PaymentRepo paymentrepo;
	
	
	
	public Payment savePayment(Payment payment) {
		return paymentrepo.save(payment);
		
	}
	
	public Payment findPayment(int paymentId)
	{
		Optional<Payment> a=paymentrepo.findById(paymentId);
		if(a.isPresent())
		{
			return a.get();
		}
		return null;
	}

	public Payment deletePayment(int paymentId)
	{
		Payment a=findPayment(paymentId);
		paymentrepo.delete(a);
	    return a;
		
	}
	
	public Payment updatePayment(Payment payment, int paymentId)
	{
		Payment expayment= findPayment(paymentId);
		if(expayment != null)
		{
			payment.setPaymentId(paymentId);
			return paymentrepo.save(payment);
		}
		return null;
	}
	
	public List<Payment> findAllPayment(List<Payment> payment)
	{
		
		List<Payment> expayment =paymentrepo.findAll();
		return expayment;
	}

	

}
