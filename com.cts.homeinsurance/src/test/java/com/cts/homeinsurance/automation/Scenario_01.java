package com.cts.homeinsurance.automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeTrue;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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

import com.cts.homeinsurance.bo.UsersBO;
import com.cts.homeinsurance.dao.OracleConnection;
import com.cts.homeinsurance.model.Users;


public class Scenario_01 {
	/* This test class will verify the ability of a user to create 
	 * register a new user account. */

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
	public void RegistrationTest() throws IOException, ClassNotFoundException, SQLException {

		String userName = "LOU";
		String password ="loupass123";

		assumeTrue(databaseIsOnline);

		driver.get("http://localhost:18080/homeinsurance/showLogin");
		driver.manage().window().maximize();
		driver.findElement(By.id("reg_page")).click();
		WebElement loginInput = driver.findElement(By.cssSelector("body > form > div:nth-child(1) > input[type=\"text\"]"));
		loginInput.sendKeys(userName);
		WebElement passwordInput = driver.findElement(By.cssSelector("body > form > div:nth-child(2) > input[type=\"text\"]"));
		passwordInput.sendKeys(password);
		takeScreenShot(driver);	

		driver.findElement(By.cssSelector("body > form > div:nth-child(3) > input[type=\"submit\"]")).click();

		//We check our SQL db the existence of this new user.
		
		Users user = new Users();
		UsersBO u_bo = new UsersBO();
		
		user = u_bo.getByUserName(userName);	
		assertThat(user.getUserName(), equalTo(userName));

	}

	
	private void takeScreenShot(WebDriver driver) throws IOException {
		File scrFile  = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(".\\Screenshots\\" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd_HH.mm.ss.SSS")) + ".png"));
	}

}
