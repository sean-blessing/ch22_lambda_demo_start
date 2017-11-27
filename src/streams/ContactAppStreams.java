package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import business.Contact;

public class ContactAppStreams {

	public static void main(String[] args) {
			System.out.println("Welcome to the ContactApp (Consumer version)!\n");
			
			// Create a list of contacts
			ArrayList<Contact> contacts = new ArrayList<>();
			contacts.add(new Contact("John Doe", "john.doe@foo.com", "513-222-3333"));
			contacts.add(new Contact("Bill Smith", "bill.smith@foo.com", null));
			contacts.add(new Contact("Harvey Boogenheimer", "harvey.boogenheimer@foo.com", "513-555-6666"));
			contacts.add(new Contact("Bob Marley", null, null));
			contacts.add(new Contact("Wonder Woman", "ggadot@ww.com", null));
			
			System.out.println("Stream the list of concacts and filter by those with no phone"
					+ "number, printing only the name field:");
			contacts.stream().filter(c->c.getPhone()==null).
								forEach(c->System.out.println(c.getName()));
			System.out.println();
			
			System.out.println("Collector.... get all contacts w/ no phone");
			List<Contact> contactsNoPhone = contacts.stream().filter(c->c.getPhone()==null).
					collect(Collectors.toList());
			System.out.println("There are "+contactsNoPhone.size()+" contacts w/ no phone.");
			System.out.println();
			
			System.out.println("mapping a list, streaming the output");
			List<String> contactNames = contacts.stream().map(c->c.getName()).
					collect(Collectors.toList());
			contactNames.stream().forEach(str->System.out.println(str));
			
			System.out.println("mapping a list, streaming the output - double colon operator");
			List<String> contactNames2 = contacts.stream().map(Contact::getName).
					collect(Collectors.toList());
			contactNames2.stream().forEach(System.out::println);
			
			System.out.println("bye!");
	}
	

}
