import com.google.gson.annotations.SerializedName;

import java.awt.image.BufferedImage;


/**
 * The enemy class supports the creation, removal and solving of enemies within
 * the game.
 */
public class Enemy extends AbstractObstacle {
  private String name;
  private boolean active; // make a boolean

  @SerializedName("affects_target")
  private boolean affectsTarget; // make a boolean

  @SerializedName("affects_player")
  private boolean affectsPlayer; // make a boolean

  private String solution;
  private int value; // make an int
  private String description;
  private String effects;
  private int damage;  // make an int
  private String target;

  @SerializedName("can_attack")
  private boolean canAttack; // make a boolean

  private String attack;
  private BufferedImage picture; //https://stackoverflow.com/questions/34072052/is-it-possible-to-add-an-image-png-as-an-attribute-of-a-java-class

  public Enemy(String name, String active, String affects_target, String affects_player,
               String solution, String value, String description, String effects, String damage,
               String target, String can_attack, String attack, BufferedImage picture) {
    super(name, description, solution);
    this.active = booleanChecker(active);
    this.affectsTarget = booleanChecker(affects_target);
    this.affectsPlayer = booleanChecker(affects_player);
    this.solution = solution;
    this.value = Integer.parseInt(value);
    this.description = description;
    this.effects = effects;
    this.damage = Integer.parseInt(damage);
    this.target = target;
    this.canAttack = booleanChecker(can_attack);
    this.attack = attack;
    this.picture = picture;
  }

  private boolean booleanChecker(String s) {
    return s.equals("true");
  }

  /**
   * Sets whether the puzzle or enemy state is solved.
   */
  @Override
  public void changeActiveState() {

  }

  /**
   * Gets the obstacle name.
   */
  @Override
  public String getName() {
    return "";
  }

  /**
   * Returns active state of obstacle as a boolean, meaning solved or not.
   */
  @Override
  public boolean getActiveState() {
    return false;
  }

  /**
   * Returns whether this impacts target as a boolean.
   */
  @Override
  public boolean getAffectsTarget() {
    return false;
  }

  /**
   * Returns whether this impacts player as a boolean.
   */
  @Override
  public boolean getAffectsPlayer() {
    return false;
  }

  /**
   * Checks solutions as a string.
   */
  @Override
  public String getSolution() {
    return "";
  }

  /**
   * Gets the obstacle value as an integer.
   */
  @Override
  public int getValue() {
    return 0;
  }

  /**
   * Gets the obstacle description.
   */
  @Override
  public String getDescription() {
    return "";
  }

  /**
   * Provides a more indepth understanding and description of what the
   * obstacle is doing or how it is behaving.
   */
  @Override
  public String getEffects() {
    return "";
  }

  /**
   * Provides the level of damage an enemy impacts upon attack.
   */
  @Override
  public String getDamage() {
    return "";
  }

  /**
   * Gets the location of the object.
   */
  @Override
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
  @Override
  public void setTarget(String target) {

  }

  /**
   * Returns whether an object can attack.
   */
  @Override
  public boolean getCanAttack() {
    return false;
  }

  /**
   * Returns a string describing how an enemy attacks.
   */
  @Override
  public String getAttack() {
    return "";
  }

  /**
   * Provides an image of the object.
   */
  @Override
  public BufferedImage getImage() {
    return null;
  }


  // * Returns current health.
  // */
  //@Override
  //public int getHealth() {
  //  return this.health;
  //}





  // * This addresses an attack on the enemy.
  // */
  //@Override
  //public void decrementHealth() {
  //  this.health = health - 25;
  //  System.out.println("You've hit the enemy!");
  //  if (this.health <= 0) {
  //    this.solved = true;
  //    System.out.println("The enemy has been defeated and is going to sleep!");
  //  }
  }


