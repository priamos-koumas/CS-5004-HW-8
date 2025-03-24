import com.google.gson.annotations.SerializedName;

/**
 * The puzzle class supports the creation, removal and solving of puzzles within
 * the game.
 */
public class Puzzle extends AbstractObstacle {
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
  private String target;

  private String picture; //https://stackoverflow.com/questions/34072052/is-it-possible-to-add-an-image-png-as-an-attribute-of-a-java-class

  public Puzzle(String name, String active, String affects_target, String affects_player,
               String solution, String value, String description, String effects,
               String target, String picture) {
    // Push to abstract constructor
    super(name, active, affects_target, affects_player, solution, value, description, effects,
            target, picture);
  }

  private boolean booleanChecker(String s) {
    return s.equalsIgnoreCase("true");
  }

  /**
   * Provides the level of damage an enemy impacts upon attack.
   */
  public int getDamage() {
    return 0;
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
}
