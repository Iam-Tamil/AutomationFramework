package com.Steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.Base.CommonMethods;
import com.Enum.Locators;
import com.Utils.ExtendReport;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewCustomer_TC02 extends CommonMethods {

	LoginTest_TC01 loginTest_TC01;
	
	@Given("user navigate to the main page")
	public void userNavigateToTheMainPage() {
		ExtendReport.testName("user navigate to the main page");
		
		loginTest_TC01 = new LoginTest_TC01();
		loginTest_TC01.userEnterTheValidUserID();
		loginTest_TC01.userEnterTheValidPassword();
		loginTest_TC01.userClickTheSigninButton();
		submit(newCustomer.addNewCustomer());
		
	}
	
	@Given("user enters following customer details")
	public void userEntersFollowingCustomerDetails(DataTable dataTable) {
		ExtendReport.testName("user enters following customer details");
		
	    
	    List<Map<String, String>> userData = dataTable.asMaps(String.class, String.class);
	    
	    for(Map<String, String> mapData : userData) {
	    	
	    	sendText(newCustomer.customerName(), mapData.get("Customer Name"));
	    	String gender = mapData.get("Gender");
		  	submit(newCustomer.getGender(gender));
		  	sendText(newCustomer.dateOfBirth(), mapData.get("Date of Birth"));
		  	sendText(newCustomer.address(), mapData.get("Address"));
		  	sendText(newCustomer.city(), mapData.get("City"));
		  	sendText(newCustomer.state(), mapData.get("State"));
		  	sendText(newCustomer.pinNo(), mapData.get("Pin"));
		  	sendText(newCustomer.mobileNo(), mapData.get("Mobile Number"));
		  	sendText(newCustomer.emailID(), mapData.get("E-mail"));
		  	sendText(newCustomer.password(), mapData.get("Password"));
	    }
	    
	  	
	  	
	}

	@When("user click the submit button")
	public void userClickTheSubmitButton() {
		ExtendReport.testName("user click the submit button");
		
	    submit(newCustomer.submit());
	  
	}
	@Then("add customer should be successful")
	public void addCustomerShouldBeSuccessful() {
		ExtendReport.testName("add customer should be success");
		
		WebElement element = element(Locators.xpath, "//p[text()='Customer Registered Successfully!!!']");
		String text = getElementText(element);
		
		if(text.equals("Customer Registered Successfully!!!")) {
			ExtendReport.testResult("pass", "Customer Registered Successfully");
		}else {
			ExtendReport.testResult("fail", "Customer Registration was unuccessful");
		}
	    
	}



}
