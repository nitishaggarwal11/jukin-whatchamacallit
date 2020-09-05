package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverFactory;
import pages.RegisterPage;

public class Register {

	RegisterPage registerPage = new RegisterPage(DriverFactory.getDriver());
	
	@Then("^User navigates to the Register page$")
	public void User_navigates_to_the_Register_page() 
	{	
		registerPage.checkRegisterPageOpens();
	}
	
	@When("^User enters \"([^\"]*)\" as email and \"([^\"]*)\" as Password in the fields$")
	public void User_enters_email_and_password_in_the_fields(String email, String password) 
	{
		registerPage.enterEmailAndPassword(email, password);
	}
	
    @And("^Clicks on Submit button on Registration page$")
	public void Clicks_on_Submit_button_on_Registration_page() 
	{	
    	registerPage.clickOnSubmitButton();
	}
    
    @Then("^User navigates to the registration success page$")
	public void User_navigates_to_the_registration_success_page() 
	{	
    	registerPage.checkRegistrationSuccess();
	}
    
    @Then("^Invalid email message will display on the register page$")
	public void Invalid_email_message_will_display_on_the_register_page() 
	{	
    	registerPage.checkInvalidEmailMessage();
	}
    
    @Then("^Invalid password confirmation message will display on the register page$")
	public void Invalid_password_confirmation_message_will_display_on_the_register_page() 
	{	
    	registerPage.checkInvalidPasswordConfirmationMessage();
	}
    
    @When("^User enters \"([^\"]*)\" as email and \"([^\"]*)\" as Password in the fields and blank in confirm password$")
	public void User_enters_email_and_password_in_the_fields_and_blank_in_confirm_password(String email, String password) 
	{
		registerPage.enterEmailAndPasswordButNotConfirmPassword(email, password);
	}
 
    @When("^User enters \"([^\"]*)\" as email and blank in the Password and Confirm password fields$")
	public void User_enters_email_and_blank_in_Password_and_confirm_password(String email) 
	{
		registerPage.enterEmail(email);
	}
    
    @Then("^Fill out all fields message will display on the register page$")
   	public void Fill_out_all_fields_message_will_display_on_the_register_page() 
   	{	
       	registerPage.checkFillOutAllFieldsMessage();
   	}
    
}
