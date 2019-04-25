package com.cts.homeinsurance.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cts.homeinsurance.model.Users;

public class UsersDAO {
	public List<Users> getAllUsers() throws SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Users u = null;
		List<Users> userList = null;

		String qString = "SELECT * FROM Users";

		OracleConnection mysql = new OracleConnection();

		try
		{

			conn = mysql.getConnection();

			System.out.println("Connected to database.");

			stmt = conn.createStatement();

			rs = stmt.executeQuery(qString);

			userList = new ArrayList<Users>();

			while (rs.next()) {

				u = new Users();

				u.setUserId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setAdminRole(rs.getString(4));

				userList.add(u);

			}
		}
		catch (ClassNotFoundException | IOException | SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		}
		finally
		{
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return userList;
	} // End of getAllUsers method


	public Integer createNewUser(Users user) throws SQLException, ClassNotFoundException, IOException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String insertString = "INSERT INTO Users (user_name, password, admin_role) VALUES (?,?,?)";		
		int ID = -1; //NOT SUCCESSFUL
		String[] COL = {"user_id"}; 

		OracleConnection oc = new OracleConnection(); 

		try
		{
			conn = oc.getConnection();
			stmt = conn.prepareStatement(insertString,COL); 
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getAdminRole());
			stmt.executeUpdate();
			rs=stmt.getGeneratedKeys();
						      
			if(rs != null && rs.next())
			{		
				ID= rs.getInt(1);
			}
					
		}
		catch (SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		}
		return ID;
	} // End of createNewUser() method

		
	public Users getByUserName(String userName) throws ClassNotFoundException, IOException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Users u = null;
		String qString = "SELECT * FROM users WHERE user_name = ?";

		OracleConnection oc = new OracleConnection();

		try 
		{   
			conn = oc.getConnection();
			stmt = conn.prepareStatement(qString);
			stmt.setString(1, userName);
			rs = stmt.executeQuery();

			if (rs.next()) 
			{
				u = new Users();
				u.setUserId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setAdminRole(rs.getString(4));

			}
		}
		catch (ClassNotFoundException | IOException | SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		}
		finally
		{
			if (rs != null)	rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		}
		return u;
	} // End of getByUserName() method


}