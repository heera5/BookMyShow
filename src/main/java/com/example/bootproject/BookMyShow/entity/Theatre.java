package com.example.bootproject.BookMyShow.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Component
@Entity
public class Theatre {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int theatreId;
	private String theatreLocation;
	private String theatrename;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Screen> listofscreen;
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreLocation() {
		return theatreLocation;
	}
	public void setTheatreLocation(String theatreLocation) {
		this.theatreLocation = theatreLocation;
	}
	public String getTheatrename() {
		return theatrename;
	}
	public void setTheatrename(String theatrename) {
		this.theatrename = theatrename;
	}
	public List<Screen> getListofscreen() {
		return listofscreen;
	}
	public void setListofscreen(List<Screen> listofscreen) {
		this.listofscreen = listofscreen;
	}
	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreLocation=" + theatreLocation + ", theatrename="
				+ theatrename + ", listofscreen=" + listofscreen + "]";
	}
	

	

}
