package gamedriver.elements;

import gamedriver.game.ItemData;

/**
 * Set up attributes and implement element interface.
 */
abstract class AbstractContents implements IElements {

  private String name;
  private String description;

  /**
   * Set up value of name and description in the constructor.
   * @param name name of item
   * @param description description of item
   */
  public AbstractContents(String name, String description) {
    this.name = name;
    this.description = description;
  }

  /**
   * Set up value of name and description if null or empty.
   * @param data item data type
   */

  public void Item(ItemData data) {
    if (data.getName() == null || data.getName().isEmpty()) {
      this.name = "Default Name";
    }
    if (data.getDescription() == null || data.getDescription().isEmpty()) {
      this.description = "Description Not Available";
    }
  }

  /**
   * Getter method for description of item.
   * @return description
   */
  @Override
  public String getDescription() {
    return description;
  }


  /**
   * Getter method for name of the item.
   * @return name
   */
  @Override
  public String getName() {
    return name;
  } }

