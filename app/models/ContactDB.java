package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In-Memory, non persistent container for the application's contacts.
 */
public class ContactDB {

  private static Map<Long, Contact> contacts = new HashMap<Long, Contact>();
  private static long nextId = 1;  // Hold the next available ID number.

  /**
   * Delete a contact from the database.
   *
   * @param id The ID to delete.
   */
  public static void deleteContact(long id) {
    contacts.remove(id);
  }

  /**
   * Find and return a Contact based on ID.
   *
   * @param id An ID number to search for.
   * @return A contact for that ID number or throw an exception if a contact is not found.
   */
  public static Contact getContact(long id) {
    Contact contact = contacts.get(new Long(id));

    if (contact == null) {
      throw new RuntimeException("Attempt to find an unknown contact ID.");
    }

    return contact;
  }


  /**
   * Add a Contact object to the ContactDB database.
   *
   * @param formContact Contact information from an HTML form.
   * @return The new contact.
   */
  public static Contact newContactDB(ContactFormData formContact) {
    Contact contact = null;

    if (formContact.id == 0) {
      contact = new Contact(nextId++
          , formContact.firstName
          , formContact.lastName
          , formContact.phone
          , formContact.phoneType);
    }
    else {
      contact = new Contact(formContact.id
          , formContact.firstName
          , formContact.lastName
          , formContact.phone
          , formContact.phoneType);
    }

    contacts.put(contact.getId(), contact);

    return contact;
  }

  /**
   * Return a list of all of the contacts in the data model.
   *
   * @return All contacts known to the application.
   */
  public static List<Contact> getContacts() {
    return new ArrayList<>(contacts.values());
  }
}
