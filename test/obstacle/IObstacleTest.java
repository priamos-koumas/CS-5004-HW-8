package obstacle;
import gamedriver.obstacle.IObstacle;
import gamedriver.obstacle.Enemy;
import gamedriver.obstacle.Puzzle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * This tests the IObstacle class and adjoining classes when applicable.
 */
public class IObstacleTest {

  private IObstacle obstacle1;
  private IObstacle obstacle2;
  private Enemy obstacle3;
  private Puzzle obstacle4;
  private IObstacle nullObstacle1;
  private IObstacle nullObstacle2;

  /**
   * Setup for testing.
   */
  @BeforeEach
  public void setUp() {
    this.obstacle1 = new Enemy("Rabbit", "true",  "true", "true", "Carrot", "300",
          "Awww. A furry rabbit twitching its nose and eating a carrot. Makes you want to pet him",
          "A monster Rabbit moves towards you! He's blocking the way north. \nI think you might be dinner!",
          "-15", "7:Dining Room","true", "licks you with a giant tongue!", "monster-rabbit.png");

    this.obstacle2 = new Puzzle("DARKNESS", "true",  "true", "true", "Lamp", "150",
            "Darkness! You cannot see!", "It's dark! You cannot see anything! Maybe we should go back?",
            "6:Kitchen", "darkness.png");
   }

  /**
   * Test happy path enemy.
   */
  @Test
  public void testHappyPathEnemy() {
    // Start with the Enemy class
    Assertions.assertEquals("Rabbit", obstacle1.getName());
    Assertions.assertEquals("Awww. A furry rabbit twitching its nose and eating a carrot. Makes you want to pet him", obstacle1.getDescription());
    Assertions.assertTrue(obstacle1.getActiveState());
    Assertions.assertTrue(obstacle1.getAffectsTarget());
    Assertions.assertTrue(obstacle1.getAffectsPlayer());
    Assertions.assertEquals("Carrot", obstacle1.getSolution());
    Assertions.assertEquals(300, obstacle1.getValue());
    Assertions.assertEquals("Awww. A furry rabbit twitching its nose and eating a carrot. Makes you want to pet him",
            obstacle1.getDescription());
    Assertions.assertEquals("A monster Rabbit moves towards you! He's blocking the way north. \nI think you might be dinner!",
            obstacle1.getEffects());
    Assertions.assertEquals(-15, obstacle1.getDamage());
    Assertions.assertTrue(obstacle1.getCanAttack());
    Assertions.assertEquals("7:Dining Room", obstacle1.getTarget());
    Assertions.assertEquals("licks you with a giant tongue!", obstacle1.getAttack());

  }

  /**
   * Test happy path puzzle.
   */
  @Test
  public void testHappyPathPuzzle() {
    // Start with the Puzzle class
    Assertions.assertEquals("DARKNESS", obstacle2.getName());
    Assertions.assertEquals("Darkness! You cannot see!", obstacle2.getDescription());
    Assertions.assertTrue(obstacle2.getActiveState());
    Assertions.assertTrue(obstacle2.getAffectsTarget());
    Assertions.assertTrue(obstacle2.getAffectsPlayer());
    Assertions.assertEquals("Lamp", obstacle2.getSolution());
    Assertions.assertEquals(150, obstacle2.getValue());
    Assertions.assertEquals("It's dark! You cannot see anything! Maybe we should go back?",
            obstacle2.getEffects());
    Assertions.assertEquals("6:Kitchen", obstacle2.getTarget());
  }
  // Additional tests
  // null or blank fields
  // check solution and changes in field values based on a correct solution.
  //

  @Test
  public void testCheckSolution() {

    Assertions.assertTrue(obstacle1.getActiveState());
    Assertions.assertEquals("Carrot", obstacle1.getSolution());
    Assertions.assertEquals("You did not clear the monster.", obstacle1.checkSolution("Banana"));
    Assertions.assertEquals("You have cleared the monster for 300 points!", obstacle1.checkSolution("Carrot"));
    Assertions.assertFalse(obstacle1.getActiveState());

    Assertions.assertTrue(obstacle2.getActiveState());
    Assertions.assertEquals("Lamp", obstacle2.getSolution());
    Assertions.assertEquals("That did not solve the puzzle.", obstacle2.checkSolution("Flame Thrower"));
    Assertions.assertEquals("You have solved the puzzle for 150 points!", obstacle2.checkSolution("Lamp"));
    Assertions.assertFalse(obstacle2.getActiveState());

  }


  @Test
  public void testManageNulls() {
      this.obstacle3 = new Enemy("Rabbit", "true",  "true", "true", "Carrot", null,
              "Awww. A furry rabbit twitching its nose and eating a carrot. Makes you want to pet him",
              "A monster Rabbit moves towards you! He's blocking the way north. \nI think you might be dinner!",
              null, "7:Dining Room","true", "licks you with a giant tongue!", "monster-rabbit.png");

      Assertions.assertEquals(0, obstacle3.getValue());
      Assertions.assertEquals(0, obstacle3.getDamage());

      this.obstacle4 = new Puzzle("DARKNESS", "true",  "true", "true", "Lamp", "150",
              "Darkness! You cannot see!", "It's dark! You cannot see anything! Maybe we should go back?",
              "6:Kitchen", "darkness.png");

      assertThrows(IllegalArgumentException.class, () -> new Enemy(null, null,  null, null, null, null,
              null, null,
              null, null,null, null, null));

  }


}
