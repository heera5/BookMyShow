package com.example.bootproject.BookMyShow.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
@Component
@Entity
public class TheatreAdmin {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int theatreAdminId;
	@NotNull(message = "user name can not be null")
	@NotBlank(message = "user name can not be blank")
	private String theatreAdminName;
	@NotNull(message="admin emailcannot be null")
	@NotBlank(message="admin email cannot be blank")
	@Email(message="enter a valid email address")
	private String theatreAdminEmail;
	@NotNull(message="password cannot be null")
	@NotBlank(message="password cannot be null")
	@Size(min=8,message="password must be atleast 8 characters")
	@Pattern(regexp = "^(?=.[a-z])(?=.[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$",
	         message="password must be atleast 1 digit,1 uppercase,1 lowercase and 1 special character")
	private String theatreAdminPassword;
	@OneToOne(cascade=CascadeType.ALL)
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
