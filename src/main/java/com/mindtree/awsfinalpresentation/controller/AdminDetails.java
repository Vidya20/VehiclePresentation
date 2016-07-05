package com.mindtree.awsfinalpresentation.controller;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/*

 *AdminDetails class is the resouceBundle accessor that

 * access the admin username and password from admindetails property file.

 * */
public class AdminDetails {
	private static final String BUNDLE_NAME = "admindetails"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private AdminDetails() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
