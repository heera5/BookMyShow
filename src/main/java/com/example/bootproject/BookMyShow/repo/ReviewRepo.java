package com.example.bootproject.BookMyShow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bootproject.BookMyShow.entity.Review
;
public interface ReviewRepo extends JpaRepository<Review, Integer> {

}
