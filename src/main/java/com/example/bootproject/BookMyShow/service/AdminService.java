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
import com.example.bootproject.BookMyShow.exception.AdminNotFound;
import com.example.bootproject.BookMyShow.exception.NoListFound;
import com.example.bootproject.BookMyShow.util.ResponseStructure;


@Service
public class AdminService {


		@Autowired
		AdminDao admindao;
		
		
		
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
			throw new AdminNotFound("Laptop is not there!!!!!!!!");
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
}
