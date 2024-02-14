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

import com.example.bootproject.BookMyShow.dto.TheatreAdminDto;
import com.example.bootproject.BookMyShow.entity.TheatreAdmin;
import com.example.bootproject.BookMyShow.service.TheatreAdminService;
import com.example.bootproject.BookMyShow.util.ResponseStructure;


@RestController
@RequestMapping("theatreadmin")
public class TheatreAdminController {

	
			@Autowired
			TheatreAdminService theatreadminservice;
			
			@PostMapping("save")
			public ResponseEntity<ResponseStructure<TheatreAdminDto>> saveTheatreAdmin(@RequestBody TheatreAdmin theatreadmin)
			{
				System.out.println("saved");
			 return theatreadminservice.saveTheatreAdmin(theatreadmin);
			}
			
			@GetMapping
			public ResponseEntity<ResponseStructure<TheatreAdminDto>> findTheatreAdmin(@RequestParam int theatreadminid)
			{
				System.out.println("found");
				return theatreadminservice.findTheatreAdmin(theatreadminid);
			}
			@DeleteMapping
			public ResponseEntity<ResponseStructure<TheatreAdminDto>> deleteTheatreAdmin(@RequestParam int theatreadminid)
			{
				System.out.println("deleted");
				return theatreadminservice.deleteTheatreAdmin(theatreadminid);
			}
			@PutMapping
			public ResponseEntity<ResponseStructure<TheatreAdminDto>> updateTheatreAdmin(@RequestBody TheatreAdmin theatreadmin,@RequestParam int theatreadminid)
			{
				System.out.println("updated");
				return theatreadminservice.updateTheatreAdmin(theatreadmin, theatreadminid);
			}
				


}
