



/**
 * The enemy class supports the creation, removal and solving of enemies within
 * the game.
 */
public class Enemy extends AbstractObstacle {
  private String name;
  private String description;
  private String answer;
  private boolean solved = false;
  private int health;
  private int attackDamage;
  private int hurtEnemy;
  private String item; // Is this the correct type?


  public Enemy(String name, String description, String answer, boolean solved, int attackDamage) {
    super(name, description, answer);
    this.solved = solved;
    this.health = 100;
    this.attackDamage = attackDamage;
    // add item to drop
    // add a drop item function
  }

  /**
   * Returns current health.
   */
  @Override
  public int getHealth() {
    return this.health;
  }

  /**
   * This addresses an attack on the enemy.
   */
  @Override
  public void decrementHealth() {
    this.health = health - 25;
    System.out.println("You've hit the enemy!");
    if (this.health <= 0) {
      this.solved = true;
      System.out.println("The enemy has been defeated and is going to sleep!");
    }
  }

}
