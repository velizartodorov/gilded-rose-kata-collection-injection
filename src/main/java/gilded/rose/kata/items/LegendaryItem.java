package gilded.rose.kata.items;

import static gilded.rose.kata.items.LegendaryItem.SULFURAS_HAND_OF_RAGNAROS;

import gilded.rose.kata.item_helpers.ItemType;
import gilded.rose.kata.main.Item;
import org.springframework.stereotype.Component;

@Component(SULFURAS_HAND_OF_RAGNAROS)
@SuppressWarnings("unused")
public class LegendaryItem extends ItemType {

  static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

  @Override
  public String getName() {
    return SULFURAS_HAND_OF_RAGNAROS;
  }

  @Override
  public String getParam() {
    return "Sulfuras";
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
