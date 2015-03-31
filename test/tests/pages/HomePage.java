package tests.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Test scaffolding for the home page.
 *
 * @author Mark Nelson
 */
public class HomePage extends FluentPage {
  private String url;

  /**
   * Create the HomePage.

   * @param webDriver The driver.
   * @param port The port.
   */
  public HomePage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/";
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
}
