package Stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;


public class Login {
	
	WebDriver driver ;
	private LoginPage loginPage;
	private AccountPage accountPage ;
	private CommonUtils commonUtils;
	
	@Given("User has navigated to login page")
	public void user_has_navigated_to_login_page() {
		
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnAccount();
		loginPage = homePage.selectLoginOption();
	    
	}

	@When("^User enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String emailText) {
	    
		loginPage.enterEmailAddress(emailText);
	}

	@When("^User has entered valid password (.+) into password field$")
	public void user_has_entered_valid_password_into_password_field(String passwordText) {
	    
		loginPage.enterPassword(passwordText);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
	   
		accountPage = loginPage.clickOnLoginButton();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {

		
       Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
	}

	@When("User enters invalid email address")
	public void user_enters_invalid_email_address() {
		
		 commonUtils = new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());

	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPassword) {
	    
		loginPage.enterPassword(invalidPassword);

	}

	@Then("User should get a proper warning message about credentials missmatch")
	public void user_should_get_a_proper_warning_message_about_credentials_missmatch() {
		
       Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User dont enter emil address into email field")
	public void user_dont_enter_emil_address_into_email_field() {
	   
		loginPage.enterEmailAddress("");

	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
	   
		loginPage.enterPassword("");
		
		
	}

	

	}
