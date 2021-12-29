package com.company;
import java.sql.SQLOutput;
import java.util.ArrayList;
public class MobilePhone {
    private String myNumber;
    private ArrayList <Contact> myContacts;
    // Options:  print list of contacts, add new contact, update existing contact, remove contact
    // and search/find contact.

//    removeContact
    // queryContact

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }
    public void addNewContact(Contact contact){
        if ((findContact(contact.getName()))>=0){
            System.out.println("Contact already in file");
        }else{
            this.myContacts.add(contact);
            System.out.println("Contact Added Successfully");
        }
    }

    public void printContacts(){
        System.out.println("You have " + this.myContacts.size() + " Contacts");
        for(int i = 0; i<this.myContacts.size(); i++){
            System.out.println((i+1) +"."+ this.myContacts.get(i).getName() + " -> " +
                    this.myContacts.get(i).getPhoneNumber());
        }
    }

    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }
    private int findContact(String contactName){
        for (int i = 0; i<this.myContacts.size(); i++){
            if (this.myContacts.get(i).getName().equals(contactName)){
                return i;
            }
        } return -1;
    }
    public void updateContact(Contact currentContact, Contact newContact){
        int position = findContact(currentContact);
        if(findContact(newContact.getName()) != -1){
            System.out.println("Contact with name " + newContact.getName() +
                    " already exists.  Update was not successful.");
        }
        this.myContacts.set(position,newContact);
        System.out.println(currentContact.getName() + ", was replaced with " + newContact.getName());
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if(position >=0) {
            return this.myContacts.get(position);
        }

        return null;
    }
    public void removeContact(Contact contact){
        System.out.println(contact.getName() + " is removed from your contacts");
        this.myContacts.remove(contact);
    }
}
