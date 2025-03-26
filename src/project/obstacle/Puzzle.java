package project.obstacle;

import project.game.PuzzleData;

/**
 * The puzzle class supports the creation, removal and solving of puzzles within
 * the game.
 */
public class Puzzle extends AbstractObstacle {

  public Puzzle(String name, String active, String affects_target, String affects_player,
               String solution, String value, String description, String effects,
               String target, String picture) {
    // Push to abstract constructor
    super(name, active, affects_target, affects_player, solution, value, description, effects,
            target, picture);
  }

  public Puzzle(PuzzleData puzzleData) {
    super(puzzleData.getName(), puzzleData.getActive(), puzzleData.getAffectsTarget(),
            puzzleData.getAffectsPlayer(), puzzleData.getSolution(), puzzleData.getValue(),
            puzzleData.getDescription(), puzzleData.getEffects(), puzzleData.getTarget(),
            puzzleData.getPicture());
  }

  private boolean booleanChecker(String s) {
    if (s == null) {
      return false;
    }
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

  @Override
  public String toString() {
    return "Puzzle{" +
            "name='" + super.getName() + '\'' +
            ", active=" + super.getActiveState() +
            ", affectsTarget=" + super.getAffectsTarget() +
            ", affectsPlayer=" + super.getAffectsPlayer() +
            ", solution='" + super.getSolution() + '\'' +
            ", value=" + super.getValue() +
            ", description='" + super.getDescription() + '\'' +
            ", effects='" + super.getEffects() + '\'' +
            ", target='" + super.getTarget() + '\'' +
            '}';
  }
}
