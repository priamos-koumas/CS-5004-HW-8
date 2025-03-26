package project.elements;

import project.game.ItemData;

public class Item extends AbstractContents implements IElements {
  private int weight;
  private int maxUses;
  private int usesRemaining;
  private int value;
  private String whenUsed;

  public Item(String name, String description, int weight, int maxUses, int usesRemaining,
              int value, String whenUsed) {
    super(name, description);
    this.weight = weight;
    this.maxUses = maxUses;
    this.usesRemaining = Math.max(0, usesRemaining);
    this.value = value;
    this.whenUsed = whenUsed;
  }

  public Item(ItemData data) {
    super(data.getName(), data.getDescription());
    if (data.getWeight() != null) {
      this.weight = Integer.parseInt(data.getWeight());
    }
    if (data.getMaxUses() != null) {
      this.maxUses = Integer.parseInt(data.getMaxUses());
    }
    if (data.getUsesRemaining() != null) {
      this.usesRemaining = Integer.parseInt(data.getUsesRemaining());
    }
    if (data.getValue() != null) {
      this.value = Integer.parseInt(data.getValue());
    }
    this.whenUsed = data.getWhenUsed();
  }

  public void decrementUsesRemaining() {
    if (this.usesRemaining > 0) {
      this.usesRemaining--;
    }
    else {
      this.usesRemaining = 0;
    }
  }

  public int getUsesRemaining() {
    return this.usesRemaining;
  }

  public String getWhenUsed() {
    return this.whenUsed;
  }

  public int getWeight() {
    return weight;
  }

  public int getValue() {
    return value;
  }

  public int getMaxUses() {
    return this.maxUses;
  }

  //public <T> void interact(T target) {


  @Override
  public String toString() {
    return "Item{" +
            "weight=" + weight +
            ", maxUses=" + maxUses +
            ", usesRemaining=" + usesRemaining +
            ", value=" + value +
            ", whenUsed='" + whenUsed + '\'' +
            '}';
  }
}
