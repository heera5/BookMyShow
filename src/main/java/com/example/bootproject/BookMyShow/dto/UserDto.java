package com.example.bootproject.BookMyShow.dto;

import java.util.List;

import com.example.bootproject.BookMyShow.entity.Booking;

import jakarta.persistence.OneToMany;

public class UserDto {

		private int userId;
		private String userName;
		private String userMail;
		
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

		public List<Booking> getListofbooking() {
			return listofbooking;
		}

		public void setListofbooking(List<Booking> listofbooking) {
			this.listofbooking = listofbooking;
		}

		@Override
		public String toString() {
			return "UserDto [userId=" + userId + ", userName=" + userName + ", userMail=" + userMail
					+ ", listofbooking=" + listofbooking + "]";
		}
		
		

}
