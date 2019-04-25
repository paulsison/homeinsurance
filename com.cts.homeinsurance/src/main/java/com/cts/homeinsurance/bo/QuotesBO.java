package com.cts.homeinsurance.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cts.homeinsurance.dao.QuotesDAO;
import com.cts.homeinsurance.model.Quotes;

public class QuotesBO {

	public Integer createNewQuote(Quotes quote) throws ClassNotFoundException, IOException, SQLException {
		
		QuotesDAO q_dao = new QuotesDAO();
		return q_dao.createNewQuote(quote);		
	}

	public List<Quotes> getAllQuotesByUserId(int userId)throws ClassNotFoundException, IOException, SQLException{

		QuotesDAO q_dao = new QuotesDAO();		
		return q_dao.getAllQuotesByUserId(userId);
	}
}
