package com.Steps;

import com.Base.CommonMethods;
import com.Utils.ConfigProperty;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest_TC01 extends CommonMethods {

	@Given("user enter the valid userID")
	public void userEnterTheValidUserID() {
	    sendText(loginpage.userName(), ConfigProperty.getPropertyFile("username"));
	    
	}
	@Given("user enter the valid password")
	public void userEnterTheValidPassword() {
		sendText(loginpage.passWord(), ConfigProperty.getPropertyFile("password"));
	    
	}
	@When("user click the signin button")
	public void userClickTheSigninButton() {
	    submit(loginpage.loginBtn());
	    
	}
	@Then("signin should be success")
	public void signinShouldBeSuccess() {
	    submit(loginpage.logoutBtn());
	    acceptAlert();
	    
	}



}
