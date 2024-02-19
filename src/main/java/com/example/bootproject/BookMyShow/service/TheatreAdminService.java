package com.example.bootproject.BookMyShow.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bootproject.BookMyShow.dao.TheatreAdminDao;
import com.example.bootproject.BookMyShow.dao.TheatreDao;
import com.example.bootproject.BookMyShow.dto.TheatreAdminDto;
import com.example.bootproject.BookMyShow.entity.Theatre;
import com.example.bootproject.BookMyShow.entity.TheatreAdmin;
import com.example.bootproject.BookMyShow.exception.NoListFound;
import com.example.bootproject.BookMyShow.exception.TheatreAdminNotFound;
import com.example.bootproject.BookMyShow.util.ResponseStructure;


@Service
public class TheatreAdminService {

	@Autowired
	TheatreAdminDao theatreadmindao;
	
	@Autowired
	TheatreDao theatredao;
	
	@Autowired
	TheatreAdmin theatreadmin;
	
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
	throw new TheatreAdminNotFound("no theatreadmin found");
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
		throw new TheatreAdminNotFound("theatreadmin is not there!!!!!!!!");
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
		throw new TheatreAdminNotFound("theatreadmin is not there!!!!!!!!");
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
			throw new TheatreAdminNotFound("theatreadmin is not there!!!!!!!!");
			}
	public ResponseEntity<ResponseStructure<List<TheatreAdmin>>>  findAllTheatreAdmin(List<TheatreAdmin> admin){
		
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
	
	public ResponseEntity<ResponseStructure<TheatreAdminDto>> assignTheatreToTheatreAdmin(int theatreAdminId,int theatreId){
		TheatreAdminDto taDto=new TheatreAdminDto();
		ModelMapper mapper=new ModelMapper();
		TheatreAdmin tAdmin=theatreadmindao.findTheatreAdmin(theatreAdminId);
		Theatre theatre=theatredao.findTheatre(theatreId);
		if(tAdmin != null) {
			if(theatre != null) {
				tAdmin.setTheatre(theatre);
				mapper.map(theatreadmindao.updateTheatreAdmin(tAdmin, theatreAdminId), taDto);
				ResponseStructure<TheatreAdminDto> structure=new ResponseStructure<TheatreAdminDto>();
				structure.setMessage("assign theatre to Theatre Admin success");
				structure.setStatus(HttpStatus .OK.value());
				structure.setData(taDto);
				return new ResponseEntity<ResponseStructure<TheatreAdminDto>>(structure,HttpStatus.OK);
			}
			else {
				throw new TheatreAdminNotFound("no theatreadmin found");
			}
			
		}
		throw new TheatreAdminNotFound("no theatre found");
	}
	
	public ResponseEntity<ResponseStructure<TheatreAdmin>>theatreadminlogin(String theatreadminemail,String theatreadminpassword){
		List<TheatreAdmin> theatreAdmin=theatreadmindao.findAllTheatreAdmin(null);
			if(theatreadmin.getTheatreAdminEmail().equals(theatreadminemail))
			{
				if(theatreadmin.getTheatreAdminPassword().equals(theatreadminpassword)) {
					ResponseStructure<TheatreAdmin>Structure=new ResponseStructure<TheatreAdmin>() ;
					Structure.setMessage("theatre admin login successfull");
					Structure.setStatus(HttpStatus.FOUND.value());
					return new ResponseEntity<ResponseStructure<TheatreAdmin>>(Structure,HttpStatus.FOUND);
				}
				throw new TheatreAdminNotFound("theatre admin login unsuccessfull");
				
			}
		
		return null;
	}


}
