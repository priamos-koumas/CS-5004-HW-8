import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;

import project.GameCommandReaderNew;
import project.avatar.AvatarController;
import project.game.Game;
import project.game.JsonData;

public class MianTest {

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
    AvatarController control = new AvatarController(game);

    while(userReader.getDataFromUser()) {
      control.Control(userReader.getOperator(), userReader.getOperand1());
    }
  }
}
