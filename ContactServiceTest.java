package com.contactservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactServiceTest {
// Setup for test
	String new_id = "123456";
	String new_firstName = "Ellen";
	String new_lastName = "Takada";
	String new_phoneNumber = "1234567890";
	String new_address = "Houston, TX";
	
	ContactService new_contactservice = new ContactService();
	Contact contact1 = new_contactservice.newContact(new_id, new_firstName, new_lastName, new_phoneNumber, new_address);

	@Test
	void ContactTest() {
		// set First Name
		new_contactservice.setFirstName(new_id, "Karen");
		assertEquals("Karen", new_contactservice.getContactInfo(new_id,"firstName"));
		// set Last Name
		new_contactservice.setLastName(new_id, "Brown");
		assertEquals("Brown", new_contactservice.getContactInfo(new_id,"lastName"));
		// set Phone Number
		new_contactservice.setPhoneNumber(new_id, "0987654321");
		assertEquals("0987654321", new_contactservice.getContactInfo(new_id,"phoneNumber"));
		// set Address
		new_contactservice.setAddress(new_id, "San Francisco, CA");
		assertEquals("San Francisco, CA", new_contactservice.getContactInfo(new_id,"address"));
	}
	
	@Test
	void ContactInvalidIDTest() {
		// create a duplicated contact
		Contact contact2 = new_contactservice.newContact(new_id, new_firstName, new_lastName, new_phoneNumber, new_address);
		System.out.println(new_contactservice.getSize());
	}

	@AfterEach
	void DeleteContactTest() {
		// delete contact1
		new_contactservice.deleteContact(new_id);
		assertEquals("Not Found.", new_contactservice.getContactInfo(new_id,"address"));
		System.out.println(new_contactservice.getSize());
	}
}
