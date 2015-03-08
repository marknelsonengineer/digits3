/**
 * Use a simulated browser to exercise the results from page requests.
 *
 * @author Mark Nelson
 * @since 6.0
 * @see http://junit.org
 * @see https://www.playframework.com
 */

/*
 * This may throw some errors when run in IntelliJ, but the tests pass.  TestBrowser is having trouble
 * getting the javascript file.
 */

package test;

import org.junit.Test;
import play.libs.F.Callback;
import play.test.TestBrowser;

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
   * Check if the home page is shown.
   */
  @Test
  public void testHome() {
    running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:3333");
        assertThat(browser.pageSource()).contains("The home page.");

        browser.goTo("http://localhost:3333/");
        assertThat(browser.pageSource()).contains("The home page.");
      }
    });
  }


  /**
   * Check if the Page 1 is shown.
   */
  @Test
  public void testPage1() {
    running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:3333/page1");
        assertThat(browser.pageSource()).contains("The first page.");
      }
    });
  }


  /**
   * Check if the Page 2 is shown.
   */
  @Test
  public void testPage2() {
    running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:3333/page2");
        assertThat(browser.pageSource()).contains("The second page.");
      }
    });
  }


  /**
   * Check if the About page is shown.
   */
  @Test
  public void testAbout() {
    running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:3333/about");
        assertThat(browser.pageSource()).contains("About this application...");
      }
    });
  }


  /**
   * Check if the Contact page is shown.
   */
  @Test
  public void testContact() {
    running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
      public void invoke(TestBrowser browser) {
        browser.goTo("http://localhost:3333/contact");
        assertThat(browser.pageSource()).contains("Please contact");
      }
    });
  }
}
