package com.example.bootproject.BookMyShow.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Component
public class Admin {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminId;
	@NotNull(message = "user name can not be null")
	@NotBlank(message = "user name can not be blank")
	private String adminmName;
	@NotNull(message="admin emailcannot be null")
	@NotBlank(message="admin email cannot be blank")
	@Email(message="enter a valid email address")
	private String adminMail;
	@NotNull(message="password cannot be null")
	@NotBlank(message="password cannot be null")
	@Size(min=8,message="password must be atleast 8 characters")
	@Pattern(regexp = "^(?=.[a-z])(?=.[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$",
	         message="password must be atleast 1 digit,1 uppercase,1 lowercase and 1 special character")
	private String adminPassword;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Theatre> listofTheatre;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminmName() {
		return adminmName;
	}
	public void setAdminmName(String adminmName) {
		this.adminmName = adminmName;
	}
	public String getAdminMail() {
		return adminMail;
	}
	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public List<Theatre> getListofTheatre() {
		return listofTheatre;
	}
	public void setListofTheatre(List<Theatre> listofTheatre) {
		this.listofTheatre = listofTheatre;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminmName=" + adminmName + ", adminMail=" + adminMail
				+ ", adminPassword=" + adminPassword + "]";
	}
	

}
