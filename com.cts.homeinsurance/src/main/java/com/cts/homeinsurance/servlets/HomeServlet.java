package com.cts.homeinsurance.servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.homeinsurance.bo.HomeownersBO;
import com.cts.homeinsurance.bo.LocationsBO;
import com.cts.homeinsurance.bo.PoliciesBO;
import com.cts.homeinsurance.bo.PropertiesBO;
import com.cts.homeinsurance.bo.QuotesBO;
import com.cts.homeinsurance.bo.UsersBO;
import com.cts.homeinsurance.model.Homeowners;
import com.cts.homeinsurance.model.Locations;
import com.cts.homeinsurance.model.Policies;
import com.cts.homeinsurance.model.Properties;
import com.cts.homeinsurance.model.Quotes;
import com.cts.homeinsurance.model.Users;


@WebServlet("/")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<String> errorList;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		try
		{
			switch (action) {
			case "/showLogin":
				showLoginPage(request, response);
				break;
			case "/login":
				loginUser(request, response);
				break;
			case "/logout":
				logout(request, response);
				break;
			case "/showRegistrationPage":
				showRegistrationPage(request, response);
				break;
			case "/registerUser":
				registerUser(request, response);
				break;
			case "/showWelcomePage":
				showGetStartedPage(request, response);
				break;
			case "/showLocationPage": // aka Get Quote Page
				showLocationPage(request, response);
				break;
			case "/postLocation": // aka Get Quote Page
				postLocation(request, response);
				break;	
			case "/postHomeowner":
				postHomeowner(request, response);
				break;				
			case "/postPropertyDetails":
				postPropertyDetails(request, response);
				break;			
			case "/showQuoteSummary":
				showQuoteSummary(request, response);
				break;					
			case "/buyQuote":
				buyQuote(request, response);
				break;
			case "/buyPolicy":
				buyPolicy(request, response);
				break;
			case "/showRetrieveQuotePage":
				showRetrieveQuotePage(request, response);
				break;
			case "/showMyPoliciesPage":
				showMyPoliciesPage(request, response);
				break;
			case "/showMyQuotesPage":
				showMyQuotesPage(request, response);
				break;
			default:
				showLoginPage(request, response);
			}
		}
		catch (Exception e)
		{
			e.getMessage();
		}
	}

	private void showMyQuotesPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("currentUser");

		int userId = user.getUserId();	
		QuotesBO q_bo = new QuotesBO();	
		List<Quotes> quotesList = q_bo.getAllQuotesByUserId(userId);
		session.setAttribute("quotesList", quotesList);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/MyQuotes.jsp");
		rd.forward(request, response);

	}

	private void showMyPoliciesPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("currentUser");

		int userId = user.getUserId();	
		PoliciesBO p_bo = new PoliciesBO();	
		List<Policies> policiesList =	p_bo.getAllPoliciesByUserId(userId,"active");
		session.setAttribute("policiesList", policiesList);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/MyPolicies.jsp");
		rd.forward(request, response);
	}

	private void buyPolicy(HttpServletRequest request, HttpServletResponse response) 
			throws ClassNotFoundException, IOException, SQLException, ServletException, ParseException {
		System.out.println("Inside buyPolicy method.");

		HttpSession session = request.getSession();
		Quotes quote = (Quotes) session.getAttribute("currentQuote");
		Users user = (Users) session.getAttribute("currentUser");

		int quoteId = quote.getQuoteId();
		int userId = user.getUserId();
		int term = 1;
		String policyStatus = "active";

		//effectiveDate string to date obj
		String dateString = request.getParameter("effectiveDate"); 
		StringBuilder strB = new StringBuilder(dateString);
		int stringLength = strB.length();
		strB.delete(stringLength-4,stringLength-3);	//(length -1) is last char
		String[] ss = (strB.toString()).split("/");
		@SuppressWarnings({"deprecation" })
		Date effectiveDate = new Date(Integer.valueOf(ss[2]), Integer.valueOf(ss[0])-1, Integer.valueOf(ss[1])); 
		System.out.println("setting effective date(date obj): "+effectiveDate);

		// Using SimpleDateFormat and Calendar to add months
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(dateString));
		c.add(Calendar.YEAR, term);  		
		String dateString2 = sdf.format(c.getTime());
		// Using StringBuilder is used to edit string
		StringBuilder strB2 = new StringBuilder(dateString2);
		int stringLength2 = strB2.length(); 
		strB2.delete(stringLength2-4,stringLength2-3);	//(length -1) is last char
		String[] ss2 = (strB2.toString()).split("/");
		@SuppressWarnings({"deprecation" })
		Date endDate = new Date(Integer.valueOf(ss2[2]),Integer.valueOf(ss2[0])-1, Integer.valueOf(ss2[1])); //accepted as MM-DD-YY
		System.out.println("setting end date(date obj): "+endDate);

		PoliciesBO p_bo = new PoliciesBO();
		Policies policy = new Policies();

		policy.setQuoteId(quoteId); 
		policy.setUserId(userId);
		policy.setEffectiveDate(effectiveDate);
		policy.setEndDate(endDate);
		policy.setTerm(term);
		policy.setPolicyStatus(policyStatus);

		int id = p_bo.createNewPolicy(policy);
		policy.setPolicyId(id);
		session.setAttribute("currentPolicy", policy); 
		System.out.println("Policy: " + policy);



		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/7_PolicyConfirmation.jsp");
		rd.forward(request, response);

	}

	private void buyQuote(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/6_BuyPolicy.jsp");
		rd.forward(request, response);

	}

	private void showQuoteSummary(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/5_QuoteSummary.jsp");
		rd.forward(request, response);

	}

	private void postPropertyDetails(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException {	
		System.out.println("Inside postPropertyDetails method.");

		HttpSession session = request.getSession();
		Locations location = (Locations) session.getAttribute("currentLocation");

		int locationId = location.getLocationId();
		float marketValue =Float.parseFloat(request.getParameter("marketValue"));
		int yearBuilt = Integer.parseInt(request.getParameter("yearBuilt"));
		int squareFootage = Integer.parseInt(request.getParameter("squareFootage"));
		String dwellingStyle = request.getParameter("dwellingStyle");
		String roofMaterial = request.getParameter("roofMaterial");
		String garageType = request.getParameter("garageType");
		int fullBaths = Integer.parseInt(request.getParameter("fullBaths"));
		int halfBaths = Integer.parseInt(request.getParameter("halfBaths"));
		boolean hasPool = Boolean.parseBoolean(request.getParameter("hasPool"));
		System.out.println("Has pool"+hasPool);

		PropertiesBO p_bo = new PropertiesBO();
		Properties property = new Properties();

		property.setLocationId(locationId);
		property.setMarketValue(marketValue);
		property.setYearBuilt(yearBuilt);
		property.setSquareFootage(squareFootage);
		property.setDwellingType(dwellingStyle);
		property.setRoofMaterial(roofMaterial);
		property.setGarageType(garageType);		
		property.setFullBaths(fullBaths);
		property.setHalfBaths(halfBaths);
		property.setPool(hasPool);

		session.setAttribute("currentProperty", property); //may come useful later.
		p_bo.createNewProperty(property);

		System.out.println("Property: " + property);

		//Quote Calculation

		//dwelling coverage
		float homeValue; 
		float dwellingCoverage;
		homeValue = squareFootage * 120;

		java.util.Date today = new java.util.Date(); 
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		int year = cal.get(Calendar.YEAR);
		System.out.println("The year is: "+year);

		if (year-yearBuilt <= 5) {
			homeValue = (float) (homeValue * .90);
		}else if(year-yearBuilt > 5 && year-yearBuilt < 10) {
			homeValue = (float) (homeValue * .80);
		}else if (year-yearBuilt >=10 && year-yearBuilt <20) {
			homeValue = (float) (homeValue * .70);
		}else if (year-yearBuilt >=20) {
			homeValue = (float) (homeValue * .50);
		}

		dwellingCoverage = (float) (homeValue + (marketValue * .50));
		System.out.println("Dwelling Coverage is: "+dwellingCoverage);

		//monthly premium
		int exposureUnit;
		exposureUnit = (int) (dwellingCoverage/1000);
		int yearlyPremium;
		yearlyPremium = (int) (5 * (homeValue/exposureUnit));
		int monthlyPremium;
		monthlyPremium = yearlyPremium/12;
		System.out.println("Monthly premium is: "+monthlyPremium);

		//detached structures
		int detachedStructures;
		detachedStructures = (int) (dwellingCoverage * .10);
		System.out.println("Detached Structures is: "+detachedStructures);

		//personal property
		int personalProperty;
		personalProperty = (int) (dwellingCoverage * .60);
		System.out.println("Personal Property is: "+personalProperty);

		//additional living expenses
		int addLivingExp;
		addLivingExp = (int) (dwellingCoverage * .20);
		System.out.println("additional living expense: "+addLivingExp);

		//medical expense
		int medicalExpense=5000;
		System.out.println("Medical Expense is: "+medicalExpense);

		//deductible
		int deductible;
		deductible = (int) (marketValue * .01);
		System.out.println("Deductible is: "+deductible);


		QuotesBO q_bo = new QuotesBO();
		Quotes quote = new Quotes();	

		quote.setLocationId(locationId); //can line 108 causes sql update thread timing issues?
		quote.setMonthlyPremium(monthlyPremium);
		quote.setDwellingCoverage(dwellingCoverage);
		quote.setDetachedStructures(detachedStructures);
		quote.setPersonalProperty(personalProperty);
		quote.setAddLivingExp(addLivingExp);
		quote.setMedicalExpense(medicalExpense);
		quote.setDeductible(deductible);

		int id = q_bo.createNewQuote(quote);
		quote.setQuoteId(id);
		session.setAttribute("currentQuote", quote); 
		System.out.println("Quote: " + quote);


		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/4_CoverageDetails.jsp");
		rd.forward(request, response);

	}

	private void showLocationPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/1_Location.jsp");
		rd.forward(request, response);		
	} //  aka Get Quote Page

	private void postLocation(HttpServletRequest request, HttpServletResponse response) 
			throws ClassNotFoundException, SQLException, IOException, ServletException {
		System.out.println("postLocation method.");

		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("currentUser");
		int userId = user.getUserId();	

		String residenceType = request.getParameter("residenceType");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String city = request.getParameter("city");
		String locationState = request.getParameter("locationState");
		String zipCode = request.getParameter("zipCode");
		String residenceUse = request.getParameter("residenceUse");


		LocationsBO l_bo = new LocationsBO();
		Locations location = new Locations();

		location.setUserId(userId);
		location.setResidenceType(residenceType);
		location.setAddressLine1(addressLine1);
		location.setAddressLine2(addressLine2);
		location.setCity(city);
		location.setLocationState(locationState);
		location.setZipCode(zipCode);
		location.setResidenceUse(residenceUse);

		int id = l_bo.createNewLocation(location);
		location.setLocationId(id);
		session.setAttribute("currentLocation", location); 

		System.out.println("Location: " + location);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/2_HomeownerInformation.jsp");
		rd.forward(request, response);	
	}

	private void postHomeowner(HttpServletRequest request, HttpServletResponse response) 
			throws ClassNotFoundException, SQLException, IOException, ServletException, ParseException {
		System.out.println("post Homeowner method.");

		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("currentUser");

		int userId = user.getUserId();	
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		String dob = request.getParameter("dob"); //mm-dd-yy 
		String[] ss = dob.split("-");
		@SuppressWarnings("deprecation")
		Date dateObj = new Date(Integer.valueOf(ss[2]),Integer.valueOf(ss[0])-1, Integer.valueOf(ss[1])); //accepted as MM-DD-YY
		System.out.println("Created: Date object format: "+dateObj);

		String retiredStatus = request.getParameter("retiredStatus");
		Boolean isRetired = Boolean.parseBoolean(retiredStatus); 
		System.out.println("Parsed: retiredStatus to boolean");

		String ssn = request.getParameter("ssn");
		String email = request.getParameter("email");	

		HomeownersBO h_bo = new HomeownersBO();
		Homeowners homeowner = new Homeowners();

		homeowner.setUserID(userId);
		homeowner.setFirstName(firstName);
		homeowner.setLastName(lastName);
		homeowner.setDob(dateObj);
		homeowner.setRetiredStatus(isRetired);
		homeowner.setSsn(ssn);
		homeowner.setEmail(email);

		session.setAttribute("currentHomeowner", homeowner);
		h_bo.createNewHomeowner(homeowner); // no homeownerId assigned


		System.out.println("Homeowner: " + homeowner);	

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/3_PropertyDetails.jsp");
		rd.forward(request, response);	
	}

	private void showRetrieveQuotePage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {



		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/RetrieveQuote.jsp");
		rd.forward(request, response);		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void showLoginPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/LoginPage.jsp");
		rd.forward(request, response);
	}

	private void loginUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		System.out.println("loginUser method.");
		HttpSession session = request.getSession();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		UsersBO u_bo = new UsersBO();
		Users user = u_bo.getByUserName(userName);
		System.out.println("User: " + user);

		if (user == null) 
		{
			errorList = new ArrayList<>();
			errorList.add("Invalid Login");
			request.setAttribute("errorList", errorList);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/LoginPage.jsp");
			rd.forward(request, response);
		} else {
			if (password.equals(user.getPassword())) {
				session.setAttribute("currentUser", user);
				response.sendRedirect("showWelcomePage");
			} else {
				errorList = new ArrayList<>();
				errorList.add("Invalid Login");
				request.setAttribute("errorList", errorList);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/LoginPage.jsp");
				rd.forward(request, response);
			}
		}
	}

	private void showGetStartedPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/GetStarted.jsp");
		rd.forward(request, response);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("showLogin");
	}

	private void showRegistrationPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/RegistrationPage.jsp");
		rd.forward(request, response);
	}

	private void registerUser(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ClassNotFoundException, SQLException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String adminRole = "user";

		Users user = new Users();
		user.setUserName(userName);
		user.setPassword(password);
		user.setAdminRole(adminRole);

		UsersBO u_bo = new UsersBO();
		int userId = u_bo.createNewUser(user);
		System.out.println("New user id:"+ userId);

		response.sendRedirect("showLogin");
	}
}
