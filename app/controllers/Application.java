/**
 * The Controller leg for this Model-View-Controller application.
 *
 * @author Mark Nelson
 * @since 6.0
 * @see https://www.playframework.com
 */

package controllers;

import play.mvc.Controller;
import play.mvc.Result;
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
    return ok(NewContact.render("New contact page successful."));
  }

}
