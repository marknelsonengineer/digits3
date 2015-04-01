package views.formdata;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class to manipluate telephone type data.
 *
 * @author Mark Nelson
 */
public class TelephoneType {

  /**
   * Generates an empty map of Telephone Types.
   *
   * @return An empty map of telephone types.
   */
  public static Map<String, Boolean> getTelephoneTypes() {
    Map<String, Boolean> telephoneTypes = new HashMap<String, Boolean>();

    telephoneTypes.put("Home", false);
    telephoneTypes.put("Mobile", false);
    telephoneTypes.put("Work", false);

    return telephoneTypes;
  }


  /**
   * Return true if the passed string is a legal telephone type.
   *
   * @param type A candidate telephone type.
   * @return True if the candidate telephone type is a valid telephone type.  False if it is not.
   */
  public static boolean isValidType(String type) {
    Map<String, Boolean> telephoneTypes = getTelephoneTypes();

    if (type == null) {
      return false;
    }

    for (String validType : telephoneTypes.keySet()) {
      if (validType.matches(type)) {
        return true;
      }
    }
    return false;  // No match was found in the iterator above.
  }


  /**
   * Return a Map object with one valid telephone type set based in inputType.  Throw an exception if inputType is not
   * valid.
   *
   * @param inputType The telephone type to set to true.
   * @return A map object where one telephone type (inputType) is set to true and all of the others are false.
   */
  public static Map<String, Boolean> getTelephoneTypes(String inputType) {
    Map<String, Boolean> types = TelephoneType.getTelephoneTypes();

    if (!TelephoneType.isValidType(inputType)) {
      throw new InvalidParameterException("The telephone type [" + inputType + "] is not a valid telephone type.");
    }

    types.put(inputType, true);

    return types;
  }

}
