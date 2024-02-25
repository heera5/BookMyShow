package com.example.bootproject.BookMyShow.controller;

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

import com.example.bootproject.BookMyShow.dto.TheatreAdminDto;
import com.example.bootproject.BookMyShow.entity.TheatreAdmin;
import com.example.bootproject.BookMyShow.service.TheatreAdminService;
import com.example.bootproject.BookMyShow.util.ResponseStructure;

import jakarta.validation.Valid;


@RestController
@RequestMapping("theatreadmin")
public class TheatreAdminController {

	
			@Autowired
			TheatreAdminService theatreadminservice;
			
			@PostMapping
			public ResponseEntity<ResponseStructure<TheatreAdminDto>> saveTheatreAdmin(@Valid @RequestBody TheatreAdmin theatreadmin,BindingResult Result)
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
			@GetMapping("assigntota")	
			public ResponseEntity<ResponseStructure<TheatreAdminDto>> assignTheatreToTheatreAdmin(@RequestParam int theatreAdminId,@RequestParam int theatreId){
				System.out.println("assigned theatre to theatreadmin");
				return theatreadminservice.assignTheatreToTheatreAdmin(theatreAdminId, theatreId);
				
			}
			@GetMapping("talogin")
			public ResponseEntity<ResponseStructure<TheatreAdmin>>theatreadminlogin(@RequestParam String theatreadminemail,@RequestParam String theatreadminpassword){
				System.out.println("ta login successful");
				return theatreadminservice.theatreadminlogin(theatreadminemail, theatreadminpassword);
			}
}
