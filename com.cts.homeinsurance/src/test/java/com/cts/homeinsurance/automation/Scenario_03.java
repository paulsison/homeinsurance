package com.cts.homeinsurance.automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeTrue;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.cts.homeinsurance.dao.OracleConnection;

public class Scenario_03 {
	/* This class will test the ability of a user to generate
	 * an insurance quote. */

	private static WebDriver driver;
	private static OracleConnection oracleSQL;
	private static Connection conn;
	private static Boolean databaseIsOnline;
	@SuppressWarnings("unused")
	private static String screenshotFolder;


	@BeforeClass
	public static void setUp() {



		System.setProperty("webdriver.chrome.driver", "C:\\Users\\xandman\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();

		try {
			oracleSQL = new OracleConnection();
			conn = oracleSQL.getConnection();
			databaseIsOnline = true;
			conn.close();
		}
		catch (Exception e)
		{
			databaseIsOnline = false;
			System.out.println("UserDAOTest Class: Could not connect to the database. Tests will be skipped");
		}

		screenshotFolder = "Screenshots_" + LocalDateTime.now();
	}

	@AfterClass
	public static void tearDownClass() {
		driver.close();
	}

	@Test
	public void GetQuoteTest() throws IOException, InterruptedException {

		//Login data
		String userName = "LOU";
		String password ="loupass123";
		//Get quote page data into locations db table
		String residenceType = "Townhouse";
		String addressLine1 = "123 Main St";
		String addressLine2 = "Unit 4A";
		String city = "Dallas";
		String state = "TX";
		String zipCode = "75254";
		String residenceUse = "Primary";
		//Homeowner information page data into db homeowner table
		String firstName = "Paul";
		String lastName = "Sison";
		String dob = "11-10-70";
		String isRetired = "0";
		String ssn = "456789012";
		String email = "lou@gmail.com";
		//Property details page data into db properties table
		String marketValue = "345000";
		String yearBuilt = "1999";
		String squareFootage = "1850";
		String dwellingType = "2 stories";
		String roofMaterial = "Steel";
		String garageType = "Attached";
		String fullBaths = "2";
		String halfBaths = "2";
		String hasPool = "0";

		//Expected Quote value pre-computed with our pricing model		
		double expectedQuote = 163.0;

		assumeTrue(databaseIsOnline);
		
		driver.get("http://localhost:18080/homeinsurance/showLogin");

		//We now login with an Existing test user account
		WebElement userNameElem = driver.findElement(By.cssSelector("body > form > div:nth-child(1) > input[type=\"text\"]"));
		userNameElem.sendKeys(userName);
		WebElement passwordElem = driver.findElement(By.cssSelector("body > form > div:nth-child(2) > input[type=\"text\"]"));
		passwordElem.sendKeys(password);				
		driver.findElement(By.cssSelector("body > form > div:nth-child(3) > input[type=\"submit\"]")).click();
		Thread.sleep(1000);
		//select get quote
		driver.findElement(By.cssSelector("body > form:nth-child(4) > input[type=\"submit\"]")).click();

		// Within Get Quote Page	
		Select residenceTypeElem= new Select(driver.findElement(By.cssSelector("body > form > div:nth-child(1) > select")));
		residenceTypeElem.selectByVisibleText(residenceType);
		WebElement addressLine1Elem = driver.findElement(By.cssSelector("body > form > div:nth-child(2) > input[type=\"text\"]"));
		addressLine1Elem.sendKeys(addressLine1);
		WebElement addressLine2Elem = driver.findElement(By.cssSelector("body > form > div:nth-child(3) > input[type=\"text\"]"));
		addressLine2Elem.sendKeys(addressLine2);
		WebElement cityElem = driver.findElement(By.cssSelector("body > form > div:nth-child(4) > input[type=\"text\"]"));
		cityElem.sendKeys(city);
		WebElement stateElem = driver.findElement(By.cssSelector("body > form > div:nth-child(5) > input[type=\"text\"]"));
		stateElem.sendKeys(state);
		WebElement zipCodeElem = driver.findElement(By.cssSelector("body > form > div:nth-child(6) > input[type=\"text\"]"));
		zipCodeElem.sendKeys(zipCode);
		Select residenceUseElem= new Select(driver.findElement(By.cssSelector("body > form > div:nth-child(7) > select")));
		residenceUseElem.selectByVisibleText(residenceUse);

		takeScreenShot(driver);
		driver.findElement(By.cssSelector("body > form > div:nth-child(8) > input[type=\"submit\"]")).click();

		//Within the Homeowner Information page
		WebElement firstNameElem = driver.findElement(By.cssSelector("body > form > div:nth-child(1) > input[type=\"text\"]"));
		firstNameElem.sendKeys(firstName);
		WebElement lastNameElem = driver.findElement(By.cssSelector("body > form > div:nth-child(2) > input[type=\"text\"]"));
		lastNameElem.sendKeys(lastName);
		WebElement dobElem = driver.findElement(By.cssSelector("body > form > div:nth-child(3) > input[type=\"text\"]"));
		dobElem.sendKeys(dob);
		WebElement isRetiredElem = driver.findElement(By.xpath("/html/body/form/div[4]/input[2]"));
		isRetiredElem.sendKeys(isRetired);
		WebElement ssnElem = driver.findElement(By.cssSelector("body > form > div:nth-child(5) > input[type=\"text\"]"));
		ssnElem.sendKeys(ssn);
		WebElement emailElem = driver.findElement(By.cssSelector("body > form > div:nth-child(6) > input[type=\"text\"]"));
		emailElem.sendKeys(email);

		takeScreenShot(driver);
		driver.findElement(By.cssSelector("body > form > div:nth-child(7) > input[type=\"submit\"]")).click();

		//Verify currentHomeowner session object contains our data to be displayed

		//Within the Property Details Page
		WebElement marketValueElem = driver.findElement(By.cssSelector("body > form > div:nth-child(1) > input[type=\"text\"]"));
		marketValueElem.sendKeys(marketValue);
		WebElement yearBuiltElem = driver.findElement(By.cssSelector("body > form > div:nth-child(2) > input[type=\"text\"]"));
		yearBuiltElem.sendKeys(yearBuilt);
		WebElement squareFootageElem = driver.findElement(By.cssSelector("body > form > div:nth-child(3) > input[type=\"text\"]"));
		squareFootageElem.sendKeys(squareFootage);
		Select dwellingTypeElem= new Select(driver.findElement(By.cssSelector("body > form > div:nth-child(4) > select")));
		dwellingTypeElem.selectByVisibleText(dwellingType);
		Select roofMaterialElem= new Select(driver.findElement(By.cssSelector("body > form > div:nth-child(5) > select")));
		roofMaterialElem.selectByVisibleText(roofMaterial);
		Select garageTypeElem= new Select(driver.findElement(By.cssSelector("body > form > div:nth-child(6) > select")));
		garageTypeElem.selectByVisibleText(garageType);
		Select fullBathsElem= new Select(driver.findElement(By.cssSelector("body > form > div:nth-child(7) > select")));
		fullBathsElem.selectByVisibleText(fullBaths);
		Select halfBathsElem= new Select(driver.findElement(By.cssSelector("body > form > div:nth-child(8) > select")));
		halfBathsElem.selectByVisibleText(halfBaths);
		WebElement hasPoolElem = driver.findElement(By.xpath("/html/body/form/div[9]/input[2]"));
		hasPoolElem.sendKeys(hasPool);

		takeScreenShot(driver);
		driver.findElement(By.cssSelector("body > form > div:nth-child(10) > input[type=\"submit\"]")).click();

		//Verify we are in the Coverage Details Page. Verify the quote.						
		assertThat(driver.getTitle(), equalTo("Coverage Details"));
		takeScreenShot(driver);

		WebElement receivedQuote = driver.findElement(By.cssSelector("body > div > div:nth-child(2) > small"));
		String quoteString = receivedQuote.getText();
		assertThat(Double.parseDouble(quoteString), equalTo(expectedQuote));
		
		//We logout.
   		driver.findElement(By.cssSelector("body > header > a:nth-child(6)")).click();		
   		assertThat(driver.getTitle(), equalTo("Login Page"));
   		takeScreenShot(driver);
	}


	
	private void takeScreenShot(WebDriver driver) throws IOException {
		File scrFile  = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(".\\Screenshots\\" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd_HH.mm.ss.SSS")) + ".png"));
	}


}
