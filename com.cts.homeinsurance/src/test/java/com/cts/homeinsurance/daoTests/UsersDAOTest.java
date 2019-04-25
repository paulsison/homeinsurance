package com.cts.homeinsurance.daoTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.cts.homeinsurance.dao.UsersDAO;
import com.cts.homeinsurance.model.Users;


public class UsersDAOTest {
	@Test
	public void testgetAllUsers() throws SQLException {
		UsersDAO testcases =new UsersDAO();
		List<Users> userslist = testcases.getAllUsers();
		assertNotNull("List should not be null.", userslist);
	}
	
	@Test
	public void testRegister()
	{
		Users user = new Users();
		user.setUserName("Test Paul");
		user.setPassword("Paulpassword");
		user.setAdminRole("user");
		
		assertEquals("Test Paul", user.getUserName());
		assertEquals("Paulpassword", user.getPassword());
		assertEquals("user",user.getAdminRole());
		
		return;
	}
	
}
