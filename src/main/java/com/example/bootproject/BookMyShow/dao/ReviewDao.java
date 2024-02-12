package com.example.bootproject.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bootproject.BookMyShow.entity.Review;
import com.example.bootproject.BookMyShow.repo.ReviewRepo;


@Repository
public class ReviewDao {

			    @Autowired
		    	ReviewRepo reviewrepo;
				
		    	public Review saveReview(Review review) {
					return reviewrepo.save(review);
					
				}
				
				public Review findReview(int reviewId)
				{
					Optional<Review> a=reviewrepo.findById(reviewId);
					if(a.isPresent())
					{
						return a.get();
					}
					return null;
				}

				public Review deleteReview(int reviewId)
				{
					Review a=findReview(reviewId);
					reviewrepo.delete(a);
				    return a;
					
				}
				
				public Review updateReview(Review review, int reviewId)
				{
					Review exreview= findReview(reviewId);
					if(exreview != null)
					{
						review.setReviewId(reviewId);
						return reviewrepo.save(review);
					}
					return null;
				}
				
				public List<Review> findAllReview(List<Review> review)
				{
					
					List<Review> exreview =reviewrepo.findAll();
					return exreview;
				}

			}	



