package gamedriver;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

import gamedriver.avatar.AvatarController;
import gamedriver.game.Game;
import gamedriver.game.JsonData;
import gamedriver.obstacle.IObstacle;

public class MainTest {
/*
  public static void main(String[] args) {

    FileReader reader;
    {
      try {
        reader = new FileReader("align_quest_game_elements.json");
      } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
      }
    }

    Gson gson = new Gson();
    JsonData data = gson.fromJson(reader, JsonData.class);
    Game game = new Game(data);

    System.out.println("Please enter your name: ");
    game.getAvatar().setName();

    GameCommandReaderNew userReader = new GameCommandReaderNew();
    AvatarController control = new AvatarController(game);

    while(userReader.getDataFromUser()) {
      control.Control(userReader.getOperator(), userReader.getOperand1());
      if (game.getAvatar().getLoc().getObstacle() != null && game.getAvatar().getLoc().getObstacle().getActiveState()) {
        IObstacle obstacle = game.getAvatar().getLoc().getObstacle();
        System.out.println(obstacle.getEffects());
        game.getAvatar().setHealth(game.getAvatar().getHealth() + obstacle.getDamage());
        System.out.println(game.getAvatar().toString());
      }
    }
  }*/
}
