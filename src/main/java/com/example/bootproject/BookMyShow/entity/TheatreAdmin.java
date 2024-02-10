package com.example.bootproject.BookMyShow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class TheatreAdmin {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int theatreAdminId;
	private String theatreAdminName;
	private String theatreAdminEmail;
	private String theatreAdminPassword;
	@OneToOne
	private Theatre theatre;
	public int getTheatreAdminId() {
		return theatreAdminId;
	}
	public void setTheatreAdminId(int theatreAdminId) {
		this.theatreAdminId = theatreAdminId;
	}
	public String getTheatreAdminName() {
		return theatreAdminName;
	}
	public void setTheatreAdminName(String theatreAdminName) {
		this.theatreAdminName = theatreAdminName;
	}
	public String getTheatreAdminEmail() {
		return theatreAdminEmail;
	}
	public void setTheatreAdminEmail(String theatreAdminEmail) {
		this.theatreAdminEmail = theatreAdminEmail;
	}
	public String getTheatreAdminPassword() {
		return theatreAdminPassword;
	}
	public void setTheatreAdminPassword(String theatreAdminPassword) {
		this.theatreAdminPassword = theatreAdminPassword;
	}
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	@Override
	public String toString() {
		return "TheatreAdmin [theatreAdminId=" + theatreAdminId + ", theatreAdminName=" + theatreAdminName
				+ ", theatreAdminEmail=" + theatreAdminEmail + ", theatreAdminPassword=" + theatreAdminPassword
				+ ", theatre=" + theatre + "]";
	}
	
}
