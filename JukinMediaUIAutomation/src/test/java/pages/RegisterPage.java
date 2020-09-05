package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;
import config.ApplicationProperties;
import constants.ConfigurationProperties;
import utils.CommonFunctions;

public class RegisterPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	/***
	 * Constructor - initialize driver and web elements 
	 * @param driver
	 */
	public RegisterPage (WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver, Integer.parseInt(ApplicationProperties.getInstance().getProperty(ConfigurationProperties.EXPLICIT_WAIT_STRING)));
	}
	
	/***
	 * WebElements/Locators of 'Register' page
	 */
	
	//@FindBy(how = How.XPATH, using = "//input[@id='reg.email']")
	@FindBy(how = How.ID, using = "reg.email")
	private WebElement EmailField;
	
	//@FindBy(how = How.XPATH, using = "//input[@id='reg.password']")
	@FindBy(how = How.ID, using = "reg.password")
	private WebElement PasswordField;
	
	//@FindBy(how = How.XPATH, using = "//input[@id='reg.confirmPassword']")
	@FindBy(how = How.ID, using = "reg.confirmPassword")
	private WebElement ConfirmPaswordField;
	
	@FindBy(how = How.XPATH, using = "//input[@name='_action_doRegister']")
	private WebElement SubmitButton;
	
	@FindBy(how = How.XPATH, using = "//input[@name='_action_index']")
	private WebElement BackToLoginButton;
	
	@FindBy(how = How.XPATH, using = "//div[@id='failedMessage']")
	private WebElement FailedMessage;
	
	@FindBy(how = How.XPATH, using = "//div//h3")
	private WebElement AccountVerificationMessage;
	
	@FindBy(how = How.XPATH, using = "//div[@id='failedMessage']")
	private WebElement FillOutAllFieldsMessage;
	
	/***
	 * @description Method to check that Register page opens successfully
	 */
	public void checkRegisterPageOpens() {
		try {
			wait.until(ExpectedConditions.visibilityOf(EmailField));
			
			if(CommonFunctions.isElementPresent(EmailField) && 
					CommonFunctions.isElementPresent(PasswordField) &&
					driver.getCurrentUrl().contains("/login/register")) {
				Assert.assertTrue("Register Page opens successfully", true);
			}
			else {
				Assert.fail("Failure in opening Register Page");
				Reporter.addStepLog("Failure in opening Register Page");
			}
		} catch (Exception e) {
			Reporter.addStepLog("Exception in opening the Register Page " + e.getMessage());
		}
	}
	
	/***
	 * @description Method to enter email
	 * @param email
	 */
	public void enterEmail(String email) {
		EmailField.sendKeys(email);
	}
	
	/***
	 * @description Method to enter email and Password
	 * @param email
	 */
	public void enterEmailAndPassword(String email, String password) 
	{
		wait.until(ExpectedConditions.visibilityOf(EmailField));
		enterEmail(email);
		PasswordField.sendKeys(password);
		ConfirmPaswordField.sendKeys(password);
	}
	
	/***
	 * @description Method to enter email and Password but not confirm password
	 * @param email
	 */
	public void enterEmailAndPasswordButNotConfirmPassword(String email, String password) 
	{
		enterEmail(email);
		PasswordField.sendKeys(password);
	}
	
	
	/***
	 * @description Method to click on Submit button
	 */
	public void clickOnSubmitButton() 
	{
		SubmitButton.click();
	}
	
	/***
	 * @description Method to check the Registration success page
	 */
	public void checkRegistrationSuccess() 
	{
		try {
			if(CommonFunctions.isElementPresent(AccountVerificationMessage)) {
				Assert.assertEquals(ApplicationProperties.getInstance().getProperty(ConfigurationProperties.REGISTER_SUCCESS_MESSAGE), 
						AccountVerificationMessage.getText());
			}
			else {
				Assert.fail("User Registration fails");
				Reporter.addStepLog("User Registration fails");
			}
			
		} catch (Exception e) {
			Reporter.addStepLog("Exception in User Registration " + e.getMessage());
		}
	}
	
	/***
	 * @description Method to check the Register User functionality
	 * @param email
	 * @param password
	 */
	public void RegisterUser(String email, String password) 
	{
		enterEmailAndPassword(email, password);
		clickOnSubmitButton();
		checkRegistrationSuccess();
	}
	
	/***
	 * @description Method to check the Invalid email message
	 * @param email
	 */
	public void checkInvalidEmailMessage() {
		try {
			if(CommonFunctions.isElementPresent(FailedMessage)) {
				Assert.assertEquals(ApplicationProperties.getInstance().getProperty(ConfigurationProperties.INVALID_EMAIL_MESSAGE), 
						FailedMessage.getText());
			}
			else {
				Assert.fail("Invalid email message is not displayed");
				Reporter.addStepLog("Invalid email message is not displayed");
			}
		} catch (Exception e) {
			Reporter.addStepLog("Exception in checking the invalid email criteria " + e.getMessage());
		}
	}
	
	/***
	 * @description Method to check the Invalid Password message
	 */
	public void checkInvalidPasswordConfirmationMessage() {
		try {
			if(CommonFunctions.isElementPresent(FailedMessage)) {
				Assert.assertEquals(ApplicationProperties.getInstance().getProperty(ConfigurationProperties.INVALID_PASSWORD_CONFIRMATION_MESSAGE),
						FailedMessage.getText());
			}
			else {
				Assert.fail("Invalid email message is not displayed");
				Reporter.addStepLog("Invalid email message is not displayed");
			}
		} catch (Exception e) {
			Reporter.addStepLog("Exception in checking the invalid password criteria " + e.getMessage());
		}
	}
	
	/***
	 * @description Method to check the Fill out all fields message
	 */
	public void checkFillOutAllFieldsMessage() {
		try {
			if(CommonFunctions.isElementPresent(FailedMessage)) {
				Assert.assertEquals(ApplicationProperties.getInstance().getProperty(ConfigurationProperties.FILL_ALL_FIELDS_MESSAGE),
						FailedMessage.getText());
			}
			else {
				Assert.fail("Fill out all fields message is not displayed");
				Reporter.addStepLog("Fill out all fields message is not displayed");
			}
		} catch (Exception e) {
			Reporter.addStepLog("Exception in checking the Fill out all fields criteria " + e.getMessage());
		}
	}
	
	/***
	 * @description Method to Click on Back to Login button
	 */
	public void clickOnBackToLoginButton() {
		BackToLoginButton.click();
	}
	
}
