package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) {
		app.getNavigationHelper().openMainPage();	
		
		// Save old state
		List<ContactData> oldContactList = app.getContactHelper().getGroups();
		
		// Actions
		Random rnd = new Random();
		int index = rnd.nextInt(oldContactList.size() - 1);
		
		app.getContactHelper().initContactModification(index);
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
		
		// Save new state
		List<ContactData> newContactList = app.getContactHelper().getGroups();
				
		// Compare states	
		oldContactList.remove(index);
		contact.email = contact.getDisplayedEmail();
		contact.homePhone = contact.getDisplayedPhone();	
		oldContactList.add(index, contact);
		Collections.sort(oldContactList);
		assertEquals(newContactList, oldContactList);
	}
}
