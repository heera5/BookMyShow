package com.example.bootproject.BookMyShow.entity;

import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity


	
public class Theatre {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int theatreId;
	private String theatreLocation;
	private String theatrename;
	@ManyToMany
	private TheatreAdmin theatreadmin;
	private List<Screen> listofscreen;
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
	public TheatreAdmin getTheatreadmin() {
		return theatreadmin;
	}
	public void setTheatreadmin(TheatreAdmin theatreadmin) {
		this.theatreadmin = theatreadmin;
	}
	public List<Screen> getListofscreen() {
		return listofscreen;
	}
	public void setListofscreen(List<Screen> listofscreen) {
		this.listofscreen = listofscreen;
	}
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreLocation=" + theatreLocation + ", theatrename="
				+ theatrename + ", theatreadmin=" + theatreadmin + ", listofscreen=" + listofscreen + "]";
	}

	

}
