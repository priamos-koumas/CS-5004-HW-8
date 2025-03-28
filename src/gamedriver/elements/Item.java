package gamedriver.elements;

import gamedriver.game.ItemData;

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
    } else {
      throw new IllegalArgumentException("Must have a weight value.");
    }
    if (data.getMaxUses() != null) {
      this.maxUses = Integer.parseInt(data.getMaxUses());
    } else {
      this.maxUses = 1000000000;
    }
    if (data.getUsesRemaining() != null) {
      this.usesRemaining = Integer.parseInt(data.getUsesRemaining());
    } else {
      this.usesRemaining = 1000000000;
    }
    if (data.getValue() != null) {
      this.value = Integer.parseInt(data.getValue());
    } else {
      throw new IllegalArgumentException("Must know value of item.");
    }
    if (data.getWhenUsed() != null) {
      this.whenUsed = data.getWhenUsed();
    } else {
      throw new IllegalArgumentException("Must know when to use item.");
    }
  }

  public void decrementUsesRemaining() {
    if (this.usesRemaining > 0) {
      this.usesRemaining--;
    }
    else {
      this.usesRemaining = 0;
    }
  }

  public int usesRemaining() {
    return this.usesRemaining;
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
