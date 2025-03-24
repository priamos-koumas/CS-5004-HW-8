package GameEngine.Avatar;

import GameEngine.Item.IItem;

public class AvatarController {

  private Avatar player;

  public AvatarController(Avatar player) {
    this.player = player;
  }

  public void Control (String ... instruction) {
    String instruct = (instruction.length > 0) ? instruction[0] : "";// 預設值

    if (instruct.equalsIgnoreCase("Move")) {
      String direction = (instruction.length > 0) ? instruction[1] : "";
      for (Direction dir : Direction.values()) {
        if (dir.getText().equalsIgnoreCase(direction)) {
          this.player.moveRoom(dir);
        }
      }
    }

    else if (instruct.equalsIgnoreCase("Add")) {
      String item = (instruction.length > 0) ? instruction[1] : "";
      for (IItem items : this.player.getLoc().getInventList()) {
        if (items.getName().equalsIgnoreCase(item)) {
          this.player.addToBag(items);
          this.player.getLoc().getInvent().removeItem(items.getName());
          return;
        }
        return;
      }
    }

  }

}
