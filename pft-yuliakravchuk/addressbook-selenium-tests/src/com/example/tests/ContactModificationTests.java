package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import static com.example.fw.ContactHelper.MODIFICATION;;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) {
		app.navigateTo().mainPage();	
		
		// Save old state
		List<ContactData> oldContactList = app.getContactHelper().getContacts();
		
		// Actions
		Random rnd = new Random();
		int index = rnd.nextInt(oldContactList.size() - 1);
		
		app.getContactHelper().initContactModification(index);
		app.getContactHelper().fillContactForm(contact, MODIFICATION);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
		
		// Save new state
		List<ContactData> newContactList = app.getContactHelper().getContacts();
				
		// Compare states	
		oldContactList.remove(index);
		contact.email = contact.getDisplayedEmail();
		contact.homePhone = contact.getDisplayedPhone();	
		oldContactList.add(index, contact);
		Collections.sort(oldContactList);
		assertEquals(newContactList, oldContactList);
	}
}
