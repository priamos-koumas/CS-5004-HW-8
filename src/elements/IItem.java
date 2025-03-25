package elements;

public interface IItem {

  public String getName();
  public String getDescription();
  public int getWeight();
  public <T> void interact(T target);
  public int getUsage();

}
