package com.example.bootproject.BookMyShow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.bootproject.BookMyShow.dao.SeatDao;
import com.example.bootproject.BookMyShow.entity.Payment;
import com.example.bootproject.BookMyShow.entity.Seat;
import com.example.bootproject.BookMyShow.exception.SeatNotFound;
import com.example.bootproject.BookMyShow.util.ResponseStructure;
@Service
public class SeatService {
	
	@Autowired
	SeatDao seatdao;
	public ResponseEntity<ResponseStructure<Seat>> saveSeat(Seat seat) {
	ResponseStructure<Seat> structure=new ResponseStructure<Seat>();
	structure.setMessage("seat save success");
	structure.setStatus(HttpStatus .CREATED.value());
	structure.setData(seatdao.saveSeat(seat));
	return new ResponseEntity<ResponseStructure<Seat>>(structure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Seat>> findSeat(int seatId) {
	ResponseStructure<Seat> structure=new ResponseStructure<Seat>();
	Seat seat=seatdao.findSeat(seatId);
	if(seat != null) {
	structure.setMessage("seat find success");
	structure.setStatus(HttpStatus .FOUND.value());
	structure.setData(seat);
	return new ResponseEntity<ResponseStructure<Seat>>(structure,HttpStatus.FOUND);
	}
	throw new SeatNotFound("seat not found for the given id");
	}
	public ResponseEntity<ResponseStructure<Seat>> deleteSeat(int seatId) {
		ResponseStructure<Seat> structure=new ResponseStructure<Seat>();
		Seat seat=seatdao.findSeat(seatId);
		if(seat != null) {
		structure.setMessage("seat delete success");
		structure.setStatus(HttpStatus .OK.value());
		structure.setData(seatdao.deleteSeat(seatId));
		return new ResponseEntity<ResponseStructure<Seat>>(structure,HttpStatus.OK);
		}
		throw new SeatNotFound("seat not deleted because,seat not found for the given id");
	}
	public ResponseEntity<ResponseStructure<Seat>> updateSeat(Seat seat,int seatId) {
		ResponseStructure<Seat> structure=new ResponseStructure<Seat>();
		Seat exSeat=seatdao.updateSeat(seat,seatId);
		if(exSeat != null) {
		structure.setMessage("seat update success");
		structure.setStatus(HttpStatus .OK.value());
		structure.setData(exSeat);
		return new ResponseEntity<ResponseStructure<Seat>>(structure,HttpStatus.OK);
		}
		throw new SeatNotFound("seat not updated because,seat not found for the given id");
	}
	public ResponseEntity<ResponseStructure<List<Seat>>> findAllSeat(List<Seat> seat) {
		ResponseStructure<List<Seat>> structure=new ResponseStructure<List<Seat>>();
		List<Seat> seatList=seatdao.findAllSeat(seat);
		structure.setMessage(" find all seat success");
		structure.setStatus(HttpStatus .FOUND.value());
		structure.setData(seatList);
		return new ResponseEntity<ResponseStructure<List<Seat>>>(structure,HttpStatus.FOUND);
	}

}
