package Green;
import GameEngine.IItem;

public class Item extends AbstractContents implements IItem, IRoomContents{
  private final int weight;

  public Item(String name, String description, int weight) {
    super(name, description);
    this.weight = weight;
  }

  @Override
  public String getName() {
    return super.getName();
  }

  @Override
  public String getDescriotion() {
    return super.getDescription();
  }


  public int getWeight() {
    return weight;
  }

  @Override
  public <T> void interact(T target) {

  }

  @Override
  public int getUsage() {
    return 0;
  }
}
