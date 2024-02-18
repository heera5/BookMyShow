package com.example.bootproject.BookMyShow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootproject.BookMyShow.dto.MovieDto;
import com.example.bootproject.BookMyShow.entity.Movie;
import com.example.bootproject.BookMyShow.service.MovieService;
import com.example.bootproject.BookMyShow.util.ResponseStructure;


@RestController
@RequestMapping("movie")
public class MovieController {

	
			@Autowired
			MovieService movieservice;
			
			@PostMapping("save")
			public ResponseEntity<ResponseStructure<MovieDto>> saveMovie(@RequestBody Movie movie)
			{
				System.out.println("saved");
			 return movieservice.saveMovie(movie);
			}
			
			@GetMapping
			public ResponseEntity<ResponseStructure<MovieDto>> findMovie(@RequestParam int movieid)
			{
				System.out.println("found");
				return movieservice.findMovie(movieid);
			}
			@DeleteMapping
			public ResponseEntity<ResponseStructure<MovieDto>> deleteMovie(@RequestParam int movieid)
			{
				System.out.println("deleted");
				return movieservice.deleteMovie(movieid);
			}
			@PutMapping
			public ResponseEntity<ResponseStructure<MovieDto>> updateMovie(@RequestBody Movie movie,@RequestParam int movieid)
			{
				System.out.println("updated");
				return movieservice.updateMovie(movie, movieid);
			}
				

			@GetMapping("found all")
			public ResponseEntity<ResponseStructure<List<Movie>>>  findAllMovie(@RequestBody List<Movie> movie){
				System.out.println("found all laptop");
				return movieservice.findAllMovie(movie);
			}
			
			@PutMapping("assignreviewtomovie")
			public ResponseEntity<ResponseStructure<MovieDto>>Assignreviewtomovie(@RequestParam int movieid,@RequestParam List<Integer> reviewid)

			{
				System.out.println("review assignted to movie");
				return movieservice.Assignreviewtomovie(movieid, reviewid);
			}
				


}
