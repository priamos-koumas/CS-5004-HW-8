import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import gamedriver.game.Game;
import gamedriver.game.JsonData;
import gamedriver.room.CardinalDirection;
import gamedriver.room.RoomNeighbors;

import static org.junit.jupiter.api.Assertions.*;

class RoomNeighborsTest {

  FileReader reader;
  {
    try {
      reader = new FileReader("json_files/align_quest_game_elements.json");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  Gson gson = new Gson();
  JsonData data = gson.fromJson(reader, JsonData.class);
  Game game = new Game(data);

  RoomNeighbors neighbors = new RoomNeighbors(game.getRooms());

  @Test
  void testConstructor() {
    assertEquals(neighbors.getRooms().get(0), game.getRooms().get(0));
  }

  @Test
  void testSetNeighbor() {
    neighbors.setNeighbor(CardinalDirection.NORTH, 1);
    assertEquals(neighbors.getRoom(CardinalDirection.NORTH), game.getRoom(1));

    assertThrows(IllegalArgumentException.class, () ->
            neighbors.setNeighbor(CardinalDirection.NORTH, 2));

  }

  @Test
  void getRoom() {
    neighbors.setNeighbor(CardinalDirection.NORTH, 1);
    assertEquals(neighbors.getRoom(CardinalDirection.NORTH), game.getRoom(1));
  }
}