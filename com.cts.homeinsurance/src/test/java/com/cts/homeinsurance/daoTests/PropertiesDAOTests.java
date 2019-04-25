package com.cts.homeinsurance.daoTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.cts.homeinsurance.dao.PropertiesDAO;
import com.cts.homeinsurance.model.Properties;


public class PropertiesDAOTests {
	@Test
	public void testgetAllProperties() throws SQLException {
		PropertiesDAO testcases =new PropertiesDAO();
		List<Properties> propertieslist = testcases.getAllProperties();
		assertNotNull("List should not be null.", propertieslist);
	}
	
	
	@Test
	public void testRegister()
	{
		Properties property = new Properties();
		property.setLocationId(322);
		property.setMarketValue(258999.73f);
		property.setYearBuilt(1970);
		property.setSquareFootage(2350); 
		property.setDwellingType("single");
		property.setRoofMaterial("asphalt");
		property.setGarageType("attached");
		property.setFullBaths(3);
		property.setHalfBaths(0);
		property.setPool(true);		
		
		assertEquals(322, property.getLocationId());
		assertEquals(258999.73f, property.getMarketValue(), .001);
		assertEquals(1970,property.getYearBuilt());
		assertEquals(2350, property.getSquareFootage());
		assertEquals("single", property.getDwellingType());
		assertEquals("asphalt", property.getRoofMaterial());
		assertEquals("attached",property.getGarageType());
		assertEquals(3, property.getFullBaths());
		assertEquals(0, property.getHalfBaths());
		assertEquals(true,property.hasPool());
						
		return;
	}
	
}

