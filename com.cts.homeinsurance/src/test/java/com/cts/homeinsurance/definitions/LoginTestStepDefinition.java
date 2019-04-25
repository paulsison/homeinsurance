package com.cts.homeinsurance.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
public class LoginTestStepDefinition {
	/* A demonstration of a CUCUMBER implementation similar to Scenario_03.java*/

	private WebDriver driver = null;
	String userName = "LOU";
	String password = "loupass123";

	@Given("^User is on the login page$")
	public void user_has_on_the_login_page() throws Throwable {
		System.out.println("User Navigates to Home Insurance site");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\xandman\\Desktop\\ChromeDriver.exe");
		driver = new ChromeDriver();  	
		driver.get("http://localhost:18080/homeinsurance/showLogin");

	}

	@When("^User enters username into username input field$")
	public void user_enters_username_into_username_input_field() throws Throwable {

		WebElement userNameElem = driver.findElement(By.cssSelector("body > form > div:nth-child(1) > input[type=\"text\"]"));
		userNameElem.sendKeys(userName);

		
	}

	@And("^User enters password into password field$")
	public void user_enters_password_into_password_field() throws Throwable {

		WebElement passwordElem = driver.findElement(By.cssSelector("body > form > div:nth-child(2) > input[type=\"text\"]"));
		passwordElem.sendKeys(password);				

	}

	@And("^User clicks submitt button$")
	public void user_clicks_submitt_button() throws Throwable {

		driver.findElement(By.cssSelector("body > form > div:nth-child(3) > input[type=\"submit\"]")).click();
	}


	@Then("^User is directed to Get Started Page$")
	public void user_is_directed_to_get_started_page() throws Throwable {

		assertThat(driver.getTitle(), equalTo("Get Started Page"));
		driver.close();		

	}



}