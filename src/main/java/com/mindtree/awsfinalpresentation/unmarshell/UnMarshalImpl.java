package com.mindtree.awsfinalpresentation.unmarshell;

import java.io.ByteArrayInputStream;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.mindtree.awsfinalpresentation.entity.Booking;
import com.mindtree.awsfinalpresentation.entity.Login;
import com.mindtree.awsfinalpresentation.dto.LoginDto;
import com.mindtree.awsfinalpresentation.dto.Users;
import com.mindtree.awsfinalpresentation.dto.ValueObject;
import com.mindtree.awsfinalpresentation.dto.ValueObjects;
import com.mindtree.awsfinalpresentation.dto.Vehicles;
import com.sun.jersey.api.client.ClientResponse;

/*
 * UnMarshalImpl is the implementation of UnMarshal interface
 * using jersey api
 * */
public class UnMarshalImpl implements UnMarshal {

	// Unmarshalls XML booking data into Booking object
	public Booking unmarshalBooking(JAXBContext context, ClientResponse response)
			throws JAXBException {

		String output = response.getEntity(String.class);
		ByteArrayInputStream input = new ByteArrayInputStream(output.getBytes());
		// JAXBContext instantiate Unmarshaller
		Unmarshaller um = context.createUnmarshaller();
		Booking book = (Booking) um.unmarshal(input);
		return book;
	}

	// Unmarshalls XML ValueObject data into ValueObject object
	public List<ValueObject> unmarshalReport(JAXBContext context,
			ClientResponse response) throws JAXBException {
		List<ValueObject> vo = null;
		String output = response.getEntity(String.class);
		ByteArrayInputStream input = new ByteArrayInputStream(output.getBytes());
		Unmarshaller um = context.createUnmarshaller();
		ValueObjects objects = (ValueObjects) um.unmarshal(input);
		vo = objects.getList();
		return vo;
	}

	// Unmarshalls XML Vehicles data into Vehicles object
	public List<String> unmarshalVehicles(JAXBContext context,
			ClientResponse response) throws JAXBException {
		List<String> vehics = null;
		String output = response.getEntity(String.class);
		ByteArrayInputStream input = new ByteArrayInputStream(output.getBytes());
		Unmarshaller um = context.createUnmarshaller();
		Vehicles vList = (Vehicles) um.unmarshal(input);
		vehics = vList.getVehicleList();

		return vehics;

	}

	// Unmarshalls XML Login data into Login object
	public List<LoginDto> unmarshallogin(JAXBContext context,
			ClientResponse response) throws JAXBException {

		List<LoginDto> lList = null;
		String output = response.getEntity(String.class);
		ByteArrayInputStream input = new ByteArrayInputStream(output.getBytes());
		Unmarshaller um = context.createUnmarshaller();
		Users users = (Users) um.unmarshal(input);
		lList = users.getLoginDetails();
		return lList;
	}

}
