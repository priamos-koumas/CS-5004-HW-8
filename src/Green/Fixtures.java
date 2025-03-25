package Green;

import com.google.gson.annotations.SerializedName;

public class Fixtures extends AbstractContents {

  @SerializedName("puzzle")
  private String puzzle;

  @SerializedName("states")
  private String states;

  public Fixtures(String name, String description, int weight, String puzzle, String states) {
    super(name, description, weight);
    this.weight = weight;
    this.puzzle = puzzle;
    this.states = states;
  }

  public boolean isFixtureMovable() {
    return weight <= 200;
  }

  public String getPuzzle() {
    return puzzle;
  }

  public String getStates() {
    return states;
  }
}
