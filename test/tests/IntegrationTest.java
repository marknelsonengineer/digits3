/**
 * Use a simulated browser to exercise the results from page requests.
 *
 * @author Mark Nelson
 * @see http://junit.org
 * @see https://www.playframework.com
 * @since 6.0
 */

/*
 * This may throw some errors when run in IntelliJ, but the tests pass.  TestBrowser is having trouble
 * getting the javascript file.
 */

package tests;

import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;
import tests.pages.HomePage;
import tests.pages.NewContactPage;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;


/**
 * Use a simulated browser to exercise the results from page requests.  These tests should focus on content and
 * page-to-page flow.
 */
public class IntegrationTest {
  /**
   * The port to be used for testing.
   */
  private final int port = 3333;

  /**
   * Check if the home page is shown.
   */
  @Test
  public void testHome() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.maximizeWindow();
        HomePage homePage = new HomePage(browser.getDriver(), port);
        browser.goTo(homePage);
        assertThat(browser.pageSource()).contains("Digits");
      }
    });
  }


  /**
   * Check if the New Contact page is shown.
   */
  @Test
  public void testNewContact() {
    running(testServer(port, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.maximizeWindow();
        NewContactPage newContactPage = new NewContactPage(browser.getDriver(), port);
        browser.goTo(newContactPage);

        String firstName = "George";
        String lastName = "Washington";
        String phone = "+1 (212) 555-1212";
        String phoneType = "Work";

        newContactPage.submitForm(firstName, lastName, phone, phoneType);

        assertThat(browser.pageSource()).contains(firstName);
        assertThat(browser.pageSource()).contains(lastName);
        assertThat(browser.pageSource()).contains(phone);
        assertThat(browser.pageSource()).contains(phoneType);

        assertThat(browser.pageSource()).contains("Digits");
      }
    });
  }
}
