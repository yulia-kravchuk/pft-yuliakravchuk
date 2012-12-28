package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestBase {
	@Test
	public void deleteSomeGroup() {
		// Save old state
		SortedListOf<GroupData> oldGroupList = app.getGroupHelper().getGroups();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldGroupList.size() - 1);
				
		// Actions
		app.getGroupHelper().deleteGroup(index);
		
		// Save new state
		SortedListOf<GroupData> newGroupList = app.getGroupHelper().getGroups();
						
		// Compare states
		assertThat(newGroupList, equalTo(oldGroupList.without(index)));
	}
}
