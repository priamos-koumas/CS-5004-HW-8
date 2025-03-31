package gamedriver.avatar;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import gamedriver.GameCommandReader;
import gamedriver.game.Game;
import gamedriver.holder.Bag;
import gamedriver.obstacle.IObstacle;
import gamedriver.room.CardinalDirection;
import gamedriver.elements.IElements;

import static java.lang.System.exit;

/**
 * Controller class.
 */
public class AvatarController {
  private Game game;
  private GameCommandReader userReader;
  private Avatar player;
  private boolean save = false;

  /**
   * Controller constructor.
   * @param game
   * @param userReader
   */
  public AvatarController(Game game, GameCommandReader userReader) {
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

    if (this.game.getAvatar().getName().isEmpty()) {
      userReader.sendOut("Please enter your name: ");
      this.userReader.getDataFromUser();
      game.getAvatar().setName(this.userReader.getLine());
    }
    userReader.sendOut("To move, enter: (N)orth, (S)outh, (E)ast or (W)est.\n" +
            "Other actions: (I)nventory, (L)ook around the location, (U)se an item\n" +
            "(T)ake an item, (D)rop an item, or e(X)amine something. \n" +
            "(A)nswer a question or provide a text solution. \n" +
            "To end the game, enter (Q)uit to quit and exit.\n" +
            "To save the game, enter sa(V)e to quit and exit.\n" +
            "To restore the game, enter (R)estore.\n");
    while(userReader.getDataFromUser()) {
      this.Control(userReader.getCommand(), userReader.getDetails());

      if (game.getAvatar().getLoc().getObstacle() != null && game.getAvatar().getLoc().getObstacle().getActiveState()) {
        IObstacle obstacle = game.getAvatar().getLoc().getObstacle();
        userReader.sendOut(obstacle.getEffects());
        game.getAvatar().setHealth(game.getAvatar().getHealth() + obstacle.getDamage());
        userReader.sendOut(game.getAvatar().toString());
      }
      if (game.getAvatar().getHealth() == 0) {
        userReader.sendOut("Game Over \n" + "Your score is: ");
        userReader.sendOut(String.valueOf(game.getAvatar().getScore()));
        exit(0);
      }
      userReader.sendOut("To move, enter: (N)orth, (S)outh, (E)ast or (W)est.\n" +
              "Other actions: (I)nventory, (L)ook around the location, (U)se an item\n" +
              "(T)ake an item, (D)rop an item, or e(X)amine something. \n" +
              "(A)nswer a question or provide a text solution. \n" +
              "To end the game, enter (Q)uit to quit and exit.\n" +
              "To save the game, enter sa(V)e to quit and exit.\n" +
              "To restore the game, enter (R)estore.\n");
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

          String result = this.player.moveRoom(dir);
          userReader.sendOut(result);
          userReader.sendOut("You are now in: " + player.getLoc().getRoomName());
          userReader.sendOut(player.getLoc().getDescription());
          return result;
        }
      }
    }

    //Pick-up item.
    else if (instruct.equalsIgnoreCase("T")) {
      String furtherInstruct = (instruction.length > 0) ? instruction[1] : "";
      for (IElements items : this.player.getLoc().getRoomItems()) {
        if (items.getName().equalsIgnoreCase(furtherInstruct)) {
          this.player.addToBag(items);
          this.player.getLoc().getRoomItems().remove(items);
          userReader.sendOut("Successfully pick up");
          return "Successfully pick up";
        }
      }
      userReader.sendOut("There is nothing here");
      return "There is nothing here";
    }

    // Examine item
    else if (instruct.equalsIgnoreCase("I")) {
      userReader.sendOut(player.getBag().toString());
      return player.getBag().toString();
    }
    //Look around.
    else if (instruct.equalsIgnoreCase("L")) {
      userReader.sendOut(player.getLoc().toString());
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
          userReader.sendOut(outcome);
          item.decrementUsesRemaining();
          if (item.usesRemaining() == 0) {
            this.player.getBag().removeItem(item.getName());
            userReader.sendOut("Maximum usage limit reached. " + item.getName() + " is destroyed");
            return "Maximum usage limit reached. " + item.getName() + " is destroyed";
          }
          return outcome;
        }
      }
      userReader.sendOut("There is no such thing in your bag");
      return "There is no such thing in your bag";
    }

    //Drop item.
    else if (instruct.equalsIgnoreCase("D")) {
      String furtherInstruct = (instruction.length > 0) ? instruction[1] : "";
      for (IElements items : this.player.getBag().getItem()) {
        if (items.getName().equalsIgnoreCase(furtherInstruct)) {
          this.player.getBag().removeItem(items.getName());
          this.player.getLoc().getRoomItems().add(items);
          userReader.sendOut("Item Dropped");
          return "Item Dropped";
        }
      }
      userReader.sendOut("There is no such thing in your bag");
      return "There is no such thing in your bag";
    }

    //examine item.
    else if (instruct.equalsIgnoreCase("X")) {
      String furtherInstruct = (instruction.length > 0) ? instruction[1] : "";
      Bag bag1 = player.getBag();
      for (IElements items : bag1.getItem()) {
        if (items.getName().equalsIgnoreCase(furtherInstruct)) {
          userReader.sendOut(items.getDescription());
          return items.getDescription();
        }
      }

      if(furtherInstruct.equalsIgnoreCase("self")) {
        userReader.sendOut(player.toString());
        return player.toString();
      }
    }

    // Solve puzzle with an answer.
    else if (instruct.equalsIgnoreCase("A")) {
      String answer = (instruction.length > 0) ? instruction[1] : "";
      String outcome = this.player.getLoc().solveObstacle(answer);
      userReader.sendOut(outcome);
      return outcome;
    }

    // Quit
    else if (instruct.equalsIgnoreCase("Q")) {

      if ( !this.save ) {
        /*
        userReader.sendOut("Game haven't save yet \n");
        userReader.sendOut("Do you really want to Quit (Yes/No)?");
        Scanner scanner = new Scanner(System.in);
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("Yes")) {
          userReader.sendOut("Game Quit \n");
          userReader.sendOut("Your current score is: ");
          userReader.sendOut(player.getScore());
          exit(0);
        }
        else if (confirm.equalsIgnoreCase("No")) {
          userReader.sendOut("Game Resume");
          return "Game Resume";
        }
        else {
          userReader.sendOut("I guess you're gonna keep playing");
          return "I guess you're gonna keep playing";
        }
        */

      }
      userReader.sendOut("Game Quit \n");
      userReader.sendOut("Your current score is: ");
      userReader.sendOut(String.valueOf(player.getScore()));
      exit(0);

    }

    //Saving.
    else if (instruct.equalsIgnoreCase("V")) {

      userReader.sendOut("Game saving");
      this.game.save();

      Path path = Paths.get(this.game.getName() + "_save_file.json");

      if (Files.exists(path)) {
        this.save = true;
        return "Game saving";
      } else {
        userReader.sendOut("Saving Failed");
        return "Saving Failed";
      }
    }

    //Restore
    else if (instruct.equalsIgnoreCase("R")) {

      userReader.sendOut("Game restoring");
      boolean loaded = this.game.restore();
      if (loaded == false) {
        return "Game file not found.";
      }
      this.player = this.game.getAvatar();
      return "Game restoring";
    }
    userReader.sendOut("Empty");
    return "";

  }

}
