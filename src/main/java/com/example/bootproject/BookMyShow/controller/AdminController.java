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
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.bootproject.BookMyShow.dto.AdminDto;
import com.example.bootproject.BookMyShow.entity.Admin;
import com.example.bootproject.BookMyShow.service.AdminService;
import com.example.bootproject.BookMyShow.util.ResponseStructure;

import jakarta.validation.Valid;


@RestController
@RequestMapping("admin")
public class AdminController {

		@Autowired
		AdminService adminservice;
		
		@PostMapping
		public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(@Valid @RequestBody Admin admin,BindingResult Result)
		{
			System.out.println("saved");
		 return adminservice.save(admin);
		}
		
		@GetMapping
		public ResponseEntity<ResponseStructure<AdminDto>> findAdmin(@RequestParam int adminid)
		{
			System.out.println("found");
			return adminservice.findAdmin(adminid);
		}
		@DeleteMapping
		public ResponseEntity<ResponseStructure<AdminDto>> deleteAdmin(@RequestParam int adminid)
		{
			System.out.println("deleted");
			return adminservice.deleteAdmin(adminid);
		}
		@PutMapping
		public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(@RequestBody Admin admin,@RequestParam int adminid)
		{
			System.out.println("updated");
			return adminservice.updateAdmin(admin, adminid);
		}
			

		@GetMapping("found all")
		public ResponseEntity<ResponseStructure<List<Admin>>>  findAllAdmin(){
			System.out.println("found all laptop");
			return adminservice.findAllAdmin();
		}
	
		@GetMapping("adminlogin")
		public ResponseEntity<ResponseStructure<AdminDto>>adminlogin(@RequestParam String adminemail,@RequestParam String admilpassword)
		{
			System.out.println("login done");
			return adminservice.adminLogin(adminemail, admilpassword);
		
		}
		
		@PutMapping("addtheatretoadmin")
		public ResponseEntity<ResponseStructure<AdminDto>> addTheatreToAdmin(@RequestParam int adminId,@RequestParam int theatreId){

			System.out.println("Assigning theatre to admin successful");
			return adminservice.addTheatreToAdmin(adminId, theatreId);
		}
			
			
		@PutMapping("addtheatreadmintoadmin")
		public ResponseEntity<ResponseStructure<AdminDto>> addTheatreAdminToAdmin(@RequestParam int adminId,@RequestParam int theatreadminId){
			System.out.println("Assigning theatreadmin to admin successful");
			return adminservice.addTheatreAdminToAdmin(adminId, theatreadminId);
		}
			
}
