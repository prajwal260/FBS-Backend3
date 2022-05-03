package com.org.model;

public class TicketResponse {
	private String respCode;
	private String respDesc;
	private BookingDetails bookingdetails;

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespDesc() {
		return respDesc;
	}

	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}

	public BookingDetails getBookingdetails() {
		return bookingdetails;
	}

	public void setBookingdetails(BookingDetails bookingdetails) {
		this.bookingdetails = bookingdetails;
	}

}
