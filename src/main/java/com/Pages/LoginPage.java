package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.InitDriver;

public class LoginPage extends InitDriver{
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="uid")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement passWord;
	
	@FindBy(name="btnLogin")
	private WebElement LoginBtn;
	
	@FindBy(name="btnReset")
	private WebElement ResetBtn;
	
	@FindBy(linkText="Log out")
	private WebElement LogoutBtn;
	
	public WebElement userName() {
		return username;
	}

	public WebElement passWord() {
		return passWord;
	}

	public WebElement loginBtn() {
		return LoginBtn;
	}
	
	public WebElement resetBtn() {
		return ResetBtn;
	}
	
	public WebElement logoutBtn() {
		return LogoutBtn;
	}
	
	
	
	
	
	
	
	
	

}
