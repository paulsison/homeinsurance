package com.cts.homeinsurance.bo;

import java.io.IOException;
import java.sql.SQLException;

import com.cts.homeinsurance.dao.HomeownersDAO;
import com.cts.homeinsurance.model.Homeowners;

public class HomeownersBO {

	public Integer createNewHomeowner(Homeowners homeowner) throws ClassNotFoundException, IOException, SQLException {
		
		HomeownersDAO h_dao = new HomeownersDAO();
		return h_dao.createNewHomeowner(homeowner);			
	}

	public Homeowners getHomeownersByUserName(int userId) throws SQLException, ClassNotFoundException, IOException {

		HomeownersDAO h_dao = new HomeownersDAO();
		return h_dao.getHomeownerByID(userId);
	}
}
