package Green;

public class Item extends AbstractContents {
  private int weight;

  public Item(String name, String description) {
    super(name, description);
  }

  public int getWeight() {
    return weight;
  }
}
