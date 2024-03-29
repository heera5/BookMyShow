package com.example.bootproject.BookMyShow.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bootproject.BookMyShow.dao.ScreenDao;
import com.example.bootproject.BookMyShow.dao.TheatreDao;
import com.example.bootproject.BookMyShow.entity.Screen;
import com.example.bootproject.BookMyShow.entity.Theatre;
import com.example.bootproject.BookMyShow.exception.NoListFound;
import com.example.bootproject.BookMyShow.exception.TheatreUnreachable;
import com.example.bootproject.BookMyShow.repo.ScreenRepo;
import com.example.bootproject.BookMyShow.repo.TheatreRepo;
import com.example.bootproject.BookMyShow.util.ResponseStructure;


@Service
public class TheatreService {

	@Autowired
	TheatreDao theatredao;
	
	@Autowired
	ScreenDao screendao;
	@Autowired
	TheatreRepo theatrerepo;
	@Autowired
	ScreenRepo screenrepo;
	
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(Theatre theatre){
		ResponseStructure <Theatre>structure=new ResponseStructure<Theatre>();
		Theatre l=theatredao.saveTheatre(theatre);
		if(l!=null) {
			structure.setMessage("save data ssuccessfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(l);
			return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.CREATED);
			//ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.CREATED);
		}
		 throw new TheatreUnreachable("theatre is not avaiable");
		}
		
		public ResponseEntity<ResponseStructure<Theatre>> findTheatre(int theatreid){
			ResponseStructure <Theatre>structure=new ResponseStructure<Theatre>();
			Theatre l=theatredao.findTheatre(theatreid);
			if(l!=null) {
				structure.setMessage("find data ssuccessfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(l);
				return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.FOUND);
			}
			 throw new TheatreUnreachable("theatre is not found");
			}
		
		public ResponseEntity<ResponseStructure<Theatre>> deleteTheatre(int theatreid){
			ResponseStructure <Theatre>structure=new ResponseStructure<Theatre>();
			Theatre l=theatredao.deleteTheatre(theatreid);
			if(l!=null) {
				structure.setMessage("delete data successfully");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(l);
				return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.OK);
			}
			 throw new TheatreUnreachable("unable to delete theatre ");
			}
		
		public ResponseEntity<ResponseStructure<Theatre>> updateTheatre(Theatre theatre, int theatreid){
				ResponseStructure <Theatre>structure=new ResponseStructure<Theatre>();
				Theatre l=theatredao.updateTheatre(theatre,theatreid);
				if(l!=null) {
					structure.setMessage("update data ssuccessfully");
					structure.setStatus(HttpStatus.OK.value());
					structure.setData(l);
					return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.OK);
				}
				 throw new TheatreUnreachable("theatre update failed");
				}
		
		public ResponseEntity<ResponseStructure<List<Theatre>>>  findAllTheatre(){
			ResponseStructure <List<Theatre>>structure=new ResponseStructure<List<Theatre>>();
			List<Theatre> l=theatredao.findAllTheatre();
			if(l!=null) {
				structure.setMessage("list of data ");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(l);
				return new ResponseEntity<ResponseStructure<List<Theatre>>>(structure,HttpStatus.FOUND);
			}
			throw new NoListFound("no list found!!!!!!");
			}
		
		public ResponseEntity<ResponseStructure<Theatre>> addScreenToTheatre(int screenId,int theatreId)
		{
			Theatre theatre1=new Theatre();
			ModelMapper mapper=new ModelMapper();
		
			Theatre theatre = theatredao.findTheatre(theatreId);
			if(theatre!=null)
			{
				    List<Screen> screenList = screendao.findAllScreen();
				    List<Screen> theatreScreenList = theatre.getListofscreen();
				    if(theatreScreenList == null)
				    {
				    	List<Screen> newScreenList=new ArrayList<Screen>();
				    	newScreenList.add(screendao.findScreen(theatreId));
				    	theatre.setListofscreen(screenList);	
				    }
				    else 
				    {
				    	for (Screen screen : screenList) 
				    	{
				    		if(screen.getScreenId()== screenId)
				    		{
				    			theatreScreenList.add(screendao.findScreen(screenId));
				    			theatre.setListofscreen(screenList);
				    		}
							
						}
				    }
				    
				    mapper.map(theatredao.updateTheatre(theatre,theatre.getTheatreId()), theatre);
				    ResponseStructure<Theatre> structure=new ResponseStructure<Theatre>();
				    structure.setMessage("Screen list assign to Theatre");
				    structure.setStatus(HttpStatus.OK.value());
				    structure.setData(theatre);
				    
				    return new ResponseEntity<ResponseStructure<Theatre>>(structure,HttpStatus.OK);
			}
			throw new TheatreUnreachable("Theatre object is not found for the given ");
	}
}
