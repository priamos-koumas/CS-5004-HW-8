

/**
 * This is the obstacle interface which represents any solvable obstacle
 * such as a puzzle or an enemy.
 */
public interface IObstacle {

  /**
   * Sets whether the puzzle or enemy state is solved.
   */
  public void solved();

  /**
   * Adds obstacle to room.
   */
  public void createObstacle();

  /**
   * Removes obstacle from room.
   */
  public void removeObstacle();

  /**
   * Checks and returns a boolean on whether obstacle has been solved.
   */
  public boolean isSolved();

  /**
   * Gets obstacle name.
   */
  public String getObstacleName();

  /**
   * Gets obstacle name.
   */
  public String getObstacleDescription();

  /**
   * Gets obstacle answer.
   */
  public String getObstacleAnswer();


  /**
   * Returns the health of enemy.
   * @return int.
   */
  int getHealth();
}
