package com.cts.homeinsurance.bo;

import java.io.IOException;
import java.sql.SQLException;

import com.cts.homeinsurance.dao.PropertiesDAO;
import com.cts.homeinsurance.model.Properties;

public class PropertiesBO {

	public Integer createNewProperty(Properties property) throws ClassNotFoundException, IOException, SQLException {
		
		PropertiesDAO p_dao = new PropertiesDAO();
		return p_dao.createNewProperty(property);
	}

	public Properties getPropertiesByUserName(int locationId) throws SQLException, ClassNotFoundException, IOException {

		PropertiesDAO p_dao = new PropertiesDAO();
		return p_dao.getPropertyByLocationId(locationId);
	}
}
