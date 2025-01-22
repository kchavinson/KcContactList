/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    // TODO: Create your array contacts
    private ArrayList<Person> contacts; // ArrayList to store contacts

    // TODO: Write a Constructor
    public ContactList()
    {
        contacts = new ArrayList<Person>();
    }

    public void printMenuOptions()
    {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    // TODO: Modify the return type of this method
    public ArrayList<Person> getContacts()
    {
        return contacts;
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact()
    {
        // TODO: Complete the addContact method
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Contact Type (1 for Student, 2 for Athlete): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        // Get Name and Phonenumber
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        // Add a Student
        if (choice == 1)
        {
            System.out.print("Enter Grade: ");
            int grade = scanner.nextInt();
            scanner.nextLine();
            contacts.add(new Student(firstName, lastName, phoneNumber, grade));
        }
        // Add an Athlete
        else if (choice == 2)
        {
            System.out.print("Enter a Sport: ");
            String sportName = scanner.nextLine();
            contacts.add(new Athlete(firstName, lastName, phoneNumber, sportName));
        }
        else
        {
            System.out.println("Invalid Contact Type. Contact not added.");
        }
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts()
    {
        // TODO: Complete the printContacts method
        for (Person contact : contacts)
        {
            System.out.println(contact);
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy)
    {
        // TODO: Complete the sort method
        for (int i = 0; i < contacts.size() - 1; i++) {
            for (int j = 0; j < contacts.size() - i - 1; j++) {

                // Sort by firstName
                if (sortBy == 0)
                {
                    if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0)
                    {
                        this.swap(j);
                    }
                }

                // Sort by lastName
                else if (sortBy == 1)
                {
                    if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0)
                    {
                        this.swap(j);
                    }
                }

                // Sort by phoneNumber
                else if (sortBy == 2)
                {
                    if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0)
                    {
                        this.swap(j);
                    }
                }
            }
        }
    }

    // New swap method for abstraction and efficiency
    public void swap(int index)
    {
        Person temp = contacts.get(index);
        contacts.set(index, contacts.get(index + 1));
        contacts.set(index + 1, temp);
    }

    // TODO: Write searchByFirstName
    public Person searchByFirstName(String firstName)
    {
        for (Person contact : contacts)
        {
            if (contact.getFirstName().equals(firstName))
            {
                return contact;
            }
        }
        return null;
    }

    // TODO: Write searchByLastName
    public Person searchByLastName(String lastName)
    {
        for (Person contact : contacts)
        {
            if (contact.getLastName().equals(lastName))
            {
                return contact;
            }
        }
        return null;
    }

    // TODO: Write searchByPhoneNumber
    public Person searchByPhoneNumber(String phoneNumber)
    {
        for (Person contact : contacts)
        {
            if (contact.getPhoneNumber().equals(phoneNumber))
            {
                return contact;
            }
        }
        return null;
    }

    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents()
    {
        // TODO: Complete the listStudents method
        for (Person contact : contacts)
        {
            if (contact instanceof Student)
            {
                System.out.println(contact);
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        // TODO: Complete the run method
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        System.out.println("Welcome to your Contacts List");
        while (choice != 0)
        {
            System.out.println("Please pick from the following menu options:");
            printMenuOptions();

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            // Add Contact
            if (choice == 1)
            {
                addContact();
            }

            // List All Contacts By First Name
            else if (choice == 2)
            {
                sort(0);
                printContacts();
            }

            // List All Contacts By Last Name
            else if (choice == 3)
            {
                sort(1);
                printContacts();
            }

            // List All Contacts By Phone Number
            else if (choice == 4)
            {
                sort(2);
                printContacts();
            }

            // List All Students
            else if (choice == 5)
            {
                listStudents();
            }

            // Search By First Name
            else if (choice == 6)
            {
                System.out.print("Enter a first name: ");
                String firstName = scanner.nextLine();
                if (searchByFirstName(firstName) == null)
                {
                    System.out.println(firstName + " is not in the list.");
                }
                else
                {
                    System.out.println(searchByFirstName(firstName));
                }
            }

            // Search By Last Name
            else if (choice == 7)
            {
                System.out.print("Enter a last name: ");
                String lastName = scanner.nextLine();
                if (searchByLastName(lastName) == null)
                {
                    System.out.println(lastName + " is not in the list.");
                }
                else
                {
                    System.out.println(searchByLastName(lastName));
                }
            }

            // Search By Phone Number
            else if (choice == 8)
            {
                System.out.print("Enter a phone number: ");
                String phoneNumber = scanner.nextLine();
                if (searchByPhoneNumber(phoneNumber) == null)
                {
                    System.out.println(phoneNumber + " is not in the list.");
                }
                else
                {
                    System.out.println(searchByPhoneNumber(phoneNumber));
                }            }

            // User exit
            else if (choice == 0)
            {
                System.out.println("Done with da program");
            }
            else
            {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args)
    {
        // Create new contactlist and run the program
        ContactList cl = new ContactList();
        cl.run();
    }
}
