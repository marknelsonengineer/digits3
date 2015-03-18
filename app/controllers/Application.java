/**
 * The Controller leg for this Model-View-Controller application.
 *
 * @author Mark Nelson
 * @since 6.0
 * @see https://www.playframework.com
 */

package controllers;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.html.NewContact;
import views.html.Home;


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
    return ok(Home.render("Home page successful."));
  }


  /**
   * New contact page for the application.
   *
   * @return HTTP OK with page content.
   */
  public static Result newContact() {
    Form<ContactFormData> contact = Form.form(ContactFormData.class);

    return ok(NewContact.render("New contact page successful.", contact));
  }


  /**
   * Process an HTTP POST method on the NewContact page.
   *
   * @return HTTP OK with page content if the page passes validation -- OR -- HTTP badRequest if the page
   * fails validation.
   */
  public static Result postNewContact() {
    Form<ContactFormData> contactForm = Form.form(ContactFormData.class).bindFromRequest();

    if (contactForm.hasErrors()) {
      System.out.printf("Error in newContact page.\n");
      return badRequest(NewContact.render("Error in newContact page.", contactForm));
    }

    ContactFormData contact = contactForm.get();

    System.out.printf("New Contact entered ::");
    System.out.printf("  First: [%s]", contact.firstName);
    System.out.printf("  Last: [%s]", contact.lastName);
    System.out.printf("  Phone: [%s]", contact.phone);
    System.out.printf("\n");

    return ok(NewContact.render("New contact page successful.", contactForm));
  }
}
