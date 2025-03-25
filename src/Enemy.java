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
  private RoomObstacles puzzle;

  @SerializedName("can_attack")
  private boolean canAttack; // make a boolean

  private String attack;
  private String picture; //https://stackoverflow.com/questions/34072052/is-it-possible-to-add-an-image-png-as-an-attribute-of-a-java-class
  private RoomObstacles enemy;

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

    // Add enemy to the Room Obstacles Class
    this.enemy = new RoomObstacles();
    this.enemy.addObstacle(this.getName(), this);
  }

  private boolean booleanChecker(String s) {
    return s.equalsIgnoreCase("true");
  }

  @Override
  public IObstacle getPuzzle() {
    return this.puzzle.getObstacle(this.getTarget());
  }

  /**
   * Provides the level of damage an enemy impacts upon attack.
   */
  public int getDamage() {
    return this.damage;
  }

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


  @Override
  public String toString() {
    return "Enemy{" +
            "name='" + name + '\'' +
            ", active=" + active +
            ", affectsTarget=" + affectsTarget +
            ", affectsPlayer=" + affectsPlayer +
            ", solution='" + solution + '\'' +
            ", value=" + value +
            ", description='" + description + '\'' +
            ", effects='" + effects + '\'' +
            ", damage=" + damage +
            ", target='" + target + '\'' +
            ", puzzle=" + puzzle +
            ", canAttack=" + canAttack +
            ", attack='" + attack + '\'' +
            ", picture='" + picture + '\'' +
            ", enemy=" + enemy +
            '}';
  }
}


