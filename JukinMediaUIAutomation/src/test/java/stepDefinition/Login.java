package stepDefinition;

import config.ApplicationProperties;
import constants.ConfigurationProperties;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverFactory;
import pages.LoginPage;

public class Login {

	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("^User launches the Jukin Media application$")
	public void User_launches_the_Jukin_Media_application() 
	{
		/* Launch the Jukin Media application */ 
		DriverFactory.navigateToApplication(ApplicationProperties.getInstance().getProperty(ConfigurationProperties.URL));
	}
		
	@When("^User enters \"([^\"]*)\" as username and \"([^\"]*)\" as the password$")
	public void User_enters_username_and_password(String username, String password) 
	{
		loginPage.enterUsernamePassword(username, password);
	}
	
	@And("^Click on Login button$")
	public void Click_on_Login_button() 
	{	
		loginPage.clickOnLoginButton();
	}
	
	@Then("^User navigates to the Login success page$")
	public void User_navigates_to_the_Login_success_page() 
	{	
		loginPage.checkLoginSuccess();
	}
	
	@Then("^Incorrect email password combination message will be shown to the user$")
	public void Incorrect_email_password_combination_message_will_be_shown_to_the_user() 
	{	
		loginPage.checkIncorrectEmailPasswordMessage();
	}
	
	@When("^User clicks on Forgot Password button$")
	public void User_clicks_on_Forgot_Password_button() 
	{
		loginPage.clickOnForgotPasswordButton();
	}
	
	@When("^User clicks on Register button$")
	public void User_clicks_on_Register_button() 
	{
		loginPage.clickOnRegisterButton();
	}
	
}
