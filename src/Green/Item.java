package Green;

import com.google.gson.annotations.SerializedName;

public class Item extends AbstractContents implements IElements {

  @SerializedName("max_uses")
  private int maxUses;

  @SerializedName("uses_remaining")
  private int usesRemaining;

  @SerializedName("value")
  private int value;

  @SerializedName("when_used")
  private String whenUsed;

  public Item(String name, String description, int weight, int maxUses, int usesRemaining,
              int value, String whenUsed) {
    super(name, description, weight);
    this.weight = weight;
    this.maxUses = maxUses;
    this.usesRemaining = usesRemaining;
    this.value = value;
    this.whenUsed = whenUsed;

  }

  public void decrementUsesRemaining() {
    if (this.usesRemaining > 0) {
      this.usesRemaining--;
    } else {
      this.usesRemaining = 0;
    }
  }

  public int getUsesRemaining() {
    return this.usesRemaining;
  }

  public String getWhenUsed() {
    return this.whenUsed;
  }

  public int getValue() {
    return value;
  }
}

