package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import static com.example.fw.HelperBase.generateRandomInt;
import static com.example.fw.HelperBase.generateRandomString;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please specify parameters: <amount of test data> <file> <format>");
			return;
		}
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()) {
			System.out.println("File \"" + file + "\" already exists. Please remove it manually.");
			return;
		}
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format: " + format);
			return;
		}
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	@SuppressWarnings("unchecked")
	public static List<ContactData> loadContactsFromXmlFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);		
		return (List<ContactData>) xstream.fromXML(file);
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.toStringAllFields() + ",!\n");
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] parts = line.split(",");
			ContactData contact = new ContactData()
				.withFirstName(parts[0])
				.withLastName(parts[1])
				.withAddress(parts[2])
				.withHomePhone(parts[3])
				.withMobilePhone(parts[4])
				.withWorkPhone(parts[5])
				.withEmail(parts[6])
				.withEmail2(parts[7])
				.withBDay(Integer.parseInt(parts[8]))
				.withBMonth(Integer.parseInt(parts[9]))
				.withBYear(parts[10])
				.withGroupName(parts[11])
				.withAddress2(parts[12])
				.withPhone2(parts[13]);
			list.add(contact);			
			line = bufferedReader.readLine();
		}
		
		bufferedReader.close();
		return list;
	}
	
	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++) {
			ContactData contact1 = new ContactData()
			.withFirstName(generateRandomString())
			.withLastName(generateRandomString())
			.withAddress(generateRandomString())
			.withHomePhone(generateRandomString())
			.withMobilePhone(generateRandomString())
			.withWorkPhone(generateRandomString())
			.withEmail(generateRandomString())
			.withEmail2(generateRandomString())
			.withBDay(generateRandomInt(32))
			.withBMonth(generateRandomInt(13))
			.withBYear(String.valueOf(1900 + generateRandomInt(Calendar.getInstance().get(Calendar.YEAR) - 1900)))
			.withGroupName(generateRandomString())
			.withAddress2(generateRandomString())
			.withPhone2(generateRandomString());
			ContactData contact = contact1;
			list.add(contact);
		}
		return list;
	}
}
