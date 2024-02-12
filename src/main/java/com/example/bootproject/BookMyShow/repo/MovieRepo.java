package com.example.bootproject.BookMyShow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bootproject.BookMyShow.entity.Movie;

public interface MovieRepo extends  JpaRepository<Movie, Integer> {

}
