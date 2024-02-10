package com.contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {
	// Setup for test
	String new_id = "123456";
	String new_firstName = "Ellen";
	String new_lastName = "Takada";
	String new_phoneNumber = "1234567890";
	String new_address = "Houston, TX";
	
	ContactService new_contactservice = new ContactService();

	@Test
	void assertContactTest() {
		Contact contact1 = new_contactservice.newContact(new_id, new_firstName, new_lastName, new_phoneNumber, new_address);
		// call getter to confirm new_contactservice
		assertAll("new_contactservice", () -> assertEquals("123456", contact1.getId()),
				() -> assertEquals("Ellen", contact1.getFirstName()),
				() -> assertEquals("Takada", contact1.getLastName()),
				() -> assertEquals("1234567890", contact1.getPhoneNumber()),
				() -> assertEquals("Houston, TX", contact1.getAddress()));
		// print out array elements
		System.out.println("Elements in Array: " + new_contactservice.getSize());
	}
	
	@Test
	void udpateContactTest() {
		String new_id = "1234567";
		Contact contact1 = new_contactservice.newContact(new_id, new_firstName, new_lastName, new_phoneNumber, new_address);
		// set First Name
		new_contactservice.setFirstName(new_id, "Karen");
		assertEquals("Karen", contact1.getFirstName());
		// set Last Name
		new_contactservice.setLastName(new_id, "Brown");
		assertEquals("Brown", contact1.getLastName());
		// set Phone Number
		new_contactservice.setPhoneNumber(new_id, "0987654321");
		assertEquals("0987654321", contact1.getPhoneNumber());
		// set Address
		new_contactservice.setAddress(new_id, "San Francisco, CA");
		assertEquals("San Francisco, CA", contact1.getAddress());
		// print out array elements
		System.out.println("Elements in Array: " + new_contactservice.getSize());
	}
	
	@Test
	void unsuccessfulFirstName() {
		String new_id = "1234567";
		String new_firstName = "";
		
		Contact contact1 = new_contactservice.newContact(new_id, new_firstName, new_lastName, new_phoneNumber, new_address);
		// print out array elements
		System.out.println("Elements in Array: " + new_contactservice.getSize());
	}
	
	@Test
	void updateInvalidTest() {
		String new_id = "12345678";
		Contact contact1 = new_contactservice.newContact(new_id, new_firstName, new_lastName, new_phoneNumber, new_address);
		// invalid set First Name, the new value should not update due to exceeded length
		new_contactservice.setFirstName(new_id, "Alexander-Huddson");
		assertNotEquals("Alexander-Huddson", contact1.getFirstName());
		// invalid set Last Name, the new value should not update due to exceeded length
		new_contactservice.setLastName(new_id, "Washington-EverGreat");
		assertNotEquals("Washington-EverGreat", contact1.getLastName());
		// invalid set Phone Number, the new value should not update due to exceeded length
		new_contactservice.setPhoneNumber(new_id, "0987654321123");
		assertNotEquals("0987654321123", contact1.getPhoneNumber());
		// invalid set Address, the new value should not update due to NULL
		new_contactservice.setAddress(new_id, "");
		assertNotEquals("", contact1.getAddress());
		// print out array elements
		System.out.println("Elements in Array: " + new_contactservice.getSize());
	}
	
}
