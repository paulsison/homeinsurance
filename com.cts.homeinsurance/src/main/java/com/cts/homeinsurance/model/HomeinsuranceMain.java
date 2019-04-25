package com.cts.homeinsurance.model;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.cts.homeinsurance.dao.*;

/* This is a test class for quickly checking DAO newly written functionality. It is not part of any test suite.*/

@SuppressWarnings("unused")
public class HomeinsuranceMain
{

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException
	{
		//PoliciesDAO _ Checks (set import above)
		//				PoliciesDAO p_dao = new PoliciesDAO();
		//				Policies s = new Policies();
		//		
		//		//getPolicyByUserID (int userId)
		//				List<Policies> policiesList =	p_dao.getPolicyByUserId(100,"active");
		//				for (Policies p : policiesList)
		//				{
		//					System.out.printf("%d %d %s %s %s",p.getPolicyId(),p.getUserId(),p.getEffectiveDate(),p.getEndDate(),p.getPolicyStatus());
		//				}
		//		//createNewPolicy(Policies policy)
		//		
		//getAllPolicies() -- OK
		//				List<Policies> policiesList = p_dao.getAllPolicies();
		//				for (Policies p : policiesList)
		//				{
		//					System.out.printf("%d %d %s %s %s",p.getPolicyId(),p.getUserId(),p.getEffectiveDate(),p.getEndDate(),p.getPolicyStatus());
		//				}



		//QuotesDAO _ Checks (set import above)		
		QuotesDAO q_dao = new QuotesDAO();
		Quotes s = new Quotes();

		//		//getAllQuotesByUserId(int userId) - OK
		List<Quotes> quotesList = q_dao.getAllQuotesByUserId(100);
		for (Quotes p : quotesList)
		{
			System.out.printf("%d %d %f %f %f %f %f %f %f",p.getQuoteId(),
					p.getLocationId(),p.getMonthlyPremium(),p.getDwellingCoverage(),p.getDetachedStructures(),
					p.getPersonalProperty(),p.getAddLivingExp(),p.getMedicalExpense(),p.getDeductible());
		}		



		//createNewQuote -- OK, but why do we have constraint of unique location id?
		//				s.setQuoteId(2);
		//				s.setLocationId(211);
		//				s.setMonthlyPremium(275.45f);
		//				s.setDwellingCoverage(50340.45f);
		//				s.setDetachedStructures(1.5f);
		//				s.setPersonalProperty(345.45f);
		//				s.setAddLivingExp(345.23f);
		//				s.setMedicalExpense(345.56f);
		//				s.setDeductible(2000.34f);
		//								
		//				System.out.printf("Creation status(1=success): %d.\n", q_dao.createNewQuote(s));	

		//getAllQuotes() -- OK
		//		List<Quotes> quotesList = p_dao.getAllQuotes();
		//		for (Quotes p : quotesList)
		//		{
		//			System.out.printf("%d %d %f %f %f %f %f %f %f",p.getQuoteId(),
		//					p.getLocationId(),p.getMonthlyPremium(),p.getDwellingCoverage(),p.getDetachedStructures(),
		//					p.getPersonalProperty(),p.getAddLivingExp(),p.getMedicalExpense(),p.getDeductible());
		//		}		



		//PropertiesDAO _ Checks (set import above)
		//		PropertiesDAO p_dao = new PropertiesDAO();
		//		Properties s = new Properties();

		//		//getPropertyByLocationId(int locationId) -- OK
		//		s = p_dao.getPropertyByLocationId(211);
		//		System.out.printf("LocationID: %d %f %d %d %s %s %s %d %d %b\n", s.getLocationId(), 
		//				s.getMarketValue(),s.getYearBuilt(),s.getSquareFootage(),s.getDwellingType(),s.getDwellingType(),
		//				s.getRoofMaterial(),s.getGarageType(),s.getFullBaths(),s.getHalfBaths(),s.isPool());
		//			
		//createNewProperty(Properties property) -- OK
		//		s.setLocationId(322);
		//		s.setMarketValue(258999.73f);
		//		s.setYearBuilt(1970);
		//		s.setSquareFootage(2350); 
		//		s.setDwellingType("s.family");
		//		s.setRoofMaterial("asphalt");
		//		s.setGarageType("attached");
		//		s.setFullBaths(3);
		//		s.setHalfBaths(0);
		//		s.setPool(true);				
		//		System.out.printf("Creation status(1=success): %d.\n", p_dao.createNewProperty(s));	

		//getAllProperties() -- OK
		//		List<Properties> propertiesList = p_dao.getAllProperties();
		//		for (Properties p : propertiesList)
		//		{
		//			System.out.printf("%d %f %s %s %s %s %s %s %s\n" ,p.getLocationId(),p.getMarketValue(),
		//					p.getYearBuilt(),p.getSquareFootage(),p.getDwellingType(),p.getRoofMaterial(),
		//					p.getFullBaths(),p.getHalfBaths(),p.isPool());
		//		}		
		//	



		//LocationsDAO _ CHECKS (set import above)

		//		LocationsDAO l_dao = new LocationsDAO();
		//		Locations s = new Locations();

		//getLocationByQuoteId(int quoteId) -- OK
		//		s = l_dao.getLocationByQuoteId(1);
		//		System.out.printf("LocationID: %d UserID: %d Property info: %s %s %s %s %s %s %s\n", 
		//				s.getLocationId(), s.getUserId(),s.getResidenceType(),s.getAddressLine1(),
		//				s.getAddressLine2(),s.getLocationState(),s.getCity(),s.getZipCode(),s.getResidenceUse());
		//				
		//createNewLocation(Locations location) --OK
		//s.setLocationId(322);
		//		s.setUserId(100);
		//		s.setResidenceType("Primary");
		//		s.setAddressLine1("11234400 N. Preston Rd"); 
		//		s.setAddressLine2("Apt 400");
		//		s.setCity("Dallas");
		//		s.setLocationState("TX");
		//		s.setZipCode("76542");
		//		s.setResidenceUse("Rental");				
		//		System.out.printf("Creation status(1=success): %d.\n", l_dao.createNewLocation(s));		


		//getAllLocations() -- OK

		//		List<Locations> locationsList = l_dao.getAllLocations();
		//		for (Locations l : locationsList)
		//		{
		//			System.out.printf("User ID %d: %d %s %s %s %s %s %s %s\n", l.getLocationId(), 
		//					l.getUserId(),l.getResidenceType(),l.getAddressLine1(),l.getAddressLine2(),
		//					l.getCity(),l.getLocationState(),l.getZipCode(),l.getResidenceUse());
		//		}	

		//HomeownersDAO _ CHECKS (set import above)

		//		HomeownersDAO h_dao = new HomeownersDAO();
		//		Homeowners s = new Homeowners();

		//getAllHomeowners() --OK

		//		List<Homeowners> homeownersList = h_dao.getAllHomeowners();
		//		for (Homeowners h : homeownersList)
		//		{
		//			System.out.printf("User ID %d: %s %s %s %s %s %s\n", h.getUserID(),h.getFirstName(),
		//					h.getLastName(),h.getDob(),h.isRetiredStatus(),h.getSsn(),h.getEmail());
		//		}

		//getHomeownerByID(int userID) -- OK
		//		s = h_dao.getHomeownerByID(100);
		//		System.out.printf("User ID %d: %s %s %s %s %s %s\n", s.getUserID(), 
		//				s.getFirstName(),s.getLastName(),s.getDob(),s.isRetiredStatus(),
		//				s.getSsn(),s.getEmail());
		//						
		//createNewHomeowner(Homeowners homeowner) -- OK
		//		s.setUserID(101);
		//		s.setFirstName("John");
		//		s.setLastName("Sison");
		//		s.setDob(new Date(2007-1900,9,13)); // 2007-1900,9,13 13-OCT-07
		//		s.setRetiredStatus(false); // java.sql.Date
		//		s.setSsn("643567890");
		//		s.setEmail("GW@gmail.com");
		//		System.out.printf("Creation status (1=success): %d\n", h_dao.createNewHomeowner(s));


		// UserDAO _ CHECKS (set import above)

		//		UsersDAO u_dao = new UsersDAO();
		//		Users s = new Users();
		//		
		//		//createNewUser(Users user) -- OK
		//		s.setUserName("PAUL");
		//		s.setPassword("paulp");
		//		s.setAdminRole("user");
		//		System.out.printf("Creation status(1=success): %d \n", u_dao.createNewUser(s));

		//		//getAllUsers() --OK

		//		List<Users> userList = u_dao.getAllUsers();
		//		for (Users u : userList)
		//		{
		//			System.out.printf("User ID %d: %s, Admin Role is %s\n", u.getUserId(),u.getUserName(),u.getAdminRole());
		//		}	

		//getUserByNameAndPassword(String userName,String password) --OK
		//		s = u_dao.getByUserName("JIM");
		//		System.out.printf("User ID %d: %s has a password of %s\n", s.getUserId(),s.getUserName(),s.getPassword());

		//		
		//		s.setUserId(101);
		//		s.setUserName	("");
		//		s.setUserPass("");		
		//		if (u_dao.updateUser(s))
		//		{
		//			System.out.println("User was updated.");						
		//		}
		//		else
		//		{
		//			System.out.println("User was NOT updated.");			
		//		}

		//		
		//		if (u_dao.removeUser()) 
		//		{
		//			System.out.println("User was successfully removed.");			
		//		}
		//		else
		//		{
		//			System.out.println("User could not be removed.");
		//		}		
	}
}
