package com.example.bootproject.BookMyShow.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bootproject.BookMyShow.dao.AdminDao;
import com.example.bootproject.BookMyShow.dto.AdminDto;
import com.example.bootproject.BookMyShow.entity.Admin;
import com.example.bootproject.BookMyShow.entity.Theatre;
import com.example.bootproject.BookMyShow.exception.AdminNotFound;
import com.example.bootproject.BookMyShow.exception.NoListFound;
import com.example.bootproject.BookMyShow.repo.TheatreRepo;
import com.example.bootproject.BookMyShow.util.ResponseStructure;


@Service
public class AdminService {


		@Autowired
		AdminDao admindao;
		
		@Autowired
		TheatreRepo theatrerepo;
		
		@Autowired
		Theatre theatre;
		
		
		
		public ResponseEntity<ResponseStructure<AdminDto>> save(Admin admin){
			
			AdminDto dto=new AdminDto();
			ModelMapper mapper=new ModelMapper();
			mapper.map(admindao.saveAdmin(admin), dto);
		    ResponseStructure <AdminDto>structure=new ResponseStructure<AdminDto>();
			if(dto!=null)
				{
			structure.setMessage("save data successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.CREATED);
		}
		throw new AdminNotFound("no student found");
		}
		
		public ResponseEntity<ResponseStructure<AdminDto>> findAdmin(int adminid){
			AdminDto dto=new AdminDto();
			ModelMapper mapper=new ModelMapper();
			mapper.map(admindao.findAdmin(adminid), dto);
			ResponseStructure <AdminDto>structure=new ResponseStructure<AdminDto>();
			
			if(dto!=null) {
				structure.setMessage("find data ssuccessfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(dto);
				return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.FOUND);
			}
			throw new AdminNotFound("Admin is not there!!!!!!!!");
			}
		
		public ResponseEntity<ResponseStructure<AdminDto>> deleteAdmin(int adminid){
			AdminDto dto=new AdminDto();
			ModelMapper mapper=new ModelMapper();
			mapper.map(admindao.deleteAdmin(adminid), dto);
			ResponseStructure <AdminDto>structure=new ResponseStructure<AdminDto>();
			
			if(dto!=null) {
				structure.setMessage("delete data successfully");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dto);
				return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.OK);
			}
			throw new AdminNotFound("Laptop is not there!!!!!!!!");
			}
		
		public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(Admin admin, int adminid){
			AdminDto dto=new AdminDto();
			ModelMapper mapper=new ModelMapper();
			mapper.map(admindao.updateAdmin(admin, adminid), dto);
			ResponseStructure <AdminDto>structure=new ResponseStructure<AdminDto>();
			    if(dto!=null) {
					structure.setMessage("update data successfully");
					structure.setStatus(HttpStatus.OK.value());
					structure.setData(dto);
					return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.OK);
				}
				throw new AdminNotFound("Laptop is not there!!!!!!!!");
				}
		public ResponseEntity<ResponseStructure<List<Admin>>>  findAllAdmin(List<Admin> admin){
			
			ResponseStructure <List<Admin>>structure=new ResponseStructure<List<Admin>>();
			AdminDto dto=new AdminDto();
			ModelMapper mapper=new ModelMapper();
			mapper.map(admindao.findAllAdmin(admin), dto);
			List<Admin> s=admindao.findAllAdmin(admin);
			if(s!=null) {
				structure.setMessage("list of data ");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(s);
				return new ResponseEntity<ResponseStructure<List<Admin>>>(structure,HttpStatus.FOUND);
			}
			throw new NoListFound("no list found");
			}
		
		public ResponseEntity<ResponseStructure<AdminDto>> adminLogin(String adminMail,String adminPassword)
		{
			
			AdminDto adminDto=new AdminDto();
			ModelMapper modelMapper=new ModelMapper();
			Admin admin=admindao.findbyMail(adminMail);
			
			ResponseStructure<AdminDto> structure=new ResponseStructure<AdminDto>();
			if(admin!=null)
			{
				if(admin.getAdminPassword().equals(adminPassword))
				{
					modelMapper.map(admin, adminDto);
				 structure.setData(adminDto);
				 structure.setMessage("Admin login succesfully");
				 structure.setStatus(HttpStatus.ACCEPTED.value());
				 
				 return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.ACCEPTED);
				} 
				throw new AdminNotFound("admin password is not matching");
				
			}
			throw new AdminNotFound("admin object not found for the given mail id");
		}
		
		public ResponseEntity<ResponseStructure<AdminDto>> assignTheatresToAdmin(int adminId,List<Integer> theatreIds){
			AdminDto aDto=new AdminDto();
			ModelMapper mapper=new ModelMapper();
			Admin admin=admindao.findAdmin(adminId);
			if(admin != null) {
				List<Theatre> extheatres=theatrerepo.findAllById(theatreIds);
				admin.setListofTheatre(extheatres);
				mapper.map(admindao.updateAdmin(admin, adminId), aDto);
				ResponseStructure<AdminDto> structure=new ResponseStructure<AdminDto>();
				structure.setMessage("assign theatre to Admin success");
				structure.setStatus(HttpStatus .OK.value());
				structure.setData(aDto);
				return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.OK);
			}
			throw new AdminNotFound("we can't assign theatres to Admin because,Admin not found for the given id");
		}
}
