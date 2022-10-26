package stepdefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {

	WebDriver driver = Hooks.driver ; //Here the we are using the hooks class for driver

	@Given("I have launched the application")
	public void i_have_launched_the_application() {

		// Step1 : Launching the saucedemo Webpage
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	@When("I enter the correct username and password")
	public void i_enter_the_correct_username_and_password() {

		// Entering the correct username 
		WebElement userID = driver.findElement(By.name("user-name"));
		userID.sendKeys("standard_user");

		//Entering the valid pswd
		WebElement Pswd = driver.findElement(By.id("password"));
		Pswd.sendKeys("secret_sauce");

	}

	@When("I click on Login Button")
	public void i_click_on_Login_Button() {

		// CLick on the login button 
		WebElement LoginBtn = driver.findElement(By.id("login-button"));
		LoginBtn.click();

	}

	@Then("I should land on the home page")
	public void i_should_land_on_the_home_page() {

		// Validating Homepage
		WebElement Homepage = driver.findElement(By.xpath("//div[@class =\"header_secondary_container\" ]/span"));
		String ExpHomepage = "PRODUCTS";
		String ActHomepage = Homepage.getText();
		Assert.assertEquals(ExpHomepage, ActHomepage);


	}

	@When("I enter the incorrect username as {string} and password as {string}")
	public void i_enter_the_incorrect_username_as_and_password_as(String UserNameVal, String pwdVal) {

		// Giving incorrect pswd and userid
		WebElement userID = driver.findElement(By.name("user-name"));
		userID.sendKeys(UserNameVal);

		WebElement Pswd = driver.findElement(By.id("password"));
		Pswd.sendKeys(pwdVal);
	}


	@Then("I should get the error message as {string}")
	public void i_should_get_the_error_message_as(String exp_error) {

		// Validating the corresponding error message for the different username and incorrect password
		WebElement Error = driver.findElement(By.xpath("//h3[@data-test ='error']"));
		String ActualError = Error.getText();

		Assert.assertEquals(exp_error, ActualError);
	}

}
