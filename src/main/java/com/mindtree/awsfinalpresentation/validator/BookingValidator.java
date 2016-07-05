/**
 * 
 */
package com.mindtree.awsfinalpresentation.validator;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;

import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mindtree.awsfinalpresentation.entity.Booking;

/**
 * @author M1018339
 * 
 */
/*
 * BookingValidator is Validator class for booking vehicle. Validates if all the
 * fields are not empty and valid.
 */
public class BookingValidator implements Validator {

	private Pattern pattern;
	private Matcher matcher;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String NAME_PATTERN = "^[a-zA-Z ]{1,25}$";

	public boolean supports(Class<?> clazz) {
		return Booking.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Booking booking = (Booking) target;

		if (booking.getCustName().equals("")) {

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "custName",
					"custName.required", "Please Enter Customer Name");
		} else {
			pattern = pattern.compile(NAME_PATTERN);
			matcher = pattern.matcher(booking.getCustName());
			boolean flag = matcher.matches();

			if (flag == false) {
				errors.rejectValue("custName", "custName.notcorrect",
						"Customer name contains only alphabets with maximum 25 characters");
			}

		}

		if (booking.getEmailId().equals("")) {

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId",
					"emailId.required", "Please Enter email");
		} else {

			pattern = pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(booking.getEmailId());
			boolean flag = matcher.matches();

			if (flag == false) {
				errors.rejectValue("emailId", "emailId.notcorrect",
						"Invalid Email...");
			}

		}

		if (booking.getPlace().equals("select")) {
			errors.rejectValue("place", "place.required", "Please Select Place");
		}
		if (booking.getCategory().equals("select")) {
			errors.rejectValue("category", "category.required",
					"Please Select Vehicle Category");
		}

		if (booking.getVehicle().getRegNo() == "select") {
			errors.rejectValue("vehicle.regNo", "vehicle.regNo.required",
					"Please Select vehicle.regNo");

		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookedFrom",
				"bookingFrom.invalid", "Please Enter From Date");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookedTo",
				"bookingTo.invalid", "Please Enter To Date");
		// check with current date
		Date currentDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);

		// Set time fields to zero
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		// Put it back in the Date object
		currentDate = cal.getTime();

		if (booking.getBookedFrom() != null) {
			long time = currentDate.getTime()
					- booking.getBookedFrom().getTime();
			if (time > 0 && time != 0) {
				errors.rejectValue("bookedFrom", "bookingFrom.invalid",
						"From Date should not be less than current Date ");
			}
		}

		if (booking.getBookedFrom() != null && booking.getBookedTo() != null) {
			long time = booking.getBookedTo().getTime()
					- booking.getBookedFrom().getTime();
			if (time < 0) {
				errors.rejectValue("bookedTo", "bookedTo.invalid",
						"From date should be less than To date");
			}
		}

	}
}
