package com.example.bootproject.BookMyShow.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Admin {
	 @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminId;
	private String adminmName;
	private String adminMail;
	private String adminPassword;
	@OneToMany
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
