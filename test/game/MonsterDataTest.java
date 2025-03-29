package game;

import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import gamedriver.obstacle.Enemy;
import gamedriver.game.MonsterData;
import gamedriver.game.Game;
import gamedriver.game.JsonData;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This tests the data class and specifically ensures the monster data
 * is pulled in correctly when it is read from the json files.
 */
public class MonsterDataTest {
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

  MonsterData monster0 = data.getMonsters().get(0);
  MonsterData monster1 = data.getMonsters().get(1);

  /**
   * Tests the name is pulled properly.
   */
  @Test
  void testGetMonsterDataNames() {
	assertEquals("Rabbit", monster0.getName());
	assertEquals("Teddy Bear", monster1.getName());
  }

  /**
   * Tests the active is pulled properly.
   */
  @Test
  void testGetMonsterDataActive() {
	assertEquals("true", monster0.getActive());
	assertEquals("true", monster1.getActive());
  }

  /**
   * Tests the target affects is pulled properly.
   */
  @Test
  void testGetMonsterDataAffectsTarget() {
	assertEquals("true", monster0.getAffectsTarget());
	assertEquals("true", monster1.getAffectsTarget());
  }
  /**
   * Tests the player affects is pulled properly.
   */
  @Test
  void testGetMonsterDataAffectsPlayer() {
	assertEquals("true", monster0.getAffectsPlayer());
	assertEquals("true", monster1.getAffectsPlayer());
  }

  /**
   * Tests the solution is pulled properly.
   */
  @Test
  void testGetMonsterDataSolution() {
	assertEquals("Carrot", monster0.getSolution());
	assertEquals("Hair Clippers", monster1.getSolution());
  }

  /**
   * Tests the name is pulled properly.
   */
  @Test
  void testGetMonsterValue() {
	assertEquals("300", monster0.getValue());
	assertEquals("200", monster1.getValue());
  }

  /**
   * Tests the description is pulled properly.
   */
  @Test
  void testGetMonsterDescription() {
	assertEquals("Awww. A furry rabbit twitching its nose and eating a carrot. " +
			"Makes you want to pet him", monster0.getDescription());
	assertEquals("A peaceful, cute-looking teddy bear with its " +
			"hair clipped sits on the floor", monster1.getDescription());
  }

  /**
   * Tests the effects is pulled properly.
   */
  @Test
  void testGetMonsterEffects() {
	assertEquals("A monster Rabbit moves towards you! He's blocking the way north. " +
			"\nI think you might be dinner!", monster0.getEffects());
	assertEquals("A monster Teddy Bear growls at you! You cannot get past!", monster1.getEffects());
  }

  /**
   * Tests the damage inflicted is pulled properly.
   */
  @Test
  void testGetMonsterDamage() {
	assertEquals("-15", monster0.getDamage());
	assertEquals("-5", monster1.getDamage());
  }

  /**
   * Tests the room target is pulled properly.
   */
  @Test
  void testGetMonsterTarget() {
	assertEquals("7:Dining Room", monster0.getTarget());
	assertEquals("3:Foyer", monster1.getTarget());
  }

  /**
   * Tests the can attack is pulled properly.
   */
  @Test
  void testGetMonsterCanAttack() {
	assertEquals("true", monster0.getCanAttack());
	assertEquals("true", monster1.getCanAttack());
  }

  /**
   * Tests the attack is pulled properly.
   */
  @Test
  void testGetAttackMethod() {
	assertEquals("licks you with a giant tongue!", monster0.getAttack());
	assertEquals("hits you with soft, fluffy paws! You might sneeze!", monster1.getAttack());

  }

}

