package com.org.service;

import org.springframework.http.ResponseEntity;

import com.org.model.BookingRequest;
import com.org.model.BookingResponse;
import com.org.model.Flight;
import com.org.model.FlightResponse;
import com.org.model.HistoryResponse;
import com.org.model.TicketResponse;

public interface FlightService {
	public ResponseEntity<?> addFlight(Flight flight);

	public Iterable<Flight> viewAllFlight();

	public Flight viewFlight(Integer flightNumber);

	public Flight modifyFlight(Flight flight);

	public String removeFlight(Integer flightNumber);
	
	//FlightResponse register(Flight req);

	//SearchResponse search(SearchRequest req);

	BookingResponse bookFlight(BookingRequest req);

	TicketResponse ticketDetails(String pnr);

	HistoryResponse getHistory(String emailId);

}
