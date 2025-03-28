package project.elements;

import project.game.ItemData;

abstract class AbstractContents implements IElements {
  private String name;
  private String description;

  public AbstractContents(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public void Item(ItemData data) {
    if (data.getName() == null || data.getName().isEmpty()) {
      this.name = "Default Character";
    }
    if (data.getDescription() == null || data.getDescription().isEmpty()) {
      this.description = "Description Not Available";
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
}
