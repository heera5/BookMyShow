package com.example.bootproject.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bootproject.BookMyShow.entity.Booking;
import com.example.bootproject.BookMyShow.repo.BookingRepo;


@Repository
public class BookingDao {

    	@Autowired
    	BookingRepo bookingrepo;
		public Booking saveBooking(Booking booking) {
			return bookingrepo.save(booking);
			
		}
		
		public Booking findBooking(int bookingId)
		{
			Optional<Booking> a=bookingrepo.findById(bookingId);
			if(a.isPresent())
			{
				return a.get();
			}
			return null;
		}

		public Booking deleteBooking(int bookingId)
		{
			Booking a=findBooking(bookingId);
			bookingrepo.delete(a);
		    return a;
			
		}
		
		public Booking updateBooking(Booking booking, int bookingId)
		{
			Booking exbooking = findBooking(bookingId);
			if(exbooking != null)
			{
				booking.setBookingId(bookingId);
				return bookingrepo.save(booking);
			}
			return null;
		}
		
		public List<Booking> findAllBooking(List<Booking> booking)
		{
			
			List<Booking> exbooking =bookingrepo.findAll();
			return exbooking;
		}

	}