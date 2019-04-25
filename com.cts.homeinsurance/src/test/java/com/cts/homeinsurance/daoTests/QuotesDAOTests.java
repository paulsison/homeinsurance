  package com.cts.homeinsurance.daoTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.cts.homeinsurance.dao.QuotesDAO;
import com.cts.homeinsurance.model.Quotes;


public class QuotesDAOTests {
	@Test
	public void testgetAllQuotes() throws SQLException {
		QuotesDAO testcases =new QuotesDAO();
		List<Quotes> quoteslist = testcases.getAllQuotes();
		assertNotNull("List should not be null.", quoteslist);
	}
	
	@Test
	public void testRegister()
	{
		Quotes quote = new Quotes();
		quote.setQuoteId(2);
		quote.setLocationId(211);
		quote.setMonthlyPremium(275.45f);
		quote.setDwellingCoverage(50340.45f);
		quote.setDetachedStructures(1.5f);
		quote.setPersonalProperty(345.45f);
		quote.setAddLivingExp(345.23f);
		quote.setMedicalExpense(345.56f);
		quote.setDeductible(2000.34f);
		
		assertEquals(2, quote.getQuoteId());
		assertEquals(211, quote.getLocationId());
		assertEquals(275.45f,quote.getMonthlyPremium(),.0001);
		assertEquals(50340.45f, quote.getDwellingCoverage(),.0001);
		assertEquals(1.5f, quote.getDetachedStructures(),.0001);
		assertEquals(345.45f,quote.getPersonalProperty(),.0001);
		assertEquals(345.23f, quote.getAddLivingExp(),.0001);
		assertEquals(345.56f, quote.getMedicalExpense(),.0001);
		assertEquals(2000.34f,quote.getDeductible(),.0001);
		
		return;
	}
	
}

