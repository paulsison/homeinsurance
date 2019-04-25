package com.cts.homeinsurance.bo;


import com.cts.homeinsurance.dao.UsersDAO;
import com.cts.homeinsurance.model.Users;

import java.io.IOException;
import java.sql.SQLException;

public class UsersBO {

	public Integer createNewUser(Users user) throws ClassNotFoundException, IOException, SQLException {
		
		UsersDAO u_dao = new UsersDAO();
		return u_dao.createNewUser(user);	
	}

	public Users getByUserName(String userName) throws SQLException, ClassNotFoundException, IOException {

		UsersDAO u_dao = new UsersDAO();
		return u_dao.getByUserName(userName);
	}

}
