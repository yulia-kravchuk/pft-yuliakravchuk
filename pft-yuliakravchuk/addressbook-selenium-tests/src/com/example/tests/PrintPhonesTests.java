package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class PrintPhonesTests extends TestBase {
	@Test
	public void testPrintPhonesAll() {
		// Save all displayed contacts
		List<ContactData> contactList = new ArrayList<ContactData>();
		
		// In this case changing contactList causes changing cachedContacts
		//contactList = app.getContactHelper().getContacts();
		
		List<ContactData> contactList0 = app.getContactHelper().getContacts();
		
		for (ContactData contact0 : contactList0) {
			// contactList.add(contact0); // this also causes changing cachedContacts
			ContactData contact = new ContactData();
			contact.copyFrom(contact0);
			contactList.add(contact);
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
		List<ContactData> printedContactList = new ArrayList<ContactData>();
		List<WebElement> cells = app.driver.findElements(By.xpath("//table[@id='view']//tr//td"));
		
		for (WebElement cell : cells) {
			if (cell.getText().equals(".")) {
				break;
			}
			// Split cell text into rows
			String[] rows = cell.getText().split(":\\s[HMW]:\\s|\\s[MW]:\\s|\\s?:?\\sBirthday|\\s?:?\\sP|:");
			ContactData contact = new ContactData();			
			// Parse First Name and Last Name
			contact.lastName = ""; // because First Name and Last Name were merged in one field
			if (rows.length == 0) {
				contact.firstName = "";
				contact.homePhone = "";
				printedContactList.add(contact);
				continue;
			} 
			contact.firstName = rows[0].trim();
			
			// Parse displayed phone number
			if ((rows.length == 1) || // no data except names are specified
					(rows[1].startsWith(":"))) { // line contains Birthday or Phone 2 info
				contact.homePhone = "";
			} else {
				contact.homePhone = rows[1];
			}			
			printedContactList.add(contact);
		}
		app.driver.navigate().back();
		
		// Compare lists
		assertThat(printedContactList, equalTo(contactList));
	}
}
