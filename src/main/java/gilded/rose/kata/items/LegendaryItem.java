package gilded.rose.kata.items;

import gilded.rose.kata.item_helpers.ItemType;
import gilded.rose.kata.main.Item;
import org.springframework.stereotype.Component;

@Component("Sulfuras, Hand of Ragnaros")
public class LegendaryItem implements ItemType {

  private Item item;


  @Override
  public void loadItem(Item item) {
    this.item = item;
  }

  @Override
  public void updateQuality() {
    decrementSellInDate();
  }

  @Override
  public void validateQuality() {
    if (isNotLegendary(item)) {
      String errorMessage = "Item is legendary, quality must be always 80! Current value: ";
      throw new IllegalArgumentException(errorMessage + item.quality);
    }
  }

  private boolean isNotLegendary(Item item) {
    return item.quality != 80;
  }

  private void decrementSellInDate() {
    item.sellIn--;
  }

}
