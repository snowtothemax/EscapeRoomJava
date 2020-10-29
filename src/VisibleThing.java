import java.io.File;
import processing.core.PImage;

/**
 * Class for visible objects
 * 
 * @author front
 *
 */
public class VisibleThing extends Thing {
  // instance fields
  private PImage image; // the graphical representation of this thing
  private int x; // the horizontal position (in pixels of this thing's left side)
  private int y; // the vertical position (in pixels of this thing's top side)

  /**
   * initializes the VisibleThing object
   * 
   * @param name
   * @param x
   * @param y
   */
  public VisibleThing(String name, int x, int y) { // initialize this new thing
    // the image for this visible thing should be loaded from :
    // "images"+File.separator+ name +".png"
    super(name);
    image = getProcessing().loadImage("images" + File.separator + name + ".png");
    this.x = x;
    this.y = y;

  }

  @Override
  /**
   * Draws the image before returning null
   * 
   * @return Action null
   */
  public Action update() {
    getProcessing().image(this.image, x, y);// creates the image
    return null;
  }

  /**
   * changes x and y by adding dx to x and dy to y
   * 
   * @param dx
   * @param dy
   */
  public void move(int dx, int dy) {
    x += dx;
    y += dy;
  }

  /**
   * Tells whether point x,y is over an image
   * 
   * @param x
   * @param y
   * @return true if point is over the image, otherwise false
   */
  public boolean isOver(int x, int y) {
    if ((x < (this.x + (this.image.width - 1))) && (x > (this.x))) {// checks if x is
                                                                    // greater than or
                                                                    // less than the
                                                                    // images position
                                                                    // plus or minus its
                                                                    // width
      if ((y < (this.y + (this.image.height - 1))) && (y > (this.y))) {// same as above
                                                                       // but for y
        return true;
      }
    }
    return false;
  }

  /**
   * Tells whether an image overlaps another image
   * 
   * @param other
   * @return true if other image overlaps this image
   */
  public boolean isOver(VisibleThing other) {
    if (heightOverlap(other) && widthOverlap(other)) {// checks if both methods are true
      return true;
    }
    return false;
  }

  /**
   * Tells if the width coordinates of either object overlap at any point
   * 
   * @param other
   * @return true only if the width overlaps
   */
  private boolean widthOverlap(VisibleThing other) {
    int otherRightWall = other.x + other.image.width - 1;
    int thisRightWall = this.x + this.image.width - 1;
    if (((thisRightWall > other.x) && (thisRightWall < otherRightWall))
        || ((otherRightWall > this.x) && (otherRightWall < thisRightWall))) {
      return true;// algorithm that checks if the furthest side of one VisibleThing is less than the
                  // furthes side of another object but also greater than the closest side of the
                  // other object
    }
    return false;
  }

  /**
   * Tells if the height coordinates of either object overlaps at any point
   * 
   * @param other
   * @return true only if the height overlaps
   */
  private boolean heightOverlap(VisibleThing other) {
    int thisBottom = this.y + this.image.height - 1;
    int otherBottom = other.y + other.image.height - 1;
    if (((thisBottom > other.y) && (thisBottom < otherBottom))
        || ((otherBottom > this.y) && (otherBottom < thisBottom))) {
      return true;// same algorithm as wdithOverlap but when it comes to height
    }
    return false;
  }
}
