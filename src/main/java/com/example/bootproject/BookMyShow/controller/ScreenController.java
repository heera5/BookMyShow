package com.example.bootproject.BookMyShow.controller;

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
		

}
