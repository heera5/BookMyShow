package com.example.bootproject.BookMyShow.dto;

import java.util.List;

import com.example.bootproject.BookMyShow.entity.Theatre;

import jakarta.persistence.OneToMany;

public class AdminDto {


		private int adminId;
		private String adminmName;
		private String adminMail;
		
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

		public List<Theatre> getListofTheatre() {
			return listofTheatre;
		}

		public void setListofTheatre(List<Theatre> listofTheatre) {
			this.listofTheatre = listofTheatre;
		}

		@Override
		public String toString() {
			return "AdminDto [adminId=" + adminId + ", adminmName=" + adminmName + ", adminMail=" + adminMail
					+ ", listofTheatre=" + listofTheatre + "]";
		}
		
		

}
