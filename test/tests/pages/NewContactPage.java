package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Test scaffolding for the New Contact page.
 *
 * @author Mark Nelson
 */
public class NewContactPage extends FluentPage {
  private String url;

  /**
   * Create the New Contact Page.

   * @param webDriver The driver.
   * @param port The port.
   */
  public NewContactPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/newcontact";
  }

  /**
   * Get the URL of the page.
   *
   * @return The URL of the page.
   */
  @Override
  public String getUrl() {
    return this.url;
  }

  /**
   * Assert that the page title contains the word Index.
   */
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Index");
  }

  /**
   * Populate the from from the input parameters.
   *
   * @param firstName The first name.
   * @param lastName The last name.
   * @param phone The phone number.
   */
  public void submitForm(String firstName, String lastName, String phone) {
    fill("#firstName").with(firstName);
    fill("#lastName").with(lastName);
    fill("#phone").with(phone);
    submit("#submit");
  }

}
