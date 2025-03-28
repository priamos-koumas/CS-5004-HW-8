package gamedriver.obstacle;

import gamedriver.game.MonsterData;

/**
 * The enemy class supports the creation, removal and solving of enemies within
 * the game.
 */
public class Enemy extends AbstractObstacle {

  private final int damage;  // make an int
  private boolean canAttack; // make a boolean
  private String attack;


  public Enemy(String name, String active, String affects_target, String affects_player,
               String solution, String value, String description, String effects, String damage,
               String target, String can_attack, String attack, String picture) {
    // Push to abstract constructor
    super(name, active, affects_target, affects_player, solution, value, description, effects,
            target, picture);

    // Not sent to abstract
    if (damage == null) {
      this.damage = 0;
    } else {
      this.damage = Integer.parseInt(damage);
    }
    this.canAttack = booleanChecker(can_attack);
    this.attack = attack;
  }

  public Enemy(MonsterData monster) {
    super(monster.getName(), monster.getActive(), monster.getAffectsTarget(), monster.getAffectsPlayer(),
            monster.getSolution(), monster.getValue(), monster.getDescription(), monster.getEffects(),
            monster.getTarget(), monster.getPicture());

    this.damage = Integer.parseInt(monster.getDamage());
    this.canAttack = booleanChecker(monster.getCanAttack());
    this.attack = monster.getAttack();
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

  /**
   * Checks solution is correct
   */
  @Override
  public String checkSolution(String solution) {
    if (solution.equalsIgnoreCase(this.getSolution())) {
      this.setActiveState(false);
      this.setAffectsTarget(false);
      this.setAffectsPlayer(false);
      return "You have cleared the monster for " + this.getValue() + " points!";
    } else {
      return "You did not clear the monster.";
    }
  }

  @Override
  public String toString() {
    return "Enemy{" +
            "name='" + super.getName() + '\'' +
            ", active=" + super.getActiveState() +
            ", affectsTarget=" + super.getAffectsTarget() +
            ", affectsPlayer=" + super.getAffectsPlayer() +
            ", solution='" + super.getSolution() + '\'' +
            ", value=" + super.getValue() +
            ", description='" + super.getDescription() + '\'' +
            ", effects='" + super.getEffects() + '\'' +
            ", target='" + super.getTarget() + '\'' +
            ", damage=" + damage +
            ", canAttack=" + canAttack +
            ", attack='" + attack + '\'' +
            '}';
  }
}


