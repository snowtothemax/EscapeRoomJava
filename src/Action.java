import java.util.ArrayList;

/**
 * Action class for actions that certain things can carry out
 * @author front
 *
 */
public class Action {
  //instance fields
  private String message; // message printed by this action (or null to do nothing)
  Thing thing;
  
  
  
  //methods
  /**
   * initializes new action
   * @param message input message
   */
  public Action(String message) {// initialize this new action
    this.message = message;
  }
  
  /**
   * initializes the Action object
   * @param thing
   */
  public Action(Thing thing) {
    this.thing = thing;
  }
  
  /**
   * initializes the Action Object
   * @param message
   * @param thing
   */
  public Action(String message, Thing thing) {
    this.thing = thing;
    this.message = message;
  }
  
  /**
   * Carries out the Action
   */
  public void act(ArrayList<Thing> things) {// when message is not null, message is printed to System.out
    if(message != null)
    {
      System.out.println(message);
    }
    if(thing != null) {//If the thing input is not null, the thing is activated and added to the array, then set to null
      thing.activate();
      things.add(thing);
      this.thing = null;
    }
  }
}
