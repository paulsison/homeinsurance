package com.cts.homeinsurance.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cts.homeinsurance.model.Locations;

public class LocationsDAO {
	
	public List<Locations> getAllLocations() throws SQLException {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Locations l = null;
		List<Locations> locationsList = null;
				
		String qString = "SELECT * FROM locations";
		
		OracleConnection oc = new OracleConnection();
		
		try
		{
		
			conn = oc.getConnection();
                       
			System.out.println("Connected to database.");
                      
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(qString);
                        
			locationsList = new ArrayList<Locations>();
			
			while (rs.next()) {
				
				l = new Locations();
				
				l.setLocationId(rs.getInt(1));
				l.setUserId(rs.getInt(2));
				l.setResidenceType(rs.getString(3));			
				l.setAddressLine1(rs.getString(4));
				l.setAddressLine2(rs.getString(5));
				l.setCity(rs.getString(6));
				l.setLocationState(rs.getString(7));
				l.setZipCode(rs.getString(8));
				l.setResidenceUse(rs.getString(9));
				
				locationsList.add(l);
				
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
		return locationsList;
	} // End of getAllLocations method
	
	public Integer createNewLocation(Locations location) throws SQLException, ClassNotFoundException, IOException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String insertString = "INSERT INTO locations (user_id, residence_type, address_line_1, address_line_2, city, location_state, zip_code, residence_use) VALUES (?,?,?,?,?,?,?,?)";		
	    int ID = -1; //NOT SUCCESSFUL
	    String[] COL = {"location_id"};
	    
		OracleConnection oc = new OracleConnection(); 
	    
	    try
	    {
	        conn = oc.getConnection();
	        stmt = conn.prepareStatement(insertString,COL);

	        stmt.setInt(1, location.getUserId());
	        stmt.setString(2, location.getResidenceType());
	        stmt.setString(3, location.getAddressLine1());
	        stmt.setString(4, location.getAddressLine2());
	        stmt.setString(5, location.getCity());
	        stmt.setString(6, location.getLocationState());
	        stmt.setString(7, location.getZipCode());
	        stmt.setString(8, location.getResidenceUse());	               
	        stmt.executeUpdate();
	        rs=stmt.getGeneratedKeys();
		      
			if(rs != null && rs.next())
			{		
				ID= rs.getInt(1);
			}     System.out.println("Created location ID:"+ID);      
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
	} // End of createNewLocation() method

	

	public Locations getLocationByQuoteId(int quoteId) throws ClassNotFoundException, IOException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Locations l = null;
		String qString = "SELECT * FROM locations INNER JOIN quotes ON locations.location_id = quotes.location_id WHERE quotes.quote_id=?";
		
		OracleConnection oc = new OracleConnection();
		
		try 
		{  
			conn = oc.getConnection();
			stmt = conn.prepareStatement(qString);
			stmt.setInt(1, quoteId); 		
			rs = stmt.executeQuery(); 
			
			if (rs.next()) 
			{
				l = new Locations();
				
				l.setLocationId(rs.getInt(1));
				l.setUserId(rs.getInt(2));
				l.setResidenceType(rs.getString(3));
				l.setAddressLine1(rs.getString(4));			
				l.setAddressLine2(rs.getString(5));
				l.setCity(rs.getString(6));
				l.setLocationState(rs.getString(7));
				l.setZipCode(rs.getString(8));
				l.setResidenceUse(rs.getString(9));							
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
		return l;
	} // End of getLocationsByQuoteId() method 
	
	
}