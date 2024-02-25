package com.example.bootproject.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bootproject.BookMyShow.entity.Movie;
import com.example.bootproject.BookMyShow.repo.MovieRepo;


@Repository
public class MovieDao {

	    	@Autowired
	    	MovieRepo movierepo;
			
	    	public Movie saveMovie(Movie movie) {
				return movierepo.save(movie);
				
			}
			
			public Movie findMovie(int movieId)
			{
				Optional<Movie> a=movierepo.findById(movieId);
				if(a.isPresent())
				{
					return a.get();
				}
				return null;
			}

			public Movie deleteMovie(int movieId)
			{
				Movie a=findMovie(movieId);
				movierepo.delete(a);
			    return a;
				
			}
			
			public Movie updateMovie(Movie movie, int movieId)
			{
				Movie exmovie= findMovie(movieId);
				if(exmovie != null)
				{
					movie.setMovieId(movieId);
					return movierepo.save(movie);
				}
				return null;
			}
			
			public List<Movie> findAllMovie()
			{
				
				List<Movie> exmovie =movierepo.findAll();
				return exmovie;
			}

		}	

