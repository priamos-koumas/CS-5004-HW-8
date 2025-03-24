import java.awt.image.BufferedImage;

/**
 * This is the abstract obstacle class which implements the IObstacle interface.
 */
public abstract class AbstractObstacle implements IObstacle {

  private String name;
  private String description;
  private String answer;
  private boolean solved = false;

  public AbstractObstacle(String name, String description, String answer) {
    this.name = name;
    this.description = description;
    this.answer = answer;

  }

  /**
   * Sets whether the puzzle or enemy state is solved.
   */
  public void changeActiveState() {

  }

  /**
   * Gets the obstacle name.
   */
  public String getName() {
    return "";
  }

  /**
   * Returns active state of obstacle as a boolean, meaning solved or not.
   */
  public boolean getActiveState() {
    return false;
  }

  /**
   * Returns whether this impacts target as a boolean.
   */
  public boolean getAffectsTarget() {
    return false;
  }

  /**
   * Returns whether this impacts player as a boolean.
   */
  public boolean getAffectsPlayer() {
    return false;
  }

  /**
   * Checks solutions as a string.
   */
  public String getSolution() {
    return "";
  }

  /**
   * Gets the obstacle value as an integer.
   */
  public int getValue() {
    return 0;
  }

  /**
   * Gets the obstacle description.
   */
  public String getDescription() {
    return "";
  }

  /**
   * Provides a more indepth understanding and description of what the
   * obstacle is doing or how it is behaving.
   */
  public String getEffects() {
    return "";
  }

  /**
   * Provides the level of damage an enemy impacts upon attack.
   */
  public String getDamage() {
    return "";
  }

  /**
   * Gets the location of the object.
   */
  public String getTarget() {
    return "";
  }

  /**
   * Set the location of an object.
   * This is originally set as part of object creation,
   * the object can move to the bag, or it can be placed in
   * a new room
   *
   * @param target
   */
  public void setTarget(String target) {

  }

  /**
   * Returns whether an object can attack.
   */
  public boolean getCanAttack() {
    return false;
  }

  /**
   * Returns a string describing how an enemy attacks.
   */
  public String getAttack() {
    return "";
  }

  /**
   * Provides an image of the object.
   */
  public BufferedImage getImage() {
    return null;
  }



}
