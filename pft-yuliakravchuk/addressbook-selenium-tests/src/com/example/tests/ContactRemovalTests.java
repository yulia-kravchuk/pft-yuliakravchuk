package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();		
		app.getContactHelper().deleteContact(0);
		app.getContactHelper().returnToHomePage();
	}
}
