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
