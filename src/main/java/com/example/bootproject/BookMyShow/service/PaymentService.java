package com.example.bootproject.BookMyShow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bootproject.BookMyShow.dao.PaymentDao;
import com.example.bootproject.BookMyShow.entity.Payment;
import com.example.bootproject.BookMyShow.entity.Review;
import com.example.bootproject.BookMyShow.entity.Ticket;
import com.example.bootproject.BookMyShow.exception.NoPaymentReceived;
import com.example.bootproject.BookMyShow.exception.TicketNotFound;
import com.example.bootproject.BookMyShow.util.ResponseStructure;
@Service
public class PaymentService {
	
	@Autowired
	PaymentDao paymentdao;
	public ResponseEntity<ResponseStructure<Payment>> savePayment(Payment payment) {
	ResponseStructure<Payment> structure=new ResponseStructure<Payment>();
	structure.setMessage("payment save success");
	structure.setStatus(HttpStatus .CREATED.value());
	structure.setData(paymentdao.savePayment(payment));
	return new ResponseEntity<ResponseStructure<Payment>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Payment>> findPayment(int paymentId) {
	ResponseStructure<Payment> structure=new ResponseStructure<Payment>();
	Payment payment=paymentdao.findPayment(paymentId);
	if(payment != null) {
	structure.setMessage("payment find success");
	structure.setStatus(HttpStatus .FOUND.value());
	structure.setData(payment);
	return new ResponseEntity<ResponseStructure<Payment>>(structure,HttpStatus.FOUND);
	}
	throw new NoPaymentReceived("payment not found for the given id");
	}
	public ResponseEntity<ResponseStructure<Payment>> deletePayment(int paymentId) {
		ResponseStructure<Payment> structure=new ResponseStructure<Payment>();
		Payment payment=paymentdao.findPayment(paymentId);
		if(payment != null) {
		structure.setMessage("payment delete success");
		structure.setStatus(HttpStatus .OK.value());
		structure.setData(paymentdao.deletePayment(paymentId));
		return new ResponseEntity<ResponseStructure<Payment>>(structure,HttpStatus.OK);
		}
		throw new NoPaymentReceived("payment not deleted because,payment not found for the given id");
	}
	public ResponseEntity<ResponseStructure<Payment>> updatePayment(Payment payment,int paymentId) {
		ResponseStructure<Payment> structure=new ResponseStructure<Payment>();
		Payment exPayment=paymentdao.updatePayment(payment,paymentId);
		if(exPayment != null) {
		structure.setMessage("payment update success");
		structure.setStatus(HttpStatus .OK.value());
		structure.setData(exPayment);
		return new ResponseEntity<ResponseStructure<Payment>>(structure,HttpStatus.OK);
		}
		throw new NoPaymentReceived("payment not updated because,payment not found for the given id");
	}
	public ResponseEntity<ResponseStructure<List<Payment>>> findAllPayment(List<Payment> payment) {
		ResponseStructure<List<Payment>> structure=new ResponseStructure<List<Payment>>();
		List<Payment> paymentList=paymentdao.findAllPayment(payment);
		structure.setMessage(" find all payment success");
		structure.setStatus(HttpStatus .FOUND.value());
		structure.setData(paymentList);
		return new ResponseEntity<ResponseStructure<List<Payment>>>(structure,HttpStatus.FOUND);
	}
	

	


}
