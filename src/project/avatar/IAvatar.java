package project.avatar;

import GameEngine.Holder.bag;
import GameEngine.Item.IItem;
import GameEngine.Room.Room;

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

  public bag getBag();

  public String toString();

}
