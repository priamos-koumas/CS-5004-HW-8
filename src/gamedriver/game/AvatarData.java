package gamedriver.game;

import gamedriver.avatar.Avatar;

/**
 * AvatarData is an intermediary class between a JSON file and the Avatar class. Stores
 * all needed data to create an Avatar from a JSON file using a Gson object. Gson objects
 * use the default constructor to create Data objects.
 */
public class AvatarData {
  private int health;
  private String name;
  private String bag;
  private int room;

  /**
   * AvatarData constructor takes an Avatar and converts its data back into AvatarData for
   * storage in a JSON.
   *
   * @param avatar Avatar object being saved
   */
  public AvatarData(Avatar avatar) {
    this.health = avatar.getHealth();
    this.name = avatar.getName();
    this.room = avatar.getLoc().getRoomNumber();
    this.bag = "";
    for (int i = 0; i < avatar.getBag().getItem().size() - 1; i++) {
      this.bag += (avatar.getBag().getItem().get(i).getName() + ", ");
    }
    if (!avatar.getBag().getItem().isEmpty()) {
      this.bag += avatar.getBag().getItem().get(
              avatar.getBag().getItem().size() - 1).getName();
    }
  }

  public int getHealth() {
    return health;
  }

  public String getName() {
    return name;
  }

  public String getBag() {
    return bag;
  }

  public int getRoom() {
    return room;
  }
}
