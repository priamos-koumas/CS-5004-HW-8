package elements;

import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import gamedriver.elements.Item;
import gamedriver.game.Game;

import gamedriver.game.JsonData;

import static org.junit.jupiter.api.Assertions.*;


public class ItemTest {
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

  Item item0 = game.getItems().get(0);
  Item item1 = game.getItems().get(1);
  Item item2 = game.getItems().get(2);


  @Test
  void getItemName() {
    assertEquals("Lamp", item0.getName());
    assertEquals("Thumb Drive", item1.getName());
    assertEquals("Algorithms Book", item2.getName());
  }

  @Test
  void getItemWeight() {
    assertEquals(3, item0.getWeight());
    assertEquals(1, item1.getWeight());
    assertEquals(2, item2.getWeight());
  }

  @Test
  void getItemMaxUses() {
    assertEquals(100, item0.getMaxUses());
    assertEquals(1000, item1.getMaxUses());
    assertEquals(1000, item2.getMaxUses());

  }

  @Test
  void getItemUsesRemaining() {
    assertEquals(20, item0.getUsesRemaining());
    assertEquals(1000, item1.getUsesRemaining());
    assertEquals(1000, item2.getUsesRemaining());

    item0.decrementUsesRemaining();
    assertEquals(19, item0.getUsesRemaining());
  }

  @Test
  void getItemValue() {
    assertEquals(100, item0.getValue());
    assertEquals(150, item1.getValue());
    assertEquals(500, item2.getValue());
  }

  @Test
  void getItemWhenUsed() {
    assertEquals("You light the lamp with the flint.", item0.getWhenUsed());
    assertEquals("You insert the thumb drive.", item1.getWhenUsed());
    assertEquals("You read the Algo Book and make note of computational theories.",
            item2.getWhenUsed());
  }

  @Test
  void getItemDescriptions() {
    assertEquals("An old oil lamp with flint to spark.", item0.getDescription());
    assertEquals("A USB thumb drive for computers", item1.getDescription());
    assertEquals("A book on computer algorithms, signed by Professor Keith. " +
            "\nThe inscription reads: \"You'll need this in CS5800. Best wishes to you, Aligner!\n " +
            "P.S.: Don't forget: a recursive solution needs a base case!", item2.getDescription());
  }


}
