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
  private String value; // make an int
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
    this.value = value;
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


