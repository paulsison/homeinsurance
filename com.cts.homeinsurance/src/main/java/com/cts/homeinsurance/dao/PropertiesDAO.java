package com.cts.homeinsurance.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cts.homeinsurance.model.Properties;

public class PropertiesDAO {

	public List<Properties> getAllProperties() throws SQLException {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Properties p = null;
		List<Properties> propertiesList = null;
		
		String qString = "SELECT * FROM properties";
		
		OracleConnection oc = new OracleConnection();
		
		try
		{
			
			conn = oc.getConnection();
                       
			System.out.println("Connected to database.");
                       
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(qString);
                       
			propertiesList = new ArrayList<Properties>();
			
			while (rs.next()) {
				
				p = new Properties();
				
				p.setLocationId(rs.getInt(1));
				p.setMarketValue(rs.getFloat(2));
				p.setYearBuilt(rs.getInt(3));			
				p.setSquareFootage(rs.getInt(4));
				p.setDwellingType(rs.getString(5));
				p.setRoofMaterial(rs.getString(6));
				p.setFullBaths(rs.getInt(7));
				p.setHalfBaths(rs.getInt(8));
				p.setPool(rs.getBoolean(9));
				
				propertiesList.add(p);
				
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
		return propertiesList;
	} // End of getAllLocations method
	
	public Integer createNewProperty(Properties property) throws SQLException, ClassNotFoundException, IOException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String insertString = "INSERT INTO properties (location_id, market_value, year_built, square_footage, dwelling_type, roof_material, garage_type, full_baths, half_baths, pool) VALUES (?,?,?,?,?,?,?,?,?,?)";		
	    int ID = -1; //NOT SUCCESSFUL
	    
		OracleConnection oc = new OracleConnection(); 
	    
	    try
	    {
	        conn = oc.getConnection();
	        stmt = conn.prepareStatement(insertString);
	        stmt.setInt(1, property.getLocationId());
	        stmt.setFloat(2, property.getMarketValue());
	        stmt.setInt(3, property.getYearBuilt());
	        stmt.setInt(4, property.getSquareFootage());
	        stmt.setString(5, property.getDwellingType());
	        stmt.setString(6, property.getRoofMaterial());
	        stmt.setString(7, property.getGarageType());
	        stmt.setInt(8, property.getFullBaths());
	        stmt.setInt(9, property.getHalfBaths());
	        stmt.setBoolean(10, property.hasPool());
	               
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
	} // End of createNewLocation() method

	public Properties getPropertyByLocationId(int locationId) throws ClassNotFoundException, IOException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Properties p = null;
		
		String qString = "SELECT * FROM Properties WHERE location_id=?";
		
		OracleConnection oc = new OracleConnection(); 
		
		try 
		{   
			conn = oc.getConnection();
			stmt = conn.prepareStatement(qString);
			stmt.setInt(1, locationId); 		
			rs = stmt.executeQuery(); 
			
			if (rs.next()) 
			{
				p = new Properties();
				
				p.setLocationId(rs.getInt(1));
				p.setMarketValue(rs.getFloat(2));
				p.setYearBuilt(rs.getInt(3));			
				p.setSquareFootage(rs.getInt(4));
				p.setDwellingType(rs.getString(5));
				p.setRoofMaterial(rs.getString(6));
				p.setFullBaths(rs.getInt(7));
				p.setHalfBaths(rs.getInt(8));
				p.setPool(rs.getBoolean(9));						
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
		return p;
	} // End of getPropertyByLocationId() method 
		
}
