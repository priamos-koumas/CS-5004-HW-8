package avatar;

import room.Room;

import room.CardinalDirection;
import elements.IItem;

public interface IAvatar {

  /**
   * move to the given direction.
   * @param direction
   * @return
   */
  public boolean moveRoom(CardinalDirection direction);

  /**
   * get room.
   * @return
   */
  public Room getLoc();

  /**
   * add item to bag.
   * @param item
   * @return
   */
  public boolean addToBag(IItem item);

  /**
   * reset the weight limit for the bag
   * @param volume
   */
  public void setBagVolume(int volume);

  /**
   * get the health info.
   * @return
   */
  public int getHealth();

  /**
   * set the health info.
   * @param health
   */
  public void setHealth(int health);

  public String toString();

}
