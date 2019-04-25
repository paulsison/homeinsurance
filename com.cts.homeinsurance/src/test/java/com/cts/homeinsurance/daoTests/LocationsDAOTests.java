package com.cts.homeinsurance.daoTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.cts.homeinsurance.dao.LocationsDAO;
import com.cts.homeinsurance.model.Locations;


public class LocationsDAOTests {
	@Test
	public void testgetAllLocations() throws SQLException {
		LocationsDAO testcases =new LocationsDAO();
		List<Locations> locationslist = testcases.getAllLocations();
		assertNotNull("List should not be null.", locationslist);
	}
	
	@Test
	public void testRegister()
	{
		Locations location = new Locations();
		location.setLocationId(322);
		location.setUserId(21);
		location.setResidenceType("townhome");
		location.setAddressLine1("1400 N. Preston Rd"); 
		location.setAddressLine2("Apt 400");
		location.setCity("Dallas");
		location.setLocationState("TX");
		location.setZipCode("76542");
		location.setResidenceUse("rental");				

		
		assertEquals(322, location.getLocationId());
		assertEquals(21, location.getUserId());
		assertEquals("townhome",location.getResidenceType());
		assertEquals("1400 N. Preston Rd", location.getAddressLine1());
		assertEquals("Apt 400", location.getAddressLine2());
		assertEquals("Dallas",location.getCity());
		assertEquals("TX", location.getLocationState());
		assertEquals("76542", location.getZipCode());
		assertEquals("rental",location.getResidenceUse());
		
		
		return;
	}
	
}
