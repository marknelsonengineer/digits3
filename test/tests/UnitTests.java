package tests;

import org.junit.Test;
import views.formdata.TelephoneType;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Unit tests for the Application.
 *
 * @author Mark Nelson
 * @since 6.0
 * @see http://junit.org
 * @see https://www.playframework.com
 */
public class UnitTests {

  /**
   * Exercise the isValidTelephoneType method.
   */
  @Test
  public void isValidTelephoneTypeTest() {
    assertThat(TelephoneType.isValidType("Mobile")).isEqualTo(true);
    assertThat(TelephoneType.isValidType("Home")).isEqualTo(true);
    assertThat(TelephoneType.isValidType("Work")).isEqualTo(true);

    assertThat(TelephoneType.isValidType("XMobile")).isEqualTo(false);
    assertThat(TelephoneType.isValidType("MobileX")).isEqualTo(false);
    assertThat(TelephoneType.isValidType("Mobile ")).isEqualTo(false);
    assertThat(TelephoneType.isValidType(" Mobile")).isEqualTo(false);
    assertThat(TelephoneType.isValidType("")).isEqualTo(false);
    assertThat(TelephoneType.isValidType(" ")).isEqualTo(false);
    assertThat(TelephoneType.isValidType("  ")).isEqualTo(false);
    assertThat(TelephoneType.isValidType(null)).isEqualTo(false);
  }
}
