package project.game;

import java.util.List;

/**
 * https://stackoverflow.com/questions/59812235/how-to-write-java-classes-representing-json-object-with-subobjects
 */
public class JsonData {
  private String name;
  private String version;
  private List<RoomData> rooms;
  private List<ItemData> items;
  private List<FixtureData> fixtures;
  private List<MonsterData> monsters;
  private List<PuzzleData> puzzles;

  @Override
  public String toString() {
    return "JsonData{" +
            "name='" + name + '\'' +
            ", version='" + version + '\'' +
            ", rooms=" + rooms +
            ", items=" + items +
            ", fixtures=" + fixtures +
            ", monsters=" + monsters +
            ", puzzles=" + puzzles +
            '}';
  }

  public String getName() {
    return name;
  }

  public String getVersion() {
    return version;
  }

  public List<RoomData> getRooms() {
    return rooms;
  }

  public List<ItemData> getItems() {
    return items;
  }

  public List<FixtureData> getFixtures() {
    return fixtures;
  }

  public List<MonsterData> getMonsters() {
    return monsters;
  }

  public List<PuzzleData> getPuzzles() {
    return puzzles;
  }
}

