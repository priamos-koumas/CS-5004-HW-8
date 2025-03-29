package gamedriver.holder;

import java.util.List;

public interface IHolder <T> {

  /**
   * Check if the bag have enough storage.
   * if true add the item in to the storage list.
   * @param item
   */
  public boolean addItem(T item);

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


  /**
   * To String.
   * @return all the item name and description.
   */
  public String toString();
}