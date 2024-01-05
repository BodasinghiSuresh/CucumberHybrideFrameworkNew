package Stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchReasultPage;

public class Search {

	WebDriver driver ;
	
	
	private HomePage homePage;
	private SearchReasultPage searchReasultPage;

	@Given("User opens the appliction")
	public void user_opens_the_appliction() {

		driver = DriverFactory.getDriver();
	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String validProduct) {
		
	    homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBoxField(validProduct);
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {

		searchReasultPage = homePage.clickOnTheSearchButton();
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {

		searchReasultPage.displayStatusOfValidProduct();
		

	}

	@When("User enters invaild product {string} Into search box fields")
	public void user_enters_invaild_product_into_search_box_fields(String invalidProductText) {

		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBoxField(invalidProductText);

	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {


		Assert.assertEquals("There is no product that matches the search criteria.",searchReasultPage.getMessageText());

	}

	@When("User dont enter any product name into search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {

		homePage = new HomePage(driver);
		
		
	}



}
