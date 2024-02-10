package com.example.bootproject.BookMyShow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Review {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int reviewId;
	private String review;
	private int rating;
	private int userId;
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", review=" + review + ", rating=" + rating + ", userId=" + userId
				+ "]";
	}
	
}
