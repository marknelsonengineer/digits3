package models;

/**
 * A single contact.
 */
public class Contact {
  private String firstName;
  private String lastName;
  private String phone;

  /**
   * Create a new contact.
   *
   * @param firstName The first name.
   * @param lastName The last name.
   * @param phone The phone number.
   */
  public Contact(String firstName, String lastName, String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
  }

  /**
   * Get the contact's first name.
   *
   * @return The first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Get the contact's last name.
   *
   * @return The last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Get the contact's phone number.
   *
   * @return The phone number.
   */
  public String getPhone() {
    return phone;
  }
}
