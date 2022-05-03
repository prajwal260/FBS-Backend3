package com.org.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.model.BookingDetails;

public interface BookingDetailsDao extends JpaRepository<BookingDetails, String> { 
	
	@Query(value = "select * from booking_details where email_id=?1", nativeQuery = true)
     List<BookingDetails> findByEmail(String emailId);

}
