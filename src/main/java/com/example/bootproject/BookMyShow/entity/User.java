package com.example.bootproject.BookMyShow.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class User {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String userMail;
	private String userPassword;
	@OneToMany
	private List<Booking> listofbooking;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public List<Booking> getListofbooking() {
		return listofbooking;
	}
	public void setListofbooking(List<Booking> listofbooking) {
		this.listofbooking = listofbooking;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userMail=" + userMail + ", userPassword="
				+ userPassword + ", getUserId()=" + getUserId() + ", getUserName()=" + getUserName()
				+ ", getUserMail()=" + getUserMail() + ", getUserPassword()=" + getUserPassword() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
