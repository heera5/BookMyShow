package com.example.bootproject.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bootproject.BookMyShow.entity.TheatreAdmin;
import com.example.bootproject.BookMyShow.repo.TheatreAdminRepo;


@Repository
public class TheatreAdminDao {

    
	@Autowired
	TheatreAdminRepo theatreadminrepo;
	public TheatreAdmin saveTheatreAdmin(TheatreAdmin theatreadmin) {
		return theatreadminrepo.save(theatreadmin);
		
	}
	
	public TheatreAdmin findTheatreAdmin(int theatreadminId)
	{
		Optional<TheatreAdmin> a=theatreadminrepo.findById(theatreadminId);
		if(a.isPresent())
		{
			return a.get();
		}
		return null;
	}

	public  TheatreAdmin deleteTheatreAdmin(int theatreadminId)
	{
		TheatreAdmin a=findTheatreAdmin(theatreadminId);
		theatreadminrepo.delete(a);
	    return a;
		
	}
	
	public TheatreAdmin updateTheatreAdmin(TheatreAdmin theatreadmin, int theatreadminId)
	{
		TheatreAdmin extheatreadmin = findTheatreAdmin(theatreadminId);
		if(extheatreadmin != null)
		{
			theatreadmin.setTheatreAdminId(theatreadminId);
			return theatreadminrepo.save(theatreadmin);
		}
		return null;
	}
	
	public List<TheatreAdmin> findAllTheatreAdmin(List<TheatreAdmin> theatreadmin)
	{
		
		List<TheatreAdmin> extheatreadmin =theatreadminrepo.findAll();
		return extheatreadmin;
	}

}
