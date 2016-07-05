/**
 * 
 */
package com.mindtree.awsfinalpresentation.marshell;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.mindtree.awsfinalpresentation.dto.NewUser;
import com.mindtree.awsfinalpresentation.entity.Booking;
import com.mindtree.awsfinalpresentation.entity.Login;
import com.mindtree.awsfinalpresentation.entity.Vehicle;

/**
 * @author m1017010
 * 
 */
/*
 * Marshel Interface to convert the java objects(vehicle, booking and  Login) in to
 * XML
 */
public interface Marshel {

	public String marshel(JAXBContext context, Vehicle vehicle) //Marshell vehicle object into its XML form
			throws JAXBException, IOException;

	public String marshel(JAXBContext context, Booking booking) //Marshell booking object into  its XML form
			throws JAXBException, IOException;

	public String marshel(JAXBContext context, Login login) //Marshell login object into  its XML form
			throws JAXBException, IOException;

}
