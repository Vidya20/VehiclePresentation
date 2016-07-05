package com.mindtree.awsfinalpresentation.controller;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/*

 *FuelDetails class is the resouceBundle accessor that

 * access the fuel types from fueldetails property file.

 * */
public class FuelDetails {
	private static final String BUNDLE_NAME = "fueldetails"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private FuelDetails() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
