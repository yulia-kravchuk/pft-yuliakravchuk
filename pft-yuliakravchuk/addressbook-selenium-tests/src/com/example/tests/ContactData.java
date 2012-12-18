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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (homePhone == null) {
			if (other.homePhone != null)
				return false;
		} else if (!homePhone.equals(other.homePhone))
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
		if (this.lastName.toLowerCase().equals(other.lastName.toLowerCase())) {				
			return this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
		} 
		return this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());	
	}

	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", homePhone=" + homePhone + "]";
	}

	String getDisplayedEmail() {
		return (!email.isEmpty()) ? email : email2;
	}

	String getDisplayedPhone() {		
		if (!homePhone.isEmpty()) {
			return homePhone;
		} 
		if (!mobilePhone.isEmpty()) {
			return mobilePhone;			
		} 	
		return workPhone;
	}
}