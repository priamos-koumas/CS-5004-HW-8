package project.game;

import java.util.List;

import project.avatar.Avatar;

public class AvatarData {
  private int health;
  private String name;
  private List<ItemData> bag;
  private RoomData room;

  public AvatarData(Avatar avatar) {

  }

  public int getHealth() {
    return health;
  }

  public String getName() {
    return name;
  }

  public List<ItemData> getBag() {
    return bag;
  }

  public RoomData getRoom() {
    return room;
  }
}
