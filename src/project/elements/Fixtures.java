package project.elements;

import project.game.FixtureData;

public class Fixtures extends AbstractContents {
  int weight;


  public Fixtures(String name, String description, int weight) {
    super(name, description);
    this.weight = weight;
  }

  public Fixtures(FixtureData fixture) {
    super(fixture.getName(), fixture.getDescription());
    if (fixture.getWeight() != null) {
      this.weight = Integer.parseInt(fixture.getWeight());
    } else {
      throw new IllegalArgumentException("Must know weight of fixture.");
    }
  }

  public int getWeight() {
    return weight;
  }

  public boolean fixtureImmovable() {
    return weight > 200;
  }

  @Override
  public String toString() {
    return "Fixtures{" +
            "weight=" + weight +
            '}';
  }
}
