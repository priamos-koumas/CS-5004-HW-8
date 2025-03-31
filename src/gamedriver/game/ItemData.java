package gamedriver.game;

import com.google.gson.annotations.SerializedName;

<<<<<<<< HEAD:src/project/game/ItemData.java
import project.elements.Item;

========
import gamedriver.elements.Item;

/**
 * ItemData is an intermediary class between a JSON file and the Item class. Stores
 * all needed data to create an Item from a JSON file using a Gson object. Gson objects
 * use the default constructor to create Data objects.
 */
>>>>>>>> f12dfc66f43f00b676ecaf48a260b29318c27306:src/gamedriver/game/ItemData.java
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

<<<<<<<< HEAD:src/project/game/ItemData.java
========
  /**
   * ItemData constructor takes an Item and converts its data back into ItemData for
   * storage in a JSON.
   *
   * @param item Item object being saved
   */
>>>>>>>> f12dfc66f43f00b676ecaf48a260b29318c27306:src/gamedriver/game/ItemData.java
public ItemData(Item item) {
  this.name = item.getName();
  this.weight = String.valueOf(item.getWeight());
  this.maxUses = String.valueOf(item.getMaxUses());
  this.usesRemaining = String.valueOf(item.getUsesRemaining());
  this.value = String.valueOf(item.getValue());
  this.whenUsed = item.getWhenUsed();
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
