package game;

import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import gamedriver.game.Game;
import gamedriver.game.JsonData;
import gamedriver.game.RoomData;
import gamedriver.room.CardinalDirection;
import gamedriver.room.Room;

import static org.junit.jupiter.api.Assertions.*;


public class RoomDataTest {
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

  RoomData room1 = data.getRooms().get(0);
  RoomData room2 = data.getRooms().get(1);
  RoomData room3 = data.getRooms().get(2);

  @Test
  void getRoomDataName() {
    assertEquals("Courtyard", room1.getRoomName());
    assertEquals("Mansion Entrance", room2.getRoomName());
    assertEquals("Foyer", room3.getRoomName());
  }

  @Test
  void getRoomDataNumber() {
    assertEquals(1, room1.getRoomNumber());
    assertEquals(2, room2.getRoomNumber());
    assertEquals(3, room3.getRoomNumber());
  }

  @Test
  void getRoomDataDescription() {
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
  void testGetRoomDataPuzzle() {
    assertEquals(null, room1.getPuzzle());
    assertEquals(null, room2.getPuzzle());
    assertEquals(null, room3.getPuzzle());
  }

  @Test
  void testGetRoomDataFixtures() {
    assertEquals("Billboard", room1.getFixtures());
    assertEquals("Chandelier", room2.getFixtures());
    assertEquals(null, room3.getFixtures());

  }

  @Test
  void testGetRoomDataItems() {
    assertEquals("Hair Clippers", room1.getItems());
    assertEquals("Thumb Drive, Modulo 2", room2.getItems());
    assertEquals("Lamp", room3.getItems());
  }

  @Test
  void testGetRoomDataMonsters() {
    assertEquals(null, room1.getMonster());
    assertEquals(null, room2.getMonster());
    assertEquals("Teddy Bear", room3.getMonster());
  }

  @Test
  void testGetRoomDataCardinalDirection() {
    assertEquals(2, room1.getN());
    assertEquals(3, room2.getN());
    assertEquals(0, room3.getN());

    assertEquals(0, room1.getS());
    assertEquals(1, room2.getS());
    assertEquals(2, room3.getS());

    assertEquals(0, room1.getE());
    assertEquals(0, room2.getE());
    assertEquals(4, room3.getE());

    assertEquals(0, room1.getW());
    assertEquals(0, room2.getW());
    assertEquals(0, room3.getW());
  }
}
