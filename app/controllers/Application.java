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
import views.html.About;
import views.html.Contact;
import views.html.Home;
import views.html.Page1;
import views.html.Page2;


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
   * Page 1 of the application.
   *
   * @return HTTP OK with page content.
   */
  public static Result page1() {
    return ok(Page1.render("Page 1 successful."));
  }


  /**
   * Page 2 of the application.
   *
   * @return HTTP OK with page content.
   */
  public static Result page2() {
    return ok(Page2.render("Page 2 successful."));
  }


  /**
   * The about page for the application.
   *
   * @return HTTP OK with page content.
   */
  public static Result about() {
    return ok(About.render("About page successful."));
  }


  /**
   * Contact page for the application.
   *
   * @return HTTP OK with page content.
   */
  public static Result contact() {
    return ok(Contact.render("Contact page successful."));
  }

}
