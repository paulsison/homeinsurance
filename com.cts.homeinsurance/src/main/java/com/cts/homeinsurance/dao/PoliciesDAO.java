package com.cts.homeinsurance.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cts.homeinsurance.model.Policies;



public class PoliciesDAO {
	
	public List<Policies> getAllPolicies() throws SQLException {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Policies pol = null;
		List<Policies> policiesList = null;
		
		String qString = "SELECT * FROM policies";
		
		OracleConnection oc = new OracleConnection();
		
		try
		{
			
			conn = oc.getConnection();
                      
			System.out.println("Connected to database.");
                        
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(qString);
                       
			policiesList = new ArrayList<Policies>();
			
			while (rs.next()) {
				
				pol = new Policies();
				
				pol.setPolicyId(rs.getInt(1));
				pol.setQuoteId(rs.getInt(2));
				pol.setUserId(rs.getInt(3));			
				pol.setEffectiveDate(rs.getDate(4));
				pol.setEndDate(rs.getDate(5));
				pol.setTerm(rs.getInt(6));
				pol.setPolicyStatus(rs.getString(7));
							
				policiesList.add(pol);
				
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
		return policiesList;
	} // End of getAllLocations method
	
	public Integer createNewPolicy(Policies policy) throws SQLException, ClassNotFoundException, IOException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String insertString = "INSERT INTO policies(quote_id, user_id, effective_date, end_date, term,"
				+ " policy_status) VALUES (?,?,?,?,?,?)";
		
	    int ID = -1; //NOT SUCCESSFUL
	    String[] COL = {"policy_id"};
	    
		OracleConnection oc = new OracleConnection(); 
	    
	    try
	    {
	        conn = oc.getConnection();
	        stmt = conn.prepareStatement(insertString, COL);
	        stmt.setInt(1, policy.getQuoteId());
	        stmt.setInt(2, policy.getUserId());
	        stmt.setDate(3, policy.getEffectiveDate());
	        stmt.setDate(4, policy.getEndDate());
	        stmt.setInt(5, policy.getTerm());
	        stmt.setString(6, policy.getPolicyStatus());       	               
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
	} // End of createNewPolicy() method

	public List<Policies> getAllPoliciesByUserId(int userId,String policyStatus) throws ClassNotFoundException, IOException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Policies pol = null;
		List<Policies> policiesList = null;
		
		String qString = "SELECT * FROM policies WHERE user_id=? AND policy_status=?";
		
		OracleConnection oc = new OracleConnection();
		
		try
		{
			
			conn = oc.getConnection();
                      
			System.out.println("Connected to database.");
			System.out.println(Integer.toString(userId));
			System.out.println(policyStatus);
                        
			stmt = conn.prepareStatement(qString);
			stmt.setString(1, Integer.toString(userId));
			stmt.setString(2,policyStatus);
			
			rs = stmt.executeQuery();
			System.out.println(qString);
			
                       
			policiesList = new ArrayList<Policies>();
			
			while (rs.next()) {
				
				pol = new Policies();
				
				pol.setPolicyId(rs.getInt(1));
				pol.setQuoteId(rs.getInt(2));
				pol.setUserId(rs.getInt(3));			
				pol.setEffectiveDate(rs.getDate(4));
				pol.setEndDate(rs.getDate(5));
				pol.setTerm(rs.getInt(6));
				pol.setPolicyStatus(rs.getString(7));
							
				policiesList.add(pol);
				
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
		return policiesList;
		
}
	public List<Policies> getAllPoliciesByUserName(String userName) throws ClassNotFoundException, IOException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Policies pol = null;
		List<Policies> policiesList = null;
		
		String qString = "SELECT * FROM policies INNER JOIN users ON policies.user_id = users.user_id WHERE user_name=?";
		
		OracleConnection oc = new OracleConnection();
		
		try
		{
			
			conn = oc.getConnection();
                      
			System.out.println("Connected to database.");
			System.out.println(userName);
			
			stmt = conn.prepareStatement(qString);
			stmt.setString(1,userName);
			
			
			rs = stmt.executeQuery();
			System.out.println(qString);
			
                       
			policiesList = new ArrayList<Policies>();
			
			while (rs.next()) {
				
				pol = new Policies();
				
				pol.setPolicyId(rs.getInt(1));
				pol.setQuoteId(rs.getInt(2));
				pol.setUserId(rs.getInt(3));			
				pol.setEffectiveDate(rs.getDate(4));
				pol.setEndDate(rs.getDate(5));
				pol.setTerm(rs.getInt(6));
				pol.setPolicyStatus(rs.getString(7));
							
				policiesList.add(pol);
				
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
		return policiesList;
		
}
	public Policies getPolicyByPolicyId(int policyId) throws ClassNotFoundException, IOException, SQLException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Policies pol = null;
		
		String qString = "SELECT * FROM Policies WHERE policy_id=?";
		
		OracleConnection oc = new OracleConnection(); 
		
		try 
		{   
			conn = oc.getConnection();
			stmt = conn.prepareStatement(qString);
			stmt.setInt(1, policyId); 		
			rs = stmt.executeQuery(); 
			
			if (rs.next()) 
			{
				pol = new Policies();
				
				pol.setPolicyId(rs.getInt(1));
				pol.setQuoteId(rs.getInt(2));
				pol.setUserId(rs.getInt(3));			
				pol.setEffectiveDate(rs.getDate(4));
				pol.setEndDate(rs.getDate(5));
				pol.setTerm(rs.getInt(6));
				pol.setPolicyStatus(rs.getString(7));						
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
		return pol;
	} // End of getPolicyByPolicyId() method 
	
	public Integer cancelPolicy(int policyId) throws SQLException, ClassNotFoundException, IOException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String insertString = "UPDATE policies SET policy_status = 'inactive' WHERE policy_id=?";
		
	    int ID = -1; //NOT SUCCESSFUL
	    
	    
		OracleConnection oc = new OracleConnection(); 
	    
	    try
	    {
	        conn = oc.getConnection();
	        stmt = conn.prepareStatement(insertString);
	        stmt.setInt(1, policyId);      	               
	        stmt.executeUpdate();
	        rs=stmt.getGeneratedKeys();
		      
			if(rs == null)
			{		
				ID= 1;
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
	} // End of cancelPolicy() method

	public Integer renewPolicy(Date effectiveDate, Date endDate, int policyId) throws SQLException, ClassNotFoundException, IOException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String insertString = "UPDATE policies SET effective_date = ?, end_date= ?, policy_status ='active' WHERE policy_id = ?";
		
	    int ID = -1; //NOT SUCCESSFUL
	    
	    
		OracleConnection oc = new OracleConnection(); 
	    
	    try
	    {
	        conn = oc.getConnection();
	        stmt = conn.prepareStatement(insertString);
	        stmt.setDate(1, effectiveDate);
	        stmt.setDate(2, endDate);
	        stmt.setInt(3, policyId);
	        stmt.executeUpdate();
	        rs=stmt.getGeneratedKeys();
		      
			if(rs == null)
			{		
				ID= 1;
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
	} // End of renew
}
