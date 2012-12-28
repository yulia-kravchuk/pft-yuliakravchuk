package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationWithValidData(GroupData group) throws Exception {		
		// Save old state
		SortedListOf<GroupData> oldGroupList = app.getGroupHelper().getGroups();
		
		// Actions		
		app.getGroupHelper().createGroup(group);
		
		// Save new state
		SortedListOf<GroupData> newGroupList = app.getGroupHelper().getGroups();
		
		// Compare states
		assertThat(newGroupList, equalTo(oldGroupList.withAdded(group)));
	}	
}
