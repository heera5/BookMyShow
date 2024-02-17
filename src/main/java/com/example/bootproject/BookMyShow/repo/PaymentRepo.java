package com.example.bootproject.BookMyShow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bootproject.BookMyShow.entity.Payment;


public interface PaymentRepo extends JpaRepository<Payment, Integer>{
	
	

}
