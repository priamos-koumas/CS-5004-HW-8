package project.avatar;

import project.game.Game;
import project.holder.Bag;
import project.room.CardinalDirection;
import project.room.Room;
import project.elements.IElements;

import static java.lang.System.exit;

public class AvatarController {
  private final Game game;
  private Avatar player;

  public AvatarController(Game game) {
    this.game = game;
    this.player = this.game.getAvatar();
  }

  public void Control (String ... instruction) {
    String instruct = (instruction.length > 0) ? instruction[0] : "";

    if (instruct.equalsIgnoreCase("W") || instruct.equalsIgnoreCase("E") ||
            instruct.equalsIgnoreCase("N")|| instruct.equalsIgnoreCase("S")) {
      for (CardinalDirection dir : CardinalDirection.values()) {
        if (dir.getText().equalsIgnoreCase(instruct)) {

          System.out.println(this.player.moveRoom(dir));
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
          System.out.println("Successfully pick up");
          return;
        }
      }
      System.out.println("There is nothing here");
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
      String targerItem = (instruction.length > 0) ? instruction[1] : "";
      for (IElements item : this.player.getBag().getItem()) {
        if (item.getName().equalsIgnoreCase(targerItem)) {
          String outcome = this.player.getLoc().solveObstacle(item.getName());
          this.player.getBag().removeItem(item.getName());
          System.out.println(outcome);
          return;
        }
      }
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
      String answer = (instruction.length > 0) ? instruction[1] : "";
      String outcome = this.player.getLoc().solveObstacle(answer);
      System.out.println(outcome);
    }

    else if (instruct.equalsIgnoreCase("Q")) {
      System.out.println("Game Ended without saving");
      exit(1);
    }



  }

}
