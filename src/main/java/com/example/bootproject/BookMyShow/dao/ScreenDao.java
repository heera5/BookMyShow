package com.example.bootproject.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bootproject.BookMyShow.entity.Screen;
import com.example.bootproject.BookMyShow.repo.ScreenRepo;


@Repository
public class ScreenDao {
			  
	
	            @Autowired
		    	ScreenRepo screenrepo;
				
		    	public Screen saveScreen(Screen screen) {
					return screenrepo.save(screen);
					
				}
				
				public Screen findScreen(int screenId)
				{
					Optional<Screen> a=screenrepo.findById(screenId);
					if(a.isPresent())
					{
						return a.get();
					}
					return null;
				}

				public Screen deleteScreen(int screenId)
				{
					Screen a=findScreen(screenId);
					screenrepo.delete(a);
				    return a;
					
				}
				
				public Screen updateScreen(Screen screen, int screenId)
				{
					Screen exscreen= findScreen(screenId);
					if(exscreen != null)
					{
						screen.setScreenId(screenId);
						return screenrepo.save(screen);
					}
					return null;
				}
				
				public List<Screen> findAllScreen(List<Screen> screen)
				{
					
					List<Screen> exscreen =screenrepo.findAll();
					return exscreen;
				}

}
