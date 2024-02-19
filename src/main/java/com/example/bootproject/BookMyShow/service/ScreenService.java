package com.example.bootproject.BookMyShow.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bootproject.BookMyShow.dao.MovieDao;
import com.example.bootproject.BookMyShow.dao.ScreenDao;
import com.example.bootproject.BookMyShow.dao.SeatDao;
import com.example.bootproject.BookMyShow.dto.AdminDto;
import com.example.bootproject.BookMyShow.entity.Admin;
import com.example.bootproject.BookMyShow.entity.Movie;
import com.example.bootproject.BookMyShow.entity.Screen;
import com.example.bootproject.BookMyShow.entity.Seat;
import com.example.bootproject.BookMyShow.entity.SeatType;
import com.example.bootproject.BookMyShow.entity.Theatre;
import com.example.bootproject.BookMyShow.exception.AdminNotFound;
import com.example.bootproject.BookMyShow.exception.NoMovieFound;
import com.example.bootproject.BookMyShow.exception.ScreenNotFound;
import com.example.bootproject.BookMyShow.exception.SeatNotFound;
import com.example.bootproject.BookMyShow.repo.ScreenRepo;
import com.example.bootproject.BookMyShow.repo.SeatRepo;
import com.example.bootproject.BookMyShow.util.ResponseStructure;


@Service
public class ScreenService {

	@Autowired
	ScreenDao screendao;
	
	@Autowired
	SeatRepo seatrepo;
	
	@Autowired
	SeatDao seatdao;
	
	@Autowired
	MovieDao moviedao;
	
	public ResponseEntity<ResponseStructure<Screen>> saveScreen(Screen screen){
		ResponseStructure <Screen>structure=new ResponseStructure<Screen>();
		Screen l=screendao.saveScreen(screen);
		if(l!=null) {
			structure.setMessage("save data ssuccessfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(l);
			return new ResponseEntity<ResponseStructure<Screen>>(structure,HttpStatus.CREATED);
			//ResponseEntity<ResponseStructure<Screen>>(structure,HttpStatus.CREATED);
		}
		 throw new ScreenNotFound("screen is not avaiable");
		}
		
		public ResponseEntity<ResponseStructure<Screen>> findScreen(int screenid){
			ResponseStructure <Screen>structure=new ResponseStructure<Screen>();
			Screen l=screendao.findScreen(screenid);
			if(l!=null) {
				structure.setMessage("find data ssuccessfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(l);
				return new ResponseEntity<ResponseStructure<Screen>>(structure,HttpStatus.FOUND);
			}
			 throw new ScreenNotFound("screen is not found");
			}
		
		public ResponseEntity<ResponseStructure<Screen>> deleteScreen(int screenid){
			ResponseStructure <Screen>structure=new ResponseStructure<Screen>();
			Screen l=screendao.deleteScreen(screenid);
			if(l!=null) {
				structure.setMessage("delete data successfully");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(l);
				return new ResponseEntity<ResponseStructure<Screen>>(structure,HttpStatus.OK);
			}
			 throw new ScreenNotFound("unable to delete screen ");
			}
		
		public ResponseEntity<ResponseStructure<Screen>> updateScreen(Screen screen, int screenid){
				ResponseStructure <Screen>structure=new ResponseStructure<Screen>();
				Screen l=screendao.updateScreen(screen,screenid);
				if(l!=null) {
					structure.setMessage("update data ssuccessfully");
					structure.setStatus(HttpStatus.OK.value());
					structure.setData(l);
					return new ResponseEntity<ResponseStructure<Screen>>(structure,HttpStatus.OK);
				}
				 throw new ScreenNotFound("screen update failed");
				}

//		public ResponseEntity<ResponseStructure<Screen>>assignseattoscreen(int screenid,List<Integer> seatid){
//			ResponseStructure<Screen>structure=new ResponseStructure<Screen>();
//			ModelMapper m=new ModelMapper();
//			Screen s=new Screen();
//			Screen exscreen=screendao.findScreen(screenid);
//			if(exscreen!=null) {
//				List<Seat> s1=seatrepo.findAllById(seatid);
//				exscreen.setSeat(s1);
//				m.map(screendao.updateScreen(exscreen, screenid), screendao);
//				structure.setMessage("seat found for the screen");
//				structure.setStatus(HttpStatus.OK.value());
//				structure.setData(exscreen);
//				return new ResponseEntity<ResponseStructure<Screen>>(structure,HttpStatus.OK);
//			}
//			throw new SeatNotFound("seat not assign to screen");
//		}
		
public ResponseEntity<ResponseStructure<Screen>> addSeatToScreen(int ScreenId,int seatId){
			
			Screen screen=new Screen();
			ModelMapper mapper=new ModelMapper();
		
			
			Screen a=screendao.findScreen(ScreenId);
			if(a!=null)
			{
				    List<Seat> seatList=seatdao.findAllSeat(null);
				    		List<Seat>ob=a.getSeat();
				    if(ob==null)
				    {
				    	List<Seat> newSeatList=new ArrayList<Seat>();
				    	newSeatList.add(seatdao.findSeat(seatId));
				    	a.setSeat(newSeatList);	
				    }
				    else 
				    {
				    	for (Seat seat : seatList) 
				    	{
				    		if(seat.getSeatId()==seatId)
				    		{
				    			ob.add(seatdao.findSeat(seatId));
				    			a.setSeat(ob);
				    		}
							
						}
				    }
				    mapper.map(screendao.updateScreen(a,a.getScreenId()),screen);
				    ResponseStructure<Screen> structure=new ResponseStructure<Screen>();
				    structure.setMessage("Seat.OK.value()");
				    structure.setData(a);
				    
	       return new ResponseEntity<ResponseStructure<Screen>>(structure,HttpStatus.OK);
			}
			throw new AdminNotFound("Screen object is not found for the given ");
	}
		
		public  ResponseEntity<ResponseStructure<List<Seat>>> findSeatAvailability(int screenid,SeatType seatType) {
			Screen s=screendao.findScreen(screenid);
			if(s!= null) {
			List<Seat> seatList=s.getSeat();
			List<Seat> seatsList=new ArrayList<Seat>();
			for (Seat seat : seatList) {
				if(seat.isSeatAvailability()==true && seat.getSeatType()==seatType) {
					seatsList.add(seat);
				}
			}
			ResponseStructure<List<Seat>> structure=new ResponseStructure<List<Seat>>();
			structure.setMessage("find seat availability found success");
			structure.setStatus(HttpStatus .FOUND.value());
			structure.setData(seatsList);
			return new ResponseEntity<ResponseStructure<List<Seat>>>(structure,HttpStatus.FOUND);
			}
			throw new ScreenNotFound("no seat avaiability");
		}
		
		public ResponseEntity<ResponseStructure<Screen>> assignMovieToScreen(int movieId,int screenId){
			
			Movie movie = moviedao.findMovie(movieId);
			Screen screen = screendao.findScreen(screenId);
			
			if(screen != null) 
			{
				if(movie != null) 
				{
					screen.setMovie(movie);
					ResponseStructure<Screen> structure=new ResponseStructure<Screen>();
					structure.setMessage("assign Movie to Screen success");
					structure.setStatus(HttpStatus .OK.value());
					structure.setData(screen);
					return new ResponseEntity<ResponseStructure<Screen>>(structure,HttpStatus.OK);
				}
				else 
				{
					throw new NoMovieFound("movie not assigned to the screen because, movie not found for the given id");
				}
				
			}
			throw new ScreenNotFound("we can't assign screen to movie because,screen not found for the given id");
		}
}
