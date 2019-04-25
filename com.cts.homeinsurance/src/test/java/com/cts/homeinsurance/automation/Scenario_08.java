package com.cts.homeinsurance.automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
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

import com.cts.homeinsurance.dao.OracleConnection;

public class Scenario_08 {
	/* This class will test the ability of an admin user
	 * to search for policies belonging to a specific user. */

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
	public void RetrieveQuoteTest() throws IOException {

		//Admin Login data
		String userName = "ADMIN";
		String password ="adminpass123";
		
		//User to Search
		String userToSearch = "LOU";
		

		assumeTrue(databaseIsOnline);

		driver.get("http://localhost:18080/homeinsurance/showLogin");
		
		//Go to admin login page
		driver.findElement(By.cssSelector("#admin_page")).click();

		//We now login with an Existing test admin account
		WebElement loginInput = driver.findElement(By.cssSelector("body > form > div:nth-child(1) > input[type=\"text\"]"));
		loginInput.sendKeys(userName);
		WebElement passwordInput = driver.findElement(By.cssSelector("body > form > div:nth-child(2) > input[type=\"text\"]"));
		passwordInput.sendKeys(password);
		takeScreenShot(driver);

		driver.findElement(By.cssSelector("body > form > div:nth-child(3) > input[type=\"submit\"]")).click();

		assertThat(driver.getTitle(), equalTo("Admin Screen"));
		takeScreenShot(driver);
		
		//Search by UserName
		WebElement userToSearchElem = driver.findElement(By.cssSelector("body > form > div:nth-child(1) > input[type=\"text\"]"));
		userToSearchElem.sendKeys(userToSearch);
		takeScreenShot(driver);

		driver.findElement(By.cssSelector("body > form > div:nth-child(2) > input[type=\"submit\"]")).click();
		
		assertThat(driver.getTitle(), equalTo("Admin Search Results"));
		takeScreenShot(driver);
		
		WebElement topPolicyIdElem = driver.findElement(By.cssSelector("body > table > tbody > tr:nth-child(2) > td:nth-child(6)"));
		String topPolicyIdString = topPolicyIdElem.getText();
		
		assertNotNull(topPolicyIdString);
		

		//We logout.
		driver.findElement(By.cssSelector("body > header > a:nth-child(4)")).click();		
		assertThat(driver.getTitle(), equalTo("Admin Page"));
		takeScreenShot(driver);

	}

	
	private void takeScreenShot(WebDriver driver) throws IOException {
		File scrFile  = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(".\\Screenshots\\" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd_HH.mm.ss.SSS")) + ".png"));
	}

}
