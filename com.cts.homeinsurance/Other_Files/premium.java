package home_premium;

import java.util.Calendar;
import java.util.Date;

public class premium {

	public static void main(String[] args) {


		float marketValue =334500;
		int yearBuilt =2014;
		int squareFootage =1690;
		String dwellingStyle ="1story";
		String roofMaterial = "concrete";
		String garageType = "attached";
		int fullBaths = 2;
		int halfBaths = 1;
		boolean hasPool = true;

		calculateQuote(marketValue,yearBuilt,squareFootage,dwellingStyle,roofMaterial,garageType,fullBaths,halfBaths,hasPool);

	}

	public static void calculateQuote(float marketValue, 
			int yearBuilt, 
			int squareFootage,
			String dwellingStyle,
			String roofMaterial,
			String garageType,
			int fullBaths,
			int halfBaths,
			boolean hasPool) {

		//Quote Calculation
		
		//dwelling coverage
		float homeValue; 
		float dwellingCoverage;
		homeValue = squareFootage * 120;

		Date today = new Date(); 
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		int year = cal.get(Calendar.YEAR);
		System.out.println("The year is: "+year);

		if (year-yearBuilt <= 5) {
			homeValue = (float) (homeValue * .90);
		}else if(year-yearBuilt > 5 && year-yearBuilt < 10) {
			homeValue = (float) (homeValue * .80);
		}else if (year-yearBuilt >=10 && year-yearBuilt <20) {
			homeValue = (float) (homeValue * .70);
		}else if (year-yearBuilt >=20) {
			homeValue = (float) (homeValue * .50);
		}

		dwellingCoverage = (float) (homeValue + (marketValue * .50));
		System.out.println("Dwelling Coverage is: "+dwellingCoverage);
		
		//monthly premium
		int exposureUnit;
		exposureUnit = (int) (dwellingCoverage/1000);
		int yearlyPremium;
		yearlyPremium = (int) (5 * (homeValue/exposureUnit));
		int monthlyPremium;
		monthlyPremium = yearlyPremium/12;
		System.out.println("Monthly premium is: "+monthlyPremium);
				
		//detached structures
		int detachedStructures;
		detachedStructures = (int) (dwellingCoverage * .10);
		System.out.println("Detached Structures is: "+detachedStructures);
		
		//personal property
		int personalProperty;
		personalProperty = (int) (dwellingCoverage * .60);
		System.out.println("Personal Property is: "+personalProperty);
		
		//additional living expenses
		int additionalLivingExpense;
		additionalLivingExpense = (int) (dwellingCoverage * .20);
		System.out.println("additional living expense: "+additionalLivingExpense);
		
		//medical expense
		int medicalExpense=5000;
		System.out.println("Medical Expense is: "+medicalExpense);
		
		//deductible
		int deductible;
		deductible = (int) (marketValue * .01);
		System.out.println("Deductible is: "+deductible);


	}
}

