package gilded.rose.kata.item_helpers;

import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;

import gilded.rose.kata.items.AgedBrieItem;
import gilded.rose.kata.items.BackstagePassItem;
import gilded.rose.kata.items.ConjuredItem;
import gilded.rose.kata.items.LegendaryItem;
import gilded.rose.kata.items.NormalItem;
import gilded.rose.kata.main.Item;
import java.util.stream.Stream;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemFactory {

  public ItemType getItemType(Item item) {
    return getItems(item)
        .collect(toMap(ItemType::getName, itemType -> itemType))
        .computeIfAbsent(item.name, (itemType -> new NormalItem(item)));
  }

  private Stream<ItemType> getItems(Item item) {
    return of(new NormalItem(item), new AgedBrieItem(item), new LegendaryItem(item),
        new BackstagePassItem(item), new ConjuredItem(item));
  }

}
