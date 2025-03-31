package gamedriver.game;

import com.google.gson.annotations.SerializedName;

<<<<<<<< HEAD:src/project/game/PuzzleData.java
import project.obstacle.Puzzle;

========
import gamedriver.obstacle.Puzzle;

/**
 * PuzzleData is an intermediary class between a JSON file and the Puzzle class. Stores
 * all needed data to create a Puzzle from a JSON file using a Gson object. Gson objects
 * use the default constructor to create Data objects.
 */
>>>>>>>> f12dfc66f43f00b676ecaf48a260b29318c27306:src/gamedriver/game/PuzzleData.java
public class PuzzleData {

  @SerializedName("name")
  private String name;

  @SerializedName("active")
  private String active;

  @SerializedName("affects_targets")
  private String affectsTarget;

  @SerializedName("affects_player")
  private String affectsPlayer;

  @SerializedName("solution")
  private String solution;

  @SerializedName("value")
  private String value;

  @SerializedName("description")
  private String description;

  @SerializedName("effects")
  private String effects;

  @SerializedName("target")
  private String target;

  @SerializedName("picture")
  private String picture;

<<<<<<<< HEAD:src/project/game/PuzzleData.java
========
  /**
   * PuzzleData constructor takes a Puzzle and converts its data back into PuzzleData for
   * storage in a JSON.
   *
   * @param puzzle Puzzle object being saved
   */
>>>>>>>> f12dfc66f43f00b676ecaf48a260b29318c27306:src/gamedriver/game/PuzzleData.java
  public PuzzleData(Puzzle puzzle) {
    this.name = puzzle.getName();
    this.active = String.valueOf(puzzle.getActiveState());
    this.affectsTarget = String.valueOf(puzzle.getAffectsTarget());
    this.affectsPlayer = String.valueOf(puzzle.getAffectsPlayer());
    this.solution = String.valueOf(puzzle.getSolution());
    this.value = String.valueOf(puzzle.getValue());
    this.description = String.valueOf(puzzle.getDescription());
    this.effects = String.valueOf(puzzle.getEffects());
    this.target = String.valueOf(puzzle.getTarget());
    this.picture = puzzle.getImage();
  }

  public String getName() {
    return name;
  }

  public String getActive() {
    return active;
  }

  public String getAffectsTarget() {
    return affectsTarget;
  }

  public String getAffectsPlayer() {
    return affectsPlayer;
  }

  public String getSolution() {
    return solution;
  }

  public String getValue() {
    return value;
  }

  public String getDescription() {
    return description;
  }

  public String getEffects() {
    return effects;
  }

  public String getTarget() {
    return target;
  }

  public String getPicture() {
    return picture;
  }

}
