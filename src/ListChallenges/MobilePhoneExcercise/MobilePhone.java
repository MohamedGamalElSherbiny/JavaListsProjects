package ListChallenges.MobilePhoneExcercise;

import java.util.Scanner;

public class MobilePhone {

    private static final Scanner scanner = new Scanner(System.in);

    private static final ContactList contactList = new ContactList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    contactList.readContactList();
                    printInstructions();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
        scanner.close();
    }

    private static void printInstructions(){
        System.out.println("\n Press: ");
        System.out.println("\t 0- To print choice options.");
        System.out.println("\t 1- To print your contacts list.");
        System.out.println("\t 2- To add a contact.");
        System.out.println("\t 3- To modify a contact.");
        System.out.println("\t 4- To remove a contact.");
        System.out.println("\t 5- To search for contact.");
        System.out.println("\t 6- To quit the application.");
    }

    private static void addItem(){
        System.out.println("Please enter name of contact: ");
        String name = scanner.nextLine();
        System.out.println("Please enter phone number of the contact: ");
        String phoneNumber = scanner.nextLine();
        checkMark(contactList.addContact(name, phoneNumber));
    }

    private static void modifyItem(){
        System.out.println("Please enter name of the old contact: ");
        String oldContact = scanner.nextLine();
        System.out.println("Please enter phone number of the old contact: ");
        String oldPhoneNumber = scanner.nextLine();
        System.out.println("Please enter the new name: ");
        String newContact = scanner.nextLine();
        System.out.println("Please enter phone number of the new contact: ");
        String newPhoneNumber = scanner.nextLine();
        checkMark(contactList.modifyContact(oldContact, oldPhoneNumber, newContact, newPhoneNumber));
    }

    private static void removeItem(){
        System.out.println("Please enter the name of contact to be removed: ");
        String contactName = scanner.nextLine();
        System.out.println("Please enter phone number of the contact: ");
        String phoneNumber = scanner.nextLine();
        checkMark(contactList.removeContact(contactName, phoneNumber));
    }

    private static void searchItem(){
        System.out.println("Please enter the name of the contact to be searched for: ");
        String contactName = scanner.nextLine();
        System.out.println("Please enter phone number of the contact: ");
        String phoneNumber = scanner.nextLine();
        contactList.onList(contactName, phoneNumber);
        printInstructions();
    }

    private static void checkMark(boolean flag){
        if(flag) System.out.println("Completed!");
        else System.out.println("Failed!");
        printInstructions();
    }
}
