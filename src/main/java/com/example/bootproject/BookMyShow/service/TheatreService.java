package com.example.bootproject.BookMyShow.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
		
		public ResponseEntity<ResponseStructure<List<Theatre>>>  findAllTheatre(List<Theatre> theatrel){
			ResponseStructure <List<Theatre>>structure=new ResponseStructure<List<Theatre>>();
			List<Theatre> l=theatredao.findAllTheatre(theatrel);
			if(l!=null) {
				structure.setMessage("list of data ");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(l);
				return new ResponseEntity<ResponseStructure<List<Theatre>>>(structure,HttpStatus.FOUND);
			}
			throw new NoListFound("no list found!!!!!!");
			}
		
		public ResponseEntity<ResponseStructure<List<Theatre>>> assignscreentotheatre(int theatreid,List<Integer>screenid){
			ResponseStructure<Theatre>structure=new ResponseStructure<Theatre>();
			ModelMapper mapper=new ModelMapper();
			Theatre theatre=theatredao.findTheatre(theatreid);
			if(theatre!=null) {
				List<Screen>s=screenrepo.findAllById(screenid);
				theatre.setListofscreen(s);
				theatredao.updateTheatre(theatre, theatreid);
				structure.setMessage("screen assigned to theatres");
				structure.setStatus(theatreid);
				structure.setData(theatre);
				return new ResponseEntity<ResponseStructure<List<Theatre>>>(HttpStatus.OK);
				
				
				
			}
			return null;
		}
	
}
