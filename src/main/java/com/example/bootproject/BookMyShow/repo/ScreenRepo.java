package com.example.bootproject.BookMyShow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bootproject.BookMyShow.entity.Screen;

public interface ScreenRepo extends JpaRepository<Screen, Integer> {

}
