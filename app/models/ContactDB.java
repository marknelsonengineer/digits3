package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.List;

/**
 * In-Memory, non persistent container for the application's contacts.
 */
public class ContactDB {

  private static List<Contact> contacts = new ArrayList<Contact>();

  /**
   * Add a Contact object to the ContactDB database.
   *
   * @param formContact Contact information from an HTML form.
   * @return The new contact.
   */
  public static Contact newContactDB(ContactFormData formContact) {
    Contact contact = new Contact(formContact.firstName, formContact.lastName, formContact.phone);

    contacts.add(contact);

    return contact;
  }

  /**
   * Return a list of all of the contacts in the data model.
   *
   * @return All contacts known to the application.
   */
  public static List<Contact> getContacts() {
    return contacts;
  }
}
