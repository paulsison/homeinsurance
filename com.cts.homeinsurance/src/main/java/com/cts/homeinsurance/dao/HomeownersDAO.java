package com.cts.homeinsurance.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cts.homeinsurance.model.Homeowners;

public class HomeownersDAO {
	
	public List<Homeowners> getAllHomeowners() throws SQLException {
		System.out.println("Inside getAllHomeowners");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Homeowners h = null;
		List<Homeowners> homeownersList = null;
				
		String qString = "SELECT * FROM homeowners";
		
		OracleConnection mysql = new OracleConnection();
		
		try
		{
			
			conn = mysql.getConnection();
                       
			System.out.println("Connected to database.");
                       
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(qString);
                        
			homeownersList = new ArrayList<Homeowners>();
			
			while (rs.next()) {
				
				h = new Homeowners();
				
				h.setUserID(rs.getInt(1));
				h.setFirstName(rs.getString(2));
				h.setLastName(rs.getString(3));			
				h.setDob(rs.getDate(4));
				h.setRetiredStatus(rs.getBoolean(5));
				h.setSsn(rs.getString(6));
				h.setEmail(rs.getString(7));
				
				homeownersList.add(h);
				
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
		return homeownersList;
	} // End of getAllHomeowners method
	
	public Integer createNewHomeowner(Homeowners homeowner) throws SQLException, ClassNotFoundException, IOException
	{
		System.out.println("Inside createNewHomeowner");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String insertString = "INSERT INTO homeowners (user_id, first_name, last_name, dob, retired_status, ssn, email) VALUES (?,?,?,?,?,?,?)";		
	    int ID = -1; //NOT SUCCESSFUL
	    
		OracleConnection oc = new OracleConnection(); 
	    
	    try
	    {
	        conn = oc.getConnection();
	        stmt = conn.prepareStatement(insertString);
	        stmt.setInt(1, homeowner.getUserID());
	        stmt.setString(2, homeowner.getFirstName());
	        stmt.setString(3, homeowner.getLastName());
	        stmt.setDate(4, homeowner.getDob());
	        stmt.setBoolean(5, homeowner.isRetiredStatus());
	        stmt.setString(6, homeowner.getSsn());
	        stmt.setString(7, homeowner.getEmail());
	               
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
	} // End of createNewHomeowner() method
	
	public Homeowners getHomeownerByID(int userID) throws ClassNotFoundException, IOException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Homeowners h = null;
		String qString = "SELECT * FROM homeowners WHERE user_id = ?";
		
		OracleConnection oc = new OracleConnection();
		
		try 
		{   
			conn = oc.getConnection();
			stmt = conn.prepareStatement(qString);
			stmt.setInt(1, userID); 		
			rs = stmt.executeQuery(); 
			
			if (rs.next()) 
			{
				h = new Homeowners();
				
				h.setUserID(rs.getInt(1));
				h.setFirstName(rs.getString(2));
				h.setLastName(rs.getString(3));			
				h.setDob(rs.getDate(4));
				h.setRetiredStatus(rs.getBoolean(5));
				h.setSsn(rs.getString(6));
				h.setEmail(rs.getString(7));
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
		return h;
	} // End of getHomeownerByID() method
	

}
