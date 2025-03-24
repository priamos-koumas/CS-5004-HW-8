package GameEngine;

import java.util.List;

import GameEngine.Avatar.Avatar;
import GameEngine.Avatar.AvatarController;
import GameEngine.Avatar.Direction;
import GameEngine.Holder.bag;
import GameEngine.Item.HealthPotion;
import GameEngine.Item.IItem;
import GameEngine.Room.Room;

public class MainTest {
  public static void main(String[] args) {

    Room rm0 = new Room("INIT", 0, "Respawn spot");
    Room rm1 = new Room("Room1", 1, "west room");
    Room rm2 = new Room("Room2", 2, "east room");
    Room rm3 = new Room("Room3", 3, "south room");

    rm0.setNeighbor(Direction.WEST, rm1);
    rm0.setNeighbor(Direction.EAST, rm2);
    rm0.setNeighbor(Direction.SOUTH, rm3);

    IItem healingPotion = new HealthPotion("small potion"
            ,"Heal 10", 5, 1, 10);
    rm1.getInvent().addItem(healingPotion);

    Avatar player = new Avatar(100, "Warrior", rm0);

    System.out.println(player.toString());


    AvatarController control = new AvatarController(player);
    control.Control("Move", "W");
    System.out.println(player.toString());
    System.out.println(rm1.toString());

    control.Control("add", "small potion");
    System.out.println(player.toString());

  }
}
