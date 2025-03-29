package gamedriver.avatar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import gamedriver.elements.IElements;
import gamedriver.elements.Item;
import gamedriver.game.AvatarData;
import gamedriver.game.Game;
import gamedriver.game.ItemData;
import gamedriver.holder.Bag;
import gamedriver.room.CardinalDirection;
import gamedriver.room.Room;

/**
 * Avatar class.
 */
public class Avatar implements IAvatar{

  private int score = 0;
  private Game game;
  private int health;
  private String name;
  private Bag inventory = new Bag(13);
  private Room loc;

  /**
   * Avatar constructor for testing.
   * @param health player health set to be 100
   * @param name Player name
   * @param init initial location
   */
  public Avatar(int health, String name, Room init) {
    this.health = health;
    this.name = name;
    this.loc = init;
  }

  /**
   * Avatar constructor.
   * @param game
   * @param avatar
   */
  public Avatar(Game game, AvatarData avatar) {
    this.game = game;
    this.health = avatar.getHealth();
    this.name = avatar.getName();
    this.loc = game.getRoom(avatar.getRoom());
    setInventory(avatar.getBag());
  }

  /**
   * Avatar constructor without name.
   * @param game
   */
  public Avatar(Game game) {
    this.game = game;
    this.health = 100;
    this.name = "";
    this.loc = this.game.getRoom(1);
  }

  /**
   * Avatar constructor without game and name.
   */
  public Avatar() {
    this.health = 100;
    this.name = "";
  }

  /**
   * Name setter.
   */
  public void setName() {
    Scanner scanner = new Scanner(System.in);
    String name = scanner.nextLine();
    this.name = name;
  }


  /**
   * Set Inventory.
   * @param inventory Inventory
   */
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


  /**
   * set inventory with Item
   * @param items
   */
  private void setInventory(List<ItemData> items) {
    for (ItemData item : items) {
      Item itemObject = this.game.getItem("item");
      this.inventory.addItem(itemObject);
    }
  }

  /**
   * move to the given direction.
   * @param direction Cardinal Direction enum
   * @return
   */
  @Override
  public String moveRoom(CardinalDirection direction) {

    if (this.loc.getNeighbor(direction) == null) {
      return "fail to move";
    }

    this.loc = this.loc.getNeighbor(direction);
    return "Successfully move to next destination";

  }

  /**
   * Name getter.
   * @return player name
   */
  public String getName() {
    return this.name;
  }

  /**
   * getter for current location
   * @return current location room
   */
  public Room getLoc() {
    return this.loc;
  }

  /**
   * add item to bag.
   * @param item IElement
   * @return True if success.
   */
  @Override
  public boolean addToBag(IElements item) {
    return this.inventory.addItem(item);
  }

  /**
   * reset the weight limit for the bag
   * @param volume setter for the weight limit
   */
  @Override
  public void setBagVolume(int volume) {
    this.inventory.setWeightLimit(volume);
  }

  /**
   * get the health info.
   * @return return health info
   */
  @Override
  public int getHealth() {
    return this.health;
  }

  /**
   * set the health info.
   * @param health health setter
   */
  @Override
  public void setHealth(int health) {
    this.health = health;
  }

  /**
   * return player inventory status.
   * @return bag
   */
  @Override
  public Bag getBag() {
    return this.inventory;
  }

  /**
   * to String method
   * @return Player status
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
            + "\n Health: " + this.health + " feeling " + status;
    return result;
  }

  /**
   * Setter for player's score
   * @param score player's score
   */
  public void setScore (int score) {
    this.score = this.score + score;
  }

  /**
   * getter for the score.
   * @return score.
   */
  public int getScore() {
    return this.score;
  }
}
