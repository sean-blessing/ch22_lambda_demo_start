package nolambda;

import java.util.ArrayList;

import business.Contact;

public class ContactApp {

	public static void main(String[] args) {
			System.out.println("Welcome to the ContactApp (No Lambda version)!\n");
			
			// Create a list of contacts
			ArrayList<Contact> contacts = new ArrayList<>();
			contacts.add(new Contact("John Doe", "john.doe@foo.com", "513-222-3333"));
			contacts.add(new Contact("Bill Smith", "bill.smith@foo.com", null));
			contacts.add(new Contact("Harvey Boogenheimer", "harvey.boogenheimer@foo.com", "513-555-6666"));
			contacts.add(new Contact("Bob Marley", null, null));
			contacts.add(new Contact("Wonder Woman", "ggadot@ww.com", null));
			
			System.out.println("Contacts without email address:");
			ArrayList<Contact> noEmailContacts = filterContactsWithoutEmail(contacts);
			for (Contact c: noEmailContacts) {
				System.out.println(c);
			}
			System.out.println();
			
			System.out.println("Contacts without phoneNumbers:");
			ArrayList<Contact> noPhoneContacts = filterContactsWithoutPhone(contacts);
			for (Contact c: noPhoneContacts) {
				System.out.println(c);
			}
			System.out.println();
			System.out.println("bye!");

	}
	
	private static ArrayList<Contact> filterContactsWithoutEmail(ArrayList<Contact> contacts) {
		ArrayList<Contact> contactsNoEmail = new ArrayList<>();
		for (Contact c: contacts) {
			if (c.getEmail()==null) {
				contactsNoEmail.add(c);
			}
		}
		return contactsNoEmail;
	}

	private static ArrayList<Contact> filterContactsWithoutPhone(ArrayList<Contact> contacts) {
		ArrayList<Contact> contactsNoEmail = new ArrayList<>();
		for (Contact c: contacts) {
			if (c.getPhone()==null) {
				contactsNoEmail.add(c);
			}
		}
		return contactsNoEmail;
	}
}
