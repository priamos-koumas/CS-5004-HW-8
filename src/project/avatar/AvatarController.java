package project.avatar;

import project.holder.Bag;
import project.room.CardinalDirection;
import project.room.Room;
import project.elements.IElements;

public class AvatarController {

  private Avatar player;

  public AvatarController(Avatar player) {
    this.player = player;
  }

  public void Control (String ... instruction) {
    String instruct = (instruction.length > 0) ? instruction[0] : "";

    if (instruct.equalsIgnoreCase("W") || instruct.equalsIgnoreCase("E") ||
            instruct.equalsIgnoreCase("N")|| instruct.equalsIgnoreCase("S")) {
      for (CardinalDirection dir : CardinalDirection.values()) {
        if (dir.getText().equalsIgnoreCase(instruct)) {
          this.player.moveRoom(dir);
          return;
        }
      }
    }

    else if (instruct.equalsIgnoreCase("T")) {
      String furtherInstruct = (instruction.length > 0) ? instruction[1] : "";
      for (IElements items : this.player.getLoc().getRoomItemsList()) {
        if (items.getName().equalsIgnoreCase(furtherInstruct)) {
          this.player.addToBag(items);
          this.player.getLoc().getRoomItems().removeItem(items.getName());
          return;
        }
      }
    }

    else if (instruct.equalsIgnoreCase("I")) {
      System.out.println(player.getBag().toString());
      return;
    }

    else if (instruct.equalsIgnoreCase("L")) {
      System.out.println(player.getLoc().toString());
      return;
    }

    else if (instruct.equalsIgnoreCase("U")) {
      return; //Still need to figure out how to use an item
    }

    else if (instruct.equalsIgnoreCase("D")) {
      String furtherInstruct = (instruction.length > 0) ? instruction[1] : "";
      for (IElements items : this.player.getBag().getItem()) {
        if (items.getName().equalsIgnoreCase(furtherInstruct)) {
          this.player.getBag().removeItem(items.getName());
          this.player.getLoc().getRoomItems().addItem(items);
          return;
        }
      }
    }

    else if (instruct.equalsIgnoreCase("X")) {
      String furtherInstruct = (instruction.length > 0) ? instruction[1] : "";
      Bag bag1 = player.getBag();
      for (IElements items : bag1.getItem()) {
        if (items.getName().equalsIgnoreCase(furtherInstruct)) {
          System.out.println(items.getDescription());
          return;
        }
      }

      if(furtherInstruct.equalsIgnoreCase("self")) {
        System.out.println(player.toString());
      }
    }

    else if (instruct.equalsIgnoreCase("A")) {
      String furtherInstruct = (instruction.length > 0) ? instruction[1] : "";
      return; //still need to figure out how to output answer.
    }

    else if (instruct.equalsIgnoreCase("Q")) {
      return; //still need to figure out how to quit game.
    }



  }

}
