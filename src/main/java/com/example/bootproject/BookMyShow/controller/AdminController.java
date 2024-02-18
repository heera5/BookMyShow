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

import com.example.bootproject.BookMyShow.dto.AdminDto;
import com.example.bootproject.BookMyShow.entity.Admin;
import com.example.bootproject.BookMyShow.service.AdminService;
import com.example.bootproject.BookMyShow.util.ResponseStructure;


@RestController
@RequestMapping("admin")
public class AdminController {

		@Autowired
		AdminService adminservice;
		
		@PostMapping("save")
		public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(@RequestBody Admin admin)
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
		public ResponseEntity<ResponseStructure<List<Admin>>>  findAllAdmin(@RequestBody List<Admin> admin){
			System.out.println("found all laptop");
			return adminservice.findAllAdmin(admin);
		}
		
		@GetMapping("adminlogin")
		public ResponseEntity<ResponseStructure<AdminDto>>adminlogin(@RequestParam String adminemail,@RequestParam String admilpassword)
		{
			System.out.println("login done");
			return adminservice.adminLogin(adminemail, admilpassword);
		
		}
		
		@PutMapping("assgintheatretoadmin")
		public ResponseEntity<ResponseStructure<AdminDto>> assignTheatresToAdmin(@RequestParam String adminEmail,@RequestParam String adminPassword,@RequestParam int adminId,List<Integer> theatreIds){
			System.out.println("Assigning theatre to admin successful");
			return adminservice.assignTheatresToAdmin(adminEmail, adminPassword, adminId, theatreIds);
		}
			
			
		@PutMapping("assgintheatreadmintoadmin")
		public ResponseEntity<ResponseStructure<AdminDto>> assignTheatreAdminToAdmin(@RequestParam String adminEmail,@RequestParam String adminPassword,@RequestParam int theatreadminId,List<Integer> theatreadminId1){
			System.out.println("Assigning theatre to admin successful");
			return adminservice.assignTheatreAdminToAdmin(adminEmail, adminPassword, theatreadminId, theatreadminId1);
		}
			
}
