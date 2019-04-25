package com.cts.homeinsurance.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cts.homeinsurance.bo.PoliciesBO;
import com.cts.homeinsurance.bo.UsersBO;
import com.cts.homeinsurance.model.Policies;
import com.cts.homeinsurance.model.Users;

@Controller
@SessionAttributes //will come useful later
public class HomeController {
	

	@RequestMapping(value="/AdminPage", method=RequestMethod.GET)
	public String adminPage() {
		return "AdminPage";
	}
	
	@RequestMapping(value="/loginAdmin", method=RequestMethod.POST)
	public String loginAdmin(HttpSession session, @RequestParam String userName, @RequestParam String password) throws ClassNotFoundException, SQLException, IOException {
		
		System.out.println("loginAmin method.");
		
		UsersBO u_bo = new UsersBO();
		Users user = u_bo.getByUserName(userName);
		System.out.println("User: " + user);

		List<String> errorList = null;
		
		if (user == null) 
		{
			errorList = new ArrayList<>();
			errorList.add("User Account does not exist.");
			session.setAttribute("errorList", errorList);
			return "AdminPage";
			
		} else {
			if (password.equals(user.getPassword())) {
				return "AdminSearch";
			} else {
				errorList = new ArrayList<>();
				errorList.add("Invalid Login");
				session.setAttribute("errorList", errorList);
				return "AdminPage";
			}
		}
	
	}
	
	@RequestMapping(value="/adminSearchPage", method=RequestMethod.GET)
	public String showSearchPage() {
		return "AdminSearch";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String closeSession(HttpServletRequest request){
	    HttpSession session=request.getSession();  
	    session.invalidate();  
	    return "AdminPage";
	}
	
	@RequestMapping(value="/searchUser", method=RequestMethod.POST)
	public String searchPoliciesByUserName(HttpSession session, @RequestParam String userName) throws ClassNotFoundException, SQLException, IOException {
					
		PoliciesBO p_bo = new PoliciesBO();	
		List<Policies> policiesList =	p_bo.getAllPoliciesByUserName(userName);
		session.setAttribute("userName", userName);
		session.setAttribute("policiesList", policiesList);			
		return "AdminSearchResults";
	} 
	
	@RequestMapping(value="/renewUserPolicy")
	public String renewPolicy(HttpSession session, HttpServletRequest request, @RequestParam String id1) throws ClassNotFoundException, SQLException, IOException {
					
		int policyId = Integer.parseInt(id1);
		System.out.println("request to renew pol id"+ policyId);
		
		PoliciesBO u_bo = new PoliciesBO();		
		
		long time = System.currentTimeMillis();
		java.sql.Date effectiveDate = new java.sql.Date(time);
		
		
		Calendar c = Calendar.getInstance();
        c.setTime(effectiveDate);
        c.add(Calendar.YEAR, 1);
        java.sql.Date endDate = new Date(c.getTimeInMillis());
        
        System.out.println("New effective date:"+effectiveDate);
        System.out.println("New end date:"+endDate);
        
        u_bo.renewPolicy(effectiveDate, endDate, policyId);
        
		return "AdminSearch";
	}
	@RequestMapping(value="/cancelUserPolicy")
	public String cancelPolicy(HttpSession session, HttpServletRequest request, @RequestParam String id2) throws ClassNotFoundException, SQLException, IOException {
		
		int policyId = Integer.parseInt(id2);
		System.out.println("request to renew pol id"+ policyId);
		
		PoliciesBO u_bo = new PoliciesBO();	
		u_bo.cancelPolicy(policyId);
				
		return "AdminSearch";
	}
	

}