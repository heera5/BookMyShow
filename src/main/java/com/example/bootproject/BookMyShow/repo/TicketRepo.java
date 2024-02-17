package com.example.bootproject.BookMyShow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bootproject.BookMyShow.entity.Ticket;

public interface TicketRepo  extends JpaRepository<Ticket, Integer>{

}
