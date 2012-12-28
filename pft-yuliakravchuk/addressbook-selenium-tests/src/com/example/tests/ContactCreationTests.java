package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactCreationWithValidData(ContactData contact) throws Exception {		
		// Save old state
		SortedListOf<ContactData> oldContactList = app.getContactHelper().getContacts();
		
		// Actions
		app.getContactHelper().createContact(contact);
		
		// Save new state
		SortedListOf<ContactData> newContactList = app.getContactHelper().getContacts();
		
		// Compare states		
		assertThat(newContactList, equalTo(oldContactList.withAdded(contact)));
	}
}
