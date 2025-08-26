package gilded.rose.kata.item_helpers;


import gilded.rose.kata.main.Item;

public interface ItemType {

  int QUALITY_LIMIT = 50;
  String QUALITY_ERROR_MESSAGE = "Quality cannot be negative! Current value: ";
  String OUT_OF_BOUND_QUALITY_MESSAGE = "Quality cannot be above "
      + QUALITY_LIMIT
      + "! Current value: ";

  void loadItem(Item item);

  default boolean qualityIsNegative(Item item) {
    return item.quality < 0;
  }

  default boolean qualityIsAboveLimit(Item item) {
    return item.quality > QUALITY_LIMIT;
  }

  void updateQuality();

  void validateQuality();

}
