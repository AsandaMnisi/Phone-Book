
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Phonebook {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // Lists to store contacts, names, recent calls, and favorites
        ArrayList<String> contacts = new ArrayList<String>();
        ArrayList<String> contactNames = new ArrayList<String>();
        ArrayList<String> recentlyCalled = new ArrayList<String>();
        ArrayList<String> favouriteContacts = new ArrayList<String>();

        // Declare user input variables
        int menuOption;
        char cDialOption = ' ';
        String cellPhoneNumber = "";
        String contactName = "";
        String nameSearch = "";
        String entry = "";

        // Header banner
        System.out.println("\n");
        System.out.println("============================================================================");
        System.out.println("=================================CONTACTS===================================");
        System.out.println("============================================================================");
        System.out.println("\n");

        // Main menu loop
        do {
            System.out.println("1.Dial");
            System.out.println("2.Search Contact");
            System.out.println("3.Contacts");
            System.out.println("4.Favourite Contacts");
            System.out.println("5.Recently Called");
            System.out.println("6.Exit");

            System.out.print("\n>>>Navigate through Contacts:");
            menuOption = keyboard.nextInt();

            // Handle user's menu choice
            switch (menuOption) {
                case 1:
                    // Call a number
                    dial(contacts, recentlyCalled, cellPhoneNumber, cDialOption, menuOption, contactNames, contactName, favouriteContacts);
                    break;
                case 2:
                    // Search for a contact
                    searchPhone(contacts, contactNames, favouriteContacts, recentlyCalled, cellPhoneNumber, nameSearch, entry);
                    break;
                case 3:
                    // View contact list
                    contactList(contactNames, contacts);
                    break;
                case 4:
                    // View favourite contacts
                    favourites(favouriteContacts);
                    break;
                case 5:
                    // View recently called
                    recentCalls(recentlyCalled);
                    break;
                case 6:
                    // Exit program
                    exiting();
                    break;
                default:
                    System.out.print("\n>>>Invalid option!!Please choose again<<<\n");
                    break;
            }
        } while (menuOption != 6);
    }

    // Validate that phone number is exactly 10 digits
    public static boolean isValidNumber(String number) {
        if (number.length() != 10) {
            return false;
        }
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Function to simulate dialing a number
    public static void dial(ArrayList<String> contacts, ArrayList<String> recentlyCalled, String cellPhoneNumber, char cDialOption, int menuOption, ArrayList<String> contactNames, String contactName, ArrayList<String> favouriteContacts) {
        Scanner keyboard = new Scanner(System.in);
        char returnMenu;

        do {
            System.out.print("\n>>>Enter a cellphone number:");
            cellPhoneNumber = keyboard.next();

            if (isValidNumber(cellPhoneNumber)) {
                if (contacts.contains(cellPhoneNumber)) {
                    // If number is already saved, retrieve contact name and dial
                    int index = contacts.indexOf(cellPhoneNumber);
                    System.out.println("\n>>>Calling Number.......");
                    recentlyCalled.add(contactNames.get(index) + "-" + cellPhoneNumber);
                } else {
                    // If number isn't saved, offer to save it before dialing
                    System.out.print("\n>>>This number is not on your contacts<<<\n>>>Do you want to save and call?:");
                    cDialOption = keyboard.next().charAt(0);

                    if (cDialOption == 'y' || cDialOption == 'Y') {
                        System.out.print("\n>>>Enter contact name:");
                        contactName = keyboard.next().toLowerCase();

                        contactNames.add(contactName);
                        contacts.add(cellPhoneNumber);

                        System.out.println("\n>>>Contact added<<<\n");
                        System.out.println(">>>Calling number.....<<<\n");

                        recentlyCalled.add(contactName + "-" + cellPhoneNumber);

                    } else if (cDialOption == 'n' || cDialOption == 'N') {
                        // Call without saving
                        System.out.println(">>>Calling Number......");
                        recentlyCalled.add(cellPhoneNumber);
                    }
                }
            } else {
                System.out.println("\n>>>Invalid Cellphone number<<<\n");
            }

            System.out.print("\n>>>Go back or Exit:");
            returnMenu = keyboard.next().charAt(0);

            System.out.println("\n");

        } while (returnMenu == 'b' || returnMenu == 'B');
    }

    // Function to search contact by name and offer to call or favorite
    public static void searchPhone(ArrayList<String> contacts, ArrayList<String> contactNames, ArrayList<String> favouriteContacts, ArrayList<String> recentlyCalled, String cellPhoneNumber, String nameSearch, String entry) {
        Scanner keyboard = new Scanner(System.in);
        char cSearchAnswer;
        int iSearchOption;
        String favouriteAdd;

        System.out.print("\n>>Enter name you want to search:");
        nameSearch = keyboard.next().toLowerCase();

        if (contactNames.contains(nameSearch)) {
            int index = contactNames.indexOf(nameSearch);
            System.out.print("\nAre you looking for?\"" + nameSearch + "-" + contacts.get(index) + "\"\n");
            cSearchAnswer = keyboard.next().charAt(0);

            if (cSearchAnswer == 'y' || cSearchAnswer == 'Y') {
                System.out.println("\t1.Add to favourite \n\t2.Call?");
                System.out.print("Select option:");
                iSearchOption = keyboard.nextInt();

                if (iSearchOption == 1) {
                    // Add to favorites
                    favouriteAdd = nameSearch + "-" + contacts.get(index);
                    if (!favouriteContacts.contains(favouriteAdd)) {
                        favouriteContacts.add(favouriteAdd);
                        System.out.println("\n>>>Contact added to favourite<<<\n" + favouriteAdd);
                    } else {
                        System.out.println("\n>>>Contact already in favourite<<<\n");
                    }
                } else if (iSearchOption == 2) {
                    // Call the contact
                    entry = nameSearch + "-" + contacts.get(index);
                    if (!recentlyCalled.contains(entry)) {
                        recentlyCalled.add(entry);
                    }
                    System.out.println("\n >>>Calling Contact<<<......\n\n");
                    System.out.println("\t\tBYE...");
                }
            } else {
                System.out.println("\n>>>Contact not found in Favourites<<<\n");
            }
        } else {
            // If not found, offer to add new contact
            System.out.print("\n>>>This name does not exist in your contacts list<<<,\n>>>Do you want to add it?:");
            char cAdd = keyboard.next().charAt(0);

            if (cAdd == 'y' || cAdd == 'Y') {
                System.out.print("\n>>>Enter contact number for name:");
                cellPhoneNumber = keyboard.next();
                if (isValidNumber(cellPhoneNumber)) {
                    contactNames.add(nameSearch);
                    contacts.add(cellPhoneNumber);
                    System.out.println("\n>>>Contact added successfully<<<\n");
                } else {
                    System.out.println("\n>>>Invalid number format<<<\n");
                }
            } else {
                System.out.println("\n>>>No Match found<<<");
            }
        }

        // Sort both lists alphabetically
        Collections.sort(contacts);
        Collections.sort(contactNames);
    }

    // Show list of saved contacts
    public static void contactList(ArrayList<String> contactNames, ArrayList<String> contacts) {
        if (contactNames.isEmpty()) {
            System.out.println("No Contacts found");
        } else {
            System.out.println("\n>>>Name \t\t Number<<<");
            for (int i = 0; i < contactNames.size(); i++) {
                System.out.println(contactNames.get(i) + "\t" + contacts.get(i));
            }
        }
    }

    // Display favorite contacts
    public static void favourites(ArrayList<String> favouriteContacts) {
        System.out.println("\n>>>Favourite Contacts<<<\n");
        if (favouriteContacts.isEmpty()) {
            System.out.println(">>>No Contact Added Yet<<<");
        } else {
            for (int i = 0; i < favouriteContacts.size(); i++) {
                System.out.println(favouriteContacts.get(i));
            }
        }
    }

    // Show recently called numbers
    public static void recentCalls(ArrayList<String> recentlyCalled) {
        System.out.println("\n>>>Recently called contacts<<<\n");

        if (recentlyCalled.isEmpty()) {
            System.out.println(">>>No contact found<<<");
        } else {
            for (int i = 0; i < recentlyCalled.size(); i++) {
                System.out.println(recentlyCalled.get(i));
            }
        }
    }

    // Exit message
    public static void exiting() {
        System.out.println("\n>>>Exiting Contacts<<<\n");
    }
}
