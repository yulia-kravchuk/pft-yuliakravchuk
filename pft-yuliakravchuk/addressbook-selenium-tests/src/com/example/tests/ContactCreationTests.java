package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import static com.example.fw.ContactHelper.CREATION;

public class ContactCreationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactCreationWithValidData(ContactData contact) throws Exception {
		app.navigateTo().mainPage();
		
		// Save old state
		List<ContactData> oldContactList = app.getContactHelper().getContacts();
		
		// Actions
		app.getContactHelper().initContactCreation();
		app.getContactHelper().fillContactForm(contact, CREATION);		
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToHomePage();
		
		// Save new state
		List<ContactData> newContactList = app.getContactHelper().getContacts();
		
		// Compare states		
		contact.email = contact.getDisplayedEmail();
		contact.homePhone = contact.getDisplayedPhone();	
		oldContactList.add(contact);
		Collections.sort(oldContactList);
		assertEquals(newContactList, oldContactList);
	}
}
