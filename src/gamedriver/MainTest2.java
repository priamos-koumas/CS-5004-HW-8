package gamedriver;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

import gamedriver.avatar.AvatarController;
import gamedriver.game.Game;
import gamedriver.game.JsonData;
import gamedriver.obstacle.IObstacle;

public class MainTest2 {

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

    GameCommandReaderNew userReader = new GameCommandReaderNew();
    AvatarController control = new AvatarController(game, userReader);
    control.go();

  }
}
