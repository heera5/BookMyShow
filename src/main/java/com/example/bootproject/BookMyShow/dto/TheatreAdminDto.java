package com.example.bootproject.BookMyShow.dto;

import com.example.bootproject.BookMyShow.entity.Theatre;

import jakarta.persistence.OneToOne;

public class TheatreAdminDto {

	private int theatreAdminId;
	private String theatreAdminName;
	private String theatreAdminEmail;
	
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

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	@Override
	public String toString() {
		return "TheatreAdminDto [theatreAdminId=" + theatreAdminId + ", theatreAdminName=" + theatreAdminName
				+ ", theatreAdminEmail=" + theatreAdminEmail + ", theatre=" + theatre + "]";
	}
	
	
}
