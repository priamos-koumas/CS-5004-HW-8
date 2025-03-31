package gamedriver.game;

import com.google.gson.annotations.SerializedName;

<<<<<<<< HEAD:src/project/game/FixtureData.java
import project.elements.Fixtures;

========
import gamedriver.elements.Fixtures;

/**
 * FixtureData is an intermediary class between a JSON file and the Fixtures class. Stores
 * all needed data to create a Fixtures from a JSON file using a Gson object. Gson objects
 * use the default constructor to create Data objects.
 */
>>>>>>>> f12dfc66f43f00b676ecaf48a260b29318c27306:src/gamedriver/game/FixtureData.java
public class FixtureData {

  @SerializedName("name")
  private String name;

  @SerializedName("weight")
  private String weight;

  @SerializedName("puzzle")
  private String puzzle;

  @SerializedName("states")
  private String states;

  @SerializedName("description")
  private String description;
  private String picture;

<<<<<<<< HEAD:src/project/game/FixtureData.java
========
  /**
   * FixtureData constructor takes a Fixtures and converts its data back into FixtureData for
   * storage in a JSON.
   *
   * @param fixture Fixtures object being saved
   */
>>>>>>>> f12dfc66f43f00b676ecaf48a260b29318c27306:src/gamedriver/game/FixtureData.java
  public FixtureData(Fixtures fixture) {
    this.name = fixture.getName();
    this.weight = String.valueOf(fixture.getWeight());
    // puzzle
    // states
    this.description = fixture.getDescription();
  }

  public String getName() {
    return name;
  }

  public String getWeight() {
    return weight;
  }

  public String getPuzzle() {
    return puzzle;
  }

  public String getStates() {
    return states;
  }

  public String getDescription() {
    return description;
  }

  public String getPicture() {
    return picture;
  }

}
