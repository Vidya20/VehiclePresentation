/**
 * 
 */
package com.mindtree.awsfinalpresentation.marshell;

import java.io.IOException;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.mindtree.awsfinalpresentation.dto.NewUser;
import com.mindtree.awsfinalpresentation.entity.Booking;
import com.mindtree.awsfinalpresentation.entity.Login;
import com.mindtree.awsfinalpresentation.entity.Vehicle;

/**
 * @author m1017010
 * 
 */
/*
 * MarshelImpl is the implementation of Marshel interface
 */
public class MarshelImpl implements Marshel {

	// Marshell vehicle object into XML
	public String marshel(JAXBContext context, Vehicle vehicle)
			throws JAXBException, IOException {
		// JAXBContext instantiate marshaller
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		StringWriter sw = new StringWriter();
		m.marshal(vehicle, sw);
		String result = sw.toString();
		return result;
	}

	// Marshell Booking object into XML
	public String marshel(JAXBContext context, Booking booking)
			throws JAXBException, IOException {
		// JAXBContext instantiate marshaller
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		StringWriter sw = new StringWriter();
		m.marshal(booking, sw);
		String result = sw.toString();
		return result;

	}

	// Marshell Booking object into XML
	public String marshel(JAXBContext context, Login login)
			throws JAXBException, IOException {
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		StringWriter sw = new StringWriter();
		m.marshal(login, sw);
		String result = sw.toString();
		return result;
	}

}
