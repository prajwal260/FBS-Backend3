package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.dao.BookingDetailsDao;
import com.org.exceptions.RecordAlreadyPresentException;
import com.org.exceptions.RecordNotFoundException;
import com.org.model.BookingDetails;
import com.org.model.BookingRequest;
import com.org.model.BookingResponse;
import com.org.model.Flight;
import com.org.model.FlightResponse;
import com.org.model.HistoryResponse;
import com.org.model.TicketResponse;
import com.org.service.FlightService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/flight")
public class FlightController {
	@Autowired(required = true)
	FlightService flightService;
	
	@Autowired
	public BookingDetailsDao bookingDetailsDao;

	@PostMapping("/addFlight")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public void addFlight(@RequestBody Flight flight) {
		flightService.addFlight(flight);
	}

	@GetMapping("/allFlight")
	public Iterable<Flight> viewAllFlight() {
		return flightService.viewAllFlight();
	}

	@GetMapping("/viewFlight/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Flight viewFlight(@PathVariable("id") Integer flightNo) {
		return flightService.viewFlight(flightNo);
	}

	@PutMapping("/updateFlight")
	@ExceptionHandler(RecordNotFoundException.class)
	public void modifyFlight(@RequestBody Flight flight) {
		flightService.modifyFlight(flight);
	}

	@DeleteMapping("/deleteFlight/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void removeFlight(@PathVariable("id") Integer flightNo) {
		flightService.removeFlight(flightNo);
	}
	
	@PostMapping("/booking")
	public BookingResponse bookFlight(@RequestBody BookingRequest req) {
		// @RequestParam(value = "flightid") int flightid,
		return flightService.bookFlight(req);
	}

	@GetMapping("/ticket/{pnr}")
	public TicketResponse getTicketDetails(@PathVariable("pnr") String pnr) {
		return flightService.ticketDetails(pnr);
	}

	@GetMapping("/history/{emailId}")
	public HistoryResponse getHistory(@PathVariable("emailId") String emailId) {
		return flightService.getHistory(emailId);
	}

	@DeleteMapping("/cancel/{pnr}")
	public FlightResponse registerAirline(@PathVariable("pnr") String pnr) {
		FlightResponse resp = new FlightResponse();
		try {
			BookingDetails model = bookingDetailsDao.findById(pnr).orElse(null);
			if (model != null) {
				bookingDetailsDao.delete(model);
				resp.setRespCode("00");
				resp.setRespDesc("successfully cancelled ticket");
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
}
