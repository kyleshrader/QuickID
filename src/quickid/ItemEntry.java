package quickid;

import javax.swing.ImageIcon;

public class ItemEntry {
  private final String itemName;

  private final ImageIcon icon;

  private ImageIcon image;

  public ItemEntry(String itemName, ImageIcon icon) {
    this.itemName = itemName;
    this.icon = icon;
  }

  public String getItemName() {
    return itemName;
  }

  public ImageIcon getImageIcon() {
    return icon;
  }

    @Override
  public String toString() {
      return itemName;
  }
}