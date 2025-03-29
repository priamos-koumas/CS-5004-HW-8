package gamedriver.avatar;

import java.util.Scanner;

import gamedriver.GameCommandReaderNew;
import gamedriver.game.Game;
import gamedriver.game.JsonData;
import gamedriver.holder.Bag;
import gamedriver.obstacle.IObstacle;
import gamedriver.room.CardinalDirection;
import gamedriver.elements.IElements;

import static java.awt.SystemColor.control;
import static java.lang.System.exit;

/**
 * Controller class.
 */
public class AvatarController {
  private Game game;
  private GameCommandReaderNew userReader;
  private Avatar player;
  private boolean save = false;

  /**
   * Controller constructor.
   * @param game
   * @param userReader
   */
  public AvatarController(Game game, GameCommandReaderNew userReader) {
    this.game = game;
    this.userReader = userReader;
    this.player = this.game.getAvatar();
  }

  /**
   * Controller constructor for avatar unit test.
   * @param avatar
   */
  public AvatarController(Avatar avatar) {
    this.game = null;
    this.player = avatar;
  }

  /**
   * Gaming loop.
   */
  public void go() {

    System.out.println("Please enter your name: ");
    game.getAvatar().setName();

    while(userReader.getDataFromUser()) {
      this.Control(userReader.getOperator(), userReader.getOperand1());
      if (game.getAvatar().getLoc().getObstacle() != null && game.getAvatar().getLoc().getObstacle().getActiveState()) {
        IObstacle obstacle = game.getAvatar().getLoc().getObstacle();
        System.out.println(obstacle.getEffects());
        game.getAvatar().setHealth(game.getAvatar().getHealth() + obstacle.getDamage());
        System.out.println(game.getAvatar().toString());
      }
      if (game.getAvatar().getHealth() == 0) {
        System.out.println("Game Over \n" + "Your score is: ");
        System.out.println(game.getAvatar().getScore());
        exit(0);
      }
    }
  }

  /**
   * Control method.
   * @param instruction Sting of instruction and further instruct.
   * @return String of output
   */
  public String Control (String ... instruction) {
    String instruct = (instruction.length > 0) ? instruction[0] : "";

    //Moving.
    if (instruct.equalsIgnoreCase("W") || instruct.equalsIgnoreCase("E") ||
            instruct.equalsIgnoreCase("N")|| instruct.equalsIgnoreCase("S")) {
      for (CardinalDirection dir : CardinalDirection.values()) {
        if (dir.getText().equalsIgnoreCase(instruct)) {

//          System.out.println(this.player.moveRoom(dir));  THIS WAS CAUSING PLAYER TO MOVE TWICE
          System.out.println("You are now in: " + player.getLoc().getRoomName());
          System.out.println(player.getLoc().getDescription());
          return this.player.moveRoom(dir);
        }
      }
    }

    //Pick-up item.
    else if (instruct.equalsIgnoreCase("T")) {
      String furtherInstruct = (instruction.length > 0) ? instruction[1] : "";
      for (IElements items : this.player.getLoc().getRoomItemsList()) {
        if (items.getName().equalsIgnoreCase(furtherInstruct)) {
          this.player.addToBag(items);
          this.player.getLoc().getRoomItems().removeItem(items.getName());
          System.out.println("Successfully pick up");
          return "Successfully pick up";
        }
      }
      System.out.println("There is nothing here");
      return "There is nothing here";
    }

    // Examine item
    else if (instruct.equalsIgnoreCase("I")) {
      System.out.println(player.getBag().toString());
      return player.getBag().toString();
    }
    //Look around.
    else if (instruct.equalsIgnoreCase("L")) {
      System.out.println(player.getLoc().toString());
      return player.getLoc().toString();
    }

    //Use item
    else if (instruct.equalsIgnoreCase("U")) {
      String targerItem = (instruction.length > 0) ? instruction[1] : "";
      for (IElements item : this.player.getBag().getItem()) {
        if (item.getName().equalsIgnoreCase(targerItem)) {
          String outcome = this.player.getLoc().solveObstacle(item.getName());

          IObstacle obstacle = game.getAvatar().getLoc().getObstacle();
          if (obstacle != null
                  && !(obstacle.getActiveState())) {
            this.player.setScore(obstacle.getValue() + this.player.getScore());
          }
          System.out.println(outcome);
          item.decrementUsesRemaining();
          if (item.usesRemaining() == 0) {
            this.player.getBag().removeItem(item.getName());
            System.out.println("Maximum usage limit reached. " + item.getName() + " is destroyed");
          }
          return outcome;
        }
      }
    }

    //Drop item.
    else if (instruct.equalsIgnoreCase("D")) {
      String furtherInstruct = (instruction.length > 0) ? instruction[1] : "";
      for (IElements items : this.player.getBag().getItem()) {
        if (items.getName().equalsIgnoreCase(furtherInstruct)) {
          this.player.getBag().removeItem(items.getName());
          this.player.getLoc().getRoomItems().addItem(items);
          System.out.println("Item Dropped");
          return "Item Dropped";
        }
      }
      System.out.println("There is no such thing in your bag");
      return "There is no such thing in your bag";
    }

    //examine item.
    else if (instruct.equalsIgnoreCase("X")) {
      String furtherInstruct = (instruction.length > 0) ? instruction[1] : "";
      Bag bag1 = player.getBag();
      for (IElements items : bag1.getItem()) {
        if (items.getName().equalsIgnoreCase(furtherInstruct)) {
          System.out.println(items.getDescription());
          return items.getDescription();
        }
      }

      if(furtherInstruct.equalsIgnoreCase("self")) {
        System.out.println(player.toString());
        return player.toString();
      }
    }

    // Solve puzzle with an answer.
    else if (instruct.equalsIgnoreCase("A")) {
      String answer = (instruction.length > 0) ? instruction[1] : "";
      String outcome = this.player.getLoc().solveObstacle(answer);
      System.out.println(outcome);
      return outcome;
    }

    // Quit
    else if (instruct.equalsIgnoreCase("Q")) {

      if ( !this.save ) {
        System.out.println("Game haven't save yet \n");
        System.out.println("Do you really want to Quit (Yes/No)?");
        Scanner scanner = new Scanner(System.in);
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("Yes")) {
          System.out.println("Game Quit \n");
          System.out.println("Your current score is: ");
          System.out.println(player.getScore());
          exit(0);
        }
        else if (confirm.equalsIgnoreCase("No")) {
          System.out.println("Game Resume");
          return "Game Resume";
        }
        else {
          System.out.println("I guess you're gonna keep playing");
          return "I guess you're gonna keep playing";
        }

      }
      System.out.println("Game Quit \n");
      System.out.println("Your current score is: ");
      System.out.println(player.getScore());
      exit(0);

    }

    //Saving.
    else if (instruct.equalsIgnoreCase("V")) {

      System.out.println("Game saving");
      this.game.save();
      this.save = true;
      return "Game saving";
    }

    //Restore
    else if (instruct.equalsIgnoreCase("R")) {

      System.out.println("Game restoring");
      boolean loaded = this.game.restore();
      if (loaded == false) {
        return "Game file not found.";
      }
      this.player = this.game.getAvatar();
      return "Game restoring";
    }
    return "";

  }

}
