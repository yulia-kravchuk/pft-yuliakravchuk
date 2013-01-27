package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	public String firstName;
	public String lastName;
	public String address;
	public String homePhone;
	public String mobilePhone;
	public String workPhone;
	public String email;
	public String email2;
	public int bDay;
	public int bMonth;
	public String bYear;
	public String groupName;
	public String address2;
	public String phone2;

	public ContactData() {		
	}
	
	public ContactData(String firstName, String lastName, String address,
			String homePhone, String mobilePhone, String workPhone,
			String email, String email2, int bDay, int bMonth,
			String bYear, String groupName, String address2, String phone2) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.email = email;
		this.email2 = email2;
		this.bDay = bDay;
		this.bMonth = bMonth;
		this.bYear = bYear;
		this.groupName = groupName;
		this.address2 = address2;
		this.phone2 = phone2;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((homePhone == null) ? 0 : homePhone.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (getDisplayedEmail() == null) {
			if (other.getDisplayedEmail() != null)
				return false;
		} else if (!getDisplayedEmail().equals(other.getDisplayedEmail()))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (getDisplayedPhone() == null) {
			if (other.getDisplayedPhone() != null)
				return false;
		} else if (!getDisplayedPhone().replaceAll("[ ]", "").equals(other.getDisplayedPhone().replaceAll("[ ]", "")))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		if ( ! this.lastName.toLowerCase().equals(other.lastName.toLowerCase())) {	
			return this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
		}
		return this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
	}

	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + getDisplayedEmail()
				+ ", phone=" + getDisplayedPhone() + "]";
	}
	
	public String toStringAllFields() {
		return firstName + "," 
				+ lastName + ","
				+ address + ","
				+ homePhone + ","
				+ mobilePhone + ","
				+ workPhone + ","
				+ email + ","
				+ email2 + ","
				+ bDay + ","
				+ bMonth + ","
				+ bYear + ","
				+ groupName + ","
				+ address2 + ","
				+ phone2;
	}

	String getDisplayedEmail() {
		return (!(email == null || email.isEmpty())) ? email : (email2 == null ? "" : email2);
	}

	String getDisplayedPhone() {		
		if (!(homePhone == null || homePhone.isEmpty())) {
			return homePhone.replaceAll("[ ]", "");
		} 
		if (!(mobilePhone == null || mobilePhone.isEmpty())) {
			return mobilePhone.replaceAll("[ ]", "");			
		} 	
		return workPhone == null ? "" : workPhone.replaceAll("[ ]", "");
	}

	public ContactData copyFrom(ContactData sample) {
		this.firstName = sample.firstName;
		this.lastName = sample.lastName;
		this.address = sample.address;
		this.homePhone = sample.homePhone;
		this.mobilePhone = sample.mobilePhone;
		this.workPhone = sample.workPhone;
		this.email = sample.email;
		this.email2 = sample.email2;
		this.bDay = sample.bDay;
		this.bMonth = sample.bMonth;
		this.bYear = sample.bYear;
		this.groupName = sample.groupName;
		this.address2 = sample.address2;
		this.phone2 = sample.phone2;
		return this;
	}
	
	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}
	
	public ContactData withHomePhone(String homePhone) {
		this.homePhone = homePhone;
		return this;
	}
	
	public ContactData withMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}
	
	public ContactData withWorkPhone(String workPhone) {
		this.workPhone = workPhone;
		return this;
	}
	
	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}
	
	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}
	
	public ContactData withBDay(int bDay) {
		this.bDay = bDay;
		return this;
	}
	
	public ContactData withBMonth(int bMonth) {
		this.bMonth = bMonth;
		return this;
	}
	
	public ContactData withBYear(String bYear) {
		this.bYear = bYear;
		return this;
	}
	
	public ContactData withGroupName(String groupName) {
		this.groupName = groupName;
		return this;
	}
	
	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}
	
	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}
	
//---------------------------------------------	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getHomePhone() {
		return homePhone;
	}
	
	public String getMobilePhone() {
		return mobilePhone;
	}
	
	public String getWorkPhone() {
		return workPhone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getEmail2() {
		return email2;
	}
	
	public int getBDay() {
		return bDay;
	}
	
	public int getBMonth() {
		return bMonth;
	}
	
	public String getBYear() {
		return bYear;
	}
	
	public String getGroupName() {
		return groupName;
	}
	
	public String getAddress2() {
		return address2;
	}
	
	public String getPhone2() {
		return phone2;
	}
}