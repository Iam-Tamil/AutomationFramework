package com.Base;

import com.Pages.LoginPage;

public class PageInitialize extends InitDriver {
	
	public static LoginPage loginpage;

	public static void initialize() {
		loginpage = new LoginPage();
	}
}
