package com.org.model;

import java.util.List;

public class BookingRequest {
	private Integer flightid;
	private List<Passenger1> passengerList;
	private String mailId;
	private String date;
	private String mobile;
    private String sourceFlight;
    private String destination;

	
	//dest
	//source
	//arr
	//retur

	public Integer getFlightid() {
		return flightid;
	}

	public void setFlightid(Integer flightid) {
		this.flightid = flightid;
	}

	public List<Passenger1> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger1> passengerList) {
		this.passengerList = passengerList;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSourceFlight() {
		return sourceFlight;
	}

	public void setSourceFlight(String sourceFlight) {
		this.sourceFlight = sourceFlight;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
