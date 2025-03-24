package Green;

public class AbstractContents implements IElements {
  private final String name;
  private final String description;

  public AbstractContents(String name, String description) {
    this.name = name;
    this.description = description;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public String getName() {
    return name;
  }
}
