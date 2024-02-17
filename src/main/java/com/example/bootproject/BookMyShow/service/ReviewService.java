package com.example.bootproject.BookMyShow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bootproject.BookMyShow.dao.ReviewDao;
import com.example.bootproject.BookMyShow.entity.Review;
import com.example.bootproject.BookMyShow.exception.ReviewNotFound;
import com.example.bootproject.BookMyShow.util.ResponseStructure;

@Service
public class ReviewService {

	@Autowired
	ReviewDao reviewdao;
	
	public ResponseEntity<ResponseStructure<Review>> saveReview(Review review){
		ResponseStructure <Review>structure=new ResponseStructure<Review>();
		Review l=reviewdao.saveReview(review);
		if(l!=null) {
			structure.setMessage("save data ssuccessfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(l);
			return new ResponseEntity<ResponseStructure<Review>>(structure,HttpStatus.CREATED);
			//ResponseEntity<ResponseStructure<Review>>(structure,HttpStatus.CREATED);
		}
		 throw new ReviewNotFound("Review is not avaiable");
		}
		
		public ResponseEntity<ResponseStructure<Review>> findReview(int Reviewid){
			ResponseStructure <Review>structure=new ResponseStructure<Review>();
			Review l=reviewdao.findReview(Reviewid);
			if(l!=null) {
				structure.setMessage("find data ssuccessfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(l);
				return new ResponseEntity<ResponseStructure<Review>>(structure,HttpStatus.FOUND);
			}
			 throw new ReviewNotFound("Review is not found");
			}
		
		public ResponseEntity<ResponseStructure<Review>> deleteReview(int Reviewid){
			ResponseStructure <Review>structure=new ResponseStructure<Review>();
			Review l=reviewdao.deleteReview(Reviewid);
			if(l!=null) {
				structure.setMessage("delete data successfully");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(l);
				return new ResponseEntity<ResponseStructure<Review>>(structure,HttpStatus.OK);
			}
			 throw new ReviewNotFound("unable to delete Review ");
			}
		
		public ResponseEntity<ResponseStructure<Review>> updateReview(Review Review, int Reviewid){
				ResponseStructure <Review>structure=new ResponseStructure<Review>();
				Review l=reviewdao.updateReview(Review,Reviewid);
				if(l!=null) {
					structure.setMessage("update data ssuccessfully");
					structure.setStatus(HttpStatus.OK.value());
					structure.setData(l);
					return new ResponseEntity<ResponseStructure<Review>>(structure,HttpStatus.OK);
				}
				 throw new ReviewNotFound("laptoupdate failed");
				}

}
