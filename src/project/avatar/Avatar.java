package project.avatar;

import project.elements.IElements;
import project.holder.Bag;
import project.room.Room;

public class Avatar implements IAvatar{

  private int health;
  private String name;
  private Bag inventory = new Bag(10);
  private Room loc;

  public Avatar(int health, String name, Room init) {
    this.health = health;
    this.name = name;
    this.loc = init;
  }

  /**
   * move to the given direction.
   * @param direction
   * @return
   */
  @Override
  public boolean moveRoom(Direction direction) {

    if (this.loc.getNeighbor(direction) == null) {
      return false;
    }

    this.loc = this.loc.getNeighbor(direction);
    return true;

  }

  public Room getLoc() {
    return this.loc;
  }

  /**
   * add item to bag.
   * @param item
   * @return
   */
  @Override
  public boolean addToBag(IElements item) {
    return this.inventory.addItem(item);
  }

  /**
   * reset the weight limit for the bag
   * @param volume
   */
  @Override
  public void setBagVolume(int volume) {
    this.inventory.setWeightLimit(volume);
  }

  /**
   * get the health info.
   * @return
   */
  @Override
  public int getHealth() {
    return this.health;
  }

  /**
   * set the health info.
   * @param health
   */
  @Override
  public void setHealth(int health) {
    this.health = health;
  }

  @Override
  public Bag getBag() {
    return this.inventory;
  }

  /**
   * to String method
   * @return
   */
  @Override
  public String toString() {
    String status = "";
    if (this.health <= 0 )
      status =  HEALTH_STATUS.SLEEP.getText();
    if(this.health < 40)
      status =  HEALTH_STATUS.WOOZY.getText();
    if(this.health < 70)
      status =  HEALTH_STATUS.FATIGUED.getText();
    if(this.health >=70)
      status =  HEALTH_STATUS.AWAKE.getText();

    String result = "Name: " + this.name
            + "\n Health: " + this.health + " feeling " + status
            + "\n Current Loc: " + this.loc.getDescription()
            + "\n Inventory: " + this.inventory.toString();
    return result;
  }
}
