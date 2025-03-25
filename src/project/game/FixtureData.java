package project.game;

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

  // Getters and Setters
}
