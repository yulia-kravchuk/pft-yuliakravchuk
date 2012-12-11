package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstName);
		type(By.name("lastname"), contact.lastName);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.homePhone);
		type(By.name("mobile"), contact.mobilePhone);
		type(By.name("work"), contact.workPhone);
		type(By.name("email"), contact.email);
		type(By.name("email2"), contact.email2);		
		selectByText(By.name("bday"), contact.bDay);
		selectByText(By.name("bmonth"), contact.bMonth);		
		type(By.name("byear"), contact.bYear);
		//selectByText(By.name("new_group"), contact.groupName);	
		type(By.name("address2"), contact.address2);
		type(By.name("phone2"), contact.phone2);
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void initContactModification(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + index + "]"));
	}

	public void submitContactModification() {
		click(By.xpath("//input[@name='update'][@value='Update']"));
	}

	public void deleteContact(int index) {
		initContactModification(index);
		click(By.xpath("//input[@name='update'][@value='Delete']"));
	}

}
