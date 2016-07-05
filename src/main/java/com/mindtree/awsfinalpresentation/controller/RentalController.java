/**
 * 
 */
package com.mindtree.awsfinalpresentation.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mindtree.awsfinalpresentation.SendRequest.SendRequest;
import com.mindtree.awsfinalpresentation.SendRequest.SendRequestImpl;
import com.mindtree.awsfinalpresentation.dto.LoginDto;
import com.mindtree.awsfinalpresentation.dto.NewUser;
import com.mindtree.awsfinalpresentation.dto.Users;
import com.mindtree.awsfinalpresentation.dto.ValueObject;
import com.mindtree.awsfinalpresentation.dto.ValueObjects;
import com.mindtree.awsfinalpresentation.dto.Vehicles;
import com.mindtree.awsfinalpresentation.entity.Booking;
import com.mindtree.awsfinalpresentation.entity.Login;
import com.mindtree.awsfinalpresentation.entity.Vehicle;
import com.mindtree.awsfinalpresentation.marshell.Marshel;
import com.mindtree.awsfinalpresentation.marshell.MarshelImpl;
import com.mindtree.awsfinalpresentation.unmarshell.UnMarshal;
import com.mindtree.awsfinalpresentation.unmarshell.UnMarshalImpl;
import com.mindtree.awsfinalpresentation.validator.BookingValidator;
import com.mindtree.awsfinalpresentation.validator.VehicleValidator;
import com.sun.jersey.api.client.ClientResponse;

/**
 * @author M1018339
 * 
 */
/**
 * Servlet implementation class RentalController
 */
@Controller
public class RentalController {

	/*
	 * public static String URL =
	 * com.mindtree.awsfinalpresentation.controller.URL .getString("URL");
	 * //$NON-NLS-1$
	 */public static String URL;

	public static String ADMIN_USERNAME = AdminDetails
			.getString("ADMIN_USERNAME"); //$NON-NLS-1$
	public static String ADMIN_PASSWORD = AdminDetails
			.getString("ADMIN_PASSWORD"); //$NON-NLS-1$
	@Autowired
	private VehicleValidator vehicleValidator;

	@Autowired
	private BookingValidator bookingValidator;

	/*
	 * Logger is used as custom information for admin. We can check errors in
	 * file in tomcat.
	 */
	private Logger logger = Logger.getLogger(RentalController.class.getName());

	/* to get values from property file */

	@RequestMapping("/home.ren")
	public String getFromPropertyFile(HttpServletRequest request) {
		System.out.println("in home.ren ");
		HttpSession session = request.getSession();
		// -------------------------------------------------------//
		// Properties properties = new Properties();
		// try {
		// properties.load(new FileInputStream(
		// "D:\\AWSPresentationCSS.properties"));
		// } catch (FileNotFoundException e) {
		// System.out.println("property file not found");
		// e.printStackTrace();
		// } catch (IOException e) {
		// System.out.println("property file not found");
		// e.printStackTrace();
		// }
		// String location = properties.getProperty("location");
		// System.out.println("-----location>>>>>" + location);
		//
		// String datepickercsslocation = properties
		// .getProperty("datepickercsslocation");
		// System.out.println("-----datepicker loc" + datepickercsslocation);
		//
		// String businessURL = properties.getProperty("businessURL");
		// System.out.println("-----businessURL>>>>>" + businessURL);
		// System.out.println("---done---");
		// -------------------------------------------------------//
		// -------------------------------------------------------//
		InitialContext ctx;
		String location = "";
		String datepickercsslocation = "";
		String businessURL = "";
		try {
			ctx = new InitialContext();
			location = (String) ctx.lookup("java:comp/env/location");
			datepickercsslocation = (String) ctx
					.lookup("java:comp/env/datepickercsslocation");
			businessURL = (String) ctx.lookup("java:comp/env/businessURL");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		// -------------------------------------------------------//

		URL = businessURL;
		System.out.println("business url in URL is" + URL);
		session.setAttribute("cssLocation", location);
		session.setAttribute("datepickercsslocation", datepickercsslocation);
		session.setAttribute("businessURL", URL);
		String page = "home";
		return page;
	}

	/* got values from property file */

	@ModelAttribute("category")
	public Map<String, String> getLeaveTypes() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put(VehicleCategory.getString("select"),
				VehicleCategory.getString("--select--"));
		map.put(VehicleCategory.getString("Car"),
				VehicleCategory.getString("Car"));
		map.put(VehicleCategory.getString("Truck"), VehicleCategory.getString("Truck")); //$NON-NLS-1$ //$NON-NLS-2$
		map.put(VehicleCategory.getString("Bus"), VehicleCategory.getString("Bus")); //$NON-NLS-1$ //$NON-NLS-2$
		return map;
	}

	// Displays Fuel type in jsp page

	@ModelAttribute("fuelType")
	public Map<String, String> getFuelTypes() {
		Map<String, String> map = new LinkedHashMap<String, String>();

		map.put(FuelDetails.getString("Petrol"), FuelDetails.getString("Petrol")); //$NON-NLS-1$ //$NON-NLS-2$
		map.put(FuelDetails.getString("Diesel"), FuelDetails.getString("Diesel")); //$NON-NLS-1$ //$NON-NLS-2$
		map.put(FuelDetails.getString("LPG"), FuelDetails.getString("LPG")); //$NON-NLS-1$ //$NON-NLS-2$
		return map;
	}

	/*
	 * Request from login.jsp comes here when skip login button is clicked and
	 * redirected to guestuserindex.jsp page
	 */
	@RequestMapping("/guestuser.ren")
	// Specifies that method is invoked to handle request path("guestuser.ren")
	public String permituser(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.setAttribute("username", "guest");
		return "guestuserindex";
	}

	@RequestMapping("/validateuser.ren")
	public String validateuser(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return "login";
	}

	/*
	 * Request from login.jsp comes here when login is clicked. Username and
	 * password will be marshalled and forwarded to business layer through URL
	 * and based on the response, it will be redirected to either adminindex
	 * page or registereduserindex page or login page itself
	 */
	@RequestMapping("/nowvalidate.ren")
	public String nowvalidate(@ModelAttribute("login") LoginDto login,
			BindingResult result, Model model, HttpServletRequest request,
			HttpServletResponse responses) throws JAXBException, IOException {

		LoginDto admin = new LoginDto();

		// Login admin = new Login();
		admin.setUsername(ADMIN_USERNAME);
		admin.setPassword(ADMIN_PASSWORD);
		HttpSession session = request.getSession(true);
		session.setAttribute("username", login.getUsername());
		String page = "";

		JAXBContext context = JAXBContext.newInstance(Users.class);
		List<LoginDto> lList = null;

		URL = URL + "/nowvalidate.ren";
		System.out.println("url in nowvalidate.ren " + URL);
		SendRequest sendRequest = new SendRequestImpl();
		ClientResponse response = sendRequest.sendGetRequest(URL);

		UnMarshal unMarshal = new UnMarshalImpl();
		lList = unMarshal.unmarshallogin(context, response);
		for (int i = 0; i < lList.size(); i++) {
			if (lList.get(i).getUsername().equals(login.getUsername())
					&& login.getUsername() != "" && login.getPassword() != "") {
				if (lList.get(i).getPassword().equals(login.getPassword())) {
					if (lList.get(i).getUsername().equals(ADMIN_USERNAME)) {
						page = "adminindex";
					} else {
						page = "registereduserindex";
					}

					model.addAttribute("message",
							"Welcome " + session.getAttribute("username"));
				}
				break;
			} else {
				page = "login";
				model.addAttribute("message", "Invalid username and password");
			}
		}
		return page;
	}

	/*
	 * * Request from login.jsp comes here when Create New Account button is
	 * clicked and it will be redirected to simplecaptcha page
	 */

	@RequestMapping("/newuser.ren")
	public String newuser(Model model) {
		NewUser newUser = new NewUser();
		model.addAttribute("newuser", newUser);
		return "simplecaptcha";

	}

	// Request comes here when logout button is clicked and redirected to home
	// page

	@RequestMapping("/logout.ren")
	public String logout(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		session.invalidate();
		response.setHeader("Cache-Control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");

		request.getSession().invalidate();
		response.sendRedirect("http://localhost:8080/PresentationFinal/home.jsp");

		return "logout";
	}

	/*
	 * Control comes here from simple captcha page when new user tries to
	 * register with all valid entires, marshalls and checks whether the
	 * username is already exists, is so it remains in simplecaptcha page. If
	 * registration is successfull it will be redirected to login page
	 */

	@RequestMapping("/decide.ren")
	public String nowddecide(@ModelAttribute("newuser") NewUser newuser,
			BindingResult result, Model model, HttpSession session,
			HttpServletRequest request) throws JAXBException, IOException {
		Login admin = new Login();
		admin.setUsername(ADMIN_USERNAME);
		admin.setPassword(ADMIN_PASSWORD);

		JAXBContext context0 = JAXBContext.newInstance(Users.class);
		List<LoginDto> lList = null;

		URL = URL + "/nowvalidate.ren";
		SendRequest sendRequest = new SendRequestImpl();
		ClientResponse response0 = sendRequest.sendGetRequest(URL);
		UnMarshal unMarshal = new UnMarshalImpl();
		lList = unMarshal.unmarshallogin(context0, response0);
		int flag = 1;
		if (newuser.getPassword().equals(newuser.getConfirmationPassword())) {
			Login login = new Login();
			login.setUsername(newuser.getUsername());
			login.setPassword(newuser.getPassword());
			login.setConfirmPassword(newuser.getConfirmationPassword());
			login.setEmail(newuser.getEmail());
			login.setMobileNo(newuser.getMobile());
			for (int i = 0; i < lList.size(); i++) {
				if (lList.get(i).getUsername().equals(login.getUsername())) {
					flag = 0;
					String message = "Duplicate username... Please try again";
					model.addAttribute("message", message);
					break;
				}
			}

			if (flag == 1) {
				JAXBContext context = JAXBContext.newInstance(Login.class);

				Marshel marshel = new MarshelImpl();
				String xmlString = marshel.marshel(context, login);
				// URL = "http://localhost:8080/VehicleBusiness/vehiclerental";

				URL = URL + "/decide.ren";

				ClientResponse response = sendRequest.sendPostRequest(URL,
						xmlString);

				model.addAttribute("message", "Registered successfully");
				return "login";

			} else {
				return "simplecaptcha";
			}
		} else {
			String message = "wrong password entered... try again";
			model.addAttribute("message", message);
			return "simplecaptcha";

		}
	}

	/*
	 * Control comes here when admin logs in and click on Add Vehicle and he
	 * will redirected to addvehicle page
	 */
	@RequestMapping("/addvehicle.ren")
	public String addVehicle(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		model.addAttribute("message", session.getAttribute("username")
				+ " logged in");
		Vehicle vehicle = new Vehicle();
		vehicle.setCat("--select--");
		model.addAttribute("vehic", vehicle);
		return "addvehicle";
	}

	/*
	 * Control comes here from addvehicle page when admin tries to save vehicle
	 * details in database. If there are errors in the data then it remains in
	 * addvehicle pages. Entries will be marshalled and sent to business layer
	 * where data is saved into database Response comes back and based on the
	 * response the controll will be either redirected to error page or success
	 * page
	 */
	@RequestMapping("/persistvehicle.ren")
	public String persistVehicle(@ModelAttribute("vehic") Vehicle vehicle,
			BindingResult result, Model model, HttpServletRequest request)
			throws JAXBException, IOException

	{

		vehicleValidator.validate(vehicle, result);
		if (result.hasErrors()) {
			return "addvehicle";
		}

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		model.addAttribute("message", username);
		JAXBContext context = JAXBContext.newInstance(Vehicle.class);

		Marshel marshel = new MarshelImpl();
		String xmlString = marshel.marshel(context, vehicle);

		URL = URL + "/persistvehicle.ren";

		SendRequest sendRequest = new SendRequestImpl();
		ClientResponse response = sendRequest.sendPostRequest(URL, xmlString);
		if (response.getStatus() != 200) {
			return "error";
		} else {
			String output = response.getEntity(String.class);
			model.addAttribute("msg", "Vehicle added successfully..");
			return "success";
		}
	}

	/*
	 * Control comes here either when guest user or admin or registered user
	 * tries to book vehicle. If Book Vehicle is clicked. Redirected to
	 * bookvehicle page
	 */
	@RequestMapping("/bookvehicle.ren")
	public String addBooking(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		model.addAttribute("message", username + " logged in");
		if (username.equals("guest")) {
			model.addAttribute("message", "");
		}
		Booking booking = new Booking();
		model.addAttribute("booking", booking);
		session.setAttribute("booking", booking);
		return "bookvehicle";
	}

	/*
	 * Control comes here from bookvehicle page when admin,registered user or
	 * guest user tries to book the vehicle.If vehicle is booked successfully it
	 * will be redirected to success page else to error page
	 */
	@RequestMapping("/persistbooking.ren")
	public String persistBooking(@ModelAttribute("booking") Booking booking,
			BindingResult result, Model model, HttpServletRequest request)
			throws JAXBException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		model.addAttribute("message", username);
		bookingValidator.validate(booking, result);
		if (result.hasErrors()) {

			booking.setTotalRent(0);
			model.addAttribute("output4", session.getAttribute("output4"));
			model.addAttribute("output", session.getAttribute("output"));
			List<String> vehics = new ArrayList<String>();
			JAXBContext context = JAXBContext.newInstance(Booking.class);

			Marshel marshel = new MarshelImpl();
			String xmlString = marshel.marshel(context, booking);

			model.addAttribute("booking", booking);
			URL = URL + "/noRent.ren";

			SendRequest sendRequest = new SendRequestImpl();
			ClientResponse response = sendRequest.sendPostRequest(URL,
					xmlString);
			String target = "";
			try {
				UnMarshal unMarshal = new UnMarshalImpl();
				Booking book = unMarshal.unmarshalBooking(context, response);
				booking.setTotalRent(book.getTotalRent());

				Vehicle vehicle = new Vehicle();
				vehicle.setRegNo(booking.getVehicle().getRegNo());
				booking.setVehicle(vehicle);

				vehics.add(booking.getVehicle().getRegNo());

				model.addAttribute("vehicleList", vehics);
				model.addAttribute("booking", booking);
				target = "bookvehicle";
			} catch (Exception e) {
				logger.error("Hey error generated while persisting the booking of vehicle");
				target = "exception";
				request.setAttribute("msg", "Contact Admin.");

			}

			return target;
		}
		JAXBContext context = JAXBContext.newInstance(Booking.class);
		Marshel marshel = new MarshelImpl();
		String xmlString = marshel.marshel(context, booking);

		URL = URL + "/persistbooking.ren";

		SendRequest sendRequest = new SendRequestImpl();
		ClientResponse response = sendRequest.sendPostRequest(URL, xmlString);
		if (response.getStatus() != 200) {
			return "error";
		} else {
			String output = response.getEntity(String.class);
			model.addAttribute("msg", "Vehicle booked successfully..");

			if (username.equals(ADMIN_USERNAME))
				return "success";
			else
				return "success";
		}
	}

	/*
	 * Control comes here when admin click on Vehicle report. hit the business
	 * layer and fetch all the reports and redirect to bookingreport page
	 */
	@RequestMapping("/bookingreport.ren")
	public String getBookingReport(Model model, HttpServletRequest request)
			throws JAXBException {
		HttpSession session = request.getSession();
		model.addAttribute("message", session.getAttribute("username")
				+ " logged in");
		JAXBContext context = JAXBContext.newInstance(ValueObjects.class);
		List<ValueObject> vo = null;

		URL = URL + "/bookingreport.ren";

		SendRequest sendRequest = new SendRequestImpl();
		ClientResponse response = sendRequest.sendGetRequest(URL);

		if (response.getStatus() != 200) {
			return "exception";
		} else {
			UnMarshal unMarshal = new UnMarshalImpl();
			vo = unMarshal.unmarshalReport(context, response);
			if (vo != null) {
				model.addAttribute("report", vo);
				return "bookingreport";
			} else {
				logger.error("hey, error generated while fetching the report");
				return "exception";
			}
		}
	}

	/*
	 * Control comes here while booking vehicle. Based on the category selected,
	 * the registration numbers will be populated by fetching from database and
	 * redirected to bookvehicle page
	 */
	@RequestMapping("/populateVehicles.ren")
	public String populateVehicles(@ModelAttribute("booking") Booking booking,
			Model model, HttpServletRequest request) throws JAXBException,
			IOException {
		HttpSession session = request.getSession();
		session.setAttribute("booking", booking);
		String username = (String) session.getAttribute("username");
		model.addAttribute("message", username);
		if (username.equals("guest")) {
			model.addAttribute("message", "");
		}
		model.addAttribute("output4", session.getAttribute("output4"));
		model.addAttribute("output", session.getAttribute("output"));
		List<String> vehics = null;

		JAXBContext context = JAXBContext.newInstance(Booking.class);
		JAXBContext contextV = JAXBContext.newInstance(Vehicles.class);

		Marshel marshel = new MarshelImpl();
		String xmlString = marshel.marshel(context, booking);

		URL = URL + "/populateVehicles.ren";

		SendRequest sendRequest = new SendRequestImpl();
		ClientResponse response = sendRequest.sendPostRequest(URL, xmlString);
		if (response.getStatus() != 200) {
			return "error";
		}

		else {
			UnMarshal unMarshal = new UnMarshalImpl();
			vehics = unMarshal.unmarshalVehicles(contextV, response);

			model.addAttribute("vehicleList", vehics);
			model.addAttribute("booking", booking);
			return "bookvehicle";
		}
	}

	/*
	 * Control comes here while booking the vehicle. Total rent for selected
	 * vehicle is calculated based on the number of days to be booked in
	 * business layer. Total Rent=rent per day*total number of days
	 */
	@RequestMapping("/getTotalRent.ren")
	public String getTotalRent(@ModelAttribute("booking") Booking booking,
			BindingResult result, Model model, HttpServletRequest request)
			throws JAXBException, IOException {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		model.addAttribute("message", username);
		if (username.equals("guest")) {
			model.addAttribute("message", "");
		}
		bookingValidator.validate(booking, result);
		if (result.hasErrors()) {
			booking.setTotalRent(0);
			model.addAttribute("output4", session.getAttribute("output4"));
			model.addAttribute("output", session.getAttribute("output"));
			List<String> vehics = new ArrayList<String>();
			JAXBContext context = JAXBContext.newInstance(Booking.class);

			Marshel marshel = new MarshelImpl();
			String xmlString = marshel.marshel(context, booking);

			model.addAttribute("booking", booking);
			URL = URL + "/noRent.ren";

			SendRequest sendRequest = new SendRequestImpl();
			ClientResponse response = sendRequest.sendPostRequest(URL,
					xmlString);

			UnMarshal unMarshal = new UnMarshalImpl();
			Booking book = unMarshal.unmarshalBooking(context, response);
			booking.setTotalRent(book.getTotalRent());

			Vehicle vehicle = new Vehicle();
			vehicle.setRegNo(booking.getVehicle().getRegNo());
			booking.setVehicle(vehicle);

			vehics.add(booking.getVehicle().getRegNo());

			model.addAttribute("vehicleList", vehics);
			model.addAttribute("booking", booking);

			return "bookvehicle";
		}
		model.addAttribute("output4", session.getAttribute("output4"));
		model.addAttribute("output", session.getAttribute("output"));
		List<String> vehics = new ArrayList<String>();
		JAXBContext context = JAXBContext.newInstance(Booking.class);

		Marshel marshel = new MarshelImpl();
		String xmlString = marshel.marshel(context, booking);

		model.addAttribute("booking", booking);

		URL = URL + "/getTotalRent.ren";

		SendRequest sendRequest = new SendRequestImpl();
		ClientResponse response = sendRequest.sendPostRequest(URL, xmlString);

		if (response.getStatus() != 200) {
			return "error";
		}

		else {
			UnMarshal unMarshal = new UnMarshalImpl();
			Booking book = unMarshal.unmarshalBooking(context, response);
			booking.setTotalRent(book.getTotalRent());

			Vehicle vehicle = new Vehicle();
			vehicle.setRegNo(booking.getVehicle().getRegNo());
			booking.setVehicle(vehicle);

			vehics.add(booking.getVehicle().getRegNo());

			model.addAttribute("vehicleList", vehics);
			model.addAttribute("booking", booking);
			return "bookvehicle";
		}
	}

	/*
	 * Control comes here while booking vehicle. When Place is selected, it
	 * shows whether report of the place selected
	 */
	@RequestMapping("/getWeather.ren")
	public void weather(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		String urll = request.getRequestURI();
		String city = request.getParameter("city");

		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(
				"172.22.218.218", 8085));
		try {
			URL url2 = new URL("http://localhost:8080/jerseytry/rest/hello");
			URL url = new URL(
					"http://free.worldweatheronline.com/feed/weather.ashx?q="
							+ city
							+ "%2cIndia&format=xml&num_of_days=2&key=4a906142e1051338120709");
			URL url3 = new URL(
					"http://www.random.org/integers/?num=10&min=1&max=6&col=4&base=10&format=plain&rnd=new");

			HttpURLConnection conn = (HttpURLConnection) url
					.openConnection(proxy);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			HttpSession session = request.getSession();
			String output = null;
			String result = null;
			String result2 = null;
			String result3 = null;
			String result4 = null;

			while ((output = br.readLine()) != null) {
				String part[] = output.split("<temp_C>");

				String part2[] = part[1].split("</temp_C>");
				result = part2[0];

				String part3[] = output.split("<temp_F>");
				String part4[] = part3[1].split("</temp_F>");
				result2 = part4[0];

				String part5[] = output.split("<humidity>");
				String part6[] = part5[1].split("</humidity>");
				result3 = part6[0];

				String part7[] = output.split("<query>");
				String part8[] = part7[1].split("</query>");
				result4 = part8[0];

			}
			session.setAttribute("output", result);
			request.setAttribute("output2", result2);
			request.setAttribute("output3", result3);
			session.setAttribute("output4", result4);
			model.addAttribute("output4", result4);
			model.addAttribute("output", output);

			try {
				request.getRequestDispatcher("/WEB-INF/pages/weather.jsp")
						.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// It Binds strings to specific format

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(false);
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,
				true));
		dataBinder.registerCustomEditor(Vehicle.class, new VehicleEditor());
	}
}
