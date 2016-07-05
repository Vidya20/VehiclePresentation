package com.mindtree.awsfinalpresentation.ses;

import java.util.LinkedList;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.amazonaws.services.simpleemail.model.SendEmailResult;
import com.mindtree.awsfinalpresentation.entity.Booking;

/**
 * @author m1017042
 * 
 */
/*
 * ConfirmBooking class
 */
public class ConfirmBooking {

	/*
	 * ACCESS_KEY and SECRET_KEY are the keys to access the Amazon web services
	 * account
	 */
	public static final String ACCESS_KEY = "AKIAIVGENJEBNG3GZFAQ";
	public static final String SECRET_KEY = "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";

	/*
	 * sendEmail method Sends Email to the customer when he books the vehicle
	 */
	public void sendEmail(String admin, Booking booking) {
		LinkedList<String> receiver = new LinkedList<String>();
		receiver.add(booking.getEmailId());
		Destination destination = new Destination(receiver);
		String subject = "Vehicle of type " + booking.getCategory()
				+ " and registration number " + booking.getVehicle().getRegNo()
				+ " from " + booking.getBookedFrom() + " to "
				+ booking.getBookedTo()
				+ " is booked succesfully and total rent is Rs: "
				+ booking.getTotalRent();
		Content subjectContent = new Content("Booking Confirmation");
		Content bodyContent = new Content(subject);
		Body msgBody = new Body(bodyContent);
		Message msg = new Message(subjectContent, msgBody);

		SendEmailRequest request = new SendEmailRequest(admin, destination, msg);

		AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY,
				SECRET_KEY);
		ClientConfiguration configuration = new ClientConfiguration();
		configuration.setProxyHost("172.22.218.218");
		configuration.setProxyPort(8085);
		AmazonSimpleEmailServiceClient sesClient = new AmazonSimpleEmailServiceClient(
				credentials, configuration);
		SendEmailResult result = sesClient.sendEmail(request);

	}
}
