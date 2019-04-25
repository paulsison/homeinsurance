package com.cts.homeinsurance.daoTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.cts.homeinsurance.dao.PoliciesDAO;
import com.cts.homeinsurance.model.Policies;


public class PoliciesDAOTests {
	@Test
	public void testgetAllPolicies() throws SQLException {
		PoliciesDAO testcases =new PoliciesDAO();
		List<Policies> policieslist = testcases.getAllPolicies();
		assertNotNull("List should not be null.", policieslist);
	}
	
	@SuppressWarnings({ "deprecation"})
	@Test
	public void testRegister()
	{
		Policies policy = new Policies();
		policy.setPolicyId(5);
		policy.setQuoteId(2);
		policy.setUserId(1);
		policy.setEffectiveDate(new Date(2018-1900,0,1));
		policy.setEndDate(new Date(2018-1900,5,30));
		policy.setTerm(6);
		policy.setPolicyStatus("active");
		
		assertEquals(5, policy.getPolicyId());
		assertEquals(2, policy.getQuoteId());
		assertEquals(1, policy.getUserId());
		assertEquals("2018-01-01", policy.getEffectiveDate());
		assertEquals("2018-01-30", policy.getEndDate());
		assertEquals(6, policy.getTerm());
		assertEquals("active", policy.getPolicyStatus());
		
		return;
	}
	
}
