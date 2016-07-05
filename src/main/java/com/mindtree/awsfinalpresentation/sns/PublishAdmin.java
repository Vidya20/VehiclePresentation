package com.mindtree.awsfinalpresentation.sns;

import java.io.IOException;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.mindtree.awsfinalpresentation.entity.Vehicle;

/**
 * @author m1017042
 * 
 */
/*
 * PublishAdmin class
 */
public class PublishAdmin {
	/*
	 * ACCESS_KEY and SECRET_KEY are the keys to access the Amazon web services
	 * account
	 */
	public static final String ACCESS_KEY = "AKIAIVGENJEBNG3GZFAQ";
	public static final String SECRET_KEY = "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";

	/*
	 * Publish admin to send notification when vehicle is added
	 */
	public void publishAdmin(Vehicle vehicle) throws IOException {

		AmazonSNS sns = null;

		ClientConfiguration configuration = new ClientConfiguration();
		configuration.setProxyPort(8085);
		configuration.setProxyHost("172.22.218.218");
		AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY,
				SECRET_KEY);
		sns = new AmazonSNSClient(credentials, configuration);
		sns.setEndpoint("https://sns.us-west-2.amazonaws.com");
		sns.publish(new PublishRequest(
				"arn:aws:sns:us-west-2:587192794941:vehicle", "New Vehicle "
						+ vehicle.getRegNo() + " of type " + vehicle.getCat()
						+ " is added...."));
	}

}
