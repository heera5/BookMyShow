package com.example.bootproject.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bootproject.BookMyShow.entity.User;
import com.example.bootproject.BookMyShow.entity.User;
import com.example.bootproject.BookMyShow.repo.UserRepo;

@Repository
public class UserDao {
	    
		@Autowired
		UserRepo userrepo;
		
		public  User saveUser(User user) {
			return userrepo.save(user);
			
		}
		
		public User findUser(int userId)
		{
			Optional<User> a=userrepo.findById(userId);
			if(a.isPresent())
			{
				return a.get();
			}
			return null;
		}

		public User deleteUser(int userId)
		{
			User a=findUser(userId);
			userrepo.delete(a);
		    return a;
			
		}
		
		public User updateUser(User user, int userId)
		{
			User exuser = findUser(userId);
			if(exuser != null)
			{
				user.setUserId(userId);
				return userrepo.save(user);
			}
			return null;
		}
		
		public List<User> findAllUser()
		{
			
			List<User> exuser =userrepo.findAll();
			return exuser;
		}
		
		public User findbyMail(String useremail) 
		{
			User user=findbyMail(useremail);
			if(user!=null)
			{
				return user;
			}
			return null;
		}


}
