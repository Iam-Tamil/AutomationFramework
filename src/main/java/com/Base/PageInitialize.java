package com.Base;

import com.Pages.LoginPage;
import com.Pages.NewCustomer;

public class PageInitialize extends InitDriver {
	
	public static LoginPage loginpage;
	public static NewCustomer newCustomer;

	public static void initialize() {
		loginpage = new LoginPage();
		newCustomer = new NewCustomer();
	}
}
