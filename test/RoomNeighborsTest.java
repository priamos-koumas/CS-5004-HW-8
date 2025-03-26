import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import project.game.Game;
import project.room.CardinalDirection;
import project.room.Room;
import project.room.RoomNeighbors;

import static org.junit.jupiter.api.Assertions.*;

class RoomNeighborsTest {

  FileReader reader;
  {
    try {
      reader = new FileReader("align_quest_game_elements.json");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  FileReader emptyReader;
  {
    try {
      emptyReader = new FileReader("test.json");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  Gson gson = new Gson();
  Game game = gson.fromJson(reader, Game.class);
  Game emptyGame = gson.fromJson(emptyReader, Game.class);

  RoomNeighbors neighbors = new RoomNeighbors(game.getRooms());
  RoomNeighbors emptyNeighbors = new RoomNeighbors(emptyGame.getRooms());

  @Test
  void testConstructor() {
    assertEquals(neighbors.getRooms().get(0), game.getRooms().get(0));
  }

  @Test
  void testSetNeighbor() {
    neighbors.setNeighbor(CardinalDirection.NORTH, 1);
    assertEquals(neighbors.getRoom(CardinalDirection.NORTH), game.getRooms().get(0));

    assertThrows(IllegalArgumentException.class, () ->
            neighbors.setNeighbor(CardinalDirection.NORTH, 2));

  }

  @Test
  void getRoom() {
    neighbors.setNeighbor(CardinalDirection.NORTH, 1);
    assertEquals(neighbors.getRoom(CardinalDirection.NORTH), game.getRooms().get(0));
  }
}