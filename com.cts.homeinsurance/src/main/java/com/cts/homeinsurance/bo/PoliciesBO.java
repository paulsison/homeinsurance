package com.cts.homeinsurance.bo;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.cts.homeinsurance.dao.PoliciesDAO;
import com.cts.homeinsurance.model.Policies;

public class PoliciesBO {

	public Integer createNewPolicy(Policies policy) throws ClassNotFoundException, IOException, SQLException {

		PoliciesDAO pol_dao = new PoliciesDAO();
		return pol_dao.createNewPolicy(policy);			
	}

	public List<Policies> getAllPoliciesByUserId(int userId, String policyStatus) throws SQLException, ClassNotFoundException, IOException {

		PoliciesDAO pol_dao = new PoliciesDAO();
		return pol_dao.getAllPoliciesByUserId(userId, policyStatus);
	}

	public List<Policies> getAllPoliciesByUserName(String userName) throws SQLException, ClassNotFoundException, IOException {

		PoliciesDAO pol_dao = new PoliciesDAO();
		return pol_dao.getAllPoliciesByUserName(userName);
	}

	public Policies getPolicyByPolicyId(int policyId) throws SQLException, ClassNotFoundException, IOException {

		PoliciesDAO pol_dao = new PoliciesDAO();
		return pol_dao.getPolicyByPolicyId(policyId);
	}

	public Integer cancelPolicy(int policyId) throws ClassNotFoundException, SQLException, IOException {

		PoliciesDAO pol_dao = new PoliciesDAO();
		return pol_dao.cancelPolicy(policyId);	

	}
	public Integer renewPolicy(Date effectiveDate, Date endDate, int policyId) throws SQLException, ClassNotFoundException, IOException
	{
		PoliciesDAO pol_dao = new PoliciesDAO();
		return pol_dao.renewPolicy(effectiveDate, endDate, policyId);
	}
}
