package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.collections.Lists;


public class PrintPhonesTests extends TestBase {
	@Test
	public void testPrintPhonesAll() {
		// Save all displayed contacts
		List<ContactData> contactList = Lists.newArrayList();
		
		List<ContactData> contactListTemp = app.getContactHelper().getContacts();
		
		for (ContactData contactTemp : contactListTemp) {
			contactList.add(new ContactData().copyFrom(contactTemp));
		}
		
		// Prepare contact list for comparison
		for (ContactData contact : contactList) {
			// Remove emails from listed contacts because they are not printed
			contact.email = "";
			contact.email2 = "";
			// Merge First Name and Last Name in one field because they are printed in one line
			contact.firstName = (contact.firstName + " " + contact.lastName).trim();
			contact.lastName = "";
		}
		
		// Read contacts from Print Phones page
		app.navigateTo().printPhonesPage();
		List<ContactData> printedContactList = app.getContactHelper().readContactsFromTable();
		app.driver.navigate().back();
		
		// Compare lists
		assertThat(printedContactList, equalTo(contactList));
	}
}
