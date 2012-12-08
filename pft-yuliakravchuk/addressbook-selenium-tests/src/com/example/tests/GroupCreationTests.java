package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	
	@Test
	public void testNonEmptyGroupCreation() throws Exception {
		app.getNavigationHelper().openMainPage();		
		app.getNavigationHelper().gotoGroupsPage();
		app.getGroupHelper().initNewGroupCreation();
		GroupData group = new GroupData();
		group.name = "test group 1";
		group.header = "Header 1";
		group.footer = "Comment 1";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returnToGroupPage();
	}
	
	@Test
	public void testEmptyGroupCreation() throws Exception {
		app.getNavigationHelper().openMainPage();		
		app.getNavigationHelper().gotoGroupsPage();
		app.getGroupHelper().initNewGroupCreation();
		app.getGroupHelper().fillGroupForm(new GroupData(null, null, null));
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returnToGroupPage();
	}
}
