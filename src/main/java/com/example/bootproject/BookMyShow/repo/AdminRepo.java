package com.example.bootproject.BookMyShow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.bootproject.BookMyShow.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{
	

	

}
