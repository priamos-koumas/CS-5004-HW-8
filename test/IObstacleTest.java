import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;



/**
 * This tests the IObstacle class and adjoining classes when applicable.
 */
public class IObstacleTest {

  private IObstacle obstacle1;
  private IObstacle obstacle2;
  private Enemy enemy1;
  private Puzzle puzzle1;

  /**
   * Setup for testing.
   */
  @BeforeEach
  public void setUp() {
    this.obstacle1 = new Puzzle("Test Obstacle Puzzle", "It's a riddle", "What has 2 legs...", false);
    this.obstacle2 = new Enemy("Test Obstacle Enemy", "It's a monster", "Kill it", false, 75);
    this.enemy1 = new Enemy("Gargantuan Goblin", "A gargantuan goblin", "It eats bananas", false, 40);
    this.puzzle1 = new Puzzle("Gigantic Chess", "How do you win", "Take the king", false);
  }

  /**
   * Test get names.
   */
  @Test
  public void getObstacleName() {
    Assertions.assertEquals("Test Obstacle Puzzle", obstacle1.getObstacleName());
    Assertions.assertEquals("Test Obstacle Enemy", obstacle2.getObstacleName());
    Assertions.assertEquals("Gargantuan Goblin", enemy1.getObstacleName());
    Assertions.assertEquals("Gigantic Chess", puzzle1.getObstacleName());
  }

  /**
   * Test get descriptions.
   */
  @Test
  public void getObstacleDescription() {
    Assertions.assertEquals("It's a riddle", obstacle1.getObstacleDescription());
    Assertions.assertEquals("It's a monster", obstacle2.getObstacleDescription());
    Assertions.assertEquals("A gargantuan goblin", enemy1.getObstacleDescription());
    Assertions.assertEquals("How do you win", puzzle1.getObstacleDescription());
  }

  /**
   * Test get answer.
   */
  @Test
  public void getObstacleAnswer() {
    Assertions.assertEquals("What has 2 legs...", obstacle1.getObstacleAnswer());
    Assertions.assertEquals("Kill it", obstacle2.getObstacleAnswer());
    Assertions.assertEquals("It eats bananas", enemy1.getObstacleAnswer());
    Assertions.assertEquals("Take the king", puzzle1.getObstacleAnswer());
  }

  /**
   * Test get solved or not.
   */
  @Test
  public void getObstacleSolved() {
    Assertions.assertEquals(false, obstacle1.isSolved());
    Assertions.assertEquals(false, obstacle2.isSolved());
    Assertions.assertEquals(false, enemy1.isSolved());
    Assertions.assertEquals(false, puzzle1.isSolved());
    obstacle1.solved();
    Assertions.assertEquals(true, obstacle1.isSolved());
    puzzle1.solved();
    Assertions.assertEquals(true, puzzle1.isSolved());
  }

  /**
   * Test attack enemy.
   */
  @Test
  public void decrementHealth() {
    Assertions.assertEquals(100, enemy1.getHealth());
    enemy1.decrementHealth();
    Assertions.assertEquals(75, enemy1.getHealth());
    enemy1.decrementHealth();
    Assertions.assertEquals(50, enemy1.getHealth());
    enemy1.decrementHealth();
    Assertions.assertEquals(25, enemy1.getHealth());
    enemy1.decrementHealth();
    Assertions.assertEquals(0, enemy1.getHealth());

  }





}
