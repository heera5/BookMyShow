package com.example.bootproject.BookMyShow.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.bootproject.BookMyShow.entity.TheatreAdmin;

public interface TheatreAdminRepo extends JpaRepository<TheatreAdmin, Integer> {

}
