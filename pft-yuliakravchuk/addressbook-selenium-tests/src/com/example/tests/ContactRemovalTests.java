package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;


public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact() {
		// Save old state
		SortedListOf<ContactData> oldContactList = app.getContactHelper().getContacts();
		
		// Actions
		Random rnd = new Random();
		int index = rnd.nextInt(oldContactList.size() - 1);		
		app.getContactHelper().deleteContact(index);
		
		// Save new state
		SortedListOf<ContactData> newContactList = app.getContactHelper().getContacts();		
		
		// Compare states
		assertThat(newContactList, equalTo(oldContactList.without(index)));
	}
}
