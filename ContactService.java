package com.contactservice;

import java.util.ArrayList;
import java.util.List;

import com.contactservice.Contact;

/**
 * Application start-up program
 * 
 * @Ellen Takada, ellen.takada@snhu.edu
 */


public class ContactService {
	//Array of contacts 
	private static List<Contact> contacts = new ArrayList<Contact>();

	private ContactService new_contact;
	
	public ContactService() {
	}
	

	// return contact in contacts
	Contact getContact(int index) {
		return contacts.get(index);
	}
	
	int getSize() {
		return contacts.size();
	}
	
	String getContactInfo(String id, String type) {
		for (int i = 0; i < contacts.size(); ++i) {
			Contact curr_contact = contacts.get(i);
			String curr_id = curr_contact.getId();
			// if matching id is found, set
			if (id.equals(curr_id)) {
				if (type.equals("firstName")) {
					return curr_contact.getFirstName();
				}
				else if (type.equals("lastName")) {
					return curr_contact.getLastName();
				}
				else if (type.equals("phoneNumber")) {
					return curr_contact.getPhoneNumber();
				}
				else if (type.equals("address")) {
					return curr_contact.getAddress();
				}
			}
		}
		return "Not Found.";
	}
		
	
	public Contact newContact(String new_id, String new_fname, String new_lname, String new_phone, String new_address) {
	
		Contact contact = null;
		// ID INPUT
		for (int i = 0; i < contacts.size(); ++i) {
			Contact curr_contact = contacts.get(i);
			String curr_id = curr_contact.getId();
			// check for duplicate, null and over 10 characters
			if (new_id.equals(curr_id) || new_id.equals(null) || new_id.length() > 10) {
				System.out.println("Invalid ID.");
				return curr_contact;
			}
		}
		
		contact = new Contact(new_id);
		boolean tempFirstName = contact.setFirstName(new_fname);
		boolean tempLastName = contact.setLastName(new_lname);
		boolean tempPhoneNumber = contact.setPhoneNumber(new_phone);
		boolean tempAddress = contact.setAddress(new_address);
		if (tempFirstName == true && tempLastName == true && tempPhoneNumber == true && tempAddress == true) {
			contacts.add(contact);
		}
		return contact;
	}
	
	public void setFirstName(String id, String fName) {
		for (int i = 0; i < contacts.size(); ++i) {
			Contact curr_contact = contacts.get(i);
			String curr_id = curr_contact.getId();
			// if matching id is found, set
			if (id.equals(curr_id)) {
				curr_contact.setFirstName(fName);
			}
		}
	}
	
	public void setLastName(String id, String lName) {
		for (int i = 0; i < contacts.size(); ++i) {
			Contact curr_contact = contacts.get(i);
			String curr_id = curr_contact.getId();
			// if matching id is found, set
			if (id.equals(curr_id)) {
				curr_contact.setLastName(lName);
			}
		}
	}
	
	public void setPhoneNumber(String id, String pNumber) {
		for (int i = 0; i < contacts.size(); ++i) {
			Contact curr_contact = contacts.get(i);
			String curr_id = curr_contact.getId();
			// if matching id is found, set
			if (id.equals(curr_id)) {
				curr_contact.setPhoneNumber(pNumber);
			}
		}
	}
	
	public void setAddress(String id, String address) {
		for (int i = 0; i < contacts.size(); ++i) {
			Contact curr_contact = contacts.get(i);
			String curr_id = curr_contact.getId();
			// if matching id is found, set
			if (id.equals(curr_id)) {
				curr_contact.setAddress(address);
			}
		}
	}
	
	public void deleteContact(String id) {
		for (int i = 0; i < contacts.size(); ++i) {
			Contact curr_contact = contacts.get(i);
			String curr_id = curr_contact.getId();
			// if matching id is found, the contact is deleted
			if (id.equals(curr_id)) {
				contacts.remove(curr_contact);
			}
		}
	}
}