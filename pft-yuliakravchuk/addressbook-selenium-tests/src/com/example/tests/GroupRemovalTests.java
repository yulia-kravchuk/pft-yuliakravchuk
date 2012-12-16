package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {
	@Test
	public void deleteSomeGroup() {
		app.getNavigationHelper().openMainPage();		
		app.getNavigationHelper().gotoGroupsPage();
		
		// Save old state
		List<GroupData> oldGroupList = app.getGroupHelper().getGroups();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldGroupList.size() - 1);
				
		// Actions
		app.getGroupHelper().deleteGroup(index);
		app.getGroupHelper().returnToGroupPage();
		
		// Save new state
		List<GroupData> newGroupList = app.getGroupHelper().getGroups();
						
		// Compare states
		oldGroupList.remove(index);
		Collections.sort(oldGroupList);
		assertEquals(newGroupList, oldGroupList);		
	}
}
