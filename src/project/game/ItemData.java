package project.game;

import com.google.gson.annotations.SerializedName;

import project.elements.Item;

public class ItemData {

  @SerializedName("name")
  private String name;

  @SerializedName("weight")
  private String weight;

  @SerializedName("max_uses")
  private String maxUses;

  @SerializedName("uses_remaining")
  private String usesRemaining;

  @SerializedName("value")
  private String value;

  @SerializedName("when_used")
  private String whenUsed;

  @SerializedName("description")
  private String description;

  @SerializedName("picture")
  private String picture;

public ItemData(Item item) {
  this.name = item.getName();
  this.weight = String.valueOf(item.getWeight());
  this.maxUses = String.valueOf(item.getMaxUses());
  this.usesRemaining = String.valueOf(item.getUsesRemaining());
  this.value = String.valueOf(item.getValue());
  this.description = item.getDescription();
  // Picture
}

  public String getName() {
    return name;
  }

  public String getWeight() {
    return weight;
  }

  public String getMaxUses() {
    return maxUses;
  }

  public String getUsesRemaining() {
    return usesRemaining;
  }

  public String getValue() {
    return value;
  }

  public String getWhenUsed() {
    return whenUsed;
  }

  public String getDescription() {
    return description;
  }

  public String getPicture() {
    return picture;
  }
}
