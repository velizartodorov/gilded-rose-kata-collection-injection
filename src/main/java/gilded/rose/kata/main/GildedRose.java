package gilded.rose.kata.main;

import static java.util.Arrays.stream;

import gilded.rose.kata.item_helpers.ItemFactory;
import gilded.rose.kata.item_helpers.ItemType;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GildedRose {

  @Setter
  Item[] items;

  @Autowired
  ItemFactory itemFactory;

  public void updateQuality() {
    stream(items).forEach(item -> {
      ItemType itemType = itemFactory.getItemType(item.name);
      itemType.setItem(item);
      itemType.validateQuality();
      itemType.updateQuality();
    });
  }
}