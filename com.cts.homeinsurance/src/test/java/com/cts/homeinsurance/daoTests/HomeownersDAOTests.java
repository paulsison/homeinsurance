package com.cts.homeinsurance.daoTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.cts.homeinsurance.dao.HomeownersDAO;
import com.cts.homeinsurance.model.Homeowners;


public class HomeownersDAOTests {
	@Test
	public void testgetAllHomeowners() throws SQLException {
		HomeownersDAO testcases =new HomeownersDAO();
		List<Homeowners> homeownerslist = testcases.getAllHomeowners();
		assertNotNull("List should not be null.", homeownerslist);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testRegister()
	{
		Homeowners homeowner = new Homeowners();
		homeowner.setUserID(1);
		homeowner.setFirstName("Francis");
		homeowner.setLastName("Bacon");
		homeowner.setDob(new Date(2007-1900,9,13));
		homeowner.setRetiredStatus(false);
		homeowner.setSsn("234-56-0987");
		homeowner.setEmail("francisB@gmail.com");
		
		assertEquals(1, homeowner.getUserID());
		assertEquals("Francis", homeowner.getFirstName());
		assertEquals("Bacon",homeowner.getLastName());
		assertEquals("2007-10-13", homeowner.getDob());
		assertEquals(false, homeowner.isRetiredStatus());
		assertEquals("francisB@gmail.com",homeowner.getEmail());
		
		
		return;
	}
	
}

