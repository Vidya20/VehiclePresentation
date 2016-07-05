/**
 * 
 */
package com.mindtree.awsfinalpresentation.entity;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author M1018339
 * 
 */
/*
 * Entity class to book vehicle
 */
@XmlRootElement
// JAX-RS(The Java API for RESTful Web Services) supports an automatic mapping
// from JAXB annotated class to XML
public class Booking {

	private int id;
	private String custName;
	private String emailId;
	private String category;
	private String place;
	private Date bookedFrom;
	private Date bookedTo;
	private double totalRent;
	private String isPaid;

	private Vehicle vehicle;

	public Booking() {
		super();
	}

	public Booking(int id, String custName, String emailId, String category,
			String place, Date bookedFrom, Date bookedTo, double totalRent,
			String isPaid, Vehicle vehicle) {
		super();
		this.id = id;
		this.custName = custName;
		this.emailId = emailId;
		this.category = category;
		this.place = place;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
		this.totalRent = totalRent;
		this.isPaid = isPaid;
		this.vehicle = vehicle;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getBookedFrom() {
		return bookedFrom;
	}

	public void setBookedFrom(Date bookedFrom) {
		this.bookedFrom = bookedFrom;
	}

	public Date getBookedTo() {
		return bookedTo;
	}

	public void setBookedTo(Date bookedTo) {
		this.bookedTo = bookedTo;
	}

	public double getTotalRent() {
		return totalRent;
	}

	public void setTotalRent(double totalRent) {
		this.totalRent = totalRent;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
