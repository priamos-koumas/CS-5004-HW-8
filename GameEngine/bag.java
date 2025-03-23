package GameEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class bag implements IHolder {

  private List<IItem> itemlist = new ArrayList<>();
  private final int weightLimit;
  private int usage = 0;

  public bag (int weightLimit) {
    this.weightLimit = weightLimit;
  }

  /**
   * Check if the bag have enough storage.
   * if true add the item in to the storage list.
   * @param item item
   */
  public void addItem(IItem item) {

    if (this.weightLimit < this.usage) {
      System.out.println("Not enough space in the bag");
      return;
    }

    itemlist.add(item);
    this.usage = this.usage + item.getWeight();

  }

  /**
   * Check if the item is in the holder.
   * if true remove and return the item.
   * @param name item
   */
  public void removeItem(String name) {

    boolean remove = false;
    if (itemlist.isEmpty() || itemlist == null) {
      System.out.println("Nothing is in the list");
    }
    for (IItem exist : itemlist) {
      if (exist != null && exist.getName() != null
              && exist.getName().equalsIgnoreCase(name)) {
        itemlist.remove(exist);
        remove = true;
        break;
      }
    }
    if (!remove) {
      System.out.println("No such item in the bag");
    }
  }

  /**
   * Check if the item is in the holder.
   * @return Item object
   */
  public List<IItem> getItem() {
    return this.itemlist;
  }
}
