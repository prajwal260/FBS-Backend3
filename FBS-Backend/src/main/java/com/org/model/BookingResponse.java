package com.org.model;

public class BookingResponse {
	private String pnrNo;
	private String email;
    private String sourceFlight;
    private String destination;
	private String respCode;
	private String respDesc;
	public String getPnrNo() {
		return pnrNo;
	}
	public void setPnrNo(String pnrNo) {
		this.pnrNo = pnrNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
