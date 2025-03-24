package Green;

public class Fixtures extends AbstractContents {
  int weight;

  public Fixtures(String name, String description, int weight) {
    super(name, description);
    this.weight = weight;
  }

  public int getWeight() {
    return weight;
  }

  public boolean fixtureImmovable() {
    return weight > 200;
  }
}
