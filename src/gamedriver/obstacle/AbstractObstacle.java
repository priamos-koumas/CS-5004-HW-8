package gamedriver.obstacle;

import com.google.gson.annotations.SerializedName;

/**
 * This is the abstract obstacle class which implements the obstacle.IObstacle interface.
 */
public abstract class AbstractObstacle implements IObstacle {


  private String name;
  private boolean active; // make a boolean

  @SerializedName("affects_target")
  private boolean affectsTarget; // make a boolean

  @SerializedName("affects_player")
  private boolean affectsPlayer; // make a boolean

  private String solution;
  private int value = 0; // make an int
  private String description;
  private String effects;
  private String target;

  private String picture;

  public AbstractObstacle(String name, String active, String affects_target, String affects_player,
                          String solution, String value, String description, String effects,
                          String target, String picture) {
    this.name = name;
    this.active = booleanChecker(active);
    this.affectsTarget = booleanChecker(affects_target);
    this.affectsPlayer = booleanChecker(affects_player);
    this.solution = solution;
    if (value == null) {
      this.value = 0;
    } else {
      this.value = Integer.parseInt(value);
    }
    this.description = description;
    this.effects = effects;
    if (target == null || target.isEmpty()) {
      throw new IllegalArgumentException("Puzzle or Enemy target room cannot be null or"
              + "empty in order to show up in a room.");
    } else {
      this.target = target;
    }
    this.picture = picture;
  }

  /**
   * This takes a string from the constructor and returns a boolean.
   * @param s is a String of either True or False.
   * @return a boolean.
   */
  private boolean booleanChecker(String s) {
    if (s == null) {
      return false;
    }
    return s.equalsIgnoreCase("true");
  }

  /**
   * Sets whether the puzzle or enemy state is solved.
   */
  public void changeActiveState() {
    if (this.active) {
      this.active = false;
    }
  }

  /**
   * Gets the obstacle name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns the active state of obstacle as a boolean, meaning solved or not.
   * This pertains to the "active" parameter.
   */
  public boolean getActiveState() {
    return this.active;
  }

  /**
   * Returns whether this impacts target as a boolean.
   */
  public boolean getAffectsTarget() {
    return this.affectsTarget;
  }

  /**
   * Returns whether this impacts player as a boolean.
   */
  public boolean getAffectsPlayer() {
    return this.affectsPlayer;
  }

  /**
   * Checks solutions as a string.
   */
  public String getSolution() {
    return this.solution;
  }

  /**
   * Checks solution is correct
   */
  public String checkSolution(String solution) {
    if (solution.equalsIgnoreCase(this.solution)) {
      this.active = false;
      this.affectsTarget = false;
      this.affectsPlayer = false;
      return "You have solved the puzzle for " + this.getValue() + " points!";
    } else {
      return "That did not solve the puzzle.";
    }
  }

  /**
   * Gets the obstacle value as an integer.
   */
  public int getValue() {
    return this.value;
  }

  /**
   * Gets the obstacle description.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Provides a more indepth understanding and description of what the
   * obstacle is doing or how it is behaving.
   */
  public String getEffects() {
    return this.effects;
  }


  /**
   * Gets the location of the object.
   */
  public String getTarget() {
    return this.target;
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
    this.target = target;
  }

  /**
   * This sets the affected target.
   */
  public void setAffectsTarget(boolean affectsTarget) {
    this.affectsTarget = affectsTarget;
  }

  /**
   * This sets the affected player.
   */
  public void setAffectsPlayer(boolean affectsPlayer) {
    this.affectsPlayer = affectsPlayer;
  }

  /**
   * This sets whether the obstacle is active.
   */
  public void setActiveState(boolean active) {
    this.active = active;
  }

  /**
   * Provides an image of the object.
   */
  public String getImage() {
    return this.picture;
  }

}
