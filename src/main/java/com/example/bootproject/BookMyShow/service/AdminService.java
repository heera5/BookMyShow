package com.example.bootproject.BookMyShow.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bootproject.BookMyShow.dao.AdminDao;
import com.example.bootproject.BookMyShow.dao.TheatreAdminDao;
import com.example.bootproject.BookMyShow.dao.TheatreDao;
import com.example.bootproject.BookMyShow.dto.AdminDto;
import com.example.bootproject.BookMyShow.entity.Admin;
import com.example.bootproject.BookMyShow.entity.Theatre;
import com.example.bootproject.BookMyShow.entity.TheatreAdmin;
import com.example.bootproject.BookMyShow.exception.AdminNotFound;
import com.example.bootproject.BookMyShow.exception.NoListFound;
import com.example.bootproject.BookMyShow.repo.TheatreAdminRepo;
import com.example.bootproject.BookMyShow.repo.TheatreRepo;
import com.example.bootproject.BookMyShow.util.ResponseStructure;


@Service
public class AdminService {


		@Autowired
		AdminDao admindao;
		
		@Autowired
		TheatreAdminRepo theatreadminrepo;
		
		@Autowired
		Theatre theatre;
		
		@Autowired
		TheatreRepo theatrerepo;
		
		@Autowired
		TheatreAdmin theatreadmin;
		
		@Autowired
		TheatreAdminDao theatreadmindao;
		@Autowired
		TheatreDao theatredao;
		
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
		throw new AdminNotFound("no admin found");
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
			throw new AdminNotFound("No admin found so delete is not possible!!!!!!!");
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
				throw new AdminNotFound("admin is not there to update!!!!!!!!");
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
				throw new AdminNotFound("admin password is not matching,log in failed");
				
			}
			throw new AdminNotFound("admin object not found for the given mail id");
		}
		
//		public ResponseEntity<ResponseStructure<AdminDto>> assignTheatresToAdmin(String adminEmail,String adminPassword,int adminId,List<Integer> theatreIds){
//			ResponseEntity<ResponseStructure<AdminDto>> ladmin=adminLogin(adminEmail, adminPassword);
//			if(ladmin !=null) {
//			AdminDto aDto=new AdminDto();
//			ModelMapper mapper=new ModelMapper();
//			Admin admin=admindao.findAdmin(adminId);
//			if(admin != null) {
//				List<Theatre> extheatres=theatrerepo.findAllById(theatreIds);
//				admin.setListofTheatre(extheatres);
//				mapper.map(admindao.updateAdmin(admin, adminId), aDto);
//				ResponseStructure<AdminDto> structure=new ResponseStructure<AdminDto>();
//				structure.setMessage("assign theatre to Admin success");
//				structure.setStatus(HttpStatus .OK.value());
//				structure.setData(aDto);
//				return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.OK);
//			}
//			throw new AdminNotFound("assign theatre to  admin");
//			}
//			throw new AdminNotFound("admin login required");
//		}
		
//		public ResponseEntity<ResponseStructure<AdminDto>> assignTheatreAdminToAdmin(String adminEmail,String adminPassword,int theatreadminId,List<Integer> theatreadminId1){
//			ResponseEntity<ResponseStructure<AdminDto>> ladmin=adminLogin(adminEmail, adminPassword);
//			if(ladmin !=null) {
//			AdminDto aDto=new AdminDto();
//			ModelMapper mapper=new ModelMapper();
//			Admin admin=admindao.findAdmin(theatreadminId);
//			if(admin != null) {
//				List<TheatreAdmin> extheatreadmin=theatreadminrepo.findAllById(theatreadminId1);
//				admin.setTheatreadmin(extheatreadmin);
//				mapper.map(admindao.updateAdmin(admin, theatreadminId), aDto);
//				ResponseStructure<AdminDto> structure=new ResponseStructure<AdminDto>();
//				structure.setMessage("assign theatre to Admin success");
//				structure.setStatus(HttpStatus .OK.value());
//				structure.setData(aDto);
//				return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.OK);
//			}
//			throw new AdminNotFound("assigning theatreadmin to admin done!!!!!");
//			}
//			throw new AdminNotFound("admin login required");
//		}
		
		public ResponseEntity<ResponseStructure<AdminDto>> addTheatreToAdmin(int adminId,int theatreId){
			
			AdminDto adminDto=new AdminDto();
			ModelMapper mapper=new ModelMapper();
		
			
			Admin a=admindao.findAdmin(adminId);
			if(a!=null)
			{
				    List<Theatre> theatreList=theatredao.findAllTheatre();
				    List<Theatre>adminTheatre=a.getListofTheatre();
				    if(adminTheatre==null)
				    {
				    	List<Theatre> newTheatreList=new ArrayList<Theatre>();
				    	newTheatreList.add(theatredao.findTheatre(theatreId));
				    	a.setListofTheatre(newTheatreList);	
				    }
				    else 
				    {
				    	for (Theatre theatre : theatreList) 
				    	{
				    		if(theatre.getTheatreId()==theatreId)
				    		{
				    			adminTheatre.add(theatredao.findTheatre(theatreId));
				    			a.setListofTheatre(adminTheatre);;
				    		}
							
						}
				    }
				    mapper.map(admindao.updateAdmin(a,a.getAdminId()), adminDto);
				    ResponseStructure<AdminDto> structure=new ResponseStructure<AdminDto>();
				    structure.setMessage("Theatre list assign to admin");
				    structure.setStatus(HttpStatus.OK.value());
				    structure.setData(adminDto);
				    
	       return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.OK);
			}
			throw new AdminNotFound("Admin object is not found for the given ");
	}
		
public ResponseEntity<ResponseStructure<AdminDto>> addTheatreAdminToAdmin(int adminId,int theatreadminId){
			
			AdminDto adminDto=new AdminDto();
			ModelMapper mapper=new ModelMapper();
		
			
			Admin a=admindao.findAdmin(adminId);
			if(a!=null)
			{
				    List<TheatreAdmin> theatreadminList=theatreadmindao.findAllTheatreAdmin(null);
				    List<TheatreAdmin>Theatreadmin=a.getTheatreadmin();
				    if(Theatreadmin==null)
				    {
				    	List<TheatreAdmin> newTheatreAdminList=new ArrayList<TheatreAdmin>();
				    	newTheatreAdminList.add(theatreadmindao.findTheatreAdmin(theatreadminId));
				    	a.setTheatreadmin(newTheatreAdminList);	
				    }
				    else 
				    {
				    	for (TheatreAdmin theatreadmin : theatreadminList) 
				    	{
				    		if(theatreadmin.getTheatreAdminId()==theatreadminId)
				    		{
				    			Theatreadmin.add(theatreadmindao.findTheatreAdmin(theatreadminId));
				    			a.setTheatreadmin(Theatreadmin);;
				    		}
							
						}
				    }
				    mapper.map(admindao.updateAdmin(a,a.getAdminId()), adminDto);
				    ResponseStructure<AdminDto> structure=new ResponseStructure<AdminDto>();
				    structure.setMessage("Theatreadmin list assign to admin");
				    structure.setStatus(HttpStatus.OK.value());
				    structure.setData(adminDto);
				    
	       return new ResponseEntity<ResponseStructure<AdminDto>>(structure,HttpStatus.OK);
			}
			throw new AdminNotFound("Admin object is not found for the given ");
	}
		
		
		

}
