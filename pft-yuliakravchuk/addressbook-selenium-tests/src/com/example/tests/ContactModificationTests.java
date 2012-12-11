package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();		
		app.getContactHelper().initContactModification(1);
		ContactData contact = new ContactData();
		contact.firstName = "new first name";
		contact.lastName = "new last name";
		contact.email = "new_email@gmail.com";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
	}
}
