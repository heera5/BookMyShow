package com.example.bootproject.BookMyShow.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bootproject.BookMyShow.dao.MovieDao;
import com.example.bootproject.BookMyShow.dao.ReviewDao;
import com.example.bootproject.BookMyShow.dto.MovieDto;
import com.example.bootproject.BookMyShow.entity.Movie;
import com.example.bootproject.BookMyShow.entity.Review;
import com.example.bootproject.BookMyShow.exception.NoListFound;
import com.example.bootproject.BookMyShow.exception.NoMovieFound;
import com.example.bootproject.BookMyShow.exception.ReviewNotFound;
import com.example.bootproject.BookMyShow.repo.ReviewRepo;
import com.example.bootproject.BookMyShow.util.ResponseStructure;


@Service
public class MovieService {

	@Autowired
	MovieDao moviedao;
	@Autowired
	ReviewDao reviewdao;
	@Autowired
	ReviewRepo reviewrepo;
	
	public ResponseEntity<ResponseStructure<MovieDto>> saveMovie(Movie movie){
		
		MovieDto dto=new MovieDto();
		ModelMapper mapper=new ModelMapper();
		mapper.map(moviedao.saveMovie(movie), dto);
	    ResponseStructure <MovieDto>structure=new ResponseStructure<MovieDto>();
		if(dto!=null)
			{
		structure.setMessage("save data successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dto);
		return new ResponseEntity<ResponseStructure<MovieDto>>(structure,HttpStatus.CREATED);
	}
	throw new NoMovieFound("no movie found");
	}
	
	public ResponseEntity<ResponseStructure<MovieDto>> findMovie(int movieid){
		MovieDto dto=new MovieDto();
		ModelMapper mapper=new ModelMapper();
		mapper.map(moviedao.findMovie(movieid), dto);
		ResponseStructure <MovieDto>structure=new ResponseStructure<MovieDto>();
		
		if(dto!=null) {
			structure.setMessage("find data ssuccessfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<MovieDto>>(structure,HttpStatus.FOUND);
		}
		throw new NoMovieFound("movie is not there!!!!!!!!");
		}
	
	public ResponseEntity<ResponseStructure<MovieDto>> deleteMovie(int movieid){
		MovieDto dto=new MovieDto();
		ModelMapper mapper=new ModelMapper();
		mapper.map(moviedao.deleteMovie(movieid), dto);
		ResponseStructure <MovieDto>structure=new ResponseStructure<MovieDto>();
		
		if(dto!=null) {
			structure.setMessage("delete data successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<MovieDto>>(structure,HttpStatus.OK);
		}
		throw new NoMovieFound("movie is not there!!!!!!!!");
		}
	
	public ResponseEntity<ResponseStructure<MovieDto>> updateMovie(Movie movie, int movieid){
		MovieDto dto=new MovieDto();
		ModelMapper mapper=new ModelMapper();
		mapper.map(moviedao.updateMovie(movie, movieid), dto);
		ResponseStructure <MovieDto>structure=new ResponseStructure<MovieDto>();
		    if(dto!=null) {
				structure.setMessage("update data successfully");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dto);
				return new ResponseEntity<ResponseStructure<MovieDto>>(structure,HttpStatus.OK);
			}
			throw new NoMovieFound("movie is not there!!!!!!!!");
			}
	public ResponseEntity<ResponseStructure<List<Movie>>>  findAllMovie(){
		
		ResponseStructure <List<Movie>>structure=new ResponseStructure<List<Movie>>();
		MovieDto dto=new MovieDto();
		ModelMapper mapper=new ModelMapper();
		mapper.map(moviedao.findAllMovie(), dto);
		List<Movie> s=moviedao.findAllMovie();
		if(s!=null) {
			structure.setMessage("list of data ");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(s);
			return new ResponseEntity<ResponseStructure<List<Movie>>>(structure,HttpStatus.FOUND);
		}
		throw new NoListFound("no list found");
		}
	
//	public ResponseEntity<ResponseStructure<MovieDto>>Assignreviewtomovie(int movieid,List<Integer> reviewid){
//		MovieDto mdto=new MovieDto();
//		ModelMapper m=new ModelMapper();
//		Movie m1=moviedao.findMovie(movieid);
//		if(m1!=null) {
//			List<Review>exreview=reviewrepo.findAllById(reviewid);
//			m1.setReview(exreview);
//			m.map(moviedao.updateMovie(m1, movieid), moviedao);
//			ResponseStructure<MovieDto> structure=new ResponseStructure<MovieDto>();
//			structure.setMessage("assign theatreAdmin to admin succesffuly");
//			structure.setStatus(HttpStatus .OK.value());
//			structure.setData(mdto);
//			return new ResponseEntity<ResponseStructure<MovieDto>>(structure,HttpStatus.OK);
//		}
//		throw new ReviewNotFound("we can't assign review to movie");
//	}
	
	public ResponseEntity<ResponseStructure<MovieDto>> addReviewToMovie(int movieId,int reviewId)
	{
		MovieDto movieDto=new MovieDto();
		ModelMapper mapper=new ModelMapper();
	
		Movie movie = moviedao.findMovie(movieId);
		if(movie!=null)
		{
			    List<Review> reviewList = reviewdao.findAllReview();
			    List<Review> movieReview = movie.getReview();
			    if(movieReview==null)
			    {
			    	List<Review> newReviewList=new ArrayList<Review>();
			    	newReviewList.add(reviewdao.findReview(reviewId));
			    	movie.setReview(newReviewList);	
			    }
			    else 
			    {
			    	for (Review review : reviewList) 
			    	{
			    		if(review.getReviewId()==reviewId)
			    		{
			    			movieReview.add(reviewdao.findReview(reviewId));
			    			movie.setReview(movieReview);;
			    		}
						
					}
			    }
			    
			    mapper.map(moviedao.updateMovie(movie,movie.getMovieId()), movieDto);
			    ResponseStructure<MovieDto> structure=new ResponseStructure<MovieDto>();
			    structure.setMessage("Review list assign to Movie");
			    structure.setStatus(HttpStatus.OK.value());
			    structure.setData(movieDto);
			    
			    return new ResponseEntity<ResponseStructure<MovieDto>>(structure,HttpStatus.OK);
		}
		throw new ReviewNotFound("Review object is not found for the given ");
}
	
	
}
