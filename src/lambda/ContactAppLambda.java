package lambda;

import java.util.ArrayList;

import business.Contact;

public class ContactAppLambda {

	public static void main(String[] args) {
			System.out.println("Welcome to the ContactApp (Lambda version)!\n");
			
			// Create a list of contacts
			ArrayList<Contact> contacts = new ArrayList<>();
			contacts.add(new Contact("John Doe", "john.doe@foo.com", "513-222-3333"));
			contacts.add(new Contact("Bill Smith", "bill.smith@foo.com", null));
			contacts.add(new Contact("Harvey Boogenheimer", "harvey.boogenheimer@foo.com", "513-555-6666"));
			contacts.add(new Contact("Bob Marley", null, null));
			contacts.add(new Contact("Wonder Woman", "ggadot@ww.com", null));
			
			System.out.println("Contacts without email address:");
			ArrayList<Contact> noEmailContacts = filterContacts(contacts, c -> c.getEmail()==null);
			for (Contact c: noEmailContacts) {
				System.out.println(c);
			}
			System.out.println();
			
			System.out.println("Contacts without phoneNumbers:");
			ArrayList<Contact> noPhoneContacts = filterContacts(contacts, ct -> ct.getPhone()==null);
			for (Contact c: noPhoneContacts) {
				System.out.println(c);
			}
			System.out.println();
			System.out.println("bye!");

	}
	
	private static ArrayList<Contact> filterContacts(ArrayList<Contact> contacts, TestContact condition) {
		ArrayList<Contact> filteredContacts = new ArrayList<>();
		for (Contact c: contacts) {
			if (condition.test(c)) {
				filteredContacts.add(c);
			}
		}
		return filteredContacts;
	}
}
