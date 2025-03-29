package game;

import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import gamedriver.elements.Fixtures;
import gamedriver.game.FixtureData;
import gamedriver.game.Game;
import gamedriver.game.JsonData;

import static org.junit.jupiter.api.Assertions.*;

public class FixtureDataTest {
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

  FixtureData fixtures0 = data.getFixtures().get(0);
  FixtureData fixtures1 = data.getFixtures().get(1);
  FixtureData fixtures2 = data.getFixtures().get(2);

  @Test
  void testGetFixtureDataNames() {
    assertEquals("Desk", fixtures0.getName());
    assertEquals("Laptop", fixtures1.getName());
    assertEquals("Professor Keith", fixtures2.getName());
  }

  @Test
  void testGetFixtureDataWeight() {
    assertEquals("1000", fixtures0.getWeight());
    assertEquals("1000", fixtures1.getWeight());
    assertEquals("1000", fixtures2.getWeight());
  }

  @Test
  void testGetFixtureDataPuzzle() {
    assertEquals(null, fixtures0.getPuzzle());
    assertEquals(null, fixtures1.getPuzzle());
    assertEquals(null, fixtures2.getPuzzle());
  }

  @Test
  void testGetFixtureDataStates() {
    assertEquals(null, fixtures0.getStates());
    assertEquals(null, fixtures1.getStates());
    assertEquals(null, fixtures2.getStates());
  }

  @Test
  void testGetFixtureDataDescription() {
    assertEquals("An old wooden desk with a mess of papers. " +
            "A note says: \"use thumb drive!\"", fixtures0.getDescription());
    assertEquals("A ZacPro 5000 with all the latest features and a USB slot. " +
            "It's bolted to the table and can't move", fixtures1.getDescription());
    assertEquals("Professor Keith, Faculty Director of Align Boston. " +
            "He smiles at you and gives a thumb's up. \"Great job! You can do this!\"",
            fixtures2.getDescription());
  }

  @Test
  void testFixturesDataConstructor() {
    Fixtures fix = new Fixtures("Desk", "An old wooden desk with a mess of papers. " +
            "A note says: \"use thumb drive!\"", 1000, null, null);

    FixtureData fixtureData = new FixtureData(fix);

    assertEquals("Desk", fixtureData.getName());
    assertEquals("1000", fixtureData.getWeight());
    assertEquals(null, fixtureData.getPuzzle());
    assertEquals(null, fixtureData.getStates());
    assertEquals("An old wooden desk with a mess of papers. " +
            "A note says: \"use thumb drive!\"", fixtureData.getDescription());
      }


    }

