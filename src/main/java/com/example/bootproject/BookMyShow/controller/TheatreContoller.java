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

import com.example.bootproject.BookMyShow.entity.Theatre;
import com.example.bootproject.BookMyShow.service.TheatreService;
import com.example.bootproject.BookMyShow.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("Theatre")
public class TheatreContoller {

	 	@Autowired
		TheatreService theatreservice;
		
		@PostMapping
		public ResponseEntity<ResponseStructure<Theatre>> saveTheatre( @Valid @RequestBody Theatre theatre,BindingResult Result)
		{
			System.out.println("saved");
		 return theatreservice.saveTheatre(theatre);
		}
		
		@GetMapping
		public ResponseEntity<ResponseStructure<Theatre>> findTheatre(@RequestParam int theatreid)
		{
			System.out.println("found");
			return theatreservice.findTheatre(theatreid);
		}
		
		@DeleteMapping
		public ResponseEntity<ResponseStructure<Theatre>> deleteTheatre(@RequestParam int theatreid)
		{
			System.out.println("deleted");
			return theatreservice.deleteTheatre(theatreid);
		}
		@PutMapping
		public ResponseEntity<ResponseStructure<Theatre>> updateTheatre(@RequestBody Theatre theatre,@RequestParam int theatreid)
		{
			System.out.println("updated");
			return theatreservice.updateTheatre(theatre, theatreid);
		}
		
		@PutMapping("allTheatre")
		public ResponseEntity<ResponseStructure<List<Theatre>>>  findAllTheatre(){
			System.out.println("list od theatre");
			return theatreservice.findAllTheatre();
		
		
		}
		
		@PutMapping("addscreentotheatre")
		public ResponseEntity<ResponseStructure<Theatre>> addScreenToTheatre(@RequestParam int screenId,@RequestParam int theatreId){
			System.out.println("list od theatre");
			return theatreservice.addScreenToTheatre(screenId, theatreId);
}
}