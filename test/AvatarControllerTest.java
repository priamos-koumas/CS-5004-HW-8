import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import project.avatar.Avatar;
import project.avatar.AvatarController;
import project.avatar.IAvatar;
import project.game.Game;
import project.game.GameOld;
import project.game.JsonData;
import project.room.Room;

public class AvatarControllerTest {
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

  Room room1 = game.getRooms().get(0);
  Room room2 = game.getRooms().get(1);
  Room room3 = game.getRooms().get(2);

  @Test
  public void AvatarTest() {
    Avatar player = new Avatar(100, "Trevor", room2);
    AvatarController control = new AvatarController(game);
    control.Control("L");
    control.Control("N");




  }
}
