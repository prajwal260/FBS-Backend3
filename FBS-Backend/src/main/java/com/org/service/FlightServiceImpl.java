package com.org.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.dao.BookingDetailsDao;
import com.org.dao.FlightDao;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.BookingDetails;
import com.org.model.BookingRequest;
import com.org.model.BookingResponse;
import com.org.model.Flight;
import com.org.model.HistoryResponse;
import com.org.model.TicketResponse;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	FlightDao flightDao;
	@Autowired
	public BookingDetailsDao bookingDetailsDao;

	/*
	 * add a flight
	 */
	@Override
	public ResponseEntity<Flight> addFlight(Flight flight) {
		Optional<Flight> findById = flightDao.findById(flight.getFlightNo());
		try {
		if (!findById.isPresent()) {
			flightDao.save(flight);
			return new ResponseEntity<Flight>(flight,HttpStatus.OK);
		} else
			throw new RecordAlreadyPresentException("Flight with number: " + flight.getFlightNo() + " already present");
	}
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * view all flights
	 */
	@Override
	public Iterable<Flight> viewAllFlight() {
		return flightDao.findAll();
	}

	/*
	 * search a flight
	 */
	@Override
	public Flight viewFlight(Integer flightNumber) {
		Optional<Flight> findById = flightDao.findById(flightNumber);
		if (findById.isPresent()) {
			return findById.get();
		}
		else
			throw new RecordNotFoundException("Flight with number: " + flightNumber + " not exists");
	    }
		/*catch(RecordNotFoundException e)
		{
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}*/

	/*
	 * modify a flight
	 */
	@Override
	public Flight modifyFlight(Flight flight) {
		Optional<Flight> findById = flightDao.findById(flight.getFlightNo());
		if (findById.isPresent()) {
			flightDao.save(flight);
		} else
			throw new RecordNotFoundException("Flight with number: " + flight.getFlightNo() + " not exists");
		return flight;
	}

	/*
	 * remove a flight
	 */
	public String removeFlight(Integer flightNumber) {
		Optional<Flight> findById = flightDao.findById(flightNumber);
		if (findById.isPresent()) {
			flightDao.deleteById(flightNumber);
			return "Flight removed!!";
		} else
			throw new RecordNotFoundException("Flight with number: " + flightNumber + " not exists");

	}
	
	@Override
	public BookingResponse bookFlight(BookingRequest req) {
		BookingResponse resp = new BookingResponse();
		try {
			Flight model = flightDao.findById(req.getFlightid()).orElse(null);
			if (model != null) {
				String pnrNo = String.valueOf(
						ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli());
				System.out.println("generated pnr no:::::" + pnrNo);
				System.out.println("date in request:::::" + req.getDate());
				BookingDetails bookingModel = new BookingDetails(pnrNo, req.getMailId(),req.getDate(),req.getSourceFlight(),req.getDestination(),
						new ObjectMapper().writeValueAsString(req.getPassengerList()));
				bookingDetailsDao.save(bookingModel);
				resp.setEmail(req.getMailId());
				resp.setPnrNo(pnrNo);
				resp.setDestination(req.getDestination());
				resp.setSourceFlight(req.getSourceFlight());
				resp.setRespCode("00");
				resp.setRespDesc("Booked Successfully");
			} else {
				resp.setRespCode("01");
				resp.setRespDesc("Booking Failed");
			}
		} catch (JsonProcessingException e) {
			resp.setRespCode("01");
			resp.setRespDesc("Booking Failed");
			e.printStackTrace();
		}
		return resp;
	}
	
	@Override
	public TicketResponse ticketDetails(String pnr) {
		TicketResponse resp = new TicketResponse();
		try {
			BookingDetails bookingModel = bookingDetailsDao.findById(pnr).orElse(null);
			if (bookingModel != null) {
				resp.setRespCode("00");
				resp.setRespDesc("Success");
				resp.setBookingdetails(bookingModel);
			} else {
				resp.setRespCode("01");
				resp.setRespDesc("Incorrect PNR");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			resp.setRespCode("01");
			resp.setRespDesc("Failure");
		}
		return resp;
	}

//	@Override
//	public FlightResponse register(Flight req) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public HistoryResponse getHistory(String emailId) {
		HistoryResponse resp = new HistoryResponse();
		try {
			List<BookingDetails> bookingModelList = bookingDetailsDao.findByEmail(emailId);
			if (bookingModelList != null && bookingModelList.size() > 0) {
				resp.setRespCode("00");
				resp.setRepDesc("Success");
				resp.setBookingList(bookingModelList);
			} else {
				resp.setRespCode("01");
				resp.setRepDesc("Empty History");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			resp.setRespCode("01");
			resp.setRepDesc("Failure");
		}
		return resp;
	}
}
