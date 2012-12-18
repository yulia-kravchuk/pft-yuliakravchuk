package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();	
		
		// Save old state
		List<ContactData> oldContactList = app.getContactHelper().getGroups();
		
		// Actions
		Random rnd = new Random();
		int index = rnd.nextInt(oldContactList.size() - 1);		
		app.getContactHelper().deleteContact(index);
		app.getContactHelper().returnToHomePage();
		
		// Save new state
		List<ContactData> newContactList = app.getContactHelper().getGroups();		
		
		// Compare states
		oldContactList.remove(index);
		Collections.sort(newContactList);
		assertEquals(newContactList, oldContactList);
	}
}
