package gamedriver.elements;

import gamedriver.game.ItemData;

/**
 * Set up attributes for items.
 */
public class Item extends AbstractContents implements IElements {
  private int weight;
  private int maxUses;
  private int usesRemaining;
  private int value;
  private String whenUsed;

  /**
   * Set up constructor method for item class.
   * @param name item name
   * @param description item description
   * @param weight item weight
   * @param maxUses item maximum amount of uses
   * @param usesRemaining item's amount of uses remaining
   * @param value value of the item
   * @param whenUsed when the item should be used
   */
  public Item(String name, String description, int weight, int maxUses, int usesRemaining,
              int value, String whenUsed) {
    super(name, description);
    this.weight = weight;
    this.maxUses = maxUses;
    this.usesRemaining = Math.max(0, usesRemaining);
    this.value = value;
    this.whenUsed = whenUsed;
  }

  /**
   * What value of item should be in case certain parameters are null.
   * @param data ItemData type
   */
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

  /**
   * Method use to decrement the amount of uses that are remaining every time an item is used.
   */
  public void decrementUsesRemaining() {
    if (this.usesRemaining > 0) {
      this.usesRemaining--;
    }
    else {
      this.usesRemaining = 0;
    }
  }

  /**
   * Used for contorller.
   * @return uses remaining
   */
  public int usesRemaining() {
    return this.usesRemaining;
  }

  /**
   * Getter method to see how many uses are remaining for a certain item.
   * @return usesRemaining.
   */
  public int getUsesRemaining() {
    return this.usesRemaining;
  }

  /**
   * Getter method used to see when an item should be used.
   * @return whenUsed
   */
  public String getWhenUsed() {
    return this.whenUsed;
  }

  /**
   * Getter method to get the value of the item's weight.
   * @return weight
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Getter method to get item value.
   * @return value
   */
  public int getValue() {
    return value;
  }

  /**
   * Getter method use to get max amount of item uses.
   * @return max amount of uses
   */
  public int getMaxUses() {
    return this.maxUses;
  }


  /**
   * To string method to print item's parameters
   * @return printed statement of all attributes.
   */
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
