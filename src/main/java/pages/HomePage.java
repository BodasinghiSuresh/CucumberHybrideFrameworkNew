package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver ;
	private ElementUtils elementUtils;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement MyAccountDropMenu;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement serechBoxField;
	
	@FindBy(xpath="//button[contains(@class,' btn-default btn-lg')]")
	private WebElement clickOnSearchButton;
	
	public void clickOnAccount() {
		
		elementUtils.clickOnElement(MyAccountDropMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public LoginPage selectLoginOption() {
		
		elementUtils.clickOnElement(loginOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		
		elementUtils.clickOnElement(registerOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
		
	}
	
	public void enterProductIntoSearchBoxField(String ProductText) {
		
		elementUtils.typeTextIntoElement(serechBoxField, ProductText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public SearchReasultPage clickOnTheSearchButton() {
		
		elementUtils.clickOnElement(clickOnSearchButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		return new SearchReasultPage(driver);
	}
	
	
	
	
}
