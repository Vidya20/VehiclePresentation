/**
 * 
 */
package com.mindtree.awsfinalpresentation.entity;

import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author M1018339
 * 
 */
/*
 * Vehicle Entity class,for vehicle details
 */
@XmlRootElement
// JAX-RS(The Java API for RESTful Web Services) supports an automatic mapping
// from JAXB annotated class to XML
public class Vehicle {
	private String regNo;
	private String cat;
	private String manufacturer;
	private int dailyRent;
	private int mileage;
	private String fuelType;
	private String description;
	private Set<Booking> bookings = new HashSet<Booking>();

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getDailyRent() {
		return dailyRent;
	}

	public void setDailyRent(int dailyRent) {
		this.dailyRent = dailyRent;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}
}
