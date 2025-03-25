package Green;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;



import static org.junit.jupiter.api.Assertions.*;

public class ItemAndFixtureTest {
  private Item lamp;
  private Fixtures whiteboard;
  private Item decrementLamp;

  @BeforeEach
  public void setUp() {
    whiteboard = new Fixtures("Whiteboard", "1000", null, null,
            "A large whiteboard mounted to the wall. " +
                    "Some UML class and sequence diagrams are scattered on it, in various colors");

    lamp = new Item("Lamp", "3",
            "100",
            "20",
            "100",
            "You light the lamp with the flint",
            "An old oil lamp with flint to spark.");

    decrementLamp = new Item("Lamp", "3",
            "100",
            "-20",
            "100",
            "You light the lamp with the flint",
            "An old oil lamp with flint to spark.");
  }

  @Test
  public void testGetName() {
    assertEquals("Whiteboard", whiteboard.getName());
    assertEquals("Lamp", lamp.getName());
  }

  @Test
  public void testGetWeight() {
    assertEquals(1000, whiteboard.getWeight());
    assertEquals(3, lamp.getWeight());
  }

  @Test
  public void testGetDescription() {
    assertEquals("An old oil lamp with flint to spark.", lamp.getDescription());
    assertEquals("A large whiteboard mounted to the wall. " +
                    "Some UML class and sequence diagrams are scattered on it, in various colors",
            whiteboard.getDescription());
  }

  @Test
  public void testIsFixtureMovable() {
    assertFalse(whiteboard.isFixtureMovable());
  }

  @Test
  public void testGetPuzzle() {
    assertEquals(null, whiteboard.getPuzzle());
  }

  @Test
  public void testGetStates() {
    assertEquals(null, whiteboard.getStates());
  }

  @Test
  public void testGetMaxUses() {
    assertEquals(100, lamp.getMaxUses());
  }

  @Test
  public void testGetUsesRemaining() {
    assertEquals(20, lamp.getUsesRemaining());
  }

  @Test
  public void testGetValue() {
    assertEquals(100, lamp.getValue());
  }

  @Test
  public void testGetWhenUsed() {
    assertEquals("You light the lamp with the flint", lamp.getWhenUsed());
  }

  @Test
  public void testDecrementUsesRemaining() {
    lamp.decrementUsesRemaining();
    assertEquals(19, lamp.getUsesRemaining());
    assertEquals(0, decrementLamp.getUsesRemaining());
  }

}



