package com.example.bootproject.BookMyShow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bootproject.BookMyShow.entity.Seat;

public interface SeatRepo extends JpaRepository<Seat, Integer> {

}
