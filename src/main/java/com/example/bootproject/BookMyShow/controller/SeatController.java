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

import com.example.bootproject.BookMyShow.entity.Seat;
import com.example.bootproject.BookMyShow.service.SeatService;
import com.example.bootproject.BookMyShow.util.ResponseStructure;
@RestController
@RequestMapping("Seat")
public class SeatController {

		    	@Autowired
				SeatService seatservice;
				
				@PostMapping
				public ResponseEntity<ResponseStructure<Seat>> saveSeat(@RequestBody Seat seat)
				{
					System.out.println("saved");
				 return seatservice.saveSeat(seat);
				}
				
				@GetMapping
				public ResponseEntity<ResponseStructure<Seat>> findSeat(@RequestParam int seatid)
				{
					System.out.println("found");
					return seatservice.findSeat(seatid);
				}
				
				@DeleteMapping
				public ResponseEntity<ResponseStructure<Seat>> deleteSeat(@RequestParam int seatid)
				{
					System.out.println("deleted");
					return seatservice.deleteSeat(seatid);
				}
				@PutMapping
				public ResponseEntity<ResponseStructure<Seat>> updateSeat(@RequestBody Seat seat,@RequestParam int seatid)
				{
					System.out.println("updated");
					return seatservice.updateSeat(seat, seatid);
				}
				
				@GetMapping("found all")
				public ResponseEntity<ResponseStructure<List<Seat>>>  findAllSeat(@RequestBody List<Seat> seat){
					System.out.println("found all laptop");
					return seatservice.findAllSeat(seat);
				}

}
