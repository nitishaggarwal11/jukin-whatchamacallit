package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverFactory;
import pages.ForgotPasswordPage;

public class ForgotPassword {
	
	ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(DriverFactory.getDriver());
	
	@Then("^User navigates to the forgot password page$")
	public void User_navigates_to_the_forgot_password_page() 
	{	
		forgotPasswordPage.checkForgotPasswordPageOpens();
	}
	
	@When("^User enters \"([^\"]*)\" as email in the field$")
	public void User_enters_email(String email) 
	{
		forgotPasswordPage.enterEmail(email);
	}
	
	@And("^Clicks on Submit button on Forgot password page$")
	public void Clicks_on_Submit_button_on_Forgot_password_page() 
	{	
		forgotPasswordPage.clickOnSubmitButton();
	}
	
	@Then("^Password Reset Successful popup will display$")
	public void Password_Reset_Successful_popup_will_display() 
	{	
		forgotPasswordPage.checkPasswordResetSuccess();
	}
	
	@Then("^Invalid email message will display on the forgot password page$")
	public void Invalid_email_message_will_display_on_the_forgot_password_page() 
	{	
		forgotPasswordPage.checkInvalidEmailMessage();
	}
	
}
