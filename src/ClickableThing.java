
/**
 * Class for visible objects that are also clickable, meaning actions can be taken out on them
 * 
 * @author front
 *
 */
public class ClickableThing extends VisibleThing {
  private Action action; // action returned from update when this object is clicked
  private boolean mouseWasPressed; // tracks whether the mouse was pressed during the last update()

  /**
   * initializes the ClickableThing object
   * 
   * @param name
   * @param x
   * @param y
   * @param action
   */
  public ClickableThing(String name, int x, int y, Action action) {
    super(name, x, y);
    this.action = action;
    mouseWasPressed = false;
  } // initializes this new object

  @Override
  /**
   * If the mouse is pressed on a ClickableThing, it returns its action
   */
  public Action update() {
    super.update();// calls the super update method
    if (!mouseWasPressed) {// checks if the mouseWasPressed is false
      if (getProcessing().mousePressed) {// checks if the mouse is currently being pressed
        if (isOver(getProcessing().mouseX, getProcessing().mouseY)) {// checks if the mouse
                                                                     // coordinates are overlapping
                                                                     // the images coordinates

          mouseWasPressed = getProcessing().mousePressed;
          return action;// if all true, returns the action of the object and sets
        }
      }
    }
    mouseWasPressed = getProcessing().mousePressed;
    return null;

  } // calls VisibleThing update, then returns action only when mouse is first clicked

}
