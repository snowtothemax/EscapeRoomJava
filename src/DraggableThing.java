
public class DraggableThing extends VisibleThing {
  private boolean mouseWasPressed; // similar to use in ClickableThing
  private boolean isDragging; // true when this object is being dragged by the user
  private int oldMouseX; // horizontal position of mouse during last update
  private int oldMouseY; // vertical position of mouse during last update

  /**
   * initializes the DraggableThing
   * 
   * @param name
   * @param x
   * @param y
   */
  public DraggableThing(String name, int x, int y) {
    super(name, x, y);
    isDragging = false;
    oldMouseX = x;
    oldMouseY = y;
  } // initialize new thing


  @Override
  /**
   * Checks if the mouse is being held down and drags and object
   */
  public Action update() {
    super.update();
    if (!mouseWasPressed) {
      if (getProcessing().mousePressed) {
        if (isOver(getProcessing().mouseX, getProcessing().mouseY)) {// checks if the mouse is
                                                                     // clicked over the object
                                                                     // being dragged
          mouseWasPressed = true;
          oldMouseX = getProcessing().mouseX;// the initial position of the mouse
          oldMouseY = getProcessing().mouseY;
          if (mouseWasPressed)
            isDragging = true;// sets the variable isDragging to true
        }
      }
    }
    if (isDragging) {// if is dragging is true the move method is called with the current mouse
                     // position
      this.move(getProcessing().mouseX - oldMouseX, getProcessing().mouseY - oldMouseY);
      oldMouseX = getProcessing().mouseX;
      oldMouseY = getProcessing().mouseY;
    }
    mouseWasPressed = getProcessing().mousePressed;// resets the mouseWasPressed to if the mouse is
                                                   // currently being pressed
    if (isDragging && !getProcessing().mousePressed) {// if it isnt being pressed anymore,
                                                      // isDragging is false and the action is
                                                      // returned
      isDragging = false;
      return drop();
    }
    return null;
  }// calls VisibleThing update(), then moves according to mouse drag
   // each time isDragging changes from true to false, the drop() method below will be called once
   // and any action objects returned from that method should then be returned from update()

  /**
   * The drop method that is returned from the object being dragged
   * 
   * @return Action
   */
  protected Action drop() {
    return null;
  } // this method returns null

  // subclass types will override this drop() method to do more interesting things
}
