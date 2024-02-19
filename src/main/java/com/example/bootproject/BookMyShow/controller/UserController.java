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

import com.example.bootproject.BookMyShow.dto.UserDto;
import com.example.bootproject.BookMyShow.entity.User;
import com.example.bootproject.BookMyShow.service.UserService;
import com.example.bootproject.BookMyShow.util.ResponseStructure;

import jakarta.validation.Valid;


@RestController
@RequestMapping("user")
public class UserController {

	        @Autowired
			UserService userservice;
			
			@PostMapping("save")
			public ResponseEntity<ResponseStructure<UserDto>> saveUser(@Valid @RequestBody User user,BindingResult Result)
			{
				System.out.println("saved");
			 return userservice.saveUser(user);
			}
			
			@GetMapping
			public ResponseEntity<ResponseStructure<UserDto>> findUser(@RequestParam int userid)
			{
				System.out.println("found");
				return userservice.findUser(userid);
			}
			@DeleteMapping
			public ResponseEntity<ResponseStructure<UserDto>> deleteUser(@RequestParam int userid)
			{
				System.out.println("deleted");
				return userservice.deleteUser(userid);
			}
			@PutMapping
			public ResponseEntity<ResponseStructure<UserDto>> updateUser(@RequestBody User user,@RequestParam int userid)
			{
				System.out.println("updated");
				return userservice.updateUser(user, userid);
			}
				

			@GetMapping("found all")
			public ResponseEntity<ResponseStructure<List<User>>>  findAllUser(List<User> user)
			{
				System.out.println("found all user");
				return userservice.findAllUser(user);
			}
			
			@PutMapping("userlogin")
			public ResponseEntity<ResponseStructure<UserDto>> userLogin(@RequestParam String useremail,@RequestParam String userPassword)
			{
				System.out.println("login successful");
				return userservice.userLogin(useremail, userPassword);
			}
			
			@GetMapping("assign")
			public ResponseEntity<ResponseStructure<User>> assignTicketToUser(int ticketId,int userId){
				System.out.println("assigning ticket to user done!!!!!!!!!!!");
				return userservice.assignTicketToUser(ticketId, userId);
			}
				
			}
