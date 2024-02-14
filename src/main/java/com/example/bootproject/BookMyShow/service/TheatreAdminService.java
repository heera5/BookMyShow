package com.example.bootproject.BookMyShow.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bootproject.BookMyShow.dao.TheatreAdminDao;
import com.example.bootproject.BookMyShow.dto.TheatreAdminDto;
import com.example.bootproject.BookMyShow.entity.TheatreAdmin;
import com.example.bootproject.BookMyShow.exception.NoListFound;
import com.example.bootproject.BookMyShow.exception.TheatreAdminNotFound;
import com.example.bootproject.BookMyShow.util.ResponseStructure;


@Service
public class TheatreAdminService {

	@Autowired
	TheatreAdminDao theatreadmindao;
	
	
	
	public ResponseEntity<ResponseStructure<TheatreAdminDto>> saveTheatreAdmin(TheatreAdmin theatreadmin){
		
		TheatreAdminDto dto=new TheatreAdminDto();
		ModelMapper mapper=new ModelMapper();
		mapper.map(theatreadmindao.saveTheatreAdmin(theatreadmin), dto);
	    ResponseStructure <TheatreAdminDto>structure=new ResponseStructure<TheatreAdminDto>();
		if(dto!=null)
			{
		structure.setMessage("save data successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dto);
		return new ResponseEntity<ResponseStructure<TheatreAdminDto>>(structure,HttpStatus.CREATED);
	}
	throw new TheatreAdminNotFound("no student found");
	}
	
	public ResponseEntity<ResponseStructure<TheatreAdminDto>> findTheatreAdmin(int theatreadminid){
		TheatreAdminDto dto=new TheatreAdminDto();
		ModelMapper mapper=new ModelMapper();
		mapper.map(theatreadmindao.findTheatreAdmin(theatreadminid), dto);
		ResponseStructure <TheatreAdminDto>structure=new ResponseStructure<TheatreAdminDto>();
		
		if(dto!=null) {
			structure.setMessage("find data ssuccessfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<TheatreAdminDto>>(structure,HttpStatus.FOUND);
		}
		throw new TheatreAdminNotFound("Laptop is not there!!!!!!!!");
		}
	
	public ResponseEntity<ResponseStructure<TheatreAdminDto>> deleteTheatreAdmin(int theatreadminid){
		TheatreAdminDto dto=new TheatreAdminDto();
		ModelMapper mapper=new ModelMapper();
		mapper.map(theatreadmindao.deleteTheatreAdmin(theatreadminid), dto);
		ResponseStructure <TheatreAdminDto>structure=new ResponseStructure<TheatreAdminDto>();
		
		if(dto!=null) {
			structure.setMessage("delete data successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<TheatreAdminDto>>(structure,HttpStatus.OK);
		}
		throw new TheatreAdminNotFound("Laptop is not there!!!!!!!!");
		}
	
	public ResponseEntity<ResponseStructure<TheatreAdminDto>> updateTheatreAdmin(TheatreAdmin theatreadmin, int theatreadminid){
		TheatreAdminDto dto=new TheatreAdminDto();
		ModelMapper mapper=new ModelMapper();
		mapper.map(theatreadmindao.updateTheatreAdmin(theatreadmin, theatreadminid), dto);
		ResponseStructure <TheatreAdminDto>structure=new ResponseStructure<TheatreAdminDto>();
		    if(dto!=null) {
				structure.setMessage("update data successfully");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dto);
				return new ResponseEntity<ResponseStructure<TheatreAdminDto>>(structure,HttpStatus.OK);
			}
			throw new TheatreAdminNotFound("Laptop is not there!!!!!!!!");
			}
	public ResponseEntity<ResponseStructure<List<TheatreAdmin>>>  findAllStudent(List<TheatreAdmin> admin){
		
		ResponseStructure <List<TheatreAdmin>>structure=new ResponseStructure<List<TheatreAdmin>>();
		TheatreAdminDto dto=new TheatreAdminDto();
		ModelMapper mapper=new ModelMapper();
		mapper.map(theatreadmindao.findAllTheatreAdmin(admin), dto);
		List<TheatreAdmin> s=theatreadmindao.findAllTheatreAdmin(admin);
		if(s!=null) {
			structure.setMessage("list of data ");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(s);
			return new ResponseEntity<ResponseStructure<List<TheatreAdmin>>>(structure,HttpStatus.FOUND);
		}
		throw new NoListFound("no list found");
		}


}
