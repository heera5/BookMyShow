package com.example.bootproject.BookMyShow.dto;

import java.util.List;



import jakarta.persistence.OneToMany;

public class UserDto {

		private int userId;
		private String userName;
		private String userMail;
		
		

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

		@Override
		public String toString() {
			return "UserDto [userId=" + userId + ", userName=" + userName + ", userMail=" + userMail + "]";
		}

		

		
		

}
