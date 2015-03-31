package views.formdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mark on 3/30/15.
 */
public class DietTypes {
  private static final String[] DIET_TYPES = {"Dairy", "Fish", "Chicken", "Beef", "Gluten"};

  /**
   * Initialize empty dietTypes object.
   *
   * @return An empty dietType map.
   */
  public static Map<String, Boolean> getDietTypes() {
    Map<String, Boolean> dietTypes = new HashMap<String, Boolean>();

    for (String type : DIET_TYPES) {
      dietTypes.put(type, false);
    }

    return dietTypes;
  }

  /**
   * Populate a dietType map from a list.  Throw exception on unknown item.
   *
   * @param list A list of diet types.
   * @return A map with diet types in the list as true.  If not in the list, the map contains false.
   */
  public static Map<String, Boolean> getDietTypes(List<String> list) {
    Map<String, Boolean> dietTypes = getDietTypes();

    for (String item : list) {
      if (dietTypes.containsKey(item)) {
        dietTypes.put(item, true);
      }
      else {
        throw new RuntimeException("The list contains an invalid value [" + item + "]");
      }
    }

    return dietTypes;
  }
}
