package GameEngine;

import java.util.List;

public class MainTest {
  public static void main(String[] args) {

    bag bag1 = new bag(10);

    IItem healPotion = new HealthPotion("Heal Potion", "Heal 10",
            3, 1, 10);

    IItem healPotionMax = new HealthPotion("Heal Potion Max", "Heal 20",
            3, 4, 20);

    bag1.addItem(healPotion);
    bag1.addItem(healPotionMax);
    bag1.addItem(healPotion);

    bag1.removeItem("Heal Potion");
    bag1.removeItem("Heal Potion");

    bag1.addItem(healPotionMax);
    bag1.addItem(healPotionMax);

    List<IItem> list = bag1.getItem();

    for (IItem exist: list) {
      System.out.println(exist.toString());
    }


  }
}
