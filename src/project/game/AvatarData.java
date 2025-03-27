package project.game;

import java.util.ArrayList;
import java.util.List;

import project.avatar.Avatar;
import project.elements.IElements;
import project.elements.Item;

public class AvatarData {
  private int health;
  private String name;
  private String bag;
  private int room;

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
