package project.game;

import com.google.gson.annotations.SerializedName;

import java.util.List;



/**
 * https://stackoverflow.com/questions/59812235/how-to-write-java-classes-representing-json-object-with-subobjects
 */
public class JsonData {

  @SerializedName("name")
  private String name;

  @SerializedName("version")
  private String version;

  @SerializedName("player")
  private String player;

  @SerializedName("rooms")
  private List<RoomData> rooms;

  @SerializedName("items")
  private List<ItemData> items;

  @SerializedName("fixtures")
  private List<FixtureData> fixtures;

  @SerializedName("monsters")
  private List<MonsterData> monsters;

  @SerializedName("puzzles")
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

  public String getPlayer() {
    return player;
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

