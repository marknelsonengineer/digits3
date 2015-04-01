/**
 * The Controller leg for this Model-View-Controller application.
 *
 * @author Mark Nelson
 * @since 6.0
 * @see https://www.playframework.com
 */

package controllers;

import models.Contact;
import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.formdata.TelephoneType;
import views.html.NewContact;
import views.html.Home;

import java.util.Map;


/**
 * Controllers for the application.
 */
public class Application extends Controller {

  /**
   * Application home page.
   *
   * @return HTTP OK with page content.
   */
  public static Result home() {
    return ok(Home.render("Home page successful.", ContactDB.getContacts()));
  }

  /**
   * Delete a contact and re-render the home page.
   *
   * @param id The contact to delete.
   * @return HTTP OK with page content.
   */
  public static Result deleteContact(long id) {
    ContactDB.deleteContact(id);

    return ok(Home.render("Deleted contact.", ContactDB.getContacts()));
  }

  /**
   * New contact page for the application.
   *
   * @param id The ID number to create or edit.
   * @return HTTP OK with page content.
   */
  public static Result newContact(long id) {
    ContactFormData contactFormData = null;
    Map<String, Boolean> telephoneType = null;

    if (id == 0) {
      contactFormData = new ContactFormData();
      telephoneType = TelephoneType.getTelephoneTypes();
    }
    else {
      contactFormData = new ContactFormData(ContactDB.getContact(id));
      telephoneType = TelephoneType.getTelephoneTypes(ContactDB.getContact(id).getPhoneType());
    }

    Form<ContactFormData> contactForm = Form.form(ContactFormData.class).fill(contactFormData);

    return ok(NewContact.render("New contact page successful.", contactForm, telephoneType));
  }


  /**
   * Process an HTTP POST method on the NewContact page.
   *
   * @return HTTP OK with page content if the page passes validation -- OR -- HTTP badRequest if the page
   * fails validation.
   */
  public static Result postNewContact() {
    Form<ContactFormData> contactForm = Form.form(ContactFormData.class).bindFromRequest();
    Map<String, Boolean> telephoneType = TelephoneType.getTelephoneTypes();

    if (contactForm.hasErrors()) {
      System.out.printf("Error in newContact page.\n");
      return badRequest(NewContact.render("Error in newContact page.", contactForm, telephoneType));
    }

    ContactFormData contactFormData = contactForm.get();

    System.out.printf("Data from the New Contact HTTP Form ::");
    System.out.printf("  ID: [%d]", contactFormData.id);
    System.out.printf("  First: [%s]", contactFormData.firstName);
    System.out.printf("  Last: [%s]", contactFormData.lastName);
    System.out.printf("  Phone: [%s]", contactFormData.phone);
    System.out.printf("  Phone Type: [%s]", contactFormData.phoneType);
    System.out.printf("\n");

    Contact contact = ContactDB.newContactDB(contactFormData);

    System.out.printf("Data from the New Contact object ::");
    System.out.printf("  ID: [%d]", contact.getId());
    System.out.printf("  First: [%s]", contact.getFirstName());
    System.out.printf("  Last: [%s]", contact.getLastName());
    System.out.printf("  Phone: [%s]", contact.getPhone());
    System.out.printf("  Phone Type: [%s]", contact.getPhoneType());
    System.out.printf("\n");

    return ok(Home.render("Added new contact.", ContactDB.getContacts()));
  }
}
