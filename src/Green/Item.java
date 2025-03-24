package Green;

public class Item extends AbstractContents implements IItem {
  private int weight;
  private int maxUses;
  private int usesRemaining;
  private int value;
  private String whenUsed;

  public Item(String name, String description, int weight, int maxUses, int usesRemaining,
              int value, String whenUsed) {
    super(name, description);
    this.weight = weight;
    this.maxUses = maxUses;
    this.usesRemaining = usesRemaining;
    this.value = value;
    this.whenUsed = whenUsed;

  }

  public void decrementUsesRemaining() {
    if (this.usesRemaining > 0) {
      this.usesRemaining--;
    }
    else {
      this.usesRemaining = 0;
    }
  }

  public int getUsesRemaining() {
    return this.usesRemaining;
  }

  public String getWhenUsed() {
    return this.whenUsed;
  }

  public int getWeight() {
    return weight;
  }

  public int getValue() {
    return value;
  }

  @Override
  public <T> void interact(T target) {

  }

  @Override
  public int getUsage() {
    return 0;
  }

  @Override
  public String getName() {
    return super.getName();
  }
}
