import models.ContactDB;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import views.formdata.ContactFormData;

/**
 * Global application object.
 *
 * @author Mark Nelson
 */
public class Global extends GlobalSettings {


  /**
   * Called on application start.  Initialize data for the application and make things ready for the user.
   *
   * @param application Unused.
   */
  @Override
  public void onStart(Application application) {
    super.onStart(application);

    Logger.info("Application has started");

    ContactFormData c1 = new ContactFormData();
    c1.firstName = "Joe";
    c1.lastName = "Schmoe";
    c1.phone = "(808) 555-1212";
    c1.phoneType = "Work";
    ContactDB.newContactDB(c1);

    ContactFormData c2 = new ContactFormData();
    c2.firstName = "Sam";
    c2.lastName = "Nelson";
    c2.phone = "(808) 555-1111";
    c2.phoneType = "Home";
    ContactDB.newContactDB(c2);

    ContactFormData c3 = new ContactFormData();
    c3.firstName = "Mark";
    c3.lastName = "Nelson";
    c3.phone = "(808) 555-3333";
    c3.phoneType = "Mobile";
    ContactDB.newContactDB(c3);

    Logger.info("Data initialized.");
  }
}
