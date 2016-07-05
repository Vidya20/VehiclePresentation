package com.mindtree.awsfinalpresentation.SendRequest;

import com.sun.jersey.api.client.ClientResponse;

/*
 * SendRequest interface to send GET,POST request to business layer
 * */
public interface SendRequest {
	
	public ClientResponse sendPostRequest(String URL,String xmlString);//Sends Post Request to business layer 
	public ClientResponse sendGetRequest(String URL);//Sends Get Request to business layer 
}
