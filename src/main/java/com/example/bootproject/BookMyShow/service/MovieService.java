package com.example.bootproject.BookMyShow.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bootproject.BookMyShow.dao.MovieDao;
import com.example.bootproject.BookMyShow.dto.MovieDto;
import com.example.bootproject.BookMyShow.entity.Movie;
import com.example.bootproject.BookMyShow.exception.NoListFound;
import com.example.bootproject.BookMyShow.exception.NoMovieFound;
import com.example.bootproject.BookMyShow.util.ResponseStructure;


@Service
public class MovieService {

	@Autowired
	MovieDao moviedao;
	
	
	
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
	throw new NoMovieFound("no student found");
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
		throw new NoMovieFound("Laptop is not there!!!!!!!!");
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
		throw new NoMovieFound("Laptop is not there!!!!!!!!");
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
			throw new NoMovieFound("Laptop is not there!!!!!!!!");
			}
	public ResponseEntity<ResponseStructure<List<Movie>>>  findAllMovie(List<Movie> movie){
		
		ResponseStructure <List<Movie>>structure=new ResponseStructure<List<Movie>>();
		MovieDto dto=new MovieDto();
		ModelMapper mapper=new ModelMapper();
		mapper.map(moviedao.findAllMovie(movie), dto);
		List<Movie> s=moviedao.findAllMovie(movie);
		if(s!=null) {
			structure.setMessage("list of data ");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(s);
			return new ResponseEntity<ResponseStructure<List<Movie>>>(structure,HttpStatus.FOUND);
		}
		throw new NoListFound("no list found");
		}
}
