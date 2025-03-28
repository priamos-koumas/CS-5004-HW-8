package project.elements;

public interface IElements {
  String getName();
  String getDescription();
  int getWeight();
  public void decrementUsesRemaining();
  public int usesRemaining();
}
