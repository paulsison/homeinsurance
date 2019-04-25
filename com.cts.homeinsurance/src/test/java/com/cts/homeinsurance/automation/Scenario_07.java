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

import com.cts.homeinsurance.dao.OracleConnection;

public class Scenario_07 {
	/* This class will test the ability of an existing user
	 * to view an existing policy. */

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
	public void ViewPolicyTest() throws IOException {

		//Login data
		String userName = "LOU";
		String password ="loupass123";

		// Expected test data
		String policyStatus = "active";

		assumeTrue(databaseIsOnline);

		driver.get("http://localhost:18080/homeinsurance/showLogin");

		//We now login with an Existing test user account
		WebElement loginInput = driver.findElement(By.cssSelector("body > form > div:nth-child(1) > input[type=\"text\"]"));
		loginInput.sendKeys(userName);
		WebElement passwordInput = driver.findElement(By.cssSelector("body > form > div:nth-child(2) > input[type=\"text\"]"));
		passwordInput.sendKeys(password);
		takeScreenShot(driver);

		driver.findElement(By.cssSelector("body > form > div:nth-child(3) > input[type=\"submit\"]")).click();

		assertThat(driver.getTitle(), equalTo("Get Started Page"));
		takeScreenShot(driver);

		//We go to Active Policies page and verify if the top most policy is active
		driver.findElement(By.cssSelector("body > header > a:nth-child(5)")).click();
	
		assertThat(driver.getTitle(), equalTo("My Policies"));
		takeScreenShot(driver);
				//We may need a more dynamic selector for varying quantity of quotes in our test
		WebElement receivedPolicyElem = driver.findElement(By.cssSelector("body > table > tbody > tr:nth-child(2) > td:nth-child(6)"));
		String policyString = receivedPolicyElem.getText();
		assertThat(policyString, equalTo(policyStatus));

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
