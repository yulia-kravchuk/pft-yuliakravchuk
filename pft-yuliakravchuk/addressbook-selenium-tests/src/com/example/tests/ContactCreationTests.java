package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@Test
	public void testNonEmptyContactCreation() throws Exception {
		openMainPage();
		initContactCreation();
		
		ContactData contact = new ContactData();
		contact.firstName = "Eduard";
		contact.lastName = "Golopupenko";
		contact.address = "USSR";
		contact.homePhone = "12345";
		contact.mobilePhone = "2947593";
		contact.workPhone = "8493920";
		contact.email = "eduard@gmail.com";
		contact.email2 = "golopupenko@ukr.net";
		contact.bDay = "20";
		contact.bMonth = "December";
		contact.bYear = "1980";
		contact.groupName = "test group 1";
		contact.address2 = "Ukraine";
		contact.phone2 = "7738292";		
		fillContactForm(contact);
		
		submitContactForm();
		returnToHomePage();
	}
	
	@Test
	public void testEmptyContactCreation() throws Exception {
		openMainPage();
		initContactCreation();
		
		fillContactForm(new ContactData("","","","","","","","","","","","","",""));
		
		submitContactForm();
		returnToHomePage();
	}
}
