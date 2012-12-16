package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {
		app.getNavigationHelper().openMainPage();		
		app.getNavigationHelper().gotoGroupsPage();
		
		// Save old state
		List<GroupData> oldGroupList = app.getGroupHelper().getGroups();
		
		// Actions		
		app.getGroupHelper().initNewGroupCreation();
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returnToGroupPage();
		
		// Save new state
		List<GroupData> newGroupList = app.getGroupHelper().getGroups();
		
		// Compare states
		oldGroupList.add(group);
		Collections.sort(oldGroupList);
		assertEquals(newGroupList, oldGroupList);
	}	
}
