import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import project.game.Game;
import project.game.JsonData;
import project.room.CardinalDirection;
import project.room.Room;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
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
  void getRoomName() {
    assertEquals("Courtyard", room1.getRoomName());
    assertEquals("Mansion Entrance", room2.getRoomName());
    assertEquals("Foyer", room3.getRoomName());
  }

  @Test
  void getRoomNumber() {
    assertEquals(1 , room1.getRoomNumber());
    assertEquals(2 , room2.getRoomNumber());
    assertEquals(3 , room3.getRoomNumber());
  }

  @Test
  void getDescription() {
    assertEquals("A beautiful courtyard with flowers on both sides of the stone walkway. "
            + "\nThe walkway leads north. A billboard is in the distance.", room1.getDescription());
    assertEquals("Entrance to an old, musty-smelling mansion. "
            + "Some people have entered, to never return. "
            + "\nThe door to the north is open. "
            + "The courtyard is to your south and a foyer to your north. "
            + "A chandelier hangs from the ceiling.", room2.getDescription());
    assertEquals("The foyer of the mansion. "
            + "A staircase leads upstairs but it is dilapidated and unusable. "
            + "Therefore, the only exits to the south and east. "
            + "\nA strange breeze moves through the room. "
            + "Eastward is a small room that looks like a library. "
            + "A teddy bear lies on the floor with its hair shaved", room3.getDescription());
  }

  @Test
  void testGetNeighbor() {

    assertEquals(game.getRoom(2), room1.getNeighbor(CardinalDirection.NORTH));
    assertEquals(game.getRoom(1), room2.getNeighbor(CardinalDirection.SOUTH));
    assertEquals(game.getRoom(3), room2.getNeighbor(CardinalDirection.NORTH));
    assertEquals(game.getRoom(4), room3.getNeighbor(CardinalDirection.EAST));
    assertNull(room3.getNeighbor(CardinalDirection.WEST));

  }

}