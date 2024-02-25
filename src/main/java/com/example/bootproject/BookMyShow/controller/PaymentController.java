package com.example.bootproject.BookMyShow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootproject.BookMyShow.entity.Payment;
import com.example.bootproject.BookMyShow.service.PaymentService;
import com.example.bootproject.BookMyShow.util.ResponseStructure;

import jakarta.validation.Valid;
@RestController
@RequestMapping("Payment")
public class PaymentController {
	
	    	@Autowired
			PaymentService paymentservice;
			
			@PostMapping
			public ResponseEntity<ResponseStructure<Payment>> savePayment(@Valid @RequestBody Payment payment,BindingResult Result)
			{
				System.out.println("saved");
			 return paymentservice.savePayment(payment);
			}
			
			@GetMapping
			public ResponseEntity<ResponseStructure<Payment>> findPayment(@RequestParam int paymentid)
			{
				System.out.println("found");
				return paymentservice.findPayment(paymentid);
			}
			
			@DeleteMapping
			public ResponseEntity<ResponseStructure<Payment>> deletePayment(@RequestParam int paymentid)
			{
				System.out.println("deleted");
				return paymentservice.deletePayment(paymentid);
			}
			@PutMapping
			public ResponseEntity<ResponseStructure<Payment>> updatePayment(@RequestBody Payment payment,@RequestParam int paymentid)
			{
				System.out.println("updated");
				return paymentservice.updatePayment(payment, paymentid);
			}
			
			@GetMapping("found all")
			public ResponseEntity<ResponseStructure<List<Payment>>>  findAllPayment(){
				System.out.println("found all laptop");
				return paymentservice.findAllPayment();
			}

}
