package gamedriver.avatar;

import gamedriver.room.CardinalDirection;
import gamedriver.room.Room;
import gamedriver.elements.IElements;
import gamedriver.holder.Bag;

public interface IAvatar {

  /**
   * move to the given direction.
   * @param direction
   * @return
   */
  public String moveRoom(CardinalDirection direction);

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

  public Bag getBag();

  public String toString();

}
