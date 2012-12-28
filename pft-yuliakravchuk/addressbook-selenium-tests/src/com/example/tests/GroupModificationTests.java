package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group) {
		// Save old state
		SortedListOf<GroupData> oldGroupList = app.getGroupHelper().getGroups();
		
		// Actions
		Random rnd = new Random();
		int index = rnd.nextInt(oldGroupList.size() - 1);
		
		app.getGroupHelper().modifyGroup(index, group);
		
		// Save new state
		SortedListOf<GroupData> newGroupList = app.getGroupHelper().getGroups();
						
		// Compare states
		assertThat(newGroupList, equalTo(oldGroupList.without(index).withAdded(group)));	
	}
}
