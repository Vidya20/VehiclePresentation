package com.mindtree.awsfinalpresentation.controller;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/*

 *VehicleCategory class is the resouceBundle accessor that

 * access the category from vehiclecategory property file.

 * */

public class VehicleCategory {
	private static final String BUNDLE_NAME = "vehiclecategory"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private VehicleCategory() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
