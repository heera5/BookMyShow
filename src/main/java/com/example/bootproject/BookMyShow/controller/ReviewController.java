package com.example.bootproject.BookMyShow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootproject.BookMyShow.entity.Admin;
import com.example.bootproject.BookMyShow.entity.Review;
import com.example.bootproject.BookMyShow.service.ReviewService;
import com.example.bootproject.BookMyShow.util.ResponseStructure;

import jakarta.validation.Valid;



@RestController
@RequestMapping("Review")

public class ReviewController {
    	@Autowired
		ReviewService reviewservice;
		
		@PostMapping
		public ResponseEntity<ResponseStructure<Review>> saveReview(@Valid @RequestBody Review review,BindingResult Result)
		{
			System.out.println("saved");
		 return reviewservice.saveReview(review);
		}
		
		@GetMapping
		public ResponseEntity<ResponseStructure<Review>> findReview(@RequestParam int reviewid)
		{
			System.out.println("found");
			return reviewservice.findReview(reviewid);
		}
		
		@DeleteMapping
		public ResponseEntity<ResponseStructure<Review>> deleteReview(@RequestParam int reviewid)
		{
			System.out.println("deleted");
			return reviewservice.deleteReview(reviewid);
		}
		@PutMapping
		public ResponseEntity<ResponseStructure<Review>> updateReview(@RequestBody Review review,@RequestParam int reviewid)
		{
			System.out.println("updated");
			return reviewservice.updateReview(review, reviewid);
		}
		
		@GetMapping("found all")
		public ResponseEntity<ResponseStructure<List<Review>>>  findAllReview(@RequestBody List<Review> review){
			System.out.println("found all laptop");
			return reviewservice.findAllReview(review);
		}

}
