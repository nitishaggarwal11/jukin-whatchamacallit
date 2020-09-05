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


public class LoginPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	/***
	 * Constructor - initialize driver and web elements 
	 * @param driver
	 */
	public LoginPage (WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver, Integer.parseInt(ApplicationProperties.getInstance().getProperty(ConfigurationProperties.EXPLICIT_WAIT_STRING)));
	}
	
	/***
	 * WebElements/Locators of 'Login' page
	 */
	
	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	private WebElement UsernameField;
	
	@FindBy(how = How.ID, using = "creds.password")
	//@FindBy(how = How.XPATH, using = "//input[@id='creds.password']")
	private WebElement PasswordField;
	
	@FindBy(how = How.XPATH, using = "//input[@id='loginButton']")
	//@FindBy(how = How.ID, using = "loginButton")
	private WebElement LoginButton;
	
	@FindBy(how = How.XPATH, using = "//a[@href='/WhatChaMaCallIt/login/forgotPassword']")
	private WebElement ForgotPasswordButton;

	@FindBy(how = How.XPATH, using = "//a[@href='/WhatChaMaCallIt/login/register']")
	private WebElement RegisterButton;
	
	@FindBy(how = How.XPATH, using = "//form//h3")
	private WebElement LoginPageHeading;
	
	@FindBy(how = How.XPATH, using = "//form//div[contains(text(),'Incorrect')]")
	private WebElement IncorrectEmailPasswordMessage;
	
	@FindBy(how = How.XPATH, using = "//div//h3[contains(text(),'successfully')]")
	private WebElement LoginSuccessMessage;
	
	
	/***
	 * @description Method to enter Username & Password
	 * @param username
	 * @param Password
	 */
	public void enterUsernamePassword(String username, String Password) 
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(LoginPageHeading));
			
			UsernameField.sendKeys(username);
			PasswordField.sendKeys(Password);
		} catch (Exception e) {
			Reporter.addStepLog("Exception in entering Username and Password on the Login Page");
		}
	}
	
	/***
	 * @description Method to Click on the Login button
	 */
	public void clickOnLoginButton() {
		LoginButton.click();
	}
	
	/***
	 * @description Method to check the successful Login
	 */
	public void checkLoginSuccess() {
		try {
			wait.until(ExpectedConditions.visibilityOf(LoginSuccessMessage));
			Assert.assertEquals(ApplicationProperties.getInstance().getProperty(ConfigurationProperties.LOGIN_SUCCESS_MESSAGE),
					LoginSuccessMessage.getText());
		} catch (Exception e) {
			Reporter.addStepLog("Exception in Logging to the application");
		}
	}
	
	/***
	 * @description Method to Login into the application by entering Username & Password
	 * @param username
	 * @param Password
	 */
	public void loginToApplication(String username, String password) 
	{
		enterUsernamePassword(username, password);
		clickOnLoginButton();
		checkLoginSuccess();
	}
	
	/***
	 * @description Method to check the Incorrect Username Password message
	 */
	public void checkIncorrectEmailPasswordMessage() {
		try {
			if(CommonFunctions.isElementPresent(IncorrectEmailPasswordMessage)) {
				Assert.assertEquals(ApplicationProperties.getInstance().getProperty(ConfigurationProperties.INCORRECT_USERNAME_PASSWORD_MESSAGE),
						IncorrectEmailPasswordMessage.getText());
			}
			else {
				Reporter.addStepLog("Incorrect email/password combination message is not displayed");
				Assert.fail("Incorrect email/password combination message is not displayed");
			}
		} catch (Exception e) {
			Reporter.addStepLog("Exception in checking the Incorrect email/password combination");
		}
	}
	
	/***
	 * @description Method to check the Incorrect Username Password message
	 * @param username
	 * @param password
	 */
	public void checkIncorrectEmailPasswordMessage(String username, String password) {
		enterUsernamePassword(username, password);
		clickOnLoginButton();
		checkIncorrectEmailPasswordMessage();
	}
	
	/***
	 * @description Method to Click on the Forgot Password button
	 */
	public void clickOnForgotPasswordButton() {
		ForgotPasswordButton.click();
	}
	
	/***
	 * @description Method to Click on the Register button
	 */
	public void clickOnRegisterButton() {
		RegisterButton.click();
	}
	
}
