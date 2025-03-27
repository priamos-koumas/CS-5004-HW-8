package project.game;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import project.avatar.Avatar;
import project.elements.Fixtures;
import project.elements.IElements;
import project.elements.Item;
import project.obstacle.Enemy;
import project.obstacle.Puzzle;
import project.room.Room;


/**
 * https://stackoverflow.com/questions/59812235/how-to-write-java-classes-representing-json-object-with-subobjects
 */
public class JsonData {

  @SerializedName("name")
  private String name;

  @SerializedName("version")
  private String version;

  @SerializedName("avatar")
  private AvatarData avatar;

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

  public JsonData(Game game) {
    this.name = game.getName();
    this.version = game.getVersion();
    this.avatar = new AvatarData(game.getAvatar());
    this.rooms = new ArrayList<RoomData>();
    for (Room room : game.getRooms()) {
      this.rooms.add(new RoomData(room));
    }
    this.items = new ArrayList<ItemData>();
    for (Item item : game.getItems()) {
      this.items.add(new ItemData(item));
    }
    this.fixtures = new ArrayList<FixtureData>();
    for (Fixtures fixture: game.getFixtures()) {
      this.fixtures.add(new FixtureData(fixture));
    }
    this.monsters = new ArrayList<MonsterData>();
    for (Enemy monster : game.getMonsters()) {
      this.monsters.add(new MonsterData(monster));
    }
    this.puzzles = new ArrayList<PuzzleData>();
    for (Puzzle puzzle : game.getPuzzles()) {
      this.puzzles.add(new PuzzleData(puzzle));
    }
  }

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

  public AvatarData getAvatar() {
    return avatar;
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

