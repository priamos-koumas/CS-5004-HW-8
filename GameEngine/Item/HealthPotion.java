package GameEngine.Item;

import java.lang.reflect.Method;

public class HealthPotion extends abstractItem {

  private final int healAmount;

  public HealthPotion(String name, String description,
                      int weight, int usage ,int healAmount) {
    super(name, description, weight, usage);
    this.healAmount = healAmount;
  }

  @Override
  public <T> void interact(T target) {
    try {
      Method getHealthMethod = target.getClass().getMethod("getHealth");
      Method setHealthMethod = target.getClass().getMethod("setHealth", int.class);

      int currentHealth = (int) getHealthMethod.invoke(target);
      setHealthMethod.invoke(target, currentHealth + this.healAmount);

      this.usage = this.usage - 1;

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String toString() {
    String result = "Name: " + this.name + "\nDescription: "
            + this.description + "\nUsage: remain " + this.usage + " time\n";
    return result;
  }
}
