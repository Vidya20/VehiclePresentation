package com.mindtree.awsfinalpresentation.unmarshell;

import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.mindtree.awsfinalpresentation.entity.Booking;
import com.mindtree.awsfinalpresentation.dto.LoginDto;
import com.mindtree.awsfinalpresentation.dto.NewUser;
import com.mindtree.awsfinalpresentation.dto.ValueObject;
import com.sun.jersey.api.client.ClientResponse;

/*
 * UnMarshal interface to convert XML data into respective java object(ValueObject,Vehicle,Booking,Login).
 * */
public interface UnMarshal {

	public List<ValueObject> unmarshalReport(JAXBContext context,
			ClientResponse response) throws JAXBException;

	public List<String> unmarshalVehicles(JAXBContext context,
			ClientResponse response) throws JAXBException;

	public Booking unmarshalBooking(JAXBContext context, ClientResponse response)
			throws JAXBException;

	public List<LoginDto> unmarshallogin(JAXBContext context,
			ClientResponse response) throws JAXBException;
	
}
