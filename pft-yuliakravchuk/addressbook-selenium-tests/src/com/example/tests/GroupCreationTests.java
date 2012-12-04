package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	
	@Test
	public void testNonEmptyGroupCreation() throws Exception {
		openMainPage();		
		gotoGroupsPage();
		initNewGroupCreation();
		GroupData group = new GroupData();
		group.name = "test group 1";
		group.header = "Header 1";
		group.footer = "Comment 1";
		fillGroupForm(group);
		submitGroupForm();
		returnToGroupPage();
	}
	
	@Test
	public void testEmptyGroupCreation() throws Exception {
		openMainPage();		
		gotoGroupsPage();
		initNewGroupCreation();
		fillGroupForm(new GroupData("", "", ""));
		submitGroupForm();
		returnToGroupPage();
	}
}
