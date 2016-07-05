/**
 * 
 */
package com.mindtree.awsfinalpresentation.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author m1017010
 * 
 */

@XmlRootElement
// JAX-RS(The Java API for RESTful Web Services) supports an automatic mapping
// from JAXB annotated class to XML
public class Users {

	private List<LoginDto> loginDetails;

	public List<LoginDto> getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(List<LoginDto> loginDetails) {
		this.loginDetails = loginDetails;
	}

}
