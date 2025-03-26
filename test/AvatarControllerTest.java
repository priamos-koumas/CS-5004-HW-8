import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import project.avatar.Avatar;
import project.avatar.AvatarController;
import project.avatar.IAvatar;
import project.game.GameOld;
import project.room.Room;

public class AvatarControllerTest {
  FileReader reader;
  {
    try {
      reader = new FileReader("simple_hallway.json");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  Gson gson = new Gson();
  GameOld game = gson.fromJson(reader, GameOld.class);

  Room room1 = game.getRooms().get(0);
  Room room2 = game.getRooms().get(1);
  Room room3 = game.getRooms().get(2);

  @Test
  public void AvatarTest() {
    Avatar player = new Avatar(100, "Trevor", room1);
    AvatarController control = new AvatarController(player);
    control.Control("L");

  }
}
