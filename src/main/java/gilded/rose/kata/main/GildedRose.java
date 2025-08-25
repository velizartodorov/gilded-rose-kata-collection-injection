package gilded.rose.kata.main;

import static java.util.Arrays.stream;
import static lombok.AccessLevel.PUBLIC;

import gilded.rose.kata.item_helpers.ItemFactory;
import gilded.rose.kata.item_helpers.ItemType;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PUBLIC)
public class GildedRose {

  Item[] items;

  public void updateQuality() {
    stream(items).forEach(item -> {
      ItemType itemType = ItemFactory.getItemType(item);
      itemType.validateQuality();
      itemType.updateQuality();
    });
  }
}
