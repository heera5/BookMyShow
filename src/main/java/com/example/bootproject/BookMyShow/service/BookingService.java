package com.example.bootproject.BookMyShow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bootproject.BookMyShow.dao.BookingDao;
import com.example.bootproject.BookMyShow.entity.Booking;
import com.example.bootproject.BookMyShow.exception.BookingUnavailable;
import com.example.bootproject.BookMyShow.util.ResponseStructure;

@Service
public class BookingService {

	@Autowired
	BookingDao bookingdao;
	
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(Booking booking){
		ResponseStructure <Booking>structure=new ResponseStructure<Booking>();
		Booking l=bookingdao.saveBooking(booking);
		if(l!=null) {
			structure.setMessage("save data ssuccessfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(l);
			return new ResponseEntity<ResponseStructure<Booking>>(structure,HttpStatus.CREATED);
			//ResponseEntity<ResponseStructure<Laptop>>(structure,HttpStatus.CREATED);
		}
		 throw new BookingUnavailable("booking is not avaiable");
		}
		
		public ResponseEntity<ResponseStructure<Booking>> findBooking(int bookingid){
			ResponseStructure <Booking>structure=new ResponseStructure<Booking>();
			Booking l=bookingdao.findBooking(bookingid);
			if(l!=null) {
				structure.setMessage("find data ssuccessfully");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(l);
				return new ResponseEntity<ResponseStructure<Booking>>(structure,HttpStatus.FOUND);
			}
			 throw new  BookingUnavailable("booking is not found");
			}
		
		public ResponseEntity<ResponseStructure<Booking>> deleteBooking(int bookingid){
			ResponseStructure <Booking>structure=new ResponseStructure<Booking>();
			Booking l=bookingdao.deleteBooking(bookingid);
			if(l!=null) {
				structure.setMessage("delete data successfully");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(l);
				return new ResponseEntity<ResponseStructure<Booking>>(structure,HttpStatus.OK);
			}
			 throw new  BookingUnavailable("unable to delete booking ");
			}
		
		public ResponseEntity<ResponseStructure<Booking>> updateBooking(Booking booking, int bookingid){
				ResponseStructure <Booking>structure=new ResponseStructure<Booking>();
				Booking l=bookingdao.updateBooking(booking,bookingid);
				if(l!=null) {
					structure.setMessage("update data ssuccessfully");
					structure.setStatus(HttpStatus.OK.value());
					structure.setData(l);
					return new ResponseEntity<ResponseStructure<Booking>>(structure,HttpStatus.OK);
				}
				 throw new  BookingUnavailable("booking update failed");
				}

}
