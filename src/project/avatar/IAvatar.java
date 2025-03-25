package project.avatar;

import project.elements.IElements;
import project.room.Room;

import project.room.CardinalDirection;

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
  public boolean addToBag(IElements item);

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
