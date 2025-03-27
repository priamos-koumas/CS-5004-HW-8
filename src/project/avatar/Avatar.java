package project.avatar;

import java.util.Arrays;
import java.util.List;

import project.elements.IElements;
import project.elements.Item;
import project.game.AvatarData;
import project.game.Game;
import project.game.ItemData;
import project.holder.Bag;
import project.room.CardinalDirection;
import project.room.Room;

public class Avatar implements IAvatar{

  private Game game;
  private int health;
  private String name;
  private Bag inventory = new Bag(13);
  private Room loc;

  public Avatar(int health, String name, Room init) {
    this.health = health;
    this.name = name;
    this.loc = init;
  }

  public Avatar(Game game, AvatarData avatar) {
    this.health = avatar.getHealth();
    this.name = avatar.getName();
    this.loc = game.getRoom(avatar.getRoom());
    setInventory(avatar.getBag());
  }

  public Avatar(Game game) {
    this.game = game;
    this.health = 100;
    this.name = "";
    this.loc = this.game.getRoom(1);
  }

  public Avatar() {
    this.health = 100;
    this.name = "";
  }


  private void setInventory(String inventory) {
    if (inventory != null) {
      List<String> itemsList = Arrays.asList(inventory.split("\\s*,\\s*"));
      for (String item : itemsList) {
        for (IElements i : this.game.getItems()) {
          if (i.getName().equals(item)) {
            this.inventory.addItem(i);
          }
        }
      }
    }
  }


  private void setInventory(List<ItemData> items) {
    for (ItemData item : items) {
      Item itemObject = this.game.getItem("item");
      this.inventory.addItem(itemObject);
    }
  }

  /**
   * move to the given direction.
   * @param direction
   * @return
   */
  @Override
  public boolean moveRoom(CardinalDirection direction) {

    if (this.loc.getNeighbor(direction) == null) {
      return false;
    }

    this.loc = this.loc.getNeighbor(direction);
    return true;

  }

  public String getName() {
    return this.name;
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
