/**
 * 
 */
package com.mindtree.awsfinalpresentation.dto;

/**
 * @author M1018339
 * 
 */
// ValueObject Entity class for vehicle report
public class ValueObject {
	private String cat;
	private Long totalVeh;
	private Long totalRented;
	private Double totalEarned;

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public Long getTotalVeh() {
		return totalVeh;
	}

	public void setTotalVeh(Long totalVeh) {
		this.totalVeh = totalVeh;
	}

	public Long getTotalRented() {
		return totalRented;
	}

	public void setTotalRented(Long totalRented) {
		this.totalRented = totalRented;
	}

	public Double getTotalEarned() {
		return totalEarned;
	}

	public void setTotalEarned(Double totalEarned) {
		this.totalEarned = totalEarned;
	}
}
