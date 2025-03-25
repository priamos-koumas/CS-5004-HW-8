package project.obstacle;


/**
 * This is the obstacle interface which represents any solvable obstacle
 * such as a puzzle or an enemy.
 */
public interface IObstacle {

  /**
   * Sets whether the puzzle or enemy state is solved.
   */
  public void changeActiveState();

  /**
   * Gets the obstacle name.
   */
  public String getName();

  /**
   * Returns active state of obstacle as a boolean, meaning solved or not.
   */
  public boolean getActiveState();

  /**
   * Returns whether this impacts target as a boolean.
   */
  public boolean getAffectsTarget();

  /**
   * Returns whether this impacts player as a boolean.
   */
  public boolean getAffectsPlayer();

  /**
   * Checks solutions as a string.
   */
  public String getSolution();

  /**
   * Gets the obstacle value as an integer.
   */
  public int getValue();

  /**
   * Gets the obstacle description.
   */
  public String getDescription();

  /**
   * Provides a more indepth understanding and description of what the
   * obstacle is doing or how it is behaving.
   */
  public String getEffects();

  /**
   * Provides the level of damage an enemy impacts upon attack.
   */
  public int getDamage();

  /**
   * Gets the location of the object.
   */
  public String getTarget();

  /**
   * Set the location of an object.
   * This is originally set as part of object creation,
   * the object can move to the bag, or it can be placed in
   * a new room
   */
  public void setTarget(String target);

  /**
   * Returns whether an object can attack.
   */
  public boolean getCanAttack();

  /**
   * Returns a string describing how an enemy attacks.
   */
  public String getAttack();

  /**
   * Provides an image of the object.
   */
  public String getImage();

}
