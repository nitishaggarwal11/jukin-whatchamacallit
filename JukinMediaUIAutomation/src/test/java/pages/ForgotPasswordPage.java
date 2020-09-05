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

public class ForgotPasswordPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	/***
	 * Constructor - initialize driver and web elements 
	 * @param driver
	 */
	public ForgotPasswordPage (WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver, Integer.parseInt(ApplicationProperties.getInstance().getProperty(ConfigurationProperties.EXPLICIT_WAIT_STRING)));
	}
	
	/***
	 * WebElements/Locators of 'Forgot Password' page
	 */
	
	//@FindBy(how = How.XPATH, using = "//input[@id='fp.email']")
	@FindBy(how = How.ID, using = "fp.email")
	private WebElement EmailField;
	
	@FindBy(how = How.XPATH, using = "//a[@id='forgotPasswordButton']")
	private WebElement SubmitButton;
	
	@FindBy(how = How.XPATH, using = "//a[@href='/WhatChaMaCallIt/login/register']")
	private WebElement BackToLoginButton;
	
	@FindBy(how = How.XPATH, using = "//div[@id='flashMsg']")
	private WebElement FlashMessage;
	
	@FindBy(how = How.XPATH, using = "//div//h5[@id='fpSuccessModalLabel']")
	private WebElement PasswordResetSuccessModalLabel;
	
	@FindBy(how = How.XPATH, using = "//div//div[@class='modal-body']")
	private WebElement PasswordResetSuccessModalBody;
	
	@FindBy(how = How.XPATH, using = "//div//button[@class='btn btn-primary']")
	private WebElement PasswordResetSuccessOKButton;
	
	/***
	 * @description Method to check that Forgot Password page opens successfully
	 */
	public void checkForgotPasswordPageOpens() {
		try {
			wait.until(ExpectedConditions.visibilityOf(EmailField));
			
			if(CommonFunctions.isElementPresent(EmailField) && 
					CommonFunctions.isElementPresent(SubmitButton) &&
					driver.getCurrentUrl().contains("/login/forgotPassword")) {
				Assert.assertTrue("Forgot Password Page opens successfully", true);
				Reporter.addStepLog("Forgot Password Page opens successfully");
			}
			else {
				Assert.fail("Failure in opening Forgot Password Page");
				Reporter.addStepLog("Failure in opening Forgot Password Page");
			}
		} catch (Exception e) {
			Reporter.addStepLog("Exception in opening the Forgot Password Page " + e.getMessage());
		}
	}
	
	/***
	 * @description Method to enter email
	 * @param email
	 */
	public void enterEmail(String email) 
	{
		EmailField.sendKeys(email);
	}
	
	/***
	 * @description Method to click on Submit button
	 */
	public void clickOnSubmitButton() 
	{
		SubmitButton.click();
	}
	
	/***
	 * @description Method to check the Password reset success
	 */
	public void checkPasswordResetSuccess() {
		try {
			wait.until(ExpectedConditions.visibilityOf(PasswordResetSuccessModalLabel));
			
			if(CommonFunctions.isElementPresent(PasswordResetSuccessModalLabel)) {
				Assert.assertEquals(ApplicationProperties.getInstance().getProperty(ConfigurationProperties.PASSWORD_RESET_SUCCESS_TITLE),
						PasswordResetSuccessModalLabel.getText());
				Assert.assertEquals(ApplicationProperties.getInstance().getProperty(ConfigurationProperties.PASSWORD_RESET_SUCCESS_BODY),
						PasswordResetSuccessModalBody.getText());
				PasswordResetSuccessOKButton.click();
			}
			else {
				Assert.fail("Password reset fails");
				Reporter.addStepLog("Password reset fails");
			}
			
		} catch (Exception e) {
			Reporter.addStepLog("Exception in resetting the password " + e.getMessage());
		}
	}
	
	/***
	 * @description Method to check the Forgot Password functionality
	 * @param email
	 */
	public void forgotPassword(String email) 
	{
		enterEmail(email);
		SubmitButton.click();
		checkPasswordResetSuccess();
	}
	
	/***
	 * @description Method to check the Invalid email message
	 */
	public void checkInvalidEmailMessage() {
		try {
			if(CommonFunctions.isElementPresent(FlashMessage)) {
				Assert.assertEquals(ApplicationProperties.getInstance().getProperty(ConfigurationProperties.INVALID_EMAIL_MESSAGE_FORGOT_PASSWORD_PAGE),
						FlashMessage.getText());
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
	 * @description Method to Click on the Back to Login button
	 */
	public void clickOnBackToLoginButton() {
		BackToLoginButton.click();
	}
	
}
