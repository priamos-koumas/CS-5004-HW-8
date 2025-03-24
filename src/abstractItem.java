public abstract class abstractItem implements IItem {
  protected final String name;
  protected final String description;
  protected final int weight;
  protected int usage;

  public abstractItem(String name, String description, int weight, int usage) {
	this.name = name;
	this.description = description;
	this.weight = weight;
	this.usage = usage;
  }

  public String getName() {
	return this.name;
  }

  public String getDescription() {
	return this.description;
  }

  public int getWeight() {
	return this.weight;
  }

  public abstract <T> void interact(T target);

  public int getUsage() {
	return this.usage;
  }

}