package models;

/**
 * A single contact.
 */
public class Contact {
  private long id;
  private String firstName;
  private String lastName;
  private String phone;
  private String phoneType;

  /**
   * Create a new contact.
   *
   * @param id        The ID number.
   * @param firstName The first name.
   * @param lastName  The last name.
   * @param phone     The phone number.
   * @param phoneType The phone type.
   */
  public Contact(long id, String firstName, String lastName, String phone, String phoneType) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.phoneType = phoneType;
  }

  /**
   * Get the contact's unique ID.
   *
   * @return A unique ID number for this contact.
   */
  public long getId() {
    return id;
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

  /**
   * Get the contact's phone type.
   *
   * @return The phone type.
   */
  public String getPhoneType() {
    return phoneType;
  }
}
