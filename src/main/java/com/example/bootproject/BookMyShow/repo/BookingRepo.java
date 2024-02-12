package com.example.bootproject.BookMyShow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bootproject.BookMyShow.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer>{

}
