package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("732 123 2389");

    public static void main(String[] args) {
        startPhone();
        printActions();
        boolean quit = false;
        while (!quit){
            System.out.println("\nEnter action: (6 to show available actions)");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;

                case 1:
                    mobilePhone.printContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    queryContact();
                    break;

                case 6:
                    printActions();
                    break;

            }
        }

    }
    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shutdown\n" +
                "1  - to print contacts\n" +
                "2  - to add a new contact\n" +
                "3  - to update an existing contact\n" +
                "4  - to remove an existing contact\n" +
                "5  - query if an existing contact exists\n" +
                "6  - to print a list of available actions.");
    }
    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void addNewContact(){
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter number");
        String number = scanner.nextLine();
        Contact contact = Contact.createContact(name, number);
        mobilePhone.addNewContact(contact);
    }

    public static void updateContact(){
        System.out.println("What is the name of the contact you want to update");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Enter new Contact name");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact number");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName,newNumber);
        mobilePhone.updateContact(existingContact, newContact);
    }

    public static void removeContact(){
        System.out.println("What is the name of the contact you want to remove");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact == null) {
            System.out.println("Contact not found.");
            return;
        }
        mobilePhone.removeContact(existingContact);
    }
    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Name: " + existingContactRecord.getName() + " phone number is " + existingContactRecord.getPhoneNumber());
    }

}