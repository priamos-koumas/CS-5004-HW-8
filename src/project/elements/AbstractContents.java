package project.elements;

import com.google.gson.annotations.SerializedName;

import project.game.ItemData;

abstract class AbstractContents implements IElements {

  private String name;
  private String description;
  private int weight;

  public AbstractContents(String name, String description,String weight) {
    this.name = name;
    this.description = description;
    this.weight = Integer.parseInt(weight);
  }

  public void Item(ItemData data) {
    if (data.getName() == null || data.getName().isEmpty()) {
      this.name = "Default Name";
    }
    if (data.getDescription() == null || data.getDescription().isEmpty()) {
      this.description = "Description Not Available";
    }
    if (data.getWeight() == null || data.getWeight().isEmpty()) {
      throw new IllegalArgumentException("Weight Not Available");
    }
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getWeight() {
    return weight;
  }
}
