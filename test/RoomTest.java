import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import project.game.GameOld;
import project.room.Room;

import static org.junit.jupiter.api.Assertions.*;
class RoomTest {
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
  void getRoomName() {
    assertEquals("Courtyard", room1.getRoomName());
    assertEquals("Mansion Entrance", room2.getRoomName());
    assertEquals("Foyer", room3.getRoomName());
  }

  @Test
  void getRoomNumber() {
  }

  @Test
  void getDescription() {
  }

  @Test
  void getNeighbor() {
  }

  @Test
  void setGame() {
  }
}