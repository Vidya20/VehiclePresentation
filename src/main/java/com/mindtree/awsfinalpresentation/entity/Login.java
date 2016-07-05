/**
 * 
 */
package com.mindtree.awsfinalpresentation.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author m1017010
 * 
 */
/*
 * Login Entity class for Login
 */
@XmlRootElement(name = "login")
//@XmlRootElement
// Define the root element for a XML tree
public class Login {

	private String username;
	private String password;
	private String confirmPassword;
	private Integer loginId;
	private String email;
	private String mobileNo;

	public Login() {
		super();
	}

	public Login(String username, String password, String confirmPassword,
			Integer loginId, String email, String mobileNo) {
		super();
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.loginId = loginId;
		this.email = email;
		this.mobileNo = mobileNo;
	}

	// getters
	public String getUsername() {
		return username;
	}

	// setters
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getLoginId() {
		return loginId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

}
