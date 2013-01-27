package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase {

	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
	}

	@Test(dataProvider = "contactsFromFile")
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
