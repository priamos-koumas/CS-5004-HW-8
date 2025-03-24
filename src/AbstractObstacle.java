

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
  public void solved() {
    this.solved = true;
  }

  /**
   * Adds obstacle to room.
   */
  public void createObstacle() {
  }

  /**
   * Removes obstacle from room.
   */

  public void removeObstacle() {
  }

  /**
   * Checks and returns a boolean on whether obstacle has been solved.
   */
  public boolean isSolved() {
    return this.solved;
  }

  /**
   * Gets obstacle name.
   */
  @Override
  public String getObstacleName() {
    return this.name;
  }

  /**
   * Gets obstacle name.
   */
  @Override
  public String getObstacleDescription() {
    return this.description;
  }

  /**
   * Gets obstacle answer.
   */
  @Override
  public String getObstacleAnswer() {
    return this.answer;
  }

  /**
   * Returns the health of enemy.
   *
   * @return int.
   */
  public int getHealth() {
    return 0;
  };

  /**
   * This decrements the health.
   */
  public void decrementHealth() {};
}
