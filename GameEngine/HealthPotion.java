package GameEngine;

public class HealthPotion extends abstractItem {

  private final int healAmount;

  public HealthPotion(String name, String description,
                      int weight, int usage ,int healAmount) {
    super(name, description, weight, usage);
    this.healAmount = healAmount;
  }

  @Override
  public <T> void interact(T target) {
    //target.setHealth(target.getHealth() + this.healAmount);
    return;
  }

  public String toString() {
    String result = "Name: " + this.name + "\nDescription: "
            + this.description + "\nUsage: remain " + this.usage + " time\n";
    return result;
  }
}
