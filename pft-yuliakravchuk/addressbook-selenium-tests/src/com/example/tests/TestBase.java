package com.example.tests;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;
	protected int modifyGroupsAmount;
	protected int modifyContactsAmount;

	@BeforeTest
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile", "application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);	
		modifyGroupsAmount = Integer.parseInt(properties.getProperty("modifyGroupsAmount"));
		modifyContactsAmount = Integer.parseInt(properties.getProperty("modifyContactsAmount"));
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	}

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wrapGroupsForDataProvider(generateRandomGroups(modifyGroupsAmount)).iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		return wrapContactsForDataProvider(generateRandomContacts(modifyContactsAmount)).iterator();
	}

	public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[]{group});
		}
		return list;
	}
	
	public static List<Object[]> wrapContactsForDataProvider(List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactData contact : contacts) {
			list.add(new Object[]{contact});
		}
		return list;
	}
	
	public static String generateRandomString() {
	    Random rnd = new Random();
	    if (rnd.nextInt(3) == 0) {
	            return "";
	    } else {
	            return "test" + rnd.nextInt();
	    }
	}

	public static int generateRandomInt(int d) {
		Random rnd = new Random();		
		return rnd.nextInt(d);	
	}
}
