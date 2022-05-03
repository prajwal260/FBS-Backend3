package com.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking_details")
public class BookingDetails {
	@Id
	@Column(name = "pnr_no")
	private String pnrNo;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "date")
	private String date;
    private String sourceFlight;
    private String destination;
	@Column(name = "passenger_details")
	private String passengerDetails;

	public String getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(String pnrNo) {
		this.pnrNo = pnrNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassengerDetails() {
		return passengerDetails;
	}

	public void setPassengerDetails(String passengerDetails) {
		this.passengerDetails = passengerDetails;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public BookingDetails() {
		super();
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

	public BookingDetails(String pnrNo, String emailId, String passengerDetails, String date) {
		super();
		this.pnrNo = pnrNo;
		this.emailId = emailId;
		this.passengerDetails = passengerDetails;
		this.date = date;
	}

	public BookingDetails(String pnrNo, String emailId, String date, String sourceFlight, String destination,
			String passengerDetails) {
		super();
		this.pnrNo = pnrNo;
		this.emailId = emailId;
		this.date = date;
		this.sourceFlight = sourceFlight;
		this.destination = destination;
		this.passengerDetails = passengerDetails;
	}
	
}
