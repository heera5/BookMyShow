package com.example.bootproject.BookMyShow.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bootproject.BookMyShow.dao.UserDao;
import com.example.bootproject.BookMyShow.dto.UserDto;

import com.example.bootproject.BookMyShow.entity.User;

import com.example.bootproject.BookMyShow.exception.UserNotFound;
import com.example.bootproject.BookMyShow.exception.NoListFound;

import com.example.bootproject.BookMyShow.util.ResponseStructure;
@Service
public class UserService {

	@Autowired
	UserDao userdao;
	
	
	
	public ResponseEntity<ResponseStructure<UserDto>> saveUser(User user){
		
		UserDto dto=new UserDto();
		ModelMapper mapper=new ModelMapper();
		mapper.map(userdao.saveUser(user), dto);
	    ResponseStructure <UserDto>structure=new ResponseStructure<UserDto>();
		if(dto!=null)
			{
		structure.setMessage("save data successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dto);
		return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.CREATED);
	}
	throw new UserNotFound("no user found");
	}
	
	public ResponseEntity<ResponseStructure<UserDto>> findUser(int userid){
		UserDto dto=new UserDto();
		ModelMapper mapper=new ModelMapper();
		mapper.map(userdao.findUser(userid), dto);
		ResponseStructure <UserDto>structure=new ResponseStructure<UserDto>();
		
		if(dto!=null) {
			structure.setMessage("find data ssuccessfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.FOUND);
		}
		throw new UserNotFound("User is not there!!!!!!!!");
		}
	
	public ResponseEntity<ResponseStructure<UserDto>> deleteUser(int userid){
		UserDto dto=new UserDto();
		ModelMapper mapper=new ModelMapper();
		mapper.map(userdao.deleteUser(userid), dto);
		ResponseStructure <UserDto>structure=new ResponseStructure<UserDto>();
		
		if(dto!=null) {
			structure.setMessage("delete data successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.OK);
		}
		throw new UserNotFound("User is not there!!!!!!!!");
		}
	
	public ResponseEntity<ResponseStructure<UserDto>> updateUser(User user, int userid){
		UserDto dto=new UserDto();
		ModelMapper mapper=new ModelMapper();
		mapper.map(userdao.updateUser(user, userid), dto);
		ResponseStructure <UserDto>structure=new ResponseStructure<UserDto>();
		    if(dto!=null) {
				structure.setMessage("update data successfully");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dto);
				return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.OK);
			}
			throw new UserNotFound("User is not there!!!!!!!!");
			}
	public ResponseEntity<ResponseStructure<List<User>>>  findAllUser(List<User> user){
		
		ResponseStructure <List<User>>structure=new ResponseStructure<List<User>>();
		UserDto dto=new UserDto();
		ModelMapper mapper=new ModelMapper();
		mapper.map(userdao.findAllUser(user), dto);
		List<User> s=userdao.findAllUser(user);
		if(s!=null) {
			structure.setMessage("list of data ");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(s);
			return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.FOUND);
		}
		throw new NoListFound("no list found");
		}

	public ResponseEntity<ResponseStructure<UserDto>> userLogin(String useremail,String userPassword)
	{
		
		UserDto userdto=new UserDto();
		ModelMapper modelMapper=new ModelMapper();
		User user=userdao.findbyMail(useremail);
		
		ResponseStructure<UserDto> structure=new ResponseStructure<UserDto>();
		if(user!=null)
		{
			if(user.getUserPassword().equals(userPassword))
			{
				modelMapper.map(user, userdto);
			 structure.setData(userdto);
			 structure.setMessage("User login succesfully");
			 structure.setStatus(HttpStatus.ACCEPTED.value());
			 
			 return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.ACCEPTED);
			} 
			throw new UserNotFound("user password is not matching,log in failed");
			
		}
		throw new UserNotFound("user object not found for the given mail id");
	}
}
