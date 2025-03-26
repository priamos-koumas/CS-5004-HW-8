package project.game;

import com.google.gson.annotations.SerializedName;

public class RoomData {
  @SerializedName("room_name")
  private String roomName;
  @SerializedName("room_number")
  private String roomNumber;
  private String description;
  private int N;
  private int S;
  private int E;
  private int W;
  private String puzzle;
  private String monster;
  private String items;
  private String fixtures;
  private String picture;

  public String getRoomName() {
    return roomName;
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public String getDescription() {
    return description;
  }

  public int getN() {
    return N;
  }

  public int getS() {
    return S;
  }

  public int getE() {
    return E;
  }

  public int getW() {
    return W;
  }

  public String getPuzzle() {
    return puzzle;
  }

  public String getMonster() {
    return monster;
  }

  public String getItems() {
    return items;
  }

  public String getFixtures() {
    return fixtures;
  }

  public String getPicture() {
    return picture;
  }

}
