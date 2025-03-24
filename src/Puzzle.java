



/**
 * The puzzle class supports the creation, removal and solving of puzzles within
 * the game.
 */
public class Puzzle extends AbstractObstacle {
  private String name;
  private String description;
  private String answer;
  private boolean solved = false;


  public Puzzle(String name, String description, String answer, boolean solved) {
    super(name, description, answer);
    this.solved = solved;
  }




}
