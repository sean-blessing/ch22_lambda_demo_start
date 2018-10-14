package function;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import business.Contact;

public class ContactAppFunction {

	public static void main(String[] args) {
			System.out.println("Welcome to the ContactApp (Consumer version)!\n");
			
			// Create a list of contacts
			ArrayList<Contact> contacts = new ArrayList<>();
			contacts.add(new Contact("John Doe", "john.doe@foo.com", "513-222-3333"));
			contacts.add(new Contact("Bill Smith", "bill.smith@foo.com", null));
			contacts.add(new Contact("Harvey Boogenheimer", "harvey.boogenheimer@foo.com", "513-555-6666"));
			contacts.add(new Contact("Bob Marley", null, null));
			contacts.add(new Contact("Wonder Woman", "ggadot@ww.com", null));
			
			System.out.println("List of name and phone numbers:");
			ArrayList<String> strings = transformContacts(contacts, c-> {
				String phone = (c.getPhone()==null)?"N/A":c.getPhone();
				return c.getName()+": "+phone;
			});
			for (String s: strings) {
				System.out.println(s);
			}
			System.out.println();
			System.out.println("bye!");
	}
	
	private static ArrayList<String> transformContacts(ArrayList<Contact> contacts, 
								Function<Contact, String> function) {
		ArrayList<String> strings = new ArrayList<>();
		for (Contact c: contacts) {
			strings.add(function.apply(c));
		}
		return strings;
	}
}
