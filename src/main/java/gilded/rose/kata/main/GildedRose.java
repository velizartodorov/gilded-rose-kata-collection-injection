package gilded.rose.kata.main;

import static java.util.Arrays.stream;

import gilded.rose.kata.item_helpers.ItemFactory;
import gilded.rose.kata.item_helpers.ItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GildedRose {

  Item[] items;

  @Autowired
  ItemFactory itemFactory;

  public void loadItems(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    stream(items).forEach(item -> {
      ItemType itemType = itemFactory.getItemType(item.name);
      itemType.loadItem(item);
      itemType.validateQuality();
      itemType.updateQuality();
    });
  }
}