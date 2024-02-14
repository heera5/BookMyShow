package com.example.bootproject.BookMyShow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.bootproject.BookMyShow.dao.ScreenDao;
import com.example.bootproject.BookMyShow.entity.Screen;
import com.example.bootproject.BookMyShow.exception.ScreenNotFound;
import com.example.bootproject.BookMyShow.util.ResponseStructure;



public class ScreenService {

	@Autowired
	ScreenDao screendao;
	
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
				 throw new ScreenNotFound("laptoupdate failed");
				}

}
