//package com.org.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public class Passenger {
//
//	@Column(name = "ticket_id")
//	private String ticketId;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "passenger_id")
//	private int passengerId;
//    
//	@Column(name = "name")
//	private String name;
//	
//	@Column(name = "age")
//	private int age;
//	
//	@Column(name = "booking_id")
//	private String bookingId;
//	
//	@Column(name = "seat_no")
//	private int seatNo;
//
//	public String getTicketId() {
//		return ticketId;
//	}
//
//	public void setTicketId(String ticketId) {
//		this.ticketId = ticketId;
//	}
//
//	public int getPassengerId() {
//		return passengerId;
//	}
//
//	public void setPassengerId(int passengerId) {
//		this.passengerId = passengerId;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	public String getBookingId() {
//		return bookingId;
//	}
//
//	public void setBookingId(String bookingId) {
//		this.bookingId = bookingId;
//	}
//
//	public int getSeatNo() {
//		return seatNo;
//	}
//
//	public void setSeatNo(int seatNo) {
//		this.seatNo = seatNo;
//	}
//	
//}
