package com.example.bootproject.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bootproject.BookMyShow.entity.Admin;
import com.example.bootproject.BookMyShow.repo.AdminRepo;

@Repository
public class AdminDao {
    
	@Autowired
	AdminRepo adminrepo;
	
	public Admin saveAdmin(Admin admin) {
		return adminrepo.save(admin);
		
	}
	
	public Admin findAdmin(int adminId)
	{
		Optional<Admin> a=adminrepo.findById(adminId);
		if(a.isPresent())
		{
			return a.get();
		}
		return null;
	}

	public Admin deleteAdmin(int adminId)
	{
		Admin a=findAdmin(adminId);
	    adminrepo.delete(a);
	    return a;
		
	}
	
	public Admin updateAdmin(Admin admin, int adminId)
	{
		Admin exadmin = findAdmin(adminId);
		if(exadmin != null)
		{
			admin.setAdminId(adminId);
			return adminrepo.save(admin);
		}
		return null;
	}
	
	public List<Admin> findAllAdmin()
	{
		
		List<Admin> exadmin =adminrepo.findAll();
		return exadmin;
	}

	public Admin findbyMail(String adminemail) 
	{
		Admin admin=findbyMail(adminemail);
		if(admin!=null)
		{
			return admin;
		}
		return null;
	}
	
}
