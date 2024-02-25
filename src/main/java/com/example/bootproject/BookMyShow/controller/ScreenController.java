package com.example.bootproject.BookMyShow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootproject.BookMyShow.entity.Screen;
import com.example.bootproject.BookMyShow.entity.Seat;
import com.example.bootproject.BookMyShow.entity.SeatType;
import com.example.bootproject.BookMyShow.service.ScreenService;
import com.example.bootproject.BookMyShow.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("Screen")
public class ScreenController {
     	
	    @Autowired
		ScreenService screenservice;
		
		@PostMapping
		public ResponseEntity<ResponseStructure<Screen>> saveScreen(@Valid @RequestBody Screen screen,BindingResult Result)
		{
			System.out.println("saved");
		 return screenservice.saveScreen(screen);
		}
		
		@GetMapping
		public ResponseEntity<ResponseStructure<Screen>> findScreen(@RequestParam int screenid)
		{
			System.out.println("found");
			return screenservice.findScreen(screenid);
		}
		
		@DeleteMapping
		public ResponseEntity<ResponseStructure<Screen>> deleteScreen(@RequestParam int screenid)
		{
			System.out.println("deleted");
			return screenservice.deleteScreen(screenid);
		}
		@PutMapping
		public ResponseEntity<ResponseStructure<Screen>> updateScreen(@RequestBody Screen screen,@RequestParam int screenid)
		{
			System.out.println("updated");
			return screenservice.updateScreen(screen, screenid);
		}
		
		@PutMapping("addnseattoscreen")
		public ResponseEntity<ResponseStructure<Screen>> addSeatToScreen(@RequestParam int ScreenId,@RequestParam int seatId){
		
			System.out.println("updated");
			return screenservice.findScreen(ScreenId);
		}
		@GetMapping("findseatavailability")
		public  ResponseEntity<ResponseStructure<List<Seat>>> findSeatAvailability(@RequestParam int screenid,@RequestParam SeatType seatType) {

			System.out.println("seat availability");
			return screenservice.findSeatAvailability(screenid, seatType);
		}
		@GetMapping("assignmovietoscreen")
		public ResponseEntity<ResponseStructure<Screen>> assignMovieToScreen(@RequestParam int movieId,@RequestParam int screenId){

			System.out.println("updated");
			return screenservice.assignMovieToScreen(movieId, screenId);
		}
}
