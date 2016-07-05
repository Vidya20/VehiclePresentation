/**
 * 
 */
package com.mindtree.awsfinalpresentation.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mindtree.awsfinalpresentation.entity.Vehicle;

/**
 * @author M1018339
 * 
 */
/*
 * VehicleValidator is Validator class for adding vehicle. Validates if all the
 * fields are not empty and valid.
 */
public class VehicleValidator implements Validator {
	private Pattern pattern;
	private Matcher matcher;
	private static final String REG_NUM_PATTERN = "^([A-Z]{2})-([0-9]{2})-([A-Z]{1})([0-9]{4})$";
	private static final String MANUFACTURER_PATTERN = "^[a-zA-Z]{1,25}$";
	private static final String DAILYRENT_PATTERN = "^[0-9]{1,25}$";

	public boolean supports(Class<?> clazz) {
		return Vehicle.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {

		Vehicle vehicle = (Vehicle) target;

		if (vehicle.getRegNo().equals("")) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "regNo",
					"regNo.required", "Please Enter Registration No");
		} else {
			String regNum = vehicle.getRegNo();
			pattern = pattern.compile(REG_NUM_PATTERN);
			matcher = pattern.matcher(regNum);
			boolean flag = matcher.matches();

			if (flag == false) {
				errors.rejectValue("regNo", "regNo.notcorrect",
						"Invalid pattern");
			}

		}

		if (vehicle.getManufacturer().equals("")) {

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "manufacturer",
					"manufacturer.required", "Please Enter Manufacturer Name");
		} else {

			pattern = pattern.compile(MANUFACTURER_PATTERN);
			matcher = pattern.matcher(vehicle.getManufacturer());
			boolean flag = matcher.matches();

			if (flag == false) {
				errors.rejectValue("manufacturer", "manufacturer.notcorrect",
						"Manufacturer name contains only alphabets with maximum 25 characters");
			}

		}

		ValidationUtils.rejectIfEmpty(errors, "fuelType", "fueltype.required",
				"Please select fuel type");

		if ((vehicle.getCat().equals("select"))) {

			errors.rejectValue("cat", "cat.required", "Please select category");
		}
		if (vehicle.getDailyRent() <= 0) {
			errors.rejectValue("dailyRent", "dailyRent.notNeg",
					"Daily Rent should be greater than 0.");
		}
		if (vehicle.getMileage() <= 0) {
			errors.rejectValue("mileage", "mileage.notNeg",
					"Mileage should be greater than 0.");
		}

	}
}
