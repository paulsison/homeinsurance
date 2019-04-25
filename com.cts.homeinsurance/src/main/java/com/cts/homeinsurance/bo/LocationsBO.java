package com.cts.homeinsurance.bo;

import java.io.IOException;
import java.sql.SQLException;

import com.cts.homeinsurance.dao.LocationsDAO;
import com.cts.homeinsurance.model.Locations;

public class LocationsBO {

	public Integer createNewLocation(Locations location) throws ClassNotFoundException, IOException, SQLException {
		
		LocationsDAO l_dao = new LocationsDAO();
		return l_dao.createNewLocation(location);			
	}

	public Locations getLocationByQuoteId(int quoteId) throws SQLException, ClassNotFoundException, IOException {

		LocationsDAO l_dao = new LocationsDAO();	
		return l_dao.getLocationByQuoteId(quoteId);
	}
}
