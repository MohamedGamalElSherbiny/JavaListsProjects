package ListChallenges.MobilePhoneExcercise;

import java.util.ArrayList;

public class ContactList {

     private final ArrayList<Contact> contactList = new ArrayList<>();

     public boolean addContact(String name, String phoneNumber){
          Contact contact = new Contact(name, phoneNumber);
          if(isFound(contact)) {
               System.out.println("Contact is already on file.");
               return false;
          }
          contactList.add(contact);
          return true;
     }

     public boolean modifyContact(String oldName, String oldPhoneNumber, String newName, String newPhoneNumber){
          Contact oldContact = new Contact(oldName, oldPhoneNumber);
          Contact newContact = new Contact(newName, newPhoneNumber);
          int itemIndex = queryContactList(oldContact);
          if(isFound(newContact)){
               System.out.println("Contact with name " + newName + " and phone number " + newPhoneNumber + "already exists.");
               return false;
          }
          if (itemIndex >= 0) {
               contactList.set(itemIndex, newContact);
               System.out.println(oldName + " with phone number:  " + oldPhoneNumber + " was successfully modified to " +
                       newName + " with phone number: " + newPhoneNumber + " .");
               return true;
          } else {
               System.out.println(oldContact.getName() + " " + oldContact.getPhoneNumber() + " is not found in your contact list.");
               return false;
          }

     }

     public boolean removeContact(String name, String phoneNumber){
          Contact contact = new Contact(name, phoneNumber);
          int itemIndex = queryContactList(contact);
          if(itemIndex >= 0){
               contactList.remove(itemIndex);
               System.out.println(name + " with phone number:  " + phoneNumber + " was successfully removed.");
               return true;
          } else {
               System.out.println(contact.getName() + " " + contact.getPhoneNumber() + " is not found in your contact list.");
               return false;
          }
     }

     public void readContactList(){
          if(contactList.size() <= 0) System.out.println("You have no contacts in your contact list.");
          for(int i = 0; i < contactList.size(); i++){
               Contact contact = contactList.get(i);
               System.out.println("Contact #" + (i+1) + " name : " + contact.getName() + " and phone number : " + contact.getPhoneNumber());
          }
     }

     public void onList(String name, String phoneNumber){
          Contact contact = new Contact(name, phoneNumber);
          if(queryContactList(contact) >= 0) System.out.println(name + " with " + phoneNumber + " is in your list.");
          else System.out.println(name + " with phone number " + phoneNumber + " was not found.");
     }

     private boolean isFound(Contact contact){
          if(contactList.size() <= 0) return false;
          for (Contact myContact : contactList) {
               if (myContact.getName().equals(contact.getName()) && myContact.getPhoneNumber().equals(contact.getPhoneNumber()))
                    return true;
          }
          return false;
     }

     private int queryContactList(Contact contact){
          if(isFound(contact)) {
               for(int i = 0; i < contactList.size(); i++){
                    Contact myContact = contactList.get(i);
                    if (myContact.getName().equals(contact.getName()) && myContact.getPhoneNumber().equals(contact.getPhoneNumber())){
                         return i;
                    }
               }
          }
          return -1;
     }
}
