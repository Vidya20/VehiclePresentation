/**
 * 
 */
package com.mindtree.awsfinalpresentation.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author m1017010
 * 
 */
/*
 * NewUser Entity class for NewUser
 */
@XmlRootElement(name="login")
public class NewUser {

	private String username;
	private String password;
	private String confirmationPassword;
	private String email;
	private String mobile;

	/**
	 * 
	 */
	public NewUser() {
		super();
	}

	public NewUser(String username, String password, String confirmationPassword) {
		super();
		this.username = username;
		this.password = password;
		this.confirmationPassword = confirmationPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmationPassword() {
		return confirmationPassword;
	}

	public void setConfirmationPassword(String confirmationPassword) {
		this.confirmationPassword = confirmationPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
