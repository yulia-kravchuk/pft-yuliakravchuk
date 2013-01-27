package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	}

	@Test(dataProvider = "groupsFromFile")
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
