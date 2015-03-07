package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

/**
 * Renders the pages for the application.
 */
public class Application extends Controller {

  /**
   * Draw the index page.
   *
   * @return HTTP OK.
   */
  public static Result index() {
    return ok(index.render("Your new application is ready."));
  }

}
