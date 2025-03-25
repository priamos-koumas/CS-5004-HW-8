package project.avatar;

import project.room.Room;
import project.elements.IElements;
import project.holder.Bag;

public interface IAvatar {

  /**
   * move to the given direction.
   * @param direction
   * @return
   */
  public boolean moveRoom(Direction direction);

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
