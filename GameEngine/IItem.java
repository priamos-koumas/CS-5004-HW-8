package GameEngine;

public interface IItem {

  public String getName();
  public String getDescriotion();
  public int getWeight();
  public <T> void interact(T target);
  public int getUsage();

}
