package game;

import com.google.gson.Gson;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import gamedriver.elements.Item;
import gamedriver.game.Game;
import gamedriver.game.ItemData;
import gamedriver.game.JsonData;

import static org.junit.jupiter.api.Assertions.*;


public class ItemDataTest {
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

  ItemData item0 = data.getItems().get(0);
  ItemData item1 = data.getItems().get(1);
  ItemData item2 = data.getItems().get(2);

  @Test
  void getItemDataName() {
    assertEquals("Lamp", item0.getName());
    assertEquals("Thumb Drive", item1.getName());
    assertEquals("Algorithms Book", item2.getName());
  }

  @Test
  void getItemDataWeight() {
    assertEquals("3", item0.getWeight());
    assertEquals("1", item1.getWeight());
    assertEquals("2", item2.getWeight());
  }

  @Test
  void getItemDataMaxUses() {
    assertEquals("100", item0.getMaxUses());
    assertEquals("1000", item1.getMaxUses());
    assertEquals("1000", item2.getMaxUses());

  }

  @Test
  void getItemDataUsesRemaining() {
    assertEquals("20", item0.getUsesRemaining());
    assertEquals("1000", item1.getUsesRemaining());
    assertEquals("1000", item2.getUsesRemaining());
  }

  @Test
  void getItemDataValue() {
    assertEquals("100", item0.getValue());
    assertEquals("150", item1.getValue());
    assertEquals("500", item2.getValue());
  }

  @Test
  void getItemDataWhenUsed() {
    assertEquals("You light the lamp with the flint.", item0.getWhenUsed());
    assertEquals("You insert the thumb drive.", item1.getWhenUsed());
    assertEquals("You read the Algo Book and make note of computational theories.",
            item2.getWhenUsed());
  }

  @Test
  void getItemDataDescriptions() {
    assertEquals("An old oil lamp with flint to spark.", item0.getDescription());
    assertEquals("A USB thumb drive for computers", item1.getDescription());
    assertEquals("A book on computer algorithms, signed by Professor Keith. " +
            "\nThe inscription reads: \"You'll need this in CS5800. Best wishes to you, Aligner!\n " +
            "P.S.: Don't forget: a recursive solution needs a base case!", item2.getDescription());
  }

  @Test
  void testItemDataConstructor() {
    Item item = new Item("Key", "A medium-sized key. " +
            "Looks like it may unlock a cabinet or desk.", 1, 3,
            3, 5, "You insert the key and turn it. 'Click!'");

    ItemData itemData = new ItemData(item);
    assertEquals("Key", itemData.getName());
    assertEquals("5", itemData.getValue());
    assertEquals("A medium-sized key. Looks like it may unlock a cabinet or desk.", itemData.getDescription());
    assertEquals("1", itemData.getWeight());
    assertEquals("3", itemData.getMaxUses());
    assertEquals("3", itemData.getUsesRemaining());
    assertEquals("You insert the key and turn it. 'Click!'", itemData.getWhenUsed());

  }


}
