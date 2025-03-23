package GameEngine;

import java.util.List;

public interface IHolder {

  /**
   * Check if the bag have enough storage.
   * if true add the item in to the storage list.
   * @param item
   */
  public void addItem(IItem item);

  /**
   * Check if the item is in the holder.
   * if true remove and return the item.
   * @param name
   */
  public void removeItem(String name);

  /**
   * Check if the item is in the holder.
   * @return Item object
   */
  public <T> List<T> getItem();
}
