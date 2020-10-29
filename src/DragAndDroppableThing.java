
public class DragAndDroppableThing extends DraggableThing {
  private VisibleThing target; // object over which this object can be dropped
  private Action action; // action that results from dropping this object over target

  /**
   * initializes the DragAndDroppableThing object
   * 
   * @param name
   * @param x
   * @param y
   * @param target
   * @param action
   */
  public DragAndDroppableThing(String name, int x, int y, VisibleThing target, Action action) {
    super(name, x, y);
    this.action = action;
    this.target = target;
  } // initialize new object

  @Override
  /**
   * Returns a certain Action if the object is dropped on its target
   */
  protected Action drop() {
    if (isOver(target) && target.isActive()) {// if the object is over the target and the target is
                                              // active, both are deactivated and the action is
                                              // returned
      this.deactivate();
      target.deactivate();
      return action;
    }
    return null;
  } // returns action and deactivates objects in response to successful drop
  // When this object is over its target and its target is active:
  // deactivate both this object and the target object, and return action,
  // otherwise return null
}
