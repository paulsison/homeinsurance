package com.cts.homeinsurance.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.cts.homeinsurance.model.Quotes;

public class QuotesDAO {

	public List<Quotes> getAllQuotes() throws SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Quotes q = null;
		List<Quotes> quotesList = null;


		String qString = "SELECT * FROM quotes";

		OracleConnection oc = new OracleConnection();

		try
		{

			conn = oc.getConnection();

			System.out.println("Connected to database.");

			stmt = conn.createStatement();

			rs = stmt.executeQuery(qString);

			quotesList = new ArrayList<Quotes>();

			while (rs.next()) {

				q = new Quotes();

				q.setQuoteId(rs.getInt(1));
				q.setLocationId(rs.getInt(2));
				q.setMonthlyPremium(rs.getFloat(3));			
				q.setDwellingCoverage(rs.getFloat(4));
				q.setDetachedStructures(rs.getFloat(5));
				q.setPersonalProperty(rs.getFloat(6));
				q.setAddLivingExp(rs.getFloat(7));
				q.setMedicalExpense(rs.getFloat(8));
				q.setDeductible(rs.getFloat(9));				

				quotesList.add(q);

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
		return quotesList;
	} // End of getAllLocations method

	public Integer createNewQuote(Quotes quote) throws SQLException, ClassNotFoundException, IOException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String insertString = "INSERT INTO quotes (location_id,monthly_premium,"
				+ "dwelling_coverage,detached_structures,personal_property,add_living_exp,"
				+ "medical_expense,deductible) VALUES (?,?,?,?,?,?,?,?)";

		int ID = -1; //NOT SUCCESSFUL
		String[] COL = {"quote_id"};

		OracleConnection oc = new OracleConnection(); 

		try
		{
			conn = oc.getConnection();
			stmt = conn.prepareStatement(insertString,COL);
			stmt.setInt(1, quote.getLocationId());
			stmt.setFloat(2, quote.getMonthlyPremium());
			stmt.setFloat(3, quote.getDwellingCoverage());
			stmt.setFloat(4, quote.getDetachedStructures());
			stmt.setFloat(5, quote.getPersonalProperty());
			stmt.setFloat(6, quote.getAddLivingExp());
			stmt.setFloat(7, quote.getMedicalExpense());
			stmt.setFloat(8, quote.getDeductible());
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

	public Quotes getQuoteByQuoteId(int quoteId) throws ClassNotFoundException, IOException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Quotes q = null;

		String qString = "SELECT * FROM quotes where quote_id=?";


		OracleConnection oc = new OracleConnection(); 

		try // Begin try/catch block to query the database
		{   // Connect to database and assign query string to PreparedStatement object
			conn = oc.getConnection();
			stmt = conn.prepareStatement(qString);
			stmt.setInt(1, quoteId); 		
			rs = stmt.executeQuery(); 

			if (rs.next()) 
			{
				q = new Quotes();

				q.setQuoteId(rs.getInt(1));
				q.setLocationId(rs.getInt(2));
				q.setMonthlyPremium(rs.getFloat(3));			
				q.setDwellingCoverage(rs.getFloat(4));
				q.setDetachedStructures(rs.getFloat(5));
				q.setPersonalProperty(rs.getFloat(6));
				q.setAddLivingExp(rs.getFloat(7));
				q.setMedicalExpense(rs.getFloat(8));
				q.setDeductible(rs.getFloat(9));						
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
		return q;
	} 
	public List<Quotes> getAllQuotesByUserId(int userId) throws ClassNotFoundException, IOException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Quotes q = null;
		List<Quotes> quotesList = null;

		String qString = "SELECT * FROM quotes \r\n" + 
				"INNER JOIN locations ON quotes.location_id=locations.location_id\r\n" + 
				"INNER JOIN users on locations.user_id=users.user_id WHERE users.user_id=?";

		OracleConnection oc = new OracleConnection();

		try
		{

			conn = oc.getConnection();

			System.out.println("Connected to database.");



			stmt = conn.prepareStatement(qString);
			stmt.setString(1, Integer.toString(userId));


			rs = stmt.executeQuery();
			System.out.println(qString);


			quotesList = new ArrayList<Quotes>();

			while (rs.next()) {

				q = new Quotes();

				q.setQuoteId(rs.getInt(1));
				q.setLocationId(rs.getInt(2));
				q.setMonthlyPremium(rs.getFloat(3));			
				q.setDwellingCoverage(rs.getFloat(4));
				q.setDetachedStructures(rs.getFloat(5));
				q.setPersonalProperty(rs.getFloat(6));
				q.setAddLivingExp(rs.getFloat(7));
				q.setMedicalExpense(rs.getFloat(8));
				q.setDeductible(rs.getFloat(9));	

				quotesList.add(q);

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
		return quotesList;

	}

}
