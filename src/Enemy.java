import com.google.gson.annotations.SerializedName;


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
  private final int damage;  // make an int
  private String target;

  @SerializedName("can_attack")
  private boolean canAttack; // make a boolean

  private String attack;
  private String picture; //https://stackoverflow.com/questions/34072052/is-it-possible-to-add-an-image-png-as-an-attribute-of-a-java-class

  public Enemy(String name, String active, String affects_target, String affects_player,
               String solution, String value, String description, String effects, String damage,
               String target, String can_attack, String attack, String picture) {
    // Push to abstract constructor
    super(name, active, affects_target, affects_player, solution, value, description, effects,
            target, picture);


    // Not sent to abstract
    this.damage = Integer.parseInt(damage);
    this.canAttack = booleanChecker(can_attack);
    this.attack = attack;
  }

  private boolean booleanChecker(String s) {
    return s.equalsIgnoreCase("true");
  }

  ///**
  // * Sets whether the puzzle or enemy state is solved.
  // */
  //public void changeActiveState() {
  //}

  ///**
  // * Gets the obstacle name.
  // */
  //public String getName() {
  //  return "";
  //}

  ///**
  // * Returns active state of obstacle as a boolean, meaning solved or not.
  // */
  //public boolean getActiveState() {
  //  return false;
  //}
  //
  ///**
  // * Returns whether this impacts target as a boolean.
  // */
  //public boolean getAffectsTarget() {
  //  return false;
  //}
  //
  ///**
  // * Returns whether this impacts player as a boolean.
  // */
  //public boolean getAffectsPlayer() {
  //  return false;
  //}
  //
  ///**
  // * Checks solutions as a string.
  // */
  //public String getSolution() {
  //  return "";
  //}
  //
  ///**
  // * Gets the obstacle value as an integer.
  // */
  //public int getValue() {
  //  return 0;
  //}
  //
  ///**
  // * Gets the obstacle description.
  // */
  //public String getDescription() {
  //  return "";
  //}
  //
  ///**
  // * Provides a more indepth understanding and description of what the
  // * obstacle is doing or how it is behaving.
  // */
  //public String getEffects() {
  //  return "";
  //}

  /**
   * Provides the level of damage an enemy impacts upon attack.
   */
  public int getDamage() {
    return this.damage;
  }

  ///**
  // * Gets the location of the object.
  // */
  //public String getTarget() {
  //  return this.target;
  //}

  ///**
  // * Set the location of an object.
  // * This is originally set as part of object creation,
  // * the object can move to the bag, or it can be placed in
  // * a new room
  // *
  // * @param target
  // */
  //public void setTarget(String target) {
  //  this.target = target;
  //}

  /**
   * Returns whether an object can attack.
   */
  public boolean getCanAttack() {
    return this.canAttack;
  }

  /**
   * Returns a string describing how an enemy attacks.
   */
  public String getAttack() {
    return this.attack;
  }

  ///**
  // * Provides an image of the object.
  // */
  //public String getImage() {
  //  return null;
  //}


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


