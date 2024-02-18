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

import com.example.bootproject.BookMyShow.entity.Screen;
import com.example.bootproject.BookMyShow.entity.Seat;
import com.example.bootproject.BookMyShow.entity.SeatType;
import com.example.bootproject.BookMyShow.service.ScreenService;
import com.example.bootproject.BookMyShow.util.ResponseStructure;

@RestController
@RequestMapping("Screen")
public class ScreenController {
     	
	    @Autowired
		ScreenService screenservice;
		
		@PostMapping
		public ResponseEntity<ResponseStructure<Screen>> saveScreen(@RequestBody Screen screen)
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
		
		@PutMapping("assignseattoscreen")
		public ResponseEntity<ResponseStructure<Screen>>assignseattoscreen(@RequestParam int screenid,@RequestParam List<Integer> seatid){
		
			System.out.println("updated");
			return screenservice.assignseattoscreen(screenid, seatid);
		}
		@GetMapping("findseatavailability")
		public  ResponseEntity<ResponseStructure<List<Seat>>> findSeatAvailability(@RequestParam int screenid,@RequestParam SeatType seatType) {

			System.out.println("seat availability");
			return screenservice.findSeatAvailability(screenid, seatType);
		}

}
