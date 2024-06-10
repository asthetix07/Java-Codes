
import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;
    String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}

class AddressBook {
    ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void displayContacts() {
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.name + ", Phone: " + contact.phoneNumber + ", Email: " + contact.email);
        }
    }

    public void searchContact(String searchTerm) {
        for (Contact contact : contacts) {
            if (contact.name.contains(searchTerm)|| contact.phoneNumber.contains(searchTerm)||  contact.email.contains(searchTerm)) {
                System.out.println("Name: " + contact.name + ", Phone: " + contact.phoneNumber + ", Email: " + contact.email);
            }
        }
    }

    public void removeContact(String contactName) {
        contacts.removeIf(contact -> contact.name.equals(contactName));
    }
}

public class AddressBookApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("1. Add Contact\n2. Display Contacts\n3. Search Contact\n4. Remove Contact\n5. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter contact name:");
                    String name = scanner.next();
                    System.out.println("Enter phone number:");
                    String phoneNumber = scanner.next();
                    System.out.println("Enter email:");
                    String email = scanner.next();
                    Contact newContact = new Contact(name, phoneNumber, email);
                    addressBook.addContact(newContact);
                    break;

                case 2:
                    addressBook.displayContacts();
                    break;

                case 3:
                    System.out.println("Enter search term:");
                    String searchTerm = scanner.next();
                    addressBook.searchContact(searchTerm);
                    break;

                case 4:
                    System.out.println("Enter contact name to remove:");
                    String contactNameToRemove = scanner.next();
                    addressBook.removeContact(contactNameToRemove);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}