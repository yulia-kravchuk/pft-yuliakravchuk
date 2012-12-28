package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.firstName);
		type(By.name("lastname"), contact.lastName);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.homePhone);
		type(By.name("mobile"), contact.mobilePhone);
		type(By.name("work"), contact.workPhone);
		type(By.name("email"), contact.email);
		type(By.name("email2"), contact.email2);		
		selectByIndex(By.name("bday"), contact.bDay);
		selectByIndex(By.name("bmonth"), contact.bMonth);		
		type(By.name("byear"), contact.bYear);
		if (formType == CREATION) {
			//selectByText(By.name("new_group"), contact.groupName);
		} else {
			if (driver.findElements(By.name("new_group")).size() != 0) {
				throw new Error("Group selector exists in Contact modification form");
			}
		}
		type(By.name("address2"), contact.address2);
		type(By.name("phone2"), contact.phone2);
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void initContactModification(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index + 1) + "]"));
	}

	public void submitContactModification() {
		click(By.xpath("//input[@name='update'][@value='Update']"));
	}

	public void deleteContact(int index) {
		initContactModification(index);
		click(By.xpath("//input[@name='update'][@value='Delete']"));
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> lines = findElementsWait(By.xpath("//tr[@name='entry']"));
		for (WebElement line : lines) {
			ContactData contact = new ContactData();
			contact.firstName = line.findElement(By.xpath("td[2]")).getText();
			contact.lastName = line.findElement(By.xpath("td[3]")).getText();
			contact.email = line.findElement(By.xpath("td[4]/a")).getText();
			contact.homePhone = line.findElement(By.xpath("td[5]")).getText();
			contacts.add(contact);
		}
		return contacts;
	}

}
