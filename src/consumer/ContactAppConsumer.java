package consumer;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

import business.Contact;

public class ContactAppConsumer {

	public static void main(String[] args) {
			System.out.println("Welcome to the ContactApp (Consumer version)!\n");
			
			// Create a list of contacts
			ArrayList<Contact> contacts = new ArrayList<>();
			contacts.add(new Contact("John Doe", "john.doe@foo.com", "513-222-3333"));
			contacts.add(new Contact("Bill Smith", "bill.smith@foo.com", null));
			contacts.add(new Contact("Harvey Boogenheimer", "harvey.boogenheimer@foo.com", "513-555-6666"));
			contacts.add(new Contact("Bob Marley", null, null));
			contacts.add(new Contact("Wonder Woman", "ggadot@ww.com", null));
			
			System.out.println("Contact Names:");
			processContacts(contacts, c -> System.out.println(c.getName().toUpperCase()));
			System.out.println();
			
			System.out.println("bye!");

	}
	
	private static void processContacts(ArrayList<Contact> contacts, 
								Consumer<Contact> condition) {
		for (Contact c: contacts) {
			condition.accept(c);
		}
	}
}
