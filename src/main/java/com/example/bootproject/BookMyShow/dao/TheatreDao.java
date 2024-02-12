package com.example.bootproject.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bootproject.BookMyShow.entity.Theatre;
import com.example.bootproject.BookMyShow.repo.TheatreRepo;


@Repository
public class TheatreDao {

		
		            @Autowired
			    	TheatreRepo theatrerepo;
					
			    	public Theatre saveTheatre(Theatre theatre) {
						return theatrerepo.save(theatre);
						
					}
					
					public Theatre findTheatre(int theatreId)
					{
						Optional<Theatre> a=theatrerepo.findById(theatreId);
						if(a.isPresent())
						{
							return a.get();
						}
						return null;
					}

					public Theatre deleteTheatre(int theatreId)
					{
						Theatre a=findTheatre(theatreId);
						theatrerepo.delete(a);
					    return a;
						
					}
					
					public Theatre updateTheatre(Theatre theatre, int theatreId)
					{
						Theatre extheatre= findTheatre(theatreId);
						if(extheatre != null)
						{
							theatre.setTheatreId(theatreId);
							return theatrerepo.save(theatre);
						}
						return null;
					}
					
					public List<Theatre> findAllTheatre(List<Theatre> theatre)
					{
						
						List<Theatre> extheatre =theatrerepo.findAll();
						return extheatre;
					}


}
