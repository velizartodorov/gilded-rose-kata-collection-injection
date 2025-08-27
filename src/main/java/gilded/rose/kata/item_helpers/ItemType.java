package gilded.rose.kata.item_helpers;


import gilded.rose.kata.main.Item;
import lombok.Setter;

@Setter
public abstract class ItemType {

  public static final int QUALITY_LIMIT = 50;
  public static final String QUALITY_ERROR_MESSAGE = "Quality cannot be negative! Current value: ";
  public static final String OUT_OF_BOUND_QUALITY_MESSAGE = "Quality cannot be above "
      + QUALITY_LIMIT
      + "! Current value: ";

  protected Item item;

  protected boolean qualityIsNegative(Item item) {
    return item.quality < 0;
  }

  protected boolean qualityIsAboveLimit(Item item) {
    return item.quality > QUALITY_LIMIT;
  }

  public abstract String getName();

  public abstract String getParam();

  public abstract void updateQuality();

  public abstract void validateQuality();

}