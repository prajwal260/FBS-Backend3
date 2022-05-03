package com.org.model;

import java.util.List;

public class HistoryResponse {
	private String respCode;
	private String repDesc;
	private List<BookingDetails> bookingList;

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRepDesc() {
		return repDesc;
	}

	public void setRepDesc(String repDesc) {
		this.repDesc = repDesc;
	}

	public List<BookingDetails> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<BookingDetails> bookingList) {
		this.bookingList = bookingList;
	}

}
