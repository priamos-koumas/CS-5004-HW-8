package project.elements;

import project.game.FixtureData;

public class Fixtures extends AbstractContents {
  int weight;
  private String puzzle;
  private String states;

  public Fixtures(String name, String description, int weight, String puzzle, String states) {
    super(name, description);
    this.weight = weight;
    this.puzzle = puzzle;
    this.states = states;
  }

  public Fixtures(FixtureData data) {
    super(data.getName(), data.getDescription());

    if (data.getWeight() != null) {
      this.weight = Integer.parseInt(data.getWeight());
    } else {
      throw new IllegalArgumentException("Weight cannot be null");
    }

    if (data.getPuzzle() != null) {
      this.puzzle = data.getPuzzle();
    } else {
      this.puzzle = null;
    }

    if (data.getStates() != null) {
      this.states = data.getStates();
    } else {
      this.states = null;
    }

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

  @Override
  public String toString() {
    return "Fixtures{" +
            "weight=" + weight +
            '}';
  }

  @Override
  public int getWeight() {
    return this.weight;
  }
}
