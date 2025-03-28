package gamedriver.holder;

import java.util.ArrayList;
import java.util.List;

import gamedriver.elements.IElements;

public class AbstractItemHolder implements IHolder<IElements> {

  private List<IElements> itemlist = new ArrayList<>();
  private int weightLimit;
  private int usage = 0;

  public AbstractItemHolder(int weightLimit) {
    this.weightLimit = weightLimit;
  }

  /**
   * Check if the bag have enough storage.
   * if true add the item in to the storage list.
   * @param item item
   */
  @Override
  public boolean addItem(IElements item) {
    if (this.weightLimit < this.usage) {
      System.out.println("Not enough space in the bag");
      return false;
    }

    itemlist.add(item);
    this.usage = this.usage + item.getWeight();
    return true;

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
    for (IElements exist : itemlist) {
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
  public List<IElements> getItem() {
    return this.itemlist;
  }


  /**
   * to String method.
   * @return Inventory status
   */
  @Override
  public String toString() {
    String result = "";

    for (IElements exist: this.itemlist) {
      result = result + "\nName: " + exist.getName()
              + "\nDescription: " + exist.getDescription();
    }

    return result;
  }
}