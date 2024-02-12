package com.example.bootproject.BookMyShow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bootproject.BookMyShow.entity.Theatre;

public interface TheatreRepo extends JpaRepository<Theatre, Integer> {

}
