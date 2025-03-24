package Green;

public class AbstractContents implements IElements {
  private String name;
  private String description;

  public AbstractContents(String name, String description) {
    this.name = name;
    this.description = description;
  }

  @Override
  public String getDescription() {
    return description;
  }
}
