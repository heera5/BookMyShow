package com.example.bootproject.BookMyShow.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class MovieDto {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int movieId;
	private String movieName;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	@Override
	public String toString() {
		return "MovieDto [movieId=" + movieId + ", movieName=" + movieName + "]";
	}
	

}
