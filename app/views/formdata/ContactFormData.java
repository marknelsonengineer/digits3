package views.formdata;

import models.Contact;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Contact HTML form backing class.
 */
public class ContactFormData {

  /** A unique contact ID. */
  public long id = 0;

  /** The first name. */
  public String firstName = "";

  /** The last name. */
  public String lastName = "";

  /** The phone number. */
  public String phone = "";

  /** The minimum phone number size. */
  public static final int MINIMUM_PHONE_NUMBER_SIZE = 12;

  /**
   * Create an empty ContactForm.
   */
  public ContactFormData() {
    // No-arg constructor as required by Play.
  }

  /**
   * Create a populated ContactForm from a contact object.
   *
   * @param contact Populate the form from this object.
   */
  public ContactFormData(Contact contact) {
    this.id = contact.getId();
    this.firstName = contact.getFirstName();
    this.lastName = contact.getLastName();
    this.phone = contact.getPhone();
  }

  /**
   * Validate data entered by the user into the HTML form.
   *
   * @return a List of validation errors or null if there are no errors.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();

    if (firstName == null || firstName.length() <= 0) {
      errors.add(new ValidationError("firstName", "First name is required."));
    }

    if (lastName == null || lastName.length() <= 0) {
      errors.add(new ValidationError("lastName", "Last name is required."));
    }

    if (phone == null || phone.length() <= 0) {
      errors.add(new ValidationError("phone", "A phone number is required."));
    }

    if (phone == null || phone.length() < MINIMUM_PHONE_NUMBER_SIZE) {
      errors.add(new ValidationError("phone", "The phone number must be " + MINIMUM_PHONE_NUMBER_SIZE + " digits"));
    }

    return errors.isEmpty() ? null : errors;
  }
}
