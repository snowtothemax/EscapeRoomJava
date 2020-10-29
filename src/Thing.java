import processing.core.PApplet;

/**
 * Thing class for "physical objects" in the escape room game
 * @author front
 *
 */
public class Thing {
  // instance fields
  private final String NAME; // the constant name identifying this object
  private boolean isActive; // active means thing is visible and can be interacted with
  private static PApplet processing = null;

  // methods
  /**
   * Initializes Thing object
   * 
   * @param name
   */
  public Thing(String name) {// initialize name, and set isActive to true
    NAME = name;
    isActive = true;
  }

  /**
   * returns true if contents of name equal NAME
   */
  public boolean hasName(String name) {// returns true only when contents of name equal NAME
    if (name.contentEquals(NAME)) {
      return true;
    }
    return false;
  }

  /**
   * returns isActive
   * 
   * @return true if isActive is true, otherwise false;
   */
  public boolean isActive() {// returns true only when isActive is true
    return isActive;
  }

  /**
   * changes activate
   */
  public void activate() {// changes isActive to true
    isActive = true;
  }

  /**
   * changes activate to false
   */
  public void deactivate() {// changes isActive to false
    isActive = false;
  }

  /**
   * method that will be overridden
   * 
   * @return null
   */
  public Action update() {
    return null;
  } // this method returns null
  // subclass types will override this update() method to do more interesting things

  /**
   * initializes the processing field
   * 
   * @param processing
   */
  public static void setProcessing(PApplet processing) {// initializes processing field
    Thing.processing = processing;
  }

  /**
   * retrieves the static field processing
   * 
   * @return PApplet processing
   */
  protected static PApplet getProcessing() { // accessor method to retrieve this static field
    return Thing.processing;
  }
}
